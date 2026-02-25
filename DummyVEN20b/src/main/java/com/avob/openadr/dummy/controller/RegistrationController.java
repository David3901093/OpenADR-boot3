package com.avob.openadr.dummy.controller;

import com.avob.openadr.client.http.oadr20b.ResponseUtils;
import com.avob.openadr.dummy.DummyVEN20bEiRegisterPartyListener;
import com.avob.openadr.dummy.config.VenUrlPath;
import com.avob.openadr.dummy.entity.VTNConfig;

import com.avob.openadr.dummy.utils.XmlParserUtil;
import com.avob.openadr.model.oadr20b.builders.eiregisterparty.Oadr20bCancelPartyRegistrationBuilder;
import com.avob.openadr.model.oadr20b.oadr.OadrPayload;
import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENEiRegisterPartyService;

import com.avob.openadr.server.oadr20b.ven.util.JsonParserUtil;
import jakarta.annotation.Resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * @author david
 * Date  2025/8/5
 */
@Controller
@RequestMapping(VenUrlPath.VEN_BASE_PATH+VenUrlPath.REGISTER_PARTY)
@PreAuthorize("hasRole('ROLE_VTN') or hasRole('ROLE_ADMIN')")
public class RegistrationController {

    @Resource
    private VtnSessionConfiguration vtnSessionConfiguration;
    @Resource
    private MultiVtnConfig multiVtnConfig;


    @Resource
    private Oadr20bVENEiRegisterPartyService oadr20bVENEiRegisterPartyService;

    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody VTNConfig vtnConfig) throws Exception {
        loadConfig(vtnConfig);
      oadr20bVENEiRegisterPartyService.postRegistration(vtnSessionConfiguration);
        String resString = ResponseUtils.getResString();
        OadrPayload oadrPayload = XmlParserUtil.parseOadrXml(resString, OadrPayload.class);
        String jsonString = JsonParserUtil.toPrettyJsonString(oadrPayload);
        log.info("createRegistration response:{}", jsonString);
        multiVtnConfig.putResponseData(vtnSessionConfiguration.getVenId(), "createRegistration", jsonString);
        return resString;

    }
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public String query(@RequestBody VTNConfig vtnConfig) throws Exception {
        loadConfig(vtnConfig);
        oadr20bVENEiRegisterPartyService.initRegistration(vtnSessionConfiguration);
        String resString = ResponseUtils.getResString();
        OadrPayload oadrPayload = XmlParserUtil.parseOadrXml(resString, OadrPayload.class);
        String jsonString = JsonParserUtil.toPrettyJsonString(oadrPayload);
        log.info("queryRegistration response:{}", jsonString);
        multiVtnConfig.putResponseData(vtnSessionConfiguration.getVenId(), "queryRegistration", jsonString);
        return resString;

    }

    private String loadConfig(VTNConfig vtnConfig) {
        vtnSessionConfiguration.setVtnUrl(vtnConfig.getVtnUrl());
        vtnSessionConfiguration.setVenId(vtnConfig.getVenId());
        vtnSessionConfiguration.setVenName(vtnConfig.getVenName());
        return vtnConfig.getPreload();
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public String cancel (@RequestBody VTNConfig vtnConfig) throws Exception {
                loadConfig(vtnConfig);
           oadr20bVENEiRegisterPartyService.cancelRegistration(vtnSessionConfiguration);
        String resString = ResponseUtils.getResString();
        OadrPayload oadrPayload = XmlParserUtil.parseOadrXml(resString, OadrPayload.class);
        String jsonString = JsonParserUtil.toPrettyJsonString(oadrPayload);
        log.info("cancelRegistration response:{}", jsonString);
        multiVtnConfig.putResponseData(vtnSessionConfiguration.getVenId(), "cancelRegistration", jsonString);
        return resString;
    }

    @RequestMapping(value = "/maintain", method = RequestMethod.POST)
    @ResponseBody
    public String maintain (@RequestBody VTNConfig vtnConfig) throws Exception {
        loadConfig(vtnConfig);
        oadr20bVENEiRegisterPartyService.maintainRegistration(vtnSessionConfiguration);
        String resString = ResponseUtils.getResString();
        OadrPayload oadrPayload = XmlParserUtil.parseOadrXml(resString, OadrPayload.class);
        String jsonString = JsonParserUtil.toPrettyJsonString(oadrPayload);
        log.info("maintainRegistration response:{}", jsonString);
        multiVtnConfig.putResponseData(vtnSessionConfiguration.getVenId(), "maintainRegistration", jsonString);
        return resString;
    }



}
