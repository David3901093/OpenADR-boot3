package com.avob.openadr.server.oadr20b.ven;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import  jakarta.annotation.Resource;
import jakarta.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.*;

import com.avob.openadr.model.oadr20b.Oadr20bJAXBContext;
import com.avob.openadr.model.oadr20b.Oadr20bSecurity;
import com.avob.openadr.security.exception.OadrSecurityException;

@Configuration
@EnableAutoConfiguration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@ComponentScan(basePackages = { "com.avob.openadr.server.oadr20b.ven" })
public class VEN20bApplicationConfig {



	@Resource
	private MultiVtnConfig multiVtnConfig;

	@Bean
	public ScheduledExecutorService scheduledExecutorService() {
		return Executors.newScheduledThreadPool(5);
	}

	@Bean
	public ScheduledExecutorService eiEventExecutorService() {
		return Executors.newScheduledThreadPool(5);
	}

	@Bean
	public WebServerFactoryCustomizer<JettyServletWebServerFactory> servletContainerCustomizer() {
		return new VENEmbeddedServletContainerCustomizer(multiVtnConfig.getMultiConfig(),
				Oadr20bSecurity.getProtocols(), Oadr20bSecurity.getCiphers());
	}

}
