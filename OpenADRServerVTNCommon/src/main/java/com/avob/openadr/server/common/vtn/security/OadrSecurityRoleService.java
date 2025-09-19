package com.avob.openadr.server.common.vtn.security;

import java.util.ArrayList;

import com.avob.openadr.server.common.vtn.models.ven.VenDao;
import  jakarta.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.avob.openadr.server.common.vtn.VtnConfig;
import com.avob.openadr.server.common.vtn.models.user.AbstractUser;
import com.avob.openadr.server.common.vtn.models.user.AbstractUserDao;
import com.avob.openadr.server.common.vtn.models.user.OadrApp;
import com.avob.openadr.server.common.vtn.models.user.OadrUser;
import com.avob.openadr.server.common.vtn.models.ven.Ven;
import com.google.common.collect.Lists;

import static com.avob.openadr.server.common.vtn.VTNRoleEnum.ROLE_VEN;

/**
 * grant role for abstract user
 * 
 * @author bzanni
 *
 */
@Service
public class OadrSecurityRoleService {
	public  static final String NAME_ADMIN = "b25b6d4f022ba0a388d1";
	private static final Logger log = LogManager.getLogger(OadrSecurityRoleService.class);
	@Resource
	private VtnConfig vtnConfig;

	@Resource
	private AbstractUserDao abstractUserDao;

	@Resource
	 private VenDao venDao;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public User digestUserDetail(String username) {
		AbstractUser abstractUser = saveFindUser(username);
		return new User(abstractUser.getUsername(), abstractUser.getDigestPassword(), Lists.newArrayList());
	}

	public User grantDigestRole(String username, String password) {
		AbstractUser abstractUser = saveFindUser(username);
		if (!abstractUser.getDigestPassword().equals(password)) {
			throw new BadCredentialsException("Bad credentials given for user: '" + username + "'");
		}
		return this.grantRole(abstractUser, abstractUser.getDigestPassword());
	}

	public User grantBasicRole(String username, CharSequence rawPassword) {
		AbstractUser abstractUser = saveFindUser(username);
		if (!encoder.matches(rawPassword, abstractUser.getBasicPassword())) {
			throw new BadCredentialsException("Bad credentials given for user: '" + username + "'");
		}
		return this.grantRole(abstractUser, abstractUser.getBasicPassword());
	}

	public User grantX509Role(String username) {
		//log.info("User '" + username + "' is registering......");
		if (username.equals(vtnConfig.getOadr20bFingerprint()) || username.equals(vtnConfig.getXmppOadr20bFingerprint())) {
			return new User(username, "", Lists.newArrayList(new SimpleGrantedAuthority("ROLE_VTN")));
		} else if (username.equals(NAME_ADMIN)) {
			return new User(username, "", Lists.newArrayList(new SimpleGrantedAuthority("ROLE_ADMIN")));
		}
		return this.grantRole(saveFindUser(username), "");
	}

	private AbstractUser saveFindUser(String username) {
		AbstractUser abstractUser = abstractUserDao.findOneByUsername(username);
		if (abstractUser == null) {
			Ven ven = new Ven();
			ven.setUsername(username);
			ven.setDigestPassword(encoder.encode(username));
			ven.setBasicPassword(encoder.encode(username));
			ven.setAuthenticationType("ROLE_VEN");
			abstractUserDao.save(ven);
			abstractUser=abstractUserDao.findOneByUsername(username);
			venDao.save(ven);
			//throw new UsernameNotFoundException("");
		}
		return abstractUser;
	}

	private User grantRole(AbstractUser abstractUser, String password) {
		if (abstractUser instanceof Ven) {
			ArrayList<SimpleGrantedAuthority> roles = Lists.newArrayList(new SimpleGrantedAuthority("ROLE_VEN"));
			Ven ven = (Ven) abstractUser;
			if (ven.getRegistrationId() != null) {
				roles.add(new SimpleGrantedAuthority("ROLE_REGISTERED"));
			}
			return new User(abstractUser.getUsername(), password, roles);
		} else if (abstractUser instanceof OadrUser) {
			OadrUser user = (OadrUser) abstractUser;
			ArrayList<SimpleGrantedAuthority> roles = Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER"));
			user.getRoles().forEach(role -> {
				roles.add(new SimpleGrantedAuthority(role));
			});
			return new User(abstractUser.getUsername(), password, roles);
		} else if (abstractUser instanceof OadrApp) {
			OadrApp app = (OadrApp) abstractUser;
			ArrayList<SimpleGrantedAuthority> roles = Lists.newArrayList(new SimpleGrantedAuthority("ROLE_APP"));
			app.getRoles().forEach(role -> {
				roles.add(new SimpleGrantedAuthority(role));
			});
			return new User(abstractUser.getUsername(), password, roles);
		}

		throw new UsernameNotFoundException("");
	}

}
