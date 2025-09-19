package com.avob.openadr.dummy.controller;

import com.avob.openadr.dummy.config.VenUrlPath;
import com.avob.openadr.dummy.entity.VTNConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import com.avob.openadr.server.oadr20b.ven.service.Oadr20bPollService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author david
 * Date  2025/8/7
 */
@Controller
@RequestMapping(VenUrlPath.VEN_BASE_PATH+VenUrlPath.POLL)
@PreAuthorize("hasRole('ROLE_VTN') or hasRole('ROLE_ADMIN')")
public class PollController {
    @Resource
    private VtnSessionConfiguration vtnSessionConfiguration;
    @Resource
    private Oadr20bPollService oadr20bPollService;
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String poll(@RequestBody VTNConfig vtnConfig) {
        loadConfig(vtnConfig);
       oadr20bPollService.initPoll(vtnSessionConfiguration,null);
        return "polling start";
    }
    @RequestMapping(value = "/cancelPoll", method = RequestMethod.POST)
    @ResponseBody
    public String cancel(@RequestBody VTNConfig vtnConfig) {
        loadConfig(vtnConfig);
        oadr20bPollService.cancelPoll(vtnSessionConfiguration,false);
       return "polling canceled";
    }
    private String loadConfig(VTNConfig vtnConfig) {
        vtnSessionConfiguration.setVtnUrl(vtnConfig.getVtnUrl());
        vtnSessionConfiguration.setVenId(vtnConfig.getVenId());
        vtnSessionConfiguration.setVenName(vtnConfig.getVenName());
        return vtnConfig.getPreload();
    }



}
