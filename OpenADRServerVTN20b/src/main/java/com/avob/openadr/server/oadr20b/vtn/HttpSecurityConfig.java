package com.avob.openadr.server.oadr20b.vtn;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.x509.X509AuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.avob.openadr.server.common.vtn.VtnConfig;
import com.avob.openadr.server.common.vtn.security.BasicAuthenticationManager;
import com.avob.openadr.server.common.vtn.security.DigestAuthenticationProvider;
import com.avob.openadr.server.common.vtn.security.DigestUserDetailsService;

/**
 * Spring Security configuration for OADR 20b VTN
 *
 * @author bertrand
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class HttpSecurityConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpSecurityConfig.class);

	@Value("${vtn.cors:@null}")
	private String corsStr;

	private List<String> cors = null;

	@Resource
	private Oadr20bX509AuthenticatedUserDetailsService oadr20bX509AuthenticatedUserDetailsService;

	@Resource
	private BasicAuthenticationManager basicAuthenticationManager;

	@Resource
	private DigestUserDetailsService digestUserDetailsService;

	@Resource
	private DigestAuthenticationProvider digestAuthenticationProvider;

	@Resource
	private VtnConfig vtnConfig;

	@PostConstruct
	public void init() {
		if (corsStr != null) {
			cors = Arrays.asList(corsStr.split(","));
		} else {
			cors = List.of();
		}
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		DigestAuthenticationEntryPoint digestEntryPoint = new DigestAuthenticationEntryPoint();
		digestEntryPoint.setKey(DigestAuthenticationProvider.DIGEST_KEY);
		digestEntryPoint.setRealmName(digestAuthenticationProvider.getRealm());
		digestEntryPoint.setNonceValiditySeconds(300);

		DigestAuthenticationFilter digestFilter = new DigestAuthenticationFilter();
		digestFilter.setAuthenticationEntryPoint(digestEntryPoint);
		digestFilter.setUserDetailsService(digestUserDetailsService);
		digestFilter.setPasswordAlreadyEncoded(true);
		digestFilter.afterPropertiesSet();

		BasicAuthenticationEntryPoint basicEntryPoint = new BasicAuthenticationEntryPoint();
		basicEntryPoint.setRealmName(BasicAuthenticationManager.BASIC_REALM);

		BasicAuthenticationFilter basicFilter = new BasicAuthenticationFilter(basicAuthenticationManager);
		http
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.csrf(AbstractHttpConfigurer :: disable)
				.sessionManagement(session ->
						session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				)
				.authorizeHttpRequests(authorize ->
						authorize
								.requestMatchers(HttpMethod.OPTIONS, ".*").permitAll()
								.requestMatchers(HttpMethod.POST, ".*/auth/.*").permitAll()
								.anyRequest().authenticated()
				)
				.x509(x509 ->
						x509
								.subjectPrincipalRegex("CN=(.*?)(?:,|$)")
								.authenticationUserDetailsService(oadr20bX509AuthenticatedUserDetailsService)
				)
				.addFilter(digestFilter)
				.addFilter(basicFilter)
				.exceptionHandling(exceptions ->
						exceptions.authenticationEntryPoint((request, response, authException) -> {
							String path = request.getServletPath();
							if (path.contains("/Ven") || path.contains("swagger")) {
								LOGGER.error("Unauthorized access to {}", path, authException);
								response.setStatus(HttpStatus.UNAUTHORIZED_401);
							} else {
								LOGGER.error("Forbidden access to {}", path, authException);
								response.setStatus(HttpStatus.FORBIDDEN_403);
							}
						})

				);


		return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "OPTIONS", "HEAD", "DELETE"));
		configuration.setAllowedOrigins(cors);
		configuration.setExposedHeaders(List.of("X-total-count", "X-total-page"));
		configuration.setAllowedHeaders(List.of("*"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}