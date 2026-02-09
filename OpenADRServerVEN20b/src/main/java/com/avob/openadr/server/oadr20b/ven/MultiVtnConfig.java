package com.avob.openadr.server.oadr20b.ven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.avob.openadr.client.http.OadrHttpClientBuilder;
import com.avob.openadr.client.http.oadr20b.OadrHttpClient20b;
import com.avob.openadr.client.http.oadr20b.ven.OadrHttpVenClient20b;
import com.avob.openadr.client.xmpp.oadr20b.OadrXmppClient20b;
import com.avob.openadr.client.xmpp.oadr20b.OadrXmppClient20bBuilder;
import com.avob.openadr.client.xmpp.oadr20b.OadrXmppException;
import com.avob.openadr.client.xmpp.oadr20b.ven.OadrXmppVenClient20b;
import com.avob.openadr.model.oadr20b.Oadr20bFactory;
import com.avob.openadr.model.oadr20b.Oadr20bSecurity;
import com.avob.openadr.model.oadr20b.builders.Oadr20bEiReportBuilders;
import com.avob.openadr.model.oadr20b.builders.eireport.Oadr20bRegisterReportBuilder;
import com.avob.openadr.model.oadr20b.ei.ReportSpecifierType;
import com.avob.openadr.model.oadr20b.ei.SpecifierPayloadType;
import com.avob.openadr.model.oadr20b.exception.Oadr20bException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bHttpLayerException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bMarshalException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bXMLSignatureException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bXMLSignatureValidationException;
import com.avob.openadr.model.oadr20b.oadr.*;
import com.avob.openadr.model.oadr20b.xcal.DurationPropType;
import com.avob.openadr.security.OadrPKISecurity;
import com.avob.openadr.security.exception.OadrSecurityException;
import com.avob.openadr.server.oadr20b.ven.exception.Oadr20bInvalidReportRequestException;
import com.avob.openadr.server.oadr20b.ven.exception.OadrVTNInitializationException;
import com.avob.openadr.server.oadr20b.ven.util.XmlDateUtil;
import com.avob.openadr.server.oadr20b.ven.xmpp.XmppVenListener;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import javax.net.ssl.SSLContext;

import jakarta.xml.bind.JAXBException;


import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jxmpp.stringprep.XmppStringprepException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

@Configuration
public class MultiVtnConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(MultiVtnConfig.class);

	@Resource
	private XmppVenListener xmppVenListeners;

	@Resource
	private VtnSessionFactory vtnSessionFactory;

	@Autowired
	private Environment env;

	private Map<String, VtnSessionConfiguration> multiConfig = new HashMap<String, VtnSessionConfiguration>();

	private Map<String, OadrHttpVenClient20b> multiHttpClientConfig = new HashMap<String, OadrHttpVenClient20b>();

	private Map<String, OadrXmppVenClient20b> multiXmppClientConfig = new HashMap<String, OadrXmppVenClient20b>();

	private Map<String, Map<String, OadrReportType>> reports = new HashMap<>();

	private List<String> knownVtnId = new ArrayList<>();

	// Store temporary PEM files to clean them up later
	private final Map<String, List<Path>> tempFilesMap = new ConcurrentHashMap<>();

	private void configureClient(VtnSessionConfiguration session)
			throws OadrSecurityException, JAXBException, OadrVTNInitializationException {

		// If JKS extraction was used, the session object now contains paths to temporary PEM files.
		// Use these paths for client configuration instead of original ones.
		String privateKeyPathForClient = session.getTempVenPrivateKeyPath() != null ?
				session.getTempVenPrivateKeyPath() :
				session.getVenPrivateKeyPath();
		String certificatePathForClient = session.getTempVenCertificatePath() != null ?
				session.getTempVenCertificatePath() :
				session.getVenCertificatePath();

		if (session.getVtnXmppHost() != null && session.getVtnXmppPort() != null) {
			configureXMPPClient(session, privateKeyPathForClient, certificatePathForClient);
		} else if (session.getVtnUrl() != null) {
			configureHTTPClient(session, privateKeyPathForClient, certificatePathForClient);
		} else {
			throw new IllegalStateException(String.format(
					"Invalid config: %s - vtnUrl must be defined for HTTP ven, xmppHost and xmppPort for XMPP ven",
					session.getSessionId()));
		}
	}

	private void configureHTTPClient(VtnSessionConfiguration session, String privateKeyPath, String certificatePath)
			throws OadrSecurityException, JAXBException, OadrVTNInitializationException {
		LOGGER.info("Init HTTP VEN client");
		OadrHttpClientBuilder builder = new OadrHttpClientBuilder().withDefaultHost(session.getVtnUrl())
				.withTrustedCertificate(new ArrayList<String>(session.getTrustCertificates())).withPooling(1, 1)
				.withProtocol(Oadr20bSecurity.getProtocols(), Oadr20bSecurity.getCiphers());

		if (session.isBasicAuthenticationConfigured()) {

			builder.withDefaultBasicAuthentication(session.getVtnUrl(), session.getBasicUsername(),
					session.getBasicPassword());

		} else if (session.isDigestAuthenticationConfigured()) {
			builder.withDefaultDigestAuthentication(session.getVtnUrl(), session.getDigestRealm(), "",
					session.getDigestUsername(), session.getDigestPassword());

		} else {
			// Use the potentially temporary paths from JKS extraction
			builder.withX509Authentication(privateKeyPath, certificatePath);
		}

		OadrHttpVenClient20b client = null;
		if (session.getXmlSignature()) {
			// Use the potentially temporary paths from JKS extraction
			client = new OadrHttpVenClient20b(new OadrHttpClient20b(builder.build(), privateKeyPath,
					certificatePath, session.getReplayProtectAcceptedDelaySecond()));
		} else {
			client = new OadrHttpVenClient20b(new OadrHttpClient20b(builder.build()));
		}

		putMultiHttpClientConfig(session, client);
	}

	private void configureXMPPClient(VtnSessionConfiguration session, String privateKeyPath, String certificatePath)
			throws OadrSecurityException, JAXBException, OadrVTNInitializationException {
		try {

			LOGGER.info("Init XMPP VEN client");
			String password = UUID.randomUUID().toString();
			// Use the potentially temporary paths from JKS extraction
			SSLContext sslContext = OadrPKISecurity.createSSLContext(privateKeyPath,
					certificatePath, session.getTrustCertificates(), password);

			OadrXmppClient20bBuilder builder = new OadrXmppClient20bBuilder()
					.withHostAndPort(session.getVtnXmppHost(), session.getVtnXmppPort()).withVenID(session.getVenId())
					.withResource("client").withSSLContext(sslContext).withListener(xmppVenListeners);

			if (session.getVtnXmppDomain() != null) {
				builder.withDomain(session.getVtnXmppDomain());
			}

			if (session.getVtnXmppUser() != null && session.getVtnXmppPass() != null) {
				builder.withPassword(session.getVtnXmppPass());
			}

			OadrXmppClient20b oadrXmppClient20b = builder.build();

			OadrXmppVenClient20b venClient = null;
			if (session.getXmlSignature()) {
				// Use the potentially temporary paths from JKS extraction
				venClient = new OadrXmppVenClient20b(oadrXmppClient20b, privateKeyPath,
						certificatePath, session.getReplayProtectAcceptedDelaySecond());
			} else {
				venClient = new OadrXmppVenClient20b(oadrXmppClient20b);
			}

			String connectionJid = venClient.getBareConnectionJid();
			session.setVenUrl(connectionJid);
			putMultiXmppClientConfig(session, venClient);

		} catch (OadrSecurityException | OadrXmppException e) {
			throw new OadrVTNInitializationException(e);
		}
	}


	@SuppressWarnings("rawtypes")
	private Map<String, Properties> loadVtnConf() {
		String dynamicConfigurationPattern = "oadr.vtn.";
		Map<String, Properties> perVtnProperties = new HashMap<>();
		Properties props = new Properties();
		MutablePropertySources propSrcs = ((AbstractEnvironment) env).getPropertySources();
		StreamSupport.stream(propSrcs.spliterator(), false).filter(ps -> ps instanceof EnumerablePropertySource)
				.map(ps -> ((EnumerablePropertySource) ps).getPropertyNames()).flatMap(Arrays::<String>stream)
				.forEach(propName -> {
					if (propName.contains(dynamicConfigurationPattern)) {
						String replaceAll = propName.replaceAll(dynamicConfigurationPattern, "");
						String key = replaceAll.split("\\.")[0];
						Properties vtnProps = perVtnProperties.get(key);
						if (vtnProps == null) {
							vtnProps = new Properties();
						}
						String propKey = replaceAll.replaceAll(key + ".", "");
						vtnProps.put(dynamicConfigurationPattern + propKey, env.getProperty(propName));
						perVtnProperties.put(key, vtnProps);

						props.setProperty(propName, env.getProperty(propName));

					}
				});

		return perVtnProperties;
	}

	@PostConstruct
	public void init() {
		Map<String, Properties> loadVtnConf = loadVtnConf();
		for (Entry<String, Properties> entry : loadVtnConf.entrySet()) {
			String vtnConfigName = entry.getKey();
			Properties vtnProps = entry.getValue();

			try {
				VtnSessionConfiguration session = vtnSessionFactory.createVtnSession(vtnConfigName, vtnProps,tempFilesMap);
				LOGGER.debug("Valid vtn configuration: " + vtnConfigName);
				LOGGER.info(session.toString());
				configureClient(session);
				multiConfig.put(getSessionKey(session.getVtnId(), session.getVenUrl()), session);
				knownVtnId.add(session.getVtnId());

				if (session.getVenRegisterReport() != null) {
					Map<String, OadrReportType> map = new HashMap<>();
					session.getVenRegisterReport().values().forEach(report -> {
						map.put(report.getReportSpecifierID(), report);
					});
					reports.put(getSessionKey(session.getVtnId(), session.getVenUrl()), map);
				}

			} catch (OadrSecurityException e) {
				LOGGER.error("Dynamic Vtn conf key: " + vtnConfigName + " is not a valid vtn configuration", e);
			} catch (JAXBException e) {
				LOGGER.error("Dynamic Vtn conf key: " + vtnConfigName + " is not a valid vtn configuration", e);
			} catch (OadrVTNInitializationException e) {
				LOGGER.error("Dynamic Vtn conf key: " + vtnConfigName + " is not a valid vtn configuration", e);
			} catch (Exception e) {
				LOGGER.error("Failed to initialize VTN configuration: " + vtnConfigName, e);
			}
		}

		if (multiConfig.isEmpty()) {
			throw new IllegalArgumentException("No Vtn configuration has been found");
		}
	}
	// Cleanup method to delete temporary PEM files when the application shuts down
	@PreDestroy
	public void destroy() {
		for (List<Path> tempFiles : tempFilesMap.values()) {
			for (Path filePath : tempFiles) {
				try {
					Files.deleteIfExists(filePath);
					LOGGER.debug("Deleted temporary file: {}", filePath);
				} catch (IOException e) {
					LOGGER.warn("Failed to delete temporary file: {}", filePath, e);
				}
			}
		}
		tempFilesMap.clear();
	}


	public String getVtnId() {
		return knownVtnId.stream().findFirst().orElse(null);
	}
	public OadrRegisterReportType getVenRegisterReport(VtnSessionConfiguration vtnConfig) {
		String requestId = UUID.randomUUID().toString();
		Oadr20bRegisterReportBuilder builder = Oadr20bEiReportBuilders.newOadr20bRegisterReportBuilder(requestId,
				vtnConfig.getVenId());
		if (vtnConfig.getVenRegisterReport() != null) {
			builder.addOadrReport(new ArrayList<>(vtnConfig.getVenRegisterReport().values()));
		}
		return builder.build();
	}

	public Integer checkReportSpecifier(VtnSessionConfiguration vtnConfig, String requestId, String reportRequestId,
										ReportSpecifierType reportSpecifier) throws Oadr20bInvalidReportRequestException {
		int valid=ReportSpecifierStatus.OK;
		// check report specifier
		String reportSpecifierID = reportSpecifier.getReportSpecifierID();
		// if report specifier is not known or reportSpecifierID is not included in VTN session configuration
		if (reports.get(getSessionKey(vtnConfig.getVtnId(), vtnConfig.getVenUrl())) == null || !reports
				.get(getSessionKey(vtnConfig.getVtnId(), vtnConfig.getVenUrl())).containsKey(reportSpecifierID)) {
			LOGGER.error("Report specifier " + reportSpecifierID + " is not known");
			return ReportSpecifierStatus.INVALID_REPORT_SPECIFIER_ID;
		}
		// check report description
		OadrReportType report = reports.get(getSessionKey(vtnConfig.getVtnId(), vtnConfig.getVenUrl()))
				.get(reportSpecifierID);
		Map<String, OadrReportDescriptionType> reportDescriptions = report.getOadrReportDescription().stream()
				.collect(Collectors.toMap(desc -> {
					return getReportDescriptionUID(desc);
				}, Function.identity()));

		DurationPropType granularity = reportSpecifier.getGranularity();
		DurationPropType reportBackDuration = reportSpecifier.getReportBackDuration();

		Long granularityMillis = Oadr20bFactory.xmlDurationToMillisecond(granularity.getDuration());
		Long reportBackDurationMillis = Oadr20bFactory.xmlDurationToMillisecond(reportBackDuration.getDuration());
		// check report back duration
		if (reportBackDurationMillis < granularityMillis) {
			LOGGER.error("Report back duration is less than granularity");
			valid =ReportSpecifierStatus.INVALID_REPORT_BACK_DURATION;
		}

		List<SpecifierPayloadType> specifierPayload = reportSpecifier.getSpecifierPayload();

		for (SpecifierPayloadType specifier : specifierPayload) {
			String reportDescriptionUID = getReportDescriptionUID(specifier);
			// check report descriptionID
			if (!reportDescriptions.containsKey(reportDescriptionUID)) {
				LOGGER.error("Report description " + reportDescriptionUID + " is not known");
				valid = ReportSpecifierStatus.INVALID_REPORT_DESCRIPTION_ID;
				break;
			}

			OadrReportDescriptionType oadrReportDescriptionType = reportDescriptions.get(reportDescriptionUID);
			OadrSamplingRateType oadrSamplingRate = oadrReportDescriptionType.getOadrSamplingRate();

			Long minSamplingRateMillis = null;
			Long maxSamplingRateMillis = null;
			boolean oadrOnChange = false;
			if (oadrSamplingRate != null) {
				if (oadrSamplingRate.getOadrMinPeriod() != null) {
					minSamplingRateMillis = Oadr20bFactory
							.xmlDurationToMillisecond(oadrSamplingRate.getOadrMinPeriod());
					// check min sampling rate
					if ( granularityMillis < minSamplingRateMillis) {
						LOGGER.error("Min sampling rate is less than granularity");
						valid= ReportSpecifierStatus.INVALID_MIN_SAMPLING_RATE;
					}
				}
				if (oadrSamplingRate.getOadrMinPeriod() != null) {
					maxSamplingRateMillis = Oadr20bFactory
							.xmlDurationToMillisecond(oadrSamplingRate.getOadrMaxPeriod());
					// check max sampling rate
					if ( reportBackDurationMillis > maxSamplingRateMillis) {
						LOGGER.error("Max sampling rate is greater than report back duration");
						valid = ReportSpecifierStatus.INVALID_MAX_SAMPLING_RATE;
					}
				}
				oadrOnChange = oadrSamplingRate.isOadrOnChange();
			}
			// check no report back duration
			if (!oadrOnChange && (granularityMillis == 0 || reportBackDurationMillis == 0)) {
				LOGGER.warn("Granularity and report back duration equal to 0");
				valid=ReportSpecifierStatus.NO_REPORT_BACK_DURATION ;
			}
		}

		return valid;
	}

	private String getReportDescriptionUID(SpecifierPayloadType description) {
		StringBuilder builder = new StringBuilder().append(description.getRID());
		if (description.getReadingType() != null) {
			builder.append(description.getReadingType());
		}
		//if (description.getItemBase() != null) {
		//	builder.append(description.getItemBase().getName().toString());
		//}
		return builder.toString();
	}

	private String getReportDescriptionUID(OadrReportDescriptionType description) {
		StringBuilder builder = new StringBuilder().append(description.getRID());
		if (description.getReadingType() != null) {
			builder.append(description.getReadingType());
		}

		//if (description.getItemBase() != null) {
		//	builder.append(description.getItemBase().getName().toString());
		//}

		return builder.toString();
	}

	public void oadrCreateReport(VtnSessionConfiguration vtnConfiguration, OadrCreateReportType payload)
			throws Oadr20bException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException,
			Oadr20bXMLSignatureValidationException, XmppStringprepException, NotConnectedException,
			Oadr20bMarshalException, InterruptedException {
		if (vtnConfiguration.getVtnUrl() != null) {
			multiHttpClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrCreateReport(payload);
		} else if (vtnConfiguration.getVtnXmppHost() != null && vtnConfiguration.getVtnXmppPort() != null) {
			multiXmppClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrCreateReport(payload);
		}
	}

	public void oadrUpdateReport(VtnSessionConfiguration vtnConfiguration, OadrUpdateReportType payload)
			throws Oadr20bException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException,
			Oadr20bXMLSignatureValidationException, XmppStringprepException, NotConnectedException,
			Oadr20bMarshalException, InterruptedException {
		if (vtnConfiguration.getVtnUrl() != null) {
			multiHttpClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrUpdateReport(payload);
		} else if (vtnConfiguration.getVtnXmppHost() != null && vtnConfiguration.getVtnXmppPort() != null) {
			multiXmppClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrUpdateReport(payload);
		}
	}

	public void oadrCreateOpt(VtnSessionConfiguration vtnConfiguration, OadrCreateOptType payload)
			throws Oadr20bException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException,
			Oadr20bXMLSignatureValidationException, XmppStringprepException, NotConnectedException,
			Oadr20bMarshalException, InterruptedException {
		if (vtnConfiguration.getVtnUrl() != null) {
			multiHttpClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrCreateOpt(payload);
		} else if (vtnConfiguration.getVtnXmppHost() != null && vtnConfiguration.getVtnXmppPort() != null) {
			multiXmppClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrCreateOpt(payload);
		}
	}


	public void oadrCancelOptType(VtnSessionConfiguration vtnConfiguration, OadrCancelOptType payload)
			throws Oadr20bException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException,
			Oadr20bXMLSignatureValidationException, XmppStringprepException, NotConnectedException,
			Oadr20bMarshalException, InterruptedException {
		if (vtnConfiguration.getVtnUrl() != null) {
			multiHttpClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrCancelOptType(payload);
		} else if (vtnConfiguration.getVtnXmppHost() != null && vtnConfiguration.getVtnXmppPort() != null) {
			multiXmppClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrCancelOptType(payload);
		}
	}

	public void oadrRegisterReport(VtnSessionConfiguration vtnConfiguration, OadrRegisterReportType payload)
			throws Oadr20bException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException,
			Oadr20bXMLSignatureValidationException, XmppStringprepException, NotConnectedException,
			Oadr20bMarshalException, InterruptedException {
		for (OadrReportType report :payload.getOadrReport()) {
			report.setCreatedDateTime(XmlDateUtil.nowXmlCalendar());
		}
		if (vtnConfiguration.getVtnUrl() != null  ) {
			multiHttpClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrRegisterReport(payload);
			LOGGER.info("oadrRegisterReport has sent ");

		} else if (vtnConfiguration.getVtnXmppHost() != null && vtnConfiguration.getVtnXmppPort() != null) {
			multiXmppClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrRegisterReport(payload);
		}
	}

	public void oadrRequestEvent(VtnSessionConfiguration vtnConfiguration, OadrRequestEventType request) throws Oadr20bException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException,
			Oadr20bXMLSignatureValidationException, XmppStringprepException, NotConnectedException,
			Oadr20bMarshalException, InterruptedException {
		if (vtnConfiguration.getVtnUrl() != null) {
			multiHttpClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrRequestEvent(request);
			LOGGER.info("oadrRequestEvent has sent ");
		} else if (vtnConfiguration.getVtnXmppHost() != null && vtnConfiguration.getVtnXmppPort() != null) {
			multiXmppClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl())).oadrRequestEvent(request);
		}
	}
	public void oadrCreatedEvent(VtnSessionConfiguration vtnConfiguration, OadrCreatedEventType payload)
			throws Oadr20bException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException,
			Oadr20bXMLSignatureValidationException, XmppStringprepException, NotConnectedException,
			Oadr20bMarshalException, InterruptedException {
		if (vtnConfiguration.getVtnUrl() != null) {
			multiHttpClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrCreatedEvent(payload);
		} else if (vtnConfiguration.getVtnXmppHost() != null && vtnConfiguration.getVtnXmppPort() != null) {
			multiXmppClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrCreatedEvent(payload);
		}
	}

	public OadrXmppVenClient20b getMultiXmppClientConfig(VtnSessionConfiguration vtnConfiguration) {
		return multiXmppClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()));
	}

	public void putMultiXmppClientConfig(VtnSessionConfiguration vtnConfiguration, OadrXmppVenClient20b venClient) {
		multiXmppClientConfig.put(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()), venClient);
	}

	public void putMultiHttpClientConfig(VtnSessionConfiguration vtnConfiguration, OadrHttpVenClient20b venClient) {
		multiHttpClientConfig.put(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()), venClient);
	}

	public void setMultiXmppClientConfig(Map<String, OadrXmppVenClient20b> multiXmppClientConfig) {
		this.multiXmppClientConfig = multiXmppClientConfig;
	}

	public Map<String, VtnSessionConfiguration> getMultiConfig() {
		return multiConfig;
	}

//	public VtnSessionConfiguration getMultiConfig(String vtnId) {
//		return multiConfig.get(vtnId);
//	}

	public OadrHttpVenClient20b getMultiHttpClientConfig(VtnSessionConfiguration vtnConfiguration) {
		return multiHttpClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()));
	}

	public void setMultiHttpClientConfigClient(VtnSessionConfiguration vtnConfiguration, OadrHttpVenClient20b client) {
		multiHttpClientConfig.put(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()), client);
	}

	public boolean isKnownVtnId(String vtnId) {
		return knownVtnId.contains(vtnId);
	}

	public VtnSessionConfiguration getMultiConfig(String vtnId, String venPushUrl) {
		return multiConfig.get(getSessionKey(vtnId, venPushUrl));
	}

	public VtnSessionConfiguration getMultiConfig(String sessionKey) {
		return multiConfig.get(sessionKey);
	}

	private String getSessionKey(String vtnId, String venPushUrl) {
		return new StringBuilder().append(vtnId).append(venPushUrl).toString();
	}


	public void oadrCreatedReport(VtnSessionConfiguration vtnConfiguration, OadrCreatedReportType payload)
			throws Oadr20bException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException,
			Oadr20bXMLSignatureValidationException, XmppStringprepException, NotConnectedException,
			Oadr20bMarshalException, InterruptedException {
		if (vtnConfiguration.getVtnUrl() != null) {
			multiHttpClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrCreatedReport(payload);
		} else if (vtnConfiguration.getVtnXmppHost() != null && vtnConfiguration.getVtnXmppPort() != null) {
			multiXmppClientConfig.get(getSessionKey(vtnConfiguration.getVtnId(), vtnConfiguration.getVenUrl()))
					.oadrCreatedReport(payload);
		}
	}

	public void oadrResponse(VtnSessionConfiguration vtnConfig, OadrResponseType response) throws Oadr20bMarshalException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException, NotConnectedException, Oadr20bXMLSignatureValidationException, XmppStringprepException, InterruptedException, Oadr20bException {
		if (vtnConfig.getVtnUrl() != null) {
			multiHttpClientConfig.get(getSessionKey(vtnConfig.getVtnId(), vtnConfig.getVenUrl())).oadrResponse(response);
		} else if (vtnConfig.getVtnXmppHost() != null && vtnConfig.getVtnXmppPort() != null) {
			multiXmppClientConfig.get(getSessionKey(vtnConfig.getVtnId(), vtnConfig.getVenUrl())).oadrResponse(response);
		}
	}
}