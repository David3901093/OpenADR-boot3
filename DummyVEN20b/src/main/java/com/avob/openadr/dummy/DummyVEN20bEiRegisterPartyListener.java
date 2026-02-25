package com.avob.openadr.dummy;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.avob.openadr.dummy.utils.HttpClientUtils;
import com.avob.openadr.model.oadr20b.oadr.*;
import com.avob.openadr.security.exception.OadrSecurityException;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENEiEventService;
import com.avob.openadr.server.oadr20b.ven.util.JsonParserUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import  jakarta.annotation.PostConstruct;
import  jakarta.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.avob.openadr.model.oadr20b.builders.Oadr20bEiOptBuilders;
import com.avob.openadr.model.oadr20b.ei.OptReasonEnumeratedType;
import com.avob.openadr.model.oadr20b.ei.OptTypeType;
import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENEiOptService;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENEiRegisterPartyService;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENEiRegisterPartyService.Oadr20bVENEiRegisterPartyServiceListener;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENEiReportService;

@Configuration
public class DummyVEN20bEiRegisterPartyListener implements Oadr20bVENEiRegisterPartyServiceListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(DummyVEN20bEiRegisterPartyListener.class);

	@Resource
	private MultiVtnConfig multiVtnConfig;

	@Resource
	private Oadr20bVENEiRegisterPartyService oadr20bVENEiRegisterPartyService;

	@Resource
	private Oadr20bVENEiReportService oadr20bVENEiReportService;

	@Resource
	private Oadr20bVENEiOptService oadr20bVENEiOptService;

	@Resource
	private Oadr20bVENEiEventService oadr20bVENEiEventService;

	@Value("${oadr.vtn.ven3_httppush.venReportDataSource}")
	private String venReportDataSourceUrl;



	@PostConstruct
	public void init() {
		oadr20bVENEiRegisterPartyService.addListener(this);
	}

	@EventListener({ ApplicationReadyEvent.class })
	void applicationReadyEvent()  {


		for (VtnSessionConfiguration vtnSessionConfiguration : multiVtnConfig.getMultiConfig().values()) {
            OadrRegisterReportType oadrRegisterReportType = null;
			try {
				oadrRegisterReportType = initReportDataSource(vtnSessionConfiguration, this.venReportDataSourceUrl);
				
				Map<String, OadrReportType> mergedReportMap = new HashMap<>();

				for (OadrReportType report : oadrRegisterReportType.getOadrReport()) {
					String specId = report.getReportSpecifierID();
					if (mergedReportMap.containsKey(specId)) {
						// merge the reportDescription with the same reportSpecifierID but different reportDescription
						mergedReportMap.get(specId).getOadrReportDescription().addAll(report.getOadrReportDescription());
					} else {
						// add the report
						mergedReportMap.put(specId, report);
					}
				}


				vtnSessionConfiguration.setVenRegisterReport(mergedReportMap);

				if (vtnSessionConfiguration.getVenRegisterReport() != null) {
					// set reports directly in multiVtnConfig
					multiVtnConfig.setReports(
							vtnSessionConfiguration.getVtnId(),
							vtnSessionConfiguration.getVenUrl(),
							vtnSessionConfiguration.getVenRegisterReport()
					);
				}
			}
			catch (Exception e) {
				LOGGER.error("Can't register report", e);
			}
		}
	}

	@Override
	public void onRegistrationSuccess(VtnSessionConfiguration vtnConfiguration,
			OadrCreatedPartyRegistrationType registration) {
		oadr20bVENEiReportService.registerReport(vtnConfiguration,null);
		//oadr20bVENEiReportService.createReportMetadata(vtnConfiguration);
        try {
            sendOadrEvent(vtnConfiguration);
			//initOpt(vtnConfiguration,registration,"http://MarketContext1");
			// save registrationID in configuration
			vtnConfiguration.setVenRegistrationId(registration.getRegistrationID());
        } catch (Exception e) {
			LOGGER.error("Can't send event", e);
        }
	}

	public void sendOadrEvent(VtnSessionConfiguration vtnConfiguration) throws Exception {
		Object request = oadr20bVENEiEventService.request(vtnConfiguration, new OadrRequestEventType());
		if (request instanceof OadrRequestEventType){
			multiVtnConfig.oadrRequestEvent(vtnConfiguration, (OadrRequestEventType) request);
		}
	}

	@Override
	public void onRegistrationError(VtnSessionConfiguration vtnConfiguration,
			OadrCreatedPartyRegistrationType registration) {
		LOGGER.error("Failed to create party registration");
		LOGGER.error(registration.getEiResponse().getResponseCode() + " - "
				+ registration.getEiResponse().getResponseDescription());

	}

	private void initOpt(VtnSessionConfiguration vtnConfiguration,String marketContext) {
		String requestId = UUID.randomUUID().toString();
		String optId = "0";
		OadrCreateOptType oadrCreateOptType = Oadr20bEiOptBuilders.newOadr20bCreateOptBuilder(requestId,
				vtnConfiguration.getVenId(), System.currentTimeMillis(), Oadr20bEiOptBuilders
						.newOadr20bVavailabilityBuilder().addPeriod(System.currentTimeMillis(), "PT24H").build(),
				optId, OptTypeType.OPT_OUT, OptReasonEnumeratedType.NOT_PARTICIPATING, marketContext).build();

		oadr20bVENEiOptService.createOpt(vtnConfiguration, oadrCreateOptType);
	}

	/**
	 * Init report data source
	 *
	 * @param vtnSessionConfiguration the vtn session configuration
	 * @param dataUrl                 the  url to get data
	 * @return the report data source
	 * @throws OadrSecurityException
	 */
	private OadrRegisterReportType initReportDataSource(VtnSessionConfiguration vtnSessionConfiguration,String dataUrl)  {
		OadrRegisterReportType oadrRegisterReportType = null;
		try{
			// init dataResourceUrl
			HttpClientUtils.loadUrl(dataUrl);
			String responseBody = HttpClientUtils.sendRequest(dataUrl, vtnSessionConfiguration, "registerReport");

			oadrRegisterReportType = JsonParserUtil.parseJaxbJson(responseBody, OadrRegisterReportType.class);
			LOGGER.info( "Register report data source:" + JsonParserUtil.toPrettyJsonString(oadrRegisterReportType) );
		}catch (IllegalStateException | JsonProcessingException ex){
			LOGGER.error("Can't register report data source", ex);
		}
		return oadrRegisterReportType;
	}





}
