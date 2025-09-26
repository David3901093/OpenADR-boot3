package com.avob.openadr.server.oadr20b.ven.service;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import jakarta.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.avob.openadr.model.oadr20b.Oadr20bFactory;
import com.avob.openadr.model.oadr20b.builders.Oadr20bEiBuilders;
import com.avob.openadr.model.oadr20b.builders.Oadr20bEiReportBuilders;
import com.avob.openadr.model.oadr20b.builders.eireport.Oadr20bUpdateReportBuilder;
import com.avob.openadr.model.oadr20b.builders.eireport.Oadr20bUpdateReportOadrReportBuilder;
import com.avob.openadr.model.oadr20b.ei.IntervalType;
import com.avob.openadr.model.oadr20b.ei.ReportNameEnumeratedType;
import com.avob.openadr.model.oadr20b.ei.SpecifierPayloadType;
import com.avob.openadr.model.oadr20b.oadr.OadrCancelReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreateReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrPayloadResourceStatusType;
import com.avob.openadr.model.oadr20b.oadr.OadrReportDescriptionType;
import com.avob.openadr.model.oadr20b.oadr.OadrReportRequestType;
import com.avob.openadr.model.oadr20b.oadr.OadrReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrUpdateReportType;
import com.avob.openadr.model.oadr20b.xcal.DurationPropType;
import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;

@Service
public class UpdateReportOrchestratorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UpdateReportOrchestratorService.class);

	@Resource
	private MultiVtnConfig multiVtnConfig;

	@Resource
	private Oadr20bVENEiReportService oadr20bVENEiReportService;

	@Resource
	public ScheduledExecutorService scheduledExecutorService;

	private Map<String, ReportRequestOrchestration> reportRequestOrchestration = new ConcurrentHashMap<>();

	public interface UpdateReportOrchestratorListener {
		BufferValue readReportData(OadrReportType report, OadrReportDescriptionType description);
	}

	public void create(VtnSessionConfiguration vtnConfig, OadrCreateReportType oadrCreateReportType,
					   UpdateReportOrchestratorListener listener) {
		for (OadrReportRequestType oadrReportRequestType : oadrCreateReportType.getOadrReportRequest()) {
			String reportSpecifierID = oadrReportRequestType.getReportSpecifier().getReportSpecifierID();
			String oadrReportRequestID = oadrReportRequestType.getReportRequestID();

			if (!Oadr20bVENEiReportService.METADATA_REPORT_SPECIFIER_ID.equals(reportSpecifierID)) {
				String orchestrationUUID = getOrchestrationUUID(vtnConfig, oadrReportRequestID);
				ReportRequestOrchestration orchestration = reportRequestOrchestration.get(orchestrationUUID);
				if (orchestration != null) {
					orchestration.cancel(false);
				}

				orchestration = new ReportRequestOrchestration(vtnConfig, oadrReportRequestType, listener);
				orchestration.start();
				reportRequestOrchestration.put(orchestrationUUID, orchestration);
			}
		}
	}

	public void cancel(VtnSessionConfiguration vtnConfig, OadrCancelReportType oadrCancelReportType) {
		oadrCancelReportType.getReportRequestID().forEach(reportRequestId -> {
			String orchestrationUUID = getOrchestrationUUID(vtnConfig, reportRequestId);
			ReportRequestOrchestration orchestration = reportRequestOrchestration.get(orchestrationUUID);
			if (orchestration != null) {
				orchestration.cancel(false);
				reportRequestOrchestration.remove(orchestrationUUID);
			}
		});
	}

	public static class BufferValue {
		private Float floatValue;
		private OadrPayloadResourceStatusType statusValue;

		private BufferValue(Float floatValue) { this.floatValue = floatValue; }
		private BufferValue(OadrPayloadResourceStatusType statusValue) { this.statusValue = statusValue; }

		public IntervalType toInterval(String intervalId, Long start, String duration, String rid, Long confidence, Float accuracy) {
			if (floatValue != null) {
				return Oadr20bEiBuilders.newOadr20bReportIntervalTypeBuilder(intervalId, start, duration, rid, confidence, accuracy, floatValue).build();
			} else {
				return Oadr20bEiBuilders.newOadr20bReportIntervalTypeBuilder(intervalId, start, duration, rid, confidence, accuracy, statusValue).build();
			}
		}

		@Override
		public String toString() {
			return floatValue != null ? String.valueOf(floatValue) : "<oadrPayloadResourceStatus>";
		}

		public static BufferValue of(Float value) { return new BufferValue(value); }
		public static BufferValue of(OadrPayloadResourceStatusType value) { return new BufferValue(value); }
	}

	private class ReportRequestOrchestration {
		private ScheduledFuture<?> reportBackTask;
		private Map<String, ScheduledFuture<?>> simulateReadingTask = new ConcurrentHashMap<>();
		private Map<String, ConcurrentSkipListMap<Long, BufferValue>> simulateReadingBuffer = new ConcurrentHashMap<>();
		private Map<String, Long> nextReportStart = new ConcurrentHashMap<>();
		private OadrReportRequestType reportRequest;
		private UpdateReportOrchestratorListener listener;
		private VtnSessionConfiguration vtnConfig;

		public ReportRequestOrchestration(VtnSessionConfiguration vtnConfig, OadrReportRequestType reportRequest, UpdateReportOrchestratorListener listener) {
			this.vtnConfig = vtnConfig;
			this.reportRequest = reportRequest;
			this.listener = listener;
		}

		public void start() {
			OffsetDateTime start = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES);

			DurationPropType granularity = reportRequest.getReportSpecifier().getGranularity();
			DurationPropType reportBackDuration = reportRequest.getReportSpecifier().getReportBackDuration();
			long granularityMs = Oadr20bFactory.xmlDurationToMillisecond(granularity.getDuration());
			long reportBackMs = Math.max(Oadr20bFactory.xmlDurationToMillisecond(reportBackDuration.getDuration()), granularityMs * 2);

			reportRequest.getReportSpecifier().getSpecifierPayload().forEach(specifier -> {
				String rid = specifier.getRID();
				ConcurrentSkipListMap<Long, BufferValue> buffer = new ConcurrentSkipListMap<>();
				simulateReadingBuffer.put(rid, buffer);
				nextReportStart.put(rid, start.toInstant().toEpochMilli());

				Optional<OadrReportType> report = vtnConfig.getReport(reportRequest.getReportSpecifier().getReportSpecifierID());
				Optional<OadrReportDescriptionType> reportDescription = vtnConfig.getReportDescription(reportRequest.getReportSpecifier().getReportSpecifierID(), rid);
				for (int i = 0; i < 2; i++) {
					long ts = start.toInstant().toEpochMilli() + i * granularityMs;
					BufferValue value = (report.isPresent() && reportDescription.isPresent() && reportDescription.get().getReportSubject() != null)
							? listener.readReportData(report.get(), reportDescription.get())
							: BufferValue.of(0.0f);
					buffer.put(ts, value);
				}

				scheduleNextGranularityTask(specifier, start.plus(granularityMs, ChronoUnit.MILLIS), granularityMs);
			});

			scheduleNextReportBack(reportBackMs);
		}

		private void scheduleNextGranularityTask(SpecifierPayloadType specifier, OffsetDateTime nextStart, long granularityMs) {
			GranularityTask task = new GranularityTask(nextStart, this, specifier, granularityMs);
			ScheduledFuture<?> scheduled = scheduledExecutorService.schedule(task, granularityMs, TimeUnit.MILLISECONDS);
			simulateReadingTask.put(specifier.getRID(), scheduled);
		}

		private void scheduleNextReportBack(long reportBackMs) {
			ReportBackTask reportBack = new ReportBackTask(this, reportBackMs);
			this.reportBackTask = scheduledExecutorService.schedule(reportBack, reportBackMs, TimeUnit.MILLISECONDS);
		}

		public void cancel(boolean interrupt) {
			if (reportBackTask != null) reportBackTask.cancel(interrupt);
			simulateReadingTask.values().forEach(f -> f.cancel(interrupt));
		}

		private class GranularityTask implements Runnable {
			private OffsetDateTime start;
			private ReportRequestOrchestration orchestration;
			private SpecifierPayloadType specifier;
			private long granularityMs;

			public GranularityTask(OffsetDateTime start, ReportRequestOrchestration orchestration, SpecifierPayloadType specifier, long granularityMs) {
				this.start = start;
				this.orchestration = orchestration;
				this.specifier = specifier;
				this.granularityMs = granularityMs;
			}

			@Override
			public void run() {
				try {
					String rid = specifier.getRID();
					ConcurrentSkipListMap<Long, BufferValue> buffer = orchestration.simulateReadingBuffer.get(rid);
					Optional<OadrReportType> report = orchestration.vtnConfig.getReport(orchestration.reportRequest.getReportSpecifier().getReportSpecifierID());
					Optional<OadrReportDescriptionType> reportDescription = orchestration.vtnConfig.getReportDescription(orchestration.reportRequest.getReportSpecifier().getReportSpecifierID(), rid);

					BufferValue value = (report.isPresent() && reportDescription.isPresent() && reportDescription.get().getReportSubject() != null)
							? orchestration.listener.readReportData(report.get(), reportDescription.get())
							: BufferValue.of(0.0f);

					buffer.put(start.toInstant().toEpochMilli(), value);
					orchestration.simulateReadingBuffer.put(rid, buffer);

					OffsetDateTime next = start.plus(granularityMs, ChronoUnit.MILLIS);
					scheduleNextGranularityTask(specifier, next, granularityMs);

				} catch (Exception e) {
					LOGGER.error("Error in GranularityTask", e);
				}
			}
		}

		private class ReportBackTask implements Runnable {
			private ReportRequestOrchestration orchestration;
			private long reportBackMs;

			public ReportBackTask(ReportRequestOrchestration orchestration, long reportBackMs) {
				this.orchestration = orchestration;
				this.reportBackMs = reportBackMs;
			}

			@Override
			public void run() {
				try {
					orchestration.simulateReadingBuffer.forEach((rid, buffer) -> {
						long startMs = orchestration.nextReportStart.getOrDefault(rid, buffer.firstKey());
						long endMs = startMs + reportBackMs;

						Oadr20bUpdateReportBuilder updateBuilder = Oadr20bEiReportBuilders
								.newOadr20bUpdateReportBuilder("0", orchestration.vtnConfig.getVenId());

						ReportNameEnumeratedType reportName = ReportNameEnumeratedType.TELEMETRY_USAGE;
						Optional<OadrReportType> reportOpt = orchestration.vtnConfig.getReport(
								orchestration.reportRequest.getReportSpecifier().getReportSpecifierID()
						);
						if (reportOpt.isPresent() && reportOpt.get().getReportName() != null) {
							try {
								String name = reportOpt.get().getReportName();
								if (name.startsWith("METADATA_")) {
									name = name.substring("METADATA_".length());
								}
								reportName = ReportNameEnumeratedType.fromValue(name);
							} catch (IllegalArgumentException ex) {
								LOGGER.warn("Unknown report name {}, fallback to TELEMETRY_USAGE", reportOpt.get().getReportName());
							}
						}


						Oadr20bUpdateReportOadrReportBuilder reportBuilder =
								Oadr20bEiReportBuilders.newOadr20bUpdateReportOadrReportBuilder(
										"0",
										orchestration.reportRequest.getReportSpecifier().getReportSpecifierID(),
										orchestration.reportRequest.getReportRequestID(),
										reportName,
										System.currentTimeMillis(),
										startMs,
										Oadr20bFactory.millisecondToXmlDuration(reportBackMs)
								);

						int intervalId = 0;
						for (Entry<Long, BufferValue> entry : buffer.subMap(startMs, endMs).entrySet()) {
							reportBuilder.addInterval(
									entry.getValue().toInterval(
											String.valueOf(intervalId++),
											entry.getKey(),
											orchestration.reportRequest.getReportSpecifier().getGranularity().getDuration(),
											rid,
											1L,
											1.0f
									)
							);
						}

						orchestration.nextReportStart.put(rid, endMs);
						updateBuilder.addReport(reportBuilder.build());

						OadrUpdateReportType updateReport = updateBuilder.build();
						oadr20bVENEiReportService.updateReport(orchestration.vtnConfig, updateReport);
					});

					scheduleNextReportBack(reportBackMs);

				} catch (Exception e) {
					LOGGER.error("Error in ReportBackTask", e);
				}
			}

		}
	}

	public String getOrchestrationUUID(VtnSessionConfiguration vtnConfig, String reportRequestId) {
		return new StringBuilder().append(vtnConfig.getSessionKey()).append(reportRequestId).toString();
	}
}
