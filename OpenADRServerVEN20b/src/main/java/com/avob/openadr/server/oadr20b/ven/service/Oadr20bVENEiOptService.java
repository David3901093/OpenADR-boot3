package com.avob.openadr.server.oadr20b.ven.service;

import  jakarta.annotation.Resource;

import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jxmpp.stringprep.XmppStringprepException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.avob.openadr.model.oadr20b.exception.Oadr20bException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bHttpLayerException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bMarshalException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bXMLSignatureException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bXMLSignatureValidationException;
import com.avob.openadr.model.oadr20b.oadr.OadrCancelOptType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreateOptType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreatedOptType;
import com.avob.openadr.model.oadr20b.ei.OptTypeType;
import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Service
public class Oadr20bVENEiOptService {

	protected static final Logger LOGGER = LoggerFactory.getLogger(Oadr20bVENEiReportService.class);
	@Resource
	private MultiVtnConfig multiVtnConfig;


	public void oadrCancelOpt(VtnSessionConfiguration vtnConfig, OadrCancelOptType oadrCancelOptType) {

		try {
			multiVtnConfig.oadrCancelOptType(vtnConfig, oadrCancelOptType);
		} catch (XmppStringprepException | NotConnectedException | Oadr20bException | Oadr20bHttpLayerException
				 | Oadr20bXMLSignatureException | Oadr20bXMLSignatureValidationException | Oadr20bMarshalException
				 | InterruptedException e) {
			LOGGER.error("Can't send cancel opt", e);
		}
	}

	public void createOpt(VtnSessionConfiguration vtnConfig, OadrCreateOptType oadrCreateOptType) {

		try {
			Instant now = Instant.now();
			XMLGregorianCalendar xmlDateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					DateTimeFormatter.ISO_INSTANT.format(now)
			);
			oadrCreateOptType.setCreatedDateTime(xmlDateTime);
			oadrCreateOptType.getVavailability().getComponents().getAvailable().get(0).getProperties().getDtstart().setDateTime(xmlDateTime);
			multiVtnConfig.oadrCreateOpt(vtnConfig, oadrCreateOptType);
		} catch (XmppStringprepException | NotConnectedException | Oadr20bException | Oadr20bHttpLayerException |
                 Oadr20bXMLSignatureException | Oadr20bXMLSignatureValidationException | Oadr20bMarshalException |
                 InterruptedException | DatatypeConfigurationException e) {
			LOGGER.error("Can't create opt", e);
		}
	}

}


