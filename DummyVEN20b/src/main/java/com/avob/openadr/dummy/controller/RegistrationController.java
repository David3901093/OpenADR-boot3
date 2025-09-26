package com.avob.openadr.dummy.controller;

import com.avob.openadr.client.http.oadr20b.ResponseUtils;
import com.avob.openadr.dummy.DummyVEN20bEiRegisterPartyListener;
import com.avob.openadr.dummy.config.VenUrlPath;
import com.avob.openadr.dummy.entity.VTNConfig;

import com.avob.openadr.model.oadr20b.builders.eiregisterparty.Oadr20bCancelPartyRegistrationBuilder;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bVENEiRegisterPartyService;

import jakarta.annotation.Resource;


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
    private Oadr20bVENEiRegisterPartyService oadr20bVENEiRegisterPartyService;

    @Resource
  private DummyVEN20bEiRegisterPartyListener oadr20bVENEiRegisterPartyServiceListener;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody VTNConfig vtnConfig) throws Exception {
        loadConfig(vtnConfig);
      oadr20bVENEiRegisterPartyService.postRegistration(vtnSessionConfiguration);
        return ResponseUtils.getResString();

    }
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public String query(@RequestBody VTNConfig vtnConfig) throws Exception {
        loadConfig(vtnConfig);
        oadr20bVENEiRegisterPartyService.initRegistration(vtnSessionConfiguration);
        return ResponseUtils.getResString();

    }

    private String loadConfig(VTNConfig vtnConfig) {
        vtnSessionConfiguration.setVtnUrl(vtnConfig.getVtnUrl());
        vtnSessionConfiguration.setVenId(vtnConfig.getVenId());
        vtnSessionConfiguration.setVenName(vtnConfig.getVenName());
        return vtnConfig.getPreload();
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public String cancel (@RequestBody VTNConfig vtnConfig) {
                loadConfig(vtnConfig);
           oadr20bVENEiRegisterPartyService.cancelRegistration(vtnSessionConfiguration);
           return ResponseUtils.getResString();
    }



}
