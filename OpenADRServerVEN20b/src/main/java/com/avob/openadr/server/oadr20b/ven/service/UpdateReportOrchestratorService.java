package com.avob.openadr.server.oadr20b.ven.service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import  jakarta.annotation.Resource;

import org.eclipse.jetty.http.HttpStatus;
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
import com.avob.openadr.model.oadr20b.oadr.OadrUpdatedReportType;
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

	public class ReportRequestOrchestration {

		private ScheduledFuture<?> reportBackTask;
		private Map<String, ScheduledFuture<?>> simulateReadingTask = new ConcurrentHashMap<>();
		private Map<String, TreeMap<Long, BufferValue>> simulateReadingBuffer = new ConcurrentHashMap<>();
		private OadrReportRequestType reportRequest;
		private UpdateReportOrchestratorListener listener;
		private VtnSessionConfiguration vtnConfig;
		private volatile boolean cancelRequested = false;
		private volatile boolean cancelSent = false;

		private String reportRequestId;

		public ReportRequestOrchestration(VtnSessionConfiguration vtnConfig,
										  OadrReportRequestType reportRequest,
										  UpdateReportOrchestratorListener listener) {
			this.vtnConfig = vtnConfig;
			this.reportRequest = reportRequest;
			this.listener = listener;
			this.reportRequestId = "ReportReqID_" + System.currentTimeMillis();
		}

		public void start() {
			OffsetDateTime start = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES).plusMinutes(1);

			DurationPropType reportBackDuration = reportRequest.getReportSpecifier().getReportBackDuration();
			DurationPropType granularity = reportRequest.getReportSpecifier().getGranularity();
			long reportBackDurationMs = Oadr20bFactory.xmlDurationToMillisecond(reportBackDuration.getDuration());

			OffsetDateTime reportBackStart = start.plus(reportBackDurationMs, ChronoUnit.MILLIS);
			reportBackTask = scheduledExecutorService.schedule(
					new ReportBackTask(reportBackStart, this),
					reportBackDurationMs,
					TimeUnit.MILLISECONDS
			);

			reportRequest.getReportSpecifier().getSpecifierPayload().forEach(specifier -> {
				String rid = specifier.getRID();
				long granularityMs = Oadr20bFactory.xmlDurationToMillisecond(granularity.getDuration());
				GranularityTask simulateRidReadingTask = new GranularityTask(start, this, specifier);

				ScheduledFuture<?> task = simulateReadingTask.get(rid);
				if (task == null) {
					task = scheduledExecutorService.schedule(simulateRidReadingTask, granularityMs, TimeUnit.MILLISECONDS);
					simulateReadingTask.put(rid, task);
				}
			});
		}

		public void requestCancel() {
			this.cancelRequested = true;
			simulateReadingTask.values().forEach(task -> task.cancel(false));
			LOGGER.info("Cancel requested for reportRequestId={}", reportRequestId);
		}

		public boolean isCancelRequested() {
			return cancelRequested;
		}

		public void cancel(boolean interrupt) {
			this.cancelRequested = true;
			if (reportBackTask != null) {
				reportBackTask.cancel(interrupt);
			}
			simulateReadingTask.values().forEach(task -> task.cancel(interrupt));
			simulateReadingTask.clear();
			simulateReadingBuffer.clear();
		}

		private class ReportBackTask implements Runnable {

			private OffsetDateTime start;
			private ReportRequestOrchestration orchestration;

			public ReportBackTask(OffsetDateTime start, ReportRequestOrchestration orchestration) {
				this.orchestration = orchestration;
				this.start = start;
			}

			@Override
			public void run() {
				try {
					String reportRequestId = orchestration.reportRequestId;
					String reportSpecifierID = orchestration.reportRequest.getReportSpecifier().getReportSpecifierID();
					DurationPropType granularity = orchestration.reportRequest.getReportSpecifier().getGranularity();
					DurationPropType reportBackDuration = orchestration.reportRequest.getReportSpecifier().getReportBackDuration();

					Oadr20bUpdateReportBuilder updateReportBuilder =
							Oadr20bEiReportBuilders.newOadr20bUpdateReportBuilder(reportRequestId, orchestration.vtnConfig.getVenId());

					orchestration.simulateReadingBuffer.forEach((rid, ridMap) -> {
						Oadr20bUpdateReportOadrReportBuilder reportBuilder =
								Oadr20bEiReportBuilders.newOadr20bUpdateReportOadrReportBuilder(
										reportRequestId, reportSpecifierID, reportRequestId,
										ReportNameEnumeratedType.TELEMETRY_USAGE,
										System.currentTimeMillis(),
										ridMap.entrySet().stream().findFirst().map(Entry::getKey).orElse(System.currentTimeMillis()),
										granularity.getDuration()
								);

						int i = 0;
						for (Entry<Long, BufferValue> entry : ridMap.entrySet()) {
							reportBuilder.addInterval(entry.getValue().toInterval(
									String.valueOf(i++),
									entry.getKey(),
									granularity.getDuration(),
									rid,
									1L,
									1F
							));
						}
						updateReportBuilder.addReport(reportBuilder.build());
					});

					orchestration.simulateReadingBuffer.clear();
					OadrUpdateReportType updateReport = updateReportBuilder.build();

					OadrCancelReportType cancelReport = null;
					if (orchestration.isCancelRequested() && !orchestration.cancelSent) {
						cancelReport = Oadr20bEiReportBuilders
								.newOadr20bCancelReportBuilder(updateReport.getRequestID(),
										orchestration.vtnConfig.getVenId(), false)
								.addReportRequestId(reportRequestId)
								.build();
						orchestration.cancelSent = true;
						LOGGER.info("Piggyback cancel included for reportRequestId={}", reportRequestId);
					}
					if (cancelReport != null) {
						cancelReport.setRequestID(updateReport.getRequestID());
					}

					OadrUpdatedReportType updatedReport = Oadr20bEiReportBuilders
							.newOadr20bUpdatedReportBuilder(updateReport.getRequestID(), HttpStatus.OK_200, orchestration.vtnConfig.getVenId())
							.withOadrCancelReport(cancelReport)
							.build();

					oadr20bVENEiReportService.oadrUpdatedReport(orchestration.vtnConfig, updatedReport);

					long delay = Oadr20bFactory.xmlDurationToMillisecond(reportBackDuration.getDuration());
					OffsetDateTime nextStart = start.plus(java.time.Duration.ofMillis(delay));
					orchestration.reportBackTask = scheduledExecutorService.schedule(
							new ReportBackTask(nextStart, orchestration),
							delay,
							TimeUnit.MILLISECONDS
					);

				} catch (Exception e) {
					LOGGER.error("Error during report back task execution", e);
				}
			}
		}
	}




	private class GranularityTask implements Runnable {

		private OffsetDateTime start;
		private ReportRequestOrchestration orchestration;
		private SpecifierPayloadType specifier;

		public GranularityTask(OffsetDateTime start, ReportRequestOrchestration orchestration,
				SpecifierPayloadType specifier) {
			this.start = start;
			this.orchestration = orchestration;
			this.specifier = specifier;
		}

		@Override
		public void run() {

			VtnSessionConfiguration multiConfig = orchestration.vtnConfig;

			String reportRequestId = orchestration.reportRequest.getReportRequestID();
			String reportSpecifierId = orchestration.reportRequest.getReportSpecifier().getReportSpecifierID();
			String rid = specifier.getRID();
			DurationPropType granularity = orchestration.reportRequest.getReportSpecifier().getGranularity();

			ScheduledFuture<?> scheduledFuture = orchestration.simulateReadingTask.get(rid);

			if (scheduledFuture.isCancelled()) {
				LOGGER.info(String.format("Cancel reading: %s %s %s %s", multiConfig.getVenName(), reportRequestId,
						reportSpecifierId, rid));
				return;
			}

			TreeMap<Long, BufferValue> ridMap = orchestration.simulateReadingBuffer.get(rid);
			if (ridMap == null) {
				ridMap = new TreeMap<>();
			}

			Optional<OadrReportType> report = orchestration.vtnConfig.getReport(reportSpecifierId);

			Optional<OadrReportDescriptionType> reportDescription = orchestration.vtnConfig
					.getReportDescription(reportSpecifierId, rid);

			if (report.isPresent() && reportDescription.isPresent()) {

				BufferValue value = orchestration.listener.readReportData(report.get(), reportDescription.get());

				ridMap.put(start.toInstant().toEpochMilli(), value);

				orchestration.simulateReadingBuffer.put(rid, ridMap);

				Long granularityToMillisecond = Oadr20bFactory.xmlDurationToMillisecond(granularity.getDuration());
				OffsetDateTime plus = start.plus(java.time.Duration.ofMillis(granularityToMillisecond));

				GranularityTask simulateRidReadingTask = new GranularityTask(plus, orchestration, specifier);
				ScheduledFuture<?> schedule = scheduledExecutorService.schedule(simulateRidReadingTask,
						granularityToMillisecond, TimeUnit.MILLISECONDS);

				orchestration.simulateReadingTask.put(rid, schedule);

				LOGGER.info(String.format("Reading: %s %s %s", reportSpecifierId, rid, value.toString()));

			} else {
				LOGGER.warn(String.format("Unknown report reportSpecifierID: %s rID: %s", reportSpecifierId, rid));
			}

		}

	}

	static public class BufferValue {

		private Float floatValue;
		private OadrPayloadResourceStatusType statusValue;

		private BufferValue(Float floatValue) {
			this.floatValue = floatValue;
		}

		private BufferValue(OadrPayloadResourceStatusType statusValue) {
			this.statusValue = statusValue;
		}

		public IntervalType toInterval(String intervalId, Long start, String duration, String rid, Long confidence,
				Float accuracy) {
			if (floatValue != null) {
				return Oadr20bEiBuilders.newOadr20bReportIntervalTypeBuilder(intervalId, start, duration, rid,
						confidence, accuracy, floatValue).build();
			} else {
				return Oadr20bEiBuilders.newOadr20bReportIntervalTypeBuilder(intervalId, start, duration, rid,
						confidence, accuracy, statusValue).build();
			}

		}

		public String toString() {
			if (floatValue != null) {
				return String.valueOf(floatValue);
			} else {
				return "<oadrPayloadResourceStatus>";
			}
		}

		public static BufferValue of(Float value) {
			return new BufferValue(value);
		}
		
		public static BufferValue of(OadrPayloadResourceStatusType value) {
			return new BufferValue(value);
		}

	}



	public void addReportRequestOrchestration(VtnSessionConfiguration vtnConfig, OadrReportRequestType reportRequest,
			UpdateReportOrchestratorListener listener) {

	}

	public String getOrchestrationUUID(VtnSessionConfiguration vtnConfig, String reportRequestId) {

		return new StringBuilder().append(vtnConfig.getSessionKey()).append(reportRequestId).toString();

	}

}
