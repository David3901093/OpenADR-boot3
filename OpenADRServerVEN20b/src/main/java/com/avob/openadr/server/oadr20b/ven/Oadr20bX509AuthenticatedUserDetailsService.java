package com.avob.openadr.server.oadr20b.ven;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

import  jakarta.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import com.avob.openadr.security.OadrFingerprintSecurity;
import com.avob.openadr.security.exception.OadrSecurityException;
import org.springframework.util.StringUtils;

/**
 * x509 oadr fingerprint mechanism demonstration
 * 
 * this fingerprint should be check against some sort of database
 * 
 * @author bertrand
 *
 */
@Service
public class Oadr20bX509AuthenticatedUserDetailsService
		implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken>, UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(Oadr20bX509AuthenticatedUserDetailsService.class);

	private static final List<SimpleGrantedAuthority> VTN_AUTHORITY = Arrays
			.asList(new SimpleGrantedAuthority("ROLE_VTN"));
	private static final List<String> WHITE_LIST = Arrays
			.asList("vtn.oadr.com","ven3.oadr.com");
	@Resource
	private MultiVtnConfig multiConfig;

	@Override
	public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) {
		X509Certificate certificate = (X509Certificate) token.getCredentials();
		String fingerprint = "";
		try {
			fingerprint = OadrFingerprintSecurity.getOadr20bFingerprint(certificate);
			//if (WHITE_LIST.contains(fingerprint)) {
			//	return new User(fingerprint, "",VTN_AUTHORITY );
			//}
			if (!fingerprint.trim().isEmpty()) {
				return new User(fingerprint, "",VTN_AUTHORITY );
			}
		} catch (OadrSecurityException e) {
			throw new UsernameNotFoundException("", e);
		}

		if (multiConfig.isKnownVtnId(fingerprint)) {
			return new User(fingerprint, "", VTN_AUTHORITY);
		}

		LOGGER.warn("Undefined VTN communication received - fingerprint: " + fingerprint);
		throw new UsernameNotFoundException("VTN with fingerprint '" + fingerprint + "' is not registered");

	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//if (WHITE_LIST.contains(username)) {
		//	username =multiConfig.getVtnId();
		//	if (username!=null){
		//		return new User(username, "", VTN_AUTHORITY);
		//	}
		//
		//}
		if (!WHITE_LIST.contains(username)) {
			username =multiConfig.getVtnId();
			if (username!=null){
				return new User(username, "", VTN_AUTHORITY);
			}

		}
		if (multiConfig.isKnownVtnId(username)) {
			return new User(username, "", VTN_AUTHORITY);
		}
		LOGGER.warn("Undefined VTN communication received - fingerprint: " + username);
		throw new UsernameNotFoundException("VTN with fingerprint '" + username + "' is not registered");
	}
}
