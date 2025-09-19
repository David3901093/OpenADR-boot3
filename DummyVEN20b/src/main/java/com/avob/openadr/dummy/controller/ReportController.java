package com.avob.openadr.dummy.controller;

import com.avob.openadr.client.http.oadr20b.OadrHttpClient20b;
import com.avob.openadr.client.http.oadr20b.ResponseUtils;
import com.avob.openadr.client.http.oadr20b.ven.OadrHttpVenClient20b;
import com.avob.openadr.dummy.config.VenUrlPath;
import com.avob.openadr.dummy.entity.VTNConfig;
import com.avob.openadr.dummy.simulator.DummyVEN20bSimulator;
import com.avob.openadr.dummy.utils.XmlParserUtil;
import com.avob.openadr.model.oadr20b.builders.Oadr20bEiReportBuilders;
import com.avob.openadr.model.oadr20b.builders.eireport.Oadr20bUpdateReportBuilder;
import com.avob.openadr.model.oadr20b.exception.*;
import com.avob.openadr.model.oadr20b.oadr.OadrCreatedReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrUpdateReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrRegisterReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrRegisteredReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreateReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreatedReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrCancelReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrUpdatedReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrPayload;
import com.avob.openadr.model.oadr20b.oadr.OadrSignedObject;
import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENEiReportService;
import com.avob.openadr.server.oadr20b.ven.service.UpdateReportOrchestratorService;
import jakarta.annotation.Resource;


import jakarta.xml.bind.JAXBException;
import org.eclipse.jetty.http.HttpStatus;
import org.jivesoftware.smack.SmackException;
import org.jxmpp.stringprep.XmppStringprepException;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author david
 * Date  2025/8/7
 */
@Controller
@RequestMapping(VenUrlPath.VEN_BASE_PATH+VenUrlPath.REPORT)
@PreAuthorize("hasRole('ROLE_VTN') or hasRole('ROLE_ADMIN')")
public class ReportController {
    @Resource
    private VtnSessionConfiguration vtnSessionConfiguration;

    @Resource
    private Oadr20bVENEiReportService oadr20bVENEiReportService;


    @Resource
    private MultiVtnConfig multiVtnConfig;


  @Resource
  private UpdateReportOrchestratorService updateReportOrchestratorService;

    @RequestMapping(value = "/created", method = RequestMethod.POST)
    @ResponseBody
    public String created(@RequestBody VTNConfig vtnConfig) {
        try {
            String preload = loadConfig(vtnConfig);
            oadr20bVENEiReportService.oadrCreatedReport(
                    vtnSessionConfiguration, XmlParserUtil.parseOadrXml(preload, OadrCreatedReportType.class));
            return ResponseUtils.getResString();
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }

    }

    @RequestMapping(value = "/metaData", method = RequestMethod.POST)
    @ResponseBody
    public String metaData(@RequestBody VTNConfig vtnConfig) {
        try {
           loadConfig(vtnConfig);
            sendMetaData(true);
            return ResponseUtils.getResString();
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }

    }

    private void sendMetaData(boolean piggy) throws JAXBException, Oadr20bUnmarshalException, Oadr20bException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException, Oadr20bXMLSignatureValidationException, XmppStringprepException, SmackException.NotConnectedException, Oadr20bMarshalException, InterruptedException {
        OadrCreateReportType reportMetadata = oadr20bVENEiReportService.createReportMetadata(vtnSessionConfiguration);
        Oadr20bUpdateReportBuilder updateReportBuilder =
                Oadr20bEiReportBuilders.newOadr20bUpdateReportBuilder(UUID.randomUUID().toString() , vtnSessionConfiguration.getVenId());
        OadrUpdateReportType updateReportType = updateReportBuilder.build();
        oadr20bVENEiReportService.updateReport(vtnSessionConfiguration, updateReportType);
        OadrCreatedReportType oadrCreatedReportType = oadr20bVENEiReportService.oadrCreateReport(vtnSessionConfiguration, reportMetadata);
        String registeredString = ResponseUtils.getResString();
        OadrPayload oadrPayload =   XmlParserUtil.parseOadrXml(registeredString, OadrPayload.class);
        OadrSignedObject oadrSignedObject = oadrPayload.getOadrSignedObject();
       OadrRegisteredReportType oadrRegisteredReportType = oadrSignedObject.getOadrRegisteredReport();
        oadrCreatedReportType.getEiResponse().setRequestID(oadrRegisteredReportType.getEiResponse().getRequestID());
        multiVtnConfig.oadrCreatedReport(vtnSessionConfiguration, oadrCreatedReportType);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody VTNConfig vtnConfig) {
        try {


            String preload = loadConfig(vtnConfig);
            oadr20bVENEiReportService.oadrUpdateReport(
                    vtnSessionConfiguration, XmlParserUtil.parseOadrXml(preload, OadrUpdateReportType.class));
            return ResponseUtils.getResString();
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }
    }

    private String loadConfig(VTNConfig vtnConfig) {
        vtnSessionConfiguration.setVtnUrl(vtnConfig.getVtnUrl());
        vtnSessionConfiguration.setVenId(vtnConfig.getVenId());
        vtnSessionConfiguration.setVenName(vtnConfig.getVenName());
        return vtnConfig.getPreload();
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String report(@RequestBody VTNConfig vtnConfig) {
        try {
            String preload = loadConfig(vtnConfig);
            oadr20bVENEiReportService.oadrRegisterReport(
                    vtnSessionConfiguration, XmlParserUtil.parseOadrXml(preload,OadrRegisterReportType.class));
            return ResponseUtils.getResString();
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }


    }
    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    @ResponseBody
    public String registeredReport(@RequestBody VTNConfig vtnConfig) {
        try {
            String preload = loadConfig(vtnConfig);
            oadr20bVENEiReportService.oadrRegisteredReport(vtnSessionConfiguration, XmlParserUtil.parseOadrXml(preload,OadrRegisteredReportType.class));
            return ResponseUtils.getResString();
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }


    }


}
