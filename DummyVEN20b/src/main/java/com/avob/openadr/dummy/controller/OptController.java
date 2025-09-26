package com.avob.openadr.dummy.controller;

import com.avob.openadr.client.http.oadr20b.ResponseUtils;
import com.avob.openadr.dummy.config.VenUrlPath;
import com.avob.openadr.dummy.entity.VTNConfig;
import com.avob.openadr.dummy.utils.XmlParserUtil;

import com.avob.openadr.model.oadr20b.oadr.OadrCreateOptType;

import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENEiOptService;
import jakarta.annotation.Resource;
import com.avob.openadr.model.oadr20b.oadr.OadrCancelOptType;
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
    @Resource
    private VtnSessionConfiguration vtnSessionConfiguration;

    @Resource
    private MultiVtnConfig multiVtnConfig;
    @Resource
    private Oadr20bVENEiOptService oadr20bVENEiOptService;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody VTNConfig vtnConfig) {
        try {
            String preload = loadConfig(vtnConfig);
            OadrCreateOptType oadrCreateOptType = XmlParserUtil.parseOadrXml(preload,OadrCreateOptType.class);
            oadr20bVENEiOptService.createOpt(vtnSessionConfiguration, oadrCreateOptType);
            return ResponseUtils.getResString();
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }
    }
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public String cancel(@RequestBody VTNConfig vtnConfig) {
        try {
            String preload = loadConfig(vtnConfig);
            multiVtnConfig.oadrCancelOptType(vtnSessionConfiguration, XmlParserUtil.parseOadrXml(preload,OadrCancelOptType.class));
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



}
