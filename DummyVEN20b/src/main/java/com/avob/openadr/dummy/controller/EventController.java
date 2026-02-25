package com.avob.openadr.dummy.controller;

import com.avob.openadr.client.http.oadr20b.ResponseUtils;
import com.avob.openadr.dummy.config.VenUrlPath;
import com.avob.openadr.dummy.entity.VTNConfig;
import com.avob.openadr.dummy.utils.HttpClientUtils;
import com.avob.openadr.dummy.utils.XmlParserUtil;

import com.avob.openadr.model.oadr20b.exception.Oadr20bException;
import com.avob.openadr.model.oadr20b.oadr.OadrCreatedEventType;
import com.avob.openadr.model.oadr20b.oadr.OadrPayload;
import com.avob.openadr.model.oadr20b.oadr.OadrRequestEventType;
import com.avob.openadr.model.oadr20b.oadr.OadrResponseType;
import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENPayloadService;
import com.avob.openadr.server.oadr20b.ven.util.JsonParserUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author david
 * Date  2025/8/7
 */
@Controller
@RequestMapping(VenUrlPath.VEN_BASE_PATH+VenUrlPath.EVENT)
@PreAuthorize("hasRole('ROLE_VTN') or hasRole('ROLE_ADMIN')")
public class EventController {
    private static final Logger log = LogManager.getLogger(EventController.class);
    @Resource
    private VtnSessionConfiguration vtnSessionConfiguration;

    @Resource
    private MultiVtnConfig multiVtnConfig;

    @Resource
    private Oadr20bVENPayloadService oadr20bVENPayloadService;
    @RequestMapping(value = "/created", method = RequestMethod.POST)
    @ResponseBody
    public String created(@RequestBody VTNConfig vtnConfig) {
        try {
            String preload = loadConfig(vtnConfig);
            multiVtnConfig.oadrCreatedEvent(vtnSessionConfiguration, XmlParserUtil.parseOadrXml(preload,OadrCreatedEventType.class));
            String response = ResponseUtils.getResString();
            OadrResponseType oadrResponseType = XmlParserUtil.parseOadrXml(response, OadrResponseType.class);
            String prettyJaxbJsonString = JsonParserUtil.toPrettyJaxbJsonString(oadrResponseType);
            multiVtnConfig.putResponseData(vtnConfig.getVenId(), "createdEvent", prettyJaxbJsonString);
            return  response;
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }


    }

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    @ResponseBody
    public String request(@RequestBody VTNConfig vtnConfig, Principal principal, HttpServletRequest request) {
        try {
            loadConfig(vtnConfig);
            String preload = HttpClientUtils.sendRequest(HttpClientUtils.getBaseUrl(), vtnSessionConfiguration, "requestEvent");
            multiVtnConfig.oadrRequestEvent(vtnSessionConfiguration, JsonParserUtil.parseJson(preload,OadrRequestEventType.class));
            String resString = ResponseUtils.getResString();
            String req = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort();

            String response = oadr20bVENPayloadService.event(principal.getName(), req, resString, false);
            OadrPayload oadrPayload = XmlParserUtil.parseOadrXml(response, OadrPayload.class);
            String prettyJsonString = JsonParserUtil.toPrettyJsonString(oadrPayload);
            log.info("requestEvent response:{}",prettyJsonString);
            multiVtnConfig.putResponseData(vtnConfig.getVenId(), "requestEventForOptIn", prettyJsonString);
            return response;
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }


    }
    @RequestMapping(value = "/requestForOptOut", method = RequestMethod.POST)
    @ResponseBody
    public String requestForOptOut(@RequestBody VTNConfig vtnConfig, Principal principal, HttpServletRequest request) {
        try {
            loadConfig(vtnConfig);
            String preload = HttpClientUtils.sendRequest(HttpClientUtils.getBaseUrl(), vtnSessionConfiguration, "requestEventForOut");
            multiVtnConfig.oadrRequestEvent(vtnSessionConfiguration, JsonParserUtil.parseJson(preload,OadrRequestEventType.class));
            String resString = ResponseUtils.getResString();
            String req = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort();

            String response = oadr20bVENPayloadService.event(principal.getName(), req, resString, true);
            OadrPayload oadrPayload = XmlParserUtil.parseOadrXml(response, OadrPayload.class);
            String prettyJsonString = JsonParserUtil.toPrettyJsonString(oadrPayload);
            log.info("requestEventForOptOut response:{}",prettyJsonString);
            multiVtnConfig.putResponseData(vtnConfig.getVenId(), "requestEventForOptOut", prettyJsonString);
            return response;
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
