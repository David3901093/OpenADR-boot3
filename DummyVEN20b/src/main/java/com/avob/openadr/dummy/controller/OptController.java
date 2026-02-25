package com.avob.openadr.dummy.controller;

import com.avob.openadr.client.http.oadr20b.ResponseUtils;
import com.avob.openadr.dummy.config.VenUrlPath;
import com.avob.openadr.dummy.entity.VTNConfig;
import com.avob.openadr.dummy.utils.HttpClientUtils;
import com.avob.openadr.dummy.utils.XmlParserUtil;

import com.avob.openadr.model.oadr20b.oadr.*;

import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENEiOptService;
import com.avob.openadr.server.oadr20b.ven.util.JsonParserUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author david
 * Date  2025/9/15
 */
@Controller
@RequestMapping(VenUrlPath.VEN_BASE_PATH+VenUrlPath.OPT)
@PreAuthorize("hasRole('ROLE_VTN') or hasRole('ROLE_ADMIN')")
public class OptController {
    private static final Logger log = LoggerFactory.getLogger(OptController.class);
    @Resource
    private VtnSessionConfiguration vtnSessionConfiguration;

    @Resource
    private MultiVtnConfig multiVtnConfig;
    @Resource
    private Oadr20bVENEiOptService oadr20bVENEiOptService;
    @RequestMapping(value = "/createin", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody VTNConfig vtnConfig) {
        try {
            loadConfig(vtnConfig);
            String preload = HttpClientUtils.sendRequest(HttpClientUtils.getBaseUrl(),vtnSessionConfiguration, "createOptin");
            OadrCreateOptType oadrCreateOptType = JsonParserUtil.parseJson(preload,OadrCreateOptType.class);
            oadr20bVENEiOptService.createOpt(vtnSessionConfiguration, oadrCreateOptType);
            String resString = ResponseUtils.getResString();
            OadrPayload oadrCreatedOptType = XmlParserUtil.parseOadrXml(resString, OadrPayload.class);
            String jsonString = JsonParserUtil.toPrettyJsonString(oadrCreatedOptType);
            log.info("createOpt response:{}", jsonString);
            multiVtnConfig.putResponseData(vtnSessionConfiguration.getVenId(), "createOpt", jsonString);
            return resString;
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }
    }
    @RequestMapping(value = "/createout", method = RequestMethod.POST)
    @ResponseBody
    public String createOut(@RequestBody VTNConfig vtnConfig) {
        try {
            loadConfig(vtnConfig);
            String preload = HttpClientUtils.sendRequest(HttpClientUtils.getBaseUrl(),vtnSessionConfiguration, "createOptout");
            OadrCreateOptType oadrCreateOptType = JsonParserUtil.parseJson(preload,OadrCreateOptType.class);
            oadr20bVENEiOptService.createOpt(vtnSessionConfiguration, oadrCreateOptType);
            String resString = ResponseUtils.getResString();
            OadrPayload oadrCreatedOptType = XmlParserUtil.parseOadrXml(resString, OadrPayload.class);
            String jsonString = JsonParserUtil.toPrettyJsonString(oadrCreatedOptType);
            log.info("createOpt response:{}", jsonString);
            multiVtnConfig.putResponseData(vtnSessionConfiguration.getVenId(), "createOpt", jsonString);
            return resString;
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }
    }
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public String cancel(@RequestBody VTNConfig vtnConfig) {
        try {
          loadConfig(vtnConfig);
          String preload = HttpClientUtils.sendRequest(HttpClientUtils.getBaseUrl(),vtnSessionConfiguration, "cancelOpt");
            multiVtnConfig.oadrCancelOptType(vtnSessionConfiguration, JsonParserUtil.parseJson(preload,OadrCancelOptType.class));
            String resString = ResponseUtils.getResString();
            OadrPayload oadrCanceledOptType = XmlParserUtil.parseOadrXml(resString, OadrPayload.class);
            String jsonString = JsonParserUtil.toPrettyJsonString(oadrCanceledOptType);
            log.info("cancelOpt response:{}", jsonString);
            multiVtnConfig.putResponseData(vtnSessionConfiguration.getVenId(), "cancelOpt", jsonString);
            return resString;
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



}
