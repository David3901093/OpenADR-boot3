package com.avob.openadr.server.oadr20b.vtn;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariable;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

@ConditionalOnProperty(name = "vtn.swagger")
@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
				.group("api")
				.pathsToMatch("/**")
				.pathsToExclude("/**/OpenADR2/**", "/**/error/**", "/**/manage/**")
				.build();
	}

	@Bean
	public OpenAPI customOpenAPI() {
		Contact contact = new Contact()
				.name("Bertrand Zanni")
				.url("http://avob.com")
				.email("bzanni@avob.com");

		Info info = new Info()
				.title("Avob VTN Rest API")
				.description("Description")
				.version("API TOS")
				.contact(contact)
				.termsOfService("Terms of service")
				.license(new License().name("License of API").url("API license URL"));

		Server server = new Server()
				.url("https://vtn.oadr.com:8181/testvtn")
				.description("VTN Server");


		return new OpenAPI()
				.info(info)
				.servers(Collections.singletonList(server))
				.components(new Components());
	}


}