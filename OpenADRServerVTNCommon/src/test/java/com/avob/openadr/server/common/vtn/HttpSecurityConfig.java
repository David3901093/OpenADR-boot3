package com.avob.openadr.server.common.vtn;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

import com.avob.openadr.server.common.vtn.security.BasicAuthenticationManager;
import com.avob.openadr.server.common.vtn.security.DigestAuthenticationProvider;
import com.avob.openadr.server.common.vtn.security.DigestUserDetailsService;

/**
 * Spring security configuration
 *
 * @author bertrand
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // 替代 @EnableGlobalMethodSecurity
public class HttpSecurityConfig {

	@Resource
	private BasicAuthenticationManager basicAuthenticationManager;

	@Resource
	private DigestUserDetailsService digestUserDetailsService;

	@Resource
	private DigestAuthenticationProvider digestAuthenticationProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// Configure Digest authentication entry point
		DigestAuthenticationEntryPoint digestEntryPoint = new DigestAuthenticationEntryPoint();
		digestEntryPoint.setKey(DigestAuthenticationProvider.DIGEST_KEY);
		digestEntryPoint.setRealmName(digestAuthenticationProvider.getRealm());

		// Configure Digest authentication Filter
		DigestAuthenticationFilter digestFilter = new DigestAuthenticationFilter();
		digestFilter.setAuthenticationEntryPoint(digestEntryPoint);
		digestFilter.setUserDetailsService(digestUserDetailsService);
		digestFilter.setPasswordAlreadyEncoded(true);

		// // Configure Basic authentication entry point
		BasicAuthenticationEntryPoint basicEntryPoint = new BasicAuthenticationEntryPoint();
		basicEntryPoint.setRealmName(BasicAuthenticationManager.BASIC_REALM);

		//// Configure Digest authentication Filter
		BasicAuthenticationFilter basicFilter = new BasicAuthenticationFilter(basicAuthenticationManager);

		// Config security filterChain
		http
				.csrf(csrf -> csrf.disable()) // Forbid CSRF
				.sessionManagement(session ->
						session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // STATELESS Session
				)
				.addFilter(digestFilter)
				.addFilter(basicFilter)
				.exceptionHandling(exceptions -> {
					exceptions.authenticationEntryPoint(digestEntryPoint);
				})
				.authorizeHttpRequests(authorize ->
						authorize.anyRequest().authenticated()
				);

		return http.build();
	}
}