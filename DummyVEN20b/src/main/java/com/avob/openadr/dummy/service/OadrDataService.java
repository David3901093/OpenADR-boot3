package com.avob.openadr.dummy.service;

import com.avob.openadr.model.oadr20b.oadr.OadrCancelOptType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreateOptType;
import com.avob.openadr.model.oadr20b.oadr.OadrRequestEventType;
import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.util.JsonParserUtil;
import com.avob.openadr.model.oadr20b.Oadr20bJAXBContext;
import com.avob.openadr.model.oadr20b.exception.Oadr20bUnmarshalException;
import com.avob.openadr.model.oadr20b.oadr.OadrRegisterReportType;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author David GE
 * Date  2026/2/12
 */
@Service
public class OadrDataService {
    @Value("${oadr.vtn.ven3_httppush.filePath:null}")
    private String venBaseFilePath;
    @Resource
    private Oadr20bJAXBContext oadr20bJAXBContext;
    Logger logger =  LoggerFactory.getLogger(OadrDataService.class);
    @Resource
    private MultiVtnConfig multiVtnConfig;

    public String getData(String venId, String action) {
        String res = null;
        try {
        if ("registerReport".equals( action)){
            OadrRegisterReportType registerReport = getRegisterReportFromFile(venBaseFilePath+"xml/thermostat.full.registerReport.xml");
            res= JsonParserUtil.toJsonString(registerReport);
           return res;

        }
        if ("createOptin".equals( action)){
            OadrCreateOptType oadrCreateOptType = getOadrCreateOptTypeFromFile(venBaseFilePath+"xml/createOptIn.xml");
            res = JsonParserUtil.toJsonString(oadrCreateOptType);
            return res;
        }
        if ("createOptout".equals(action)){
                OadrCreateOptType oadrCreateOptType = getOadrCreateOptTypeFromFile(venBaseFilePath+"/xml/createOptOut.xml");
                res = JsonParserUtil.toJsonString(oadrCreateOptType);
                return res;
        }

        if ("cancelOpt".equals(action)){
            OadrCancelOptType oadrCancelOptType = getOadrCreateCancelOPtTypeFromFile(venBaseFilePath+"xml/cancelOpt.xml");
            res = JsonParserUtil.toJsonString(oadrCancelOptType);
                return res;
        }
        if ("requestEvent".equals(action)){
            OadrRequestEventType oadrRequestEventType = getOadrRequestEventTypeFromFile(venBaseFilePath+"xml/requestEvent.xml");
            res = JsonParserUtil.toJsonString(oadrRequestEventType);
            return res;
        }
        if ("requestEventForOut".equals(action)){
            OadrRequestEventType oadrRequestEventType = getOadrRequestEventTypeFromFile(venBaseFilePath+"xml/requestEventForOut.xml");
            res = JsonParserUtil.toJsonString(oadrRequestEventType);
            return res;
        }
        res = JsonParserUtil.toJsonString(null);
        } catch (JsonProcessingException e) {
            logger.error("Error while parsing json",e);
            throw new RuntimeException(e);
        }
        return res;

    }


    private OadrRegisterReportType getRegisterReportFromFile(String filePath) {
        Path path = Paths.get(filePath);
        File file = path.toFile();
        if (! file.exists()) {
            throw new IllegalArgumentException(
                    "oadr.vtn.venRegisterReport.file must be a valid file path containing XML formatted OadrRegisterReportType");
        }

        try {
            return oadr20bJAXBContext.unmarshal(file, OadrRegisterReportType.class);
        } catch (Oadr20bUnmarshalException e) {
            throw new IllegalArgumentException(
                    "oadr.vtn.venRegisterReport.file must be a valid file path containing XML formatted OadrRegisterReportType",
                    e);
        }

    }
    private OadrCreateOptType getOadrCreateOptTypeFromFile(String filePath) {
        Path path = Paths.get(filePath);
        File file = path.toFile();
        if (! file.exists()) {
            throw new IllegalArgumentException("can't read xml from file path");
        }

        try {
            return oadr20bJAXBContext.unmarshal(file, OadrCreateOptType.class);
        } catch (Oadr20bUnmarshalException e) {
            throw new IllegalArgumentException(
                    "oadr.vtn.venRegisterReport.file must be a valid file path containing XML formatted OadrCreateOptType",
                    e);
        }

    }

    private OadrCancelOptType getOadrCreateCancelOPtTypeFromFile(String filePath) {
        Path path = Paths.get(filePath);
        File file = path.toFile();
        if (! file.exists()) {
            throw new IllegalArgumentException("can't read xml from file path");
        }

        try {
            return oadr20bJAXBContext.unmarshal(file, OadrCancelOptType.class);
        } catch (Oadr20bUnmarshalException e) {
            throw new IllegalArgumentException(
                    "oadr.vtn.venRegisterReport.file must be a valid file path containing XML formatted OadrCreateOptType",
                    e);
        }

    }

    private OadrRequestEventType getOadrRequestEventTypeFromFile(String filePath) {
        Path path = Paths.get(filePath);
        File file = path.toFile();
        if (! file.exists()) {
            throw new IllegalArgumentException("can't read xml from file path");
        }

        try {
            return oadr20bJAXBContext.unmarshal(file, OadrRequestEventType.class);
        } catch (Oadr20bUnmarshalException e) {
            throw new IllegalArgumentException(
                    "oadr.vtn.venRegisterReport.file must be a valid file path containing XML formatted OadrCreateOptType",
                    e);
        }

    }

    public String processResponse(String venId, String action) {
        return multiVtnConfig.getResponseData(venId, action);
    }
}
