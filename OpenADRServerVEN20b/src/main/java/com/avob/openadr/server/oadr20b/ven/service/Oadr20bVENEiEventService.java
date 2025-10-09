package com.avob.openadr.server.oadr20b.ven.service;

import java.util.*;

import com.avob.openadr.model.oadr20b.builders.eiopt.Oadr20bCreateOptBuilder;
import  jakarta.annotation.Resource;

import org.eclipse.jetty.http.HttpStatus;

import com.avob.openadr.model.oadr20b.ei.OptReasonEnumeratedType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.avob.openadr.model.oadr20b.ei.SignalNameEnumeratedType;
import com.avob.openadr.model.oadr20b.ei.SignalTypeEnumeratedType;
import com.avob.openadr.model.oadr20b.builders.Oadr20bEiEventBuilders;
import com.avob.openadr.model.oadr20b.builders.Oadr20bResponseBuilders;
import com.avob.openadr.model.oadr20b.ei.EiEventSignalType;
import com.avob.openadr.model.oadr20b.ei.EventResponses.EventResponse;
import com.avob.openadr.model.oadr20b.ei.IntervalType;
import com.avob.openadr.model.oadr20b.ei.OptTypeType;
import com.avob.openadr.model.oadr20b.errorcodes.Oadr20bApplicationLayerErrorCode;
import com.avob.openadr.model.oadr20b.ei.SchemaVersionEnumeratedType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreatedEventType;
import com.avob.openadr.model.oadr20b.oadr.OadrDistributeEventType;
import com.avob.openadr.model.oadr20b.oadr.OadrDistributeEventType.OadrEvent;
import com.avob.openadr.model.oadr20b.oadr.OadrResponseType;
import com.avob.openadr.model.oadr20b.oadr.ResponseRequiredType;
import com.avob.openadr.model.oadr20b.oadr.OadrRequestEventType;
import com.avob.openadr.model.oadr20b.pyld.EiRequestEvent;
import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.avob.openadr.server.oadr20b.ven.exception.Oadr20bDistributeEventApplicationLayerException;
import com.avob.openadr.server.oadr20b.ven.timeline.Timeline;
import com.avob.openadr.server.oadr20b.ven.timeline.Timeline.ActiveBaselineSignal;
import com.avob.openadr.server.oadr20b.ven.timeline.Timeline.ActiveSignal;
import com.avob.openadr.server.oadr20b.ven.timeline.Timeline.EventTimelineListener;



@Service
public class Oadr20bVENEiEventService implements Oadr20bVENEiService {

	private static final String EI_SERVICE_NAME = "EiEvent";

	private static final Logger LOGGER = LoggerFactory.getLogger(Oadr20bVENEiEventService.class);

	@Resource
	private MultiVtnConfig multiVtnConfig;

	private Map<String, OadrEvent> optInEventsMap = new HashMap<>();

	protected List<EventTimelineListener> listeners;

	private Timeline timeline = new Timeline(new EventTimelineListener() {

		@Override
		public void onActivePeriodStart(VtnSessionConfiguration vtnConfiguration, OadrEvent event) {
			if (listeners != null) {
				for (EventTimelineListener listener : listeners) {
					listener.onActivePeriodStart(vtnConfiguration, event);
				}
			}
		}

		@Override
		public void onActivePeriodEnd(VtnSessionConfiguration vtnConfiguration, OadrEvent event) {
			if (listeners != null) {
				for (EventTimelineListener listener : listeners) {
					listener.onActivePeriodEnd(vtnConfiguration, event);
				}
			}

		}

		@Override
		public void onIntervalStart(VtnSessionConfiguration vtnConfiguration, OadrEvent event,
				EiEventSignalType eiEventSignalType, IntervalType intervalType) {
			if (listeners != null) {
				for (EventTimelineListener listener : listeners) {
					listener.onIntervalStart(vtnConfiguration, event, eiEventSignalType, intervalType);
				}
			}

		}

		@Override
		public void onIntervalEnd(VtnSessionConfiguration vtnConfiguration, OadrEvent event,
				EiEventSignalType eiEventSignalType, IntervalType intervalType) {
			if (listeners != null) {
				for (EventTimelineListener listener : listeners) {
					listener.onIntervalEnd(vtnConfiguration, event, eiEventSignalType, intervalType);
				}
			}

		}

		@Override
		public void onCreatedEvent(VtnSessionConfiguration vtnConfiguration, OadrEvent event) {
			if (listeners != null) {
				for (EventTimelineListener listener : listeners) {
					listener.onCreatedEvent(vtnConfiguration, event);
				}
			}
		}

		@Override
		public void onDeletedEvent(VtnSessionConfiguration vtnConfiguration, OadrEvent event) {
			if (listeners != null) {
				for (EventTimelineListener listener : listeners) {
					listener.onDeletedEvent(vtnConfiguration, event);
				}
			}
		}

		@Override
		public void onUpdatedEvent(VtnSessionConfiguration vtnConfiguration, OadrEvent event) {
			if (listeners != null) {
				for (EventTimelineListener listener : listeners) {
					listener.onUpdatedEvent(vtnConfiguration, event);
				}
			}
		}

		@Override
		public void onBaselineIntervalStart(VtnSessionConfiguration vtnConfiguration, OadrEvent event,
				IntervalType intervalType) {
			if (listeners != null) {
				for (EventTimelineListener listener : listeners) {
					listener.onBaselineIntervalStart(vtnConfiguration, event, intervalType);
				}
			}
		}

		@Override
		public void onBaselineIntervalEnd(VtnSessionConfiguration vtnConfiguration, OadrEvent event,
				IntervalType intervalType) {
			if (listeners != null) {
				for (EventTimelineListener listener : listeners) {
					listener.onBaselineIntervalEnd(vtnConfiguration, event, intervalType);
				}
			}
		}
	});

	private Optional<EventResponse> processOadrEvent(VtnSessionConfiguration vtnConfiguration, String requestId,int responseCode,
			OadrEvent event,boolean isOut) throws Oadr20bDistributeEventApplicationLayerException {

		ResponseRequiredType oadrResponseRequired = event.getOadrResponseRequired();

		boolean doNeedResponse = ResponseRequiredType.ALWAYS.equals(oadrResponseRequired);
		if (!ResponseRequiredType.NEVER.equals(oadrResponseRequired) && doNeedResponse) {
			String eventID = event.getEiEvent().getEventDescriptor().getEventID();
			long modificationNumber = event.getEiEvent().getEventDescriptor().getModificationNumber();
			try {
			// check if the event has already  been opted in, if yes,  send opt out
				if (optInEventsMap.get(eventID)!=null || isOut) {
					multiVtnConfig.oadrCreateOpt(vtnConfiguration, new Oadr20bCreateOptBuilder(requestId, vtnConfiguration.getVenId(), System.currentTimeMillis(), eventID, modificationNumber, UUID.randomUUID().toString(), OptTypeType.OPT_OUT, OptReasonEnumeratedType.NOT_PARTICIPATING, null).withSchemaVersion(SchemaVersionEnumeratedType.OADR_20B.value()).build());
					optInEventsMap.remove(eventID);
					return Optional.of(Oadr20bEiEventBuilders.newOadr20bCreatedEventEventResponseBuilder(eventID,
							modificationNumber, requestId, responseCode, OptTypeType.OPT_OUT).build());

				}else {
					return Optional.of(Oadr20bEiEventBuilders.newOadr20bCreatedEventEventResponseBuilder(eventID,
							modificationNumber, requestId, responseCode, OptTypeType.OPT_IN).build());
				}
			}catch (Exception  e){
				LOGGER.error("Error while processing event", e);
			}

		}

		return Optional.empty();
	}

	public OadrResponseType oadrDistributeEvent(VtnSessionConfiguration vtnConfiguration, OadrDistributeEventType event,boolean isOut) {
		String vtnRequestID = event.getRequestID();
		int responseCode = HttpStatus.OK_200;
		boolean hasError = false;

		if (!(vtnConfiguration.getVtnId().equals(event.getVtnID()))) {
			responseCode = Oadr20bApplicationLayerErrorCode.INVALID_ID_452;
			return getErrorResponseType(vtnConfiguration, responseCode, new ArrayList<EventResponse>(), vtnRequestID);
		}
		if (event.getOadrEvent().size()==0){
			return null;
		}

		Set<String> validSignalNames = new HashSet<>();
		Set<String> validSignalTypes = new HashSet<>();

		for (SignalNameEnumeratedType signal : SignalNameEnumeratedType.values()) {
			validSignalNames.add(signal.value());
		}
		for (SignalTypeEnumeratedType signal : SignalTypeEnumeratedType.values()) {
			validSignalTypes.add(signal.value());
		}

		try {
			// for DER cases only push model needs to be synchronized
			if (!vtnConfiguration.getPullModel()){
				timeline.synchronizeOadrDistributeEvent(vtnConfiguration, event);
			}
			List<EventResponse> eventResponses = new ArrayList<>();

			for (OadrEvent next : event.getOadrEvent()) {
				List<EiEventSignalType> signals = next.getEiEvent().getEiEventSignals().getEiEventSignal();

				for (EiEventSignalType signal : signals) {
					if (!validSignalNames.contains(signal.getSignalName())) {
						LOGGER.error("Unsupported signal name: " + signal.getSignalName());
						responseCode = Oadr20bApplicationLayerErrorCode.SIGNAL_NOT_SUPPORTED_460;
						hasError = true;
					}
					if (!validSignalTypes.contains(signal.getSignalType().value())) {
						LOGGER.error("Unsupported signal type: " + signal.getSignalType().value());
						responseCode = Oadr20bApplicationLayerErrorCode.SIGNAL_NOT_SUPPORTED_460;
						hasError = true;
					}
				}


				Optional<EventResponse> processOadrEvent = processOadrEvent(vtnConfiguration, vtnRequestID,responseCode, next,isOut);
				processOadrEvent.ifPresent(eventResponses::add);

				if (hasError) {
					return getErrorResponseType(vtnConfiguration, responseCode, eventResponses, vtnRequestID);
				}
			}

			if (!eventResponses.isEmpty()) {
			OadrCreatedEventType createdEvent = Oadr20bEiEventBuilders.newCreatedEventBuilder(
								Oadr20bResponseBuilders.newOadr20bEiResponseBuilder("", HttpStatus.OK_200).build(),
								vtnConfiguration.getVenId())
						.addEventResponse(eventResponses)
						.build();
				try {
					multiVtnConfig.oadrCreatedEvent(vtnConfiguration, createdEvent);
					LOGGER.info("oadrCreatedEvent successfully sent.");
				} catch (Exception e) {
					LOGGER.error("Error sending oadrCreatedEvent", e);
					responseCode = HttpStatus.INTERNAL_SERVER_ERROR_500;
					return getErrorResponseType(vtnConfiguration, responseCode, eventResponses, vtnRequestID);
				}

				return Oadr20bResponseBuilders.newOadr20bResponseBuilder(vtnRequestID, HttpStatus.OK_200, vtnConfiguration.getVenId())
						.build();
			}

		} catch (Oadr20bDistributeEventApplicationLayerException e) {
			LOGGER.error("Error processing oadrDistributeEvent", e);
			responseCode = HttpStatus.INTERNAL_SERVER_ERROR_500;
			return e.getResponse();
		}

		return Oadr20bResponseBuilders.newOadr20bResponseBuilder(vtnRequestID, HttpStatus.OK_200, vtnConfiguration.getVenId())
				.build();
	}


	private OadrResponseType getErrorResponseType(VtnSessionConfiguration vtnConfiguration, int responseCode, List<EventResponse> eventResponses, String vtnRequestID) {
		OadrCreatedEventType build=null;
		if (responseCode==Oadr20bApplicationLayerErrorCode.INVALID_ID_452){
			 build = Oadr20bEiEventBuilders.newCreatedEventBuilder(
					Oadr20bResponseBuilders.newOadr20bEiResponseBuilder("", responseCode).build(),
					vtnConfiguration.getVenId()).addEventResponse(eventResponses).build();
		}else{
			build = Oadr20bEiEventBuilders.newCreatedEventBuilder(
					Oadr20bResponseBuilders.newOadr20bEiResponseBuilder("", HttpStatus.OK_200).build(),
					vtnConfiguration.getVenId()).addEventResponse(eventResponses).build();

		}
			try {
				multiVtnConfig.oadrCreatedEvent(vtnConfiguration, build);
			} catch (Exception e) {
				LOGGER.error("Can't send oadrCreatedEvent", e);
			}
			if (vtnConfiguration.getPullModel()){
				return Oadr20bResponseBuilders.newOadr20bResponseBuilder(vtnRequestID, HttpStatus.OK_200, vtnConfiguration.getVenId())
						.build();
			}else {
				return Oadr20bResponseBuilders.newOadr20bResponseBuilder(vtnRequestID, responseCode, vtnConfiguration.getVenId())
						.build();
			}

	}


	public OadrRequestEventType OadrEiRequestEvent(VtnSessionConfiguration vtnConfiguration, OadrRequestEventType event) {
		EiRequestEvent eiRequestEvent = new EiRequestEvent();
		eiRequestEvent.setVenID(vtnConfiguration.getVenId());
		eiRequestEvent.setRequestID("");
		event.setSchemaVersion(SchemaVersionEnumeratedType.OADR_20B.value());
		event.setEiRequestEvent(eiRequestEvent);
		return event;
	}

	public void addListener(EventTimelineListener listener) {
		if (listeners == null) {
			listeners = new ArrayList<>();
		}
		listeners.add(listener);
	}
	public Object outOptRequest(VtnSessionConfiguration multiConfig, Object unmarshal){
		if (unmarshal instanceof OadrDistributeEventType) {

			OadrDistributeEventType oadrDistributeEvent = (OadrDistributeEventType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - OadrDistributeEventType");

			return oadrDistributeEvent(multiConfig, oadrDistributeEvent,true);

		}
		return Oadr20bResponseBuilders
				.newOadr20bResponseBuilder("0", Oadr20bApplicationLayerErrorCode.NOT_RECOGNIZED_453,
						multiConfig.getVtnId())
				.withDescription("Unknown payload type for service: " + this.getServiceName()).build();
	}
	public Object request(VtnSessionConfiguration multiConfig, Object unmarshal) {

		if (unmarshal instanceof OadrDistributeEventType) {

			OadrDistributeEventType oadrDistributeEvent = (OadrDistributeEventType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - OadrDistributeEventType");

            return oadrDistributeEvent(multiConfig, oadrDistributeEvent,false);

		}

		if (unmarshal instanceof OadrRequestEventType) {

			OadrRequestEventType oadrRequestEventType = (OadrRequestEventType) unmarshal;

			LOGGER.info(multiConfig.getVtnId() + " - EiRequestEvent");

			return OadrEiRequestEvent(multiConfig, oadrRequestEventType);

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

	public Map<String, OadrEvent> getOadrEvents(VtnSessionConfiguration multiConfig) {
		return timeline.getEvents(multiConfig);
	}

	public List<ActiveSignal> getActiveSignals(VtnSessionConfiguration multiConfig) {
		return timeline.getActiveSignals(multiConfig);
	}

	public List<ActiveBaselineSignal> getActiveBaselineSignals(VtnSessionConfiguration multiConfig) {
		return timeline.getActiveBaselineSignals(multiConfig);
	}

	public void clearOadrEvents() {
		timeline.clear();

	}

}
