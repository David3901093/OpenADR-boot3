package com.avob.openadr.server.oadr20b.ven.service;

import java.util.*;

import com.avob.openadr.server.oadr20b.ven.ReportSpecifierStatus;
import  jakarta.annotation.Resource;

import org.eclipse.jetty.http.HttpStatus;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jxmpp.stringprep.XmppStringprepException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.avob.openadr.model.oadr20b.builders.Oadr20bEiReportBuilders;
import com.avob.openadr.model.oadr20b.builders.Oadr20bResponseBuilders;
import com.avob.openadr.model.oadr20b.ei.ReadingTypeEnumeratedType;
import com.avob.openadr.model.oadr20b.ei.ReportSpecifierType;
import com.avob.openadr.model.oadr20b.ei.SpecifierPayloadType;
import com.avob.openadr.model.oadr20b.errorcodes.Oadr20bApplicationLayerErrorCode;
import com.avob.openadr.model.oadr20b.exception.Oadr20bException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bHttpLayerException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bMarshalException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bXMLSignatureException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bXMLSignatureValidationException;
import com.avob.openadr.model.oadr20b.oadr.OadrCancelReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrCanceledReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreateReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreatedReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrRegisterReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrRegisteredReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrReportRequestType;
import com.avob.openadr.model.oadr20b.oadr.OadrResponseType;
import com.avob.openadr.model.oadr20b.oadr.OadrUpdateReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrUpdatedReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrReportType;
import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.avob.openadr.server.oadr20b.ven.exception.Oadr20bInvalidReportRequestException;

import  com.avob.openadr.model.oadr20b.ei.ReportNameEnumeratedType;


@Service
public class Oadr20bVENEiReportService implements Oadr20bVENEiService {

	private static final String EI_SERVICE_NAME = "EiReport";

	protected static final Logger LOGGER = LoggerFactory.getLogger(Oadr20bVENEiReportService.class);

	protected static final String METADATA_REPORT_SPECIFIER_ID = "METADATA";
	protected static final String METADATA_REPORT_RID = "0";
	protected static final String NO_GRANULARITY = "P0D";

	@Resource
	private MultiVtnConfig multiVtnConfig;

	private Map<String, Map<String, OadrReportRequestType>> venRequestReport = new HashMap<>();

	private Map<String, OadrRegisterReportType> vtnRegisteredReport = new HashMap<>();

	private List<Oadr20bVENEiReportServiceVenReportListener> venReportListeners = new ArrayList<>();

	private List<Oadr20bVENEiReportServiceVtnReportListener> vtnReportListeners = new ArrayList<>();


	public void registerReport(VtnSessionConfiguration vtnConfiguration, String reportTypeRequestID) {

		OadrRegisterReportType payload = multiVtnConfig.getVenRegisterReport(vtnConfiguration);
		 payload.setReportRequestID(reportTypeRequestID);
        try {
			multiVtnConfig.oadrRegisterReport(vtnConfiguration, payload);
		} catch (XmppStringprepException | NotConnectedException | Oadr20bException | Oadr20bHttpLayerException
				| Oadr20bXMLSignatureException | Oadr20bXMLSignatureValidationException | Oadr20bMarshalException
				| InterruptedException e) {
			LOGGER.error("Can't register report", e);
		}
	}



	public OadrCreateReportType createReportMetadata(VtnSessionConfiguration vtnConfiguration) {
		String requestId = UUID.randomUUID().toString();
		String reportRequestId = UUID.randomUUID().toString();

		// Require RegisterReport from VTN (by sending METADATA CreatedReport)
		OadrReportRequestType oadrReportRequestType = Oadr20bEiReportBuilders
				.newOadr20bReportRequestTypeBuilder(reportRequestId, METADATA_REPORT_SPECIFIER_ID, NO_GRANULARITY,
						NO_GRANULARITY)
				.addSpecifierPayload(null, ReadingTypeEnumeratedType. X_NOT_APPLICABLE, METADATA_REPORT_RID).build();
		OadrCreateReportType createReport = Oadr20bEiReportBuilders
				.newOadr20bCreateReportBuilder(requestId, vtnConfiguration.getVenId())
				.addReportRequest(oadrReportRequestType).build();

		try {
			multiVtnConfig.oadrCreateReport(vtnConfiguration, createReport);
			return createReport;
		} catch (XmppStringprepException | NotConnectedException | Oadr20bException | Oadr20bHttpLayerException
				| Oadr20bXMLSignatureException | Oadr20bXMLSignatureValidationException | Oadr20bMarshalException
				| InterruptedException e) {
			LOGGER.error("Can't create report metadata", e);
			return null;
		}
	}

	public void updateReport(VtnSessionConfiguration vtnConfiguration, OadrUpdateReportType payload) {
		try {
			multiVtnConfig.oadrUpdateReport(vtnConfiguration, payload);
		} catch (XmppStringprepException | NotConnectedException | Oadr20bException | Oadr20bHttpLayerException
				| Oadr20bXMLSignatureException | Oadr20bXMLSignatureValidationException | Oadr20bMarshalException
				| InterruptedException e) {
			LOGGER.error("Can't send update report", e);
		}
	}

	public OadrCreatedReportType oadrCreateReport(VtnSessionConfiguration vtnConfig,
			OadrCreateReportType oadrCreateReportType,boolean isPiggyback) {
		String requestID = oadrCreateReportType.getRequestID();
		String reportTypeRequestID = null;

		boolean sendSelfRegisterReport = false;
		boolean sendUpdateReport = true;
		try {
			int CreatedReportCode = HttpStatus.OK_200;
			List<OadrReportRequestType> oadrReportRequest = oadrCreateReportType.getOadrReportRequest();
			if (oadrReportRequest != null) {
				for (OadrReportRequestType request : oadrReportRequest) {
					String reportRequestID = request.getReportRequestID();
					ReportSpecifierType reportSpecifier = request.getReportSpecifier();
					String reportSpecifierID = reportSpecifier.getReportSpecifierID();
					if (METADATA_REPORT_SPECIFIER_ID.equals(reportSpecifierID)) {
						int count = 0;
						for (SpecifierPayloadType specifier : reportSpecifier.getSpecifierPayload()) {
							String rid = specifier.getRID();
							if (METADATA_REPORT_RID.equals(rid)) {
								sendSelfRegisterReport = true;
								if (count==0){
									//the first one is the reportRequestID
									reportTypeRequestID = reportRequestID;

								}
								addVenReportRequest(vtnConfig, request,reportRequestID);
								count+=1;
							}

						}
					} else {
						Integer res = multiVtnConfig.checkReportSpecifier(vtnConfig, requestID, reportRequestID, reportSpecifier);
						sendUpdateReport = Objects.equals(res, ReportSpecifierStatus.OK);
						addVenReportRequest(vtnConfig, request,reportRequestID);
						if (!sendUpdateReport){
                            try {
								if (res.equals(ReportSpecifierStatus.INVALID_REPORT_SPECIFIER_ID) || res.equals(ReportSpecifierStatus.INVALID_REPORT_DESCRIPTION_ID)){
									isPiggyback=false;
									CreatedReportCode = Oadr20bApplicationLayerErrorCode.INVALID_ID_452;
								}
								if(isPiggyback){

									multiVtnConfig.oadrUpdateReport(vtnConfig, Oadr20bEiReportBuilders.newOadr20bUpdateReportBuilder(requestID,vtnConfig.getVenId()).buildDefaultUpdateReport(requestID,vtnConfig.getVenId(),reportRequestID,reportSpecifierID,reportSpecifier,resolveReportName(vtnConfig,reportSpecifierID)));
								}else{
									//  In push model,   an update report is needed to reply to the VTN
									if (!vtnConfig.getPullModel()){
										multiVtnConfig.oadrUpdateReport(vtnConfig, Oadr20bEiReportBuilders.newOadr20bUpdateReportBuilder(requestID,vtnConfig.getVenId()).build());
									}
									break;
								}
                            }catch (Exception e){
								LOGGER.error("Can't send update report", e);

							}
                        }

					}

				}

			}
			// if the report can piggyback,the reportRequestID comes from the createReport,else the reportRequestID is null.
			if (sendSelfRegisterReport) {
				if (isPiggyback){
					this.registerReport(vtnConfig, reportTypeRequestID);
				}
				else {
					this.registerReport(vtnConfig, null);
				}

				LOGGER.info("Sending self register report");
			}
			if (sendUpdateReport){
				venReportListeners.forEach(listener -> {
					listener.onCreateReport(vtnConfig, oadrCreateReportType);
				});
			}

			OadrCreatedReportType oadrCreatedReportType= Oadr20bEiReportBuilders
					.newOadr20bCreatedReportBuilder(requestID, CreatedReportCode,
							vtnConfig.getVenId())
					.addPendingReportRequestId(getExistingVenReportRequest(vtnConfig))
					.build();
			return oadrCreatedReportType;


		} catch (Oadr20bInvalidReportRequestException e) {
			return Oadr20bEiReportBuilders.newOadr20bCreatedReportBuilder(requestID,
					Integer.valueOf(e.getResponse().getEiResponse().getResponseCode()), e.getResponse().getVenID())
					.withResponseDescription(e.getResponse().getEiResponse().getResponseDescription()).build();
		}

	}

	public OadrCanceledReportType oadrCancelReport(VtnSessionConfiguration vtnConfig,
												   OadrCancelReportType oadrCancelReportType) {

		String requestID = oadrCancelReportType.getRequestID();

		List<String> existingVenReportRequest = getExistingVenReportRequest(vtnConfig);
		List<String> canceledReportRequest = new ArrayList<>(oadrCancelReportType.getReportRequestID());


		canceledReportRequest.removeAll(existingVenReportRequest);
		if (!canceledReportRequest.isEmpty()) {
			return Oadr20bEiReportBuilders
					.newOadr20bCanceledReportBuilder(requestID, Oadr20bApplicationLayerErrorCode.NOT_RECOGNIZED_453,
							vtnConfig.getVenId())
					.withResponseDescription(
							String.format("Invalid cancel report - Report request id %s not recognized",
									String.join(",", canceledReportRequest)))
					.build();
		}

		boolean reportToFollow =oadrCancelReportType.isReportToFollow();


		oadrCancelReportType.getReportRequestID().forEach(canceledReportRequestId -> {
			removeVenReportRequest(vtnConfig, canceledReportRequestId);
		});

		List<String> pendingReports = new ArrayList<>();
		if (reportToFollow) {
			String newReportRequestID = "ReportReqID_" + System.currentTimeMillis();
			pendingReports.add(newReportRequestID);
			// send update report
			OadrUpdateReportType oadrUpdateReportType =  Oadr20bEiReportBuilders.newOadr20bUpdateReportBuilder(requestID, vtnConfig.getVenId()).build();
			try {
				multiVtnConfig.oadrUpdateReport(vtnConfig,oadrUpdateReportType);
			} catch (Exception e) {
				LOGGER.error("Can't send update report", e);
			}
		}

		venReportListeners.forEach(listener -> {
			listener.onCancelReport(vtnConfig, oadrCancelReportType);
		});
		if (vtnConfig.getPullModel()){
			// send update report
			OadrUpdateReportType oadrUpdateReportType =  Oadr20bEiReportBuilders.newOadr20bUpdateReportBuilder(requestID, vtnConfig.getVenId()).build();
			try {
				multiVtnConfig.oadrUpdateReport(vtnConfig,oadrUpdateReportType);
			} catch (Exception e) {
				LOGGER.error("Can't send update report", e);
			}
		}

        return Oadr20bEiReportBuilders
				.newOadr20bCanceledReportBuilder(requestID, HttpStatus.OK_200,
						vtnConfig.getVenId())
				.addPendingReportRequestId(pendingReports)
				.build();
	}

	public Object oadrRegisteredReport(VtnSessionConfiguration vtnConfig,
			OadrRegisteredReportType oadrRegisteredReportType) {

		venReportListeners.forEach(listener -> {
			listener.onRegisteredReport(vtnConfig, oadrRegisteredReportType);
		});

		return Oadr20bResponseBuilders
				.newOadr20bResponseBuilder(oadrRegisteredReportType.getEiResponse().getRequestID(), HttpStatus.OK_200)
				.build();
	}

	public Object oadrUpdatedReport(VtnSessionConfiguration vtnConfig, OadrUpdatedReportType oadrUpdatedReportType) {
		venReportListeners.forEach(listener -> {
			listener.onUpdatedReport(vtnConfig, oadrUpdatedReportType);
		});

		return Oadr20bResponseBuilders
				.newOadr20bResponseBuilder(oadrUpdatedReportType.getEiResponse().getRequestID(), HttpStatus.OK_200)
				.build();
	}

	public OadrRegisteredReportType addRequestReport( OadrRegisteredReportType oadrRegisteredReportType,OadrReportRequestType requestReport){
		oadrRegisteredReportType.getOadrReportRequest().add(requestReport);
		return oadrRegisteredReportType;
	}

	public OadrRegisteredReportType oadrRegisterReport(VtnSessionConfiguration vtnConfig, OadrRegisterReportType oadrRegisterReportType) {

		String requestID = oadrRegisterReportType.getRequestID();

		vtnRegisteredReport.put(vtnConfig.getSessionKey(), oadrRegisterReportType);


		vtnReportListeners.forEach(listener -> {
			listener.onRegisterReport(vtnConfig, oadrRegisterReportType);
		});

		List<OadrReportRequestType> venReportRequests = venRequestReport.get(vtnConfig.getSessionKey()) == null ? null
				: venRequestReport.get(vtnConfig.getSessionKey()).values().stream().toList();

		if (venReportRequests!= null && ! venReportRequests.isEmpty()) {
			return 	Oadr20bEiReportBuilders
					.newOadr20bRegisteredReportBuilder(requestID, HttpStatus.OK_200, vtnConfig.getVenId()).addReportRequest(venReportRequests)
					.build();
		}

		return 	 Oadr20bEiReportBuilders
				.newOadr20bRegisteredReportBuilder(requestID, HttpStatus.OK_200, vtnConfig.getVenId())
				.build();
	}

	private String resolveReportName(VtnSessionConfiguration vtnSessionConfiguration, String reportSpecifierID) {
		OadrRegisterReportType registerReport = multiVtnConfig.getVenRegisterReport(vtnSessionConfiguration);
		if (registerReport == null) {
			LOGGER.warn("No registered report found for Ven: {}",vtnSessionConfiguration.getVenId());
			return ReportNameEnumeratedType.TELEMETRY_USAGE.value();
		}

		for (OadrReportType report : registerReport.getOadrReport()) {
			if (report.getReportSpecifierID() != null &&
					report.getReportSpecifierID().equals(reportSpecifierID)) {
				String name =  report.getReportName();
					if (name.startsWith("METADATA_")) {
						name = name.substring("METADATA_".length());
					}
					return name ;

			}
		}
		LOGGER.warn("No matching reportName found for reportSpecifierID: {}", reportSpecifierID);
		return ReportNameEnumeratedType.TELEMETRY_USAGE.value(); // default reportName
	}

	public OadrUpdatedReportType oadrUpdateReport(VtnSessionConfiguration vtnConfig,
			OadrUpdateReportType oadrUpdateReportType) {

		String requestID = oadrUpdateReportType.getRequestID();

		vtnReportListeners.forEach(listener -> {
			listener.onUpdateReport(vtnConfig, oadrUpdateReportType);
		});

		return Oadr20bEiReportBuilders.newOadr20bUpdatedReportBuilder(requestID, HttpStatus.OK_200,
				vtnConfig.getVenId()).build();
	}

	public OadrResponseType oadrCreatedReport(VtnSessionConfiguration vtnConfig,
			OadrCreatedReportType oadrCreatedReportType) {

		vtnReportListeners.forEach(listener -> {
			listener.onCreatedReport(vtnConfig, oadrCreatedReportType);
		});

		return Oadr20bResponseBuilders
				.newOadr20bResponseBuilder(oadrCreatedReportType.getEiResponse().getRequestID(), HttpStatus.OK_200,vtnConfig.getVenId())
				.build();
	}

	public OadrResponseType oadrCanceledReport(VtnSessionConfiguration vtnConfig,
			OadrCanceledReportType oadrCanceledReportType) {
		vtnReportListeners.forEach(listener -> {
			listener.onCanceledReport(vtnConfig, oadrCanceledReportType);
		});

		return Oadr20bResponseBuilders
				.newOadr20bResponseBuilder(oadrCanceledReportType.getEiResponse().getRequestID(), HttpStatus.OK_200)
				.build();
	}

	public void addVenListener(Oadr20bVENEiReportServiceVenReportListener listener) {
		if (venReportListeners == null) {
			venReportListeners = new ArrayList<Oadr20bVENEiReportServiceVenReportListener>();
		}

		if (!venReportListeners.contains(listener)) {
			venReportListeners.add(listener);
		}
	}

	public void addVtnListener(Oadr20bVENEiReportServiceVtnReportListener listener) {
		if (vtnReportListeners == null) {
			vtnReportListeners = new ArrayList<Oadr20bVENEiReportServiceVtnReportListener>();
		}

		if (!vtnReportListeners.contains(listener)) {
			vtnReportListeners.add(listener);
		}
	}

	private List<String> getExistingVenReportRequest(VtnSessionConfiguration vtnConfig) {
		Map<String, OadrReportRequestType> map = venRequestReport.get(vtnConfig.getSessionKey());
		List<String> pending = new ArrayList<>();
		if (map != null) {
			pending = new ArrayList<>(map.keySet());

		}
		return pending;
	}

	private void addVenReportRequest(VtnSessionConfiguration vtnConfig, OadrReportRequestType reportRequest, String reportRequestID) {
		Map<String, OadrReportRequestType> map = venRequestReport.get(vtnConfig.getSessionKey());
		if (map == null) {
			map = new HashMap<>();
		}
		map.put(reportRequestID, reportRequest);
		venRequestReport.put(vtnConfig.getSessionKey(), map);
	}
	private void removeVenReportRequest(VtnSessionConfiguration vtnConfig, String reportRequestId) {
		Map<String, OadrReportRequestType> map = venRequestReport.get(vtnConfig.getSessionKey());
		if (map != null) {
			map.remove(reportRequestId);
			if (map.isEmpty()) {
				venRequestReport.remove(vtnConfig.getSessionKey());
			} else {
				venRequestReport.put(vtnConfig.getSessionKey(), map);
			}
		}
	}

	public interface Oadr20bVENEiReportServiceVenReportListener {
		public void onCreateReport(VtnSessionConfiguration vtnConfiguration, OadrCreateReportType oadrCreateReportType);

		public void onCancelReport(VtnSessionConfiguration vtnConfiguration, OadrCancelReportType oadrCreateReportType);

		public void onRegisteredReport(VtnSessionConfiguration vtnConfiguration,
				OadrRegisteredReportType registeredreport);

		public void onUpdatedReport(VtnSessionConfiguration vtnConfiguration, OadrUpdatedReportType registeredreport);
	}

	public interface Oadr20bVENEiReportServiceVtnReportListener {

		public void onRegisterReport(VtnSessionConfiguration vtnConfiguration, OadrRegisterReportType registerReport);

		public void onUpdateReport(VtnSessionConfiguration vtnConfiguration, OadrUpdateReportType updateReport);

		public void onCreatedReport(VtnSessionConfiguration vtnConfiguration, OadrCreatedReportType registration);

		public void onCanceledReport(VtnSessionConfiguration vtnConfiguration, OadrCanceledReportType registration);
	}

	@Override
	public Object request(VtnSessionConfiguration multiConfig, Object unmarshal) {

		if (unmarshal instanceof OadrCancelReportType) {

			OadrCancelReportType oadrCancelReportType = (OadrCancelReportType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - OadrCancelReport");

			return oadrCancelReport(multiConfig, oadrCancelReportType);

		} else if (unmarshal instanceof OadrCreateReportType) {

			OadrCreateReportType oadrCreateReportType = (OadrCreateReportType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - OadrCreateReport");

			return oadrCreateReport(multiConfig, oadrCreateReportType,true);

		} else if (unmarshal instanceof OadrRegisterReportType) {

			OadrRegisterReportType oadrRegisterReportType = (OadrRegisterReportType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - OadrRegisterReport");

			return oadrRegisterReport(multiConfig, oadrRegisterReportType);

		} else if (unmarshal instanceof OadrUpdateReportType) {

			OadrUpdateReportType oadrUpdateReportType = (OadrUpdateReportType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - OadrUpdateReport");

			return oadrUpdateReport(multiConfig, oadrUpdateReportType);

		} else if (unmarshal instanceof OadrCanceledReportType) {

			OadrCanceledReportType oadrCanceledReportType = (OadrCanceledReportType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - OadrCanceledReportType");

			return oadrCanceledReport(multiConfig, oadrCanceledReportType);

		} else if (unmarshal instanceof OadrCreatedReportType) {

			OadrCreatedReportType oadrCreatedReportType = (OadrCreatedReportType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - OadrCreatedReportType");

			return oadrCreatedReport(multiConfig, oadrCreatedReportType);

		} else if (unmarshal instanceof OadrRegisteredReportType) {

			OadrRegisteredReportType oadrRegisteredReportType = (OadrRegisteredReportType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - OadrRegisteredReportType");

			return oadrRegisteredReport(multiConfig, oadrRegisteredReportType);

		} else if (unmarshal instanceof OadrUpdatedReportType) {

			OadrUpdatedReportType oadrUpdatedReportType = (OadrUpdatedReportType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - OadrUpdatedReportType");

			return oadrUpdatedReport(multiConfig, oadrUpdatedReportType);

		}

		return Oadr20bResponseBuilders
				.newOadr20bResponseBuilder("0", Oadr20bApplicationLayerErrorCode.NOT_RECOGNIZED_453,
						multiConfig.getVtnId())
				.withDescription("Unknown payload type for service: " + this.getServiceName()).build();
	}

	@Override
	public String getServiceName() {
		return EI_SERVICE_NAME;
	}

}
