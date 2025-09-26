package com.avob.openadr.server.oadr20b.ven.service;

import com.avob.openadr.model.oadr20b.exception.*;
import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import jakarta.annotation.Resource;
import org.apache.logging.log4j.core.Logger;
import org.springframework.stereotype.Service;

import com.avob.openadr.model.oadr20b.oadr.OadrResponseType;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;

@Service
public class Oadr20bVENEiResponseService {
    private final Logger LOGGER=(Logger) org.apache.logging.log4j.LogManager.getLogger(Oadr20bVENEiResponseService.class);
	@Resource
	private MultiVtnConfig  multiVtnConfig;
	public void oadrResponse(VtnSessionConfiguration vtnConfig, OadrResponseType response) {

    }

}
