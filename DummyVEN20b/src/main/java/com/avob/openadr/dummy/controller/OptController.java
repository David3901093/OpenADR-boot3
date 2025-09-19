package com.avob.openadr.dummy.controller;

import com.avob.openadr.client.http.oadr20b.ResponseUtils;
import com.avob.openadr.dummy.config.VenUrlPath;
import com.avob.openadr.dummy.entity.VTNConfig;
import com.avob.openadr.dummy.utils.XmlParserUtil;
import com.avob.openadr.model.oadr20b.builders.Oadr20bEiOptBuilders;
import com.avob.openadr.model.oadr20b.builders.eiopt.Oadr20bCancelOptBuilder;
import com.avob.openadr.model.oadr20b.oadr.OadrRequestEventType;
import com.avob.openadr.model.oadr20b.oadr.OadrRequestEventType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreateOptType;
import com.avob.openadr.model.oadr20b.ei.OptTypeType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreateOptType;
import com.avob.openadr.model.oadr20b.ei.OptReasonEnumeratedType;
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
import java.util.UUID;

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
    private Oadr20bVENEiOptService oadr20bVENEiOptService;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create() {
        try {
            String requestId = UUID.randomUUID().toString();
            String optId = "0";
            OadrCreateOptType oadrCreateOptType = Oadr20bEiOptBuilders.newOadr20bCreateOptBuilder(requestId,
                    vtnSessionConfiguration.getVenId(), System.currentTimeMillis(), Oadr20bEiOptBuilders
                            .newOadr20bVavailabilityBuilder().addPeriod(System.currentTimeMillis(), "PT24H").build(),
                    optId, OptTypeType.OPT_OUT, OptReasonEnumeratedType.NOT_PARTICIPATING).build();

            oadr20bVENEiOptService.createOpt(vtnSessionConfiguration, oadrCreateOptType);
            return ResponseUtils.getResString();
        }catch (Exception e){
            return "error response:"+ e.getMessage();
        }


    }
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public String cancel() {
        try {
            String requestId = UUID.randomUUID().toString();
            String optId = "0";
            OadrCancelOptType oadrCancelOptType = Oadr20bEiOptBuilders.newOadr20bCancelOptBuilder(requestId, optId,vtnSessionConfiguration.getVenId()).build();
            oadr20bVENEiOptService.oadrCancelOpt(vtnSessionConfiguration, oadrCancelOptType);
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
