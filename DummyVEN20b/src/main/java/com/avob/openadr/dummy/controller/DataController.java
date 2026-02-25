package com.avob.openadr.dummy.controller;

import com.avob.openadr.dummy.config.VenUrlPath;
import com.avob.openadr.dummy.service.OadrDataService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David GE
 * Date  2026/2/11
 */
@RestController
@RequestMapping(VenUrlPath.VEN_BASE_PATH+VenUrlPath.DATA)
@PreAuthorize("hasRole('ROLE_VTN') or hasRole('ROLE_ADMIN')")
public class DataController {

    @Resource
    private OadrDataService dataService;
    @GetMapping("/getBusinessData")
    public String getBusinessData(@RequestParam String venId,@RequestParam String action) {
      return dataService.getData(venId,action);

    }
    @GetMapping("/processResponse")
    public String processResponse(@RequestParam String venId,@RequestParam String action) {
        return dataService.processResponse(venId,action);

    }



}
