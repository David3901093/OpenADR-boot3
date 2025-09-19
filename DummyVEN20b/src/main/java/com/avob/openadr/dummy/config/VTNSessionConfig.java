package com.avob.openadr.dummy.config;

import com.avob.openadr.server.oadr20b.ven.MultiVtnConfig;
import com.avob.openadr.server.oadr20b.ven.VtnSessionConfiguration;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author david
 * Date  2025/8/5
 */
@Configuration
public class VTNSessionConfig {
    @Resource
    private MultiVtnConfig multiVtnConfig;
    @Bean
    public VtnSessionConfiguration vtnSessionConfiguration() {
        return multiVtnConfig.getMultiConfig().values().stream().findFirst().orElse(null);
    }
}
