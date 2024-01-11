package com.project1.david.configuration;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;


import lombok.SneakyThrows;
/**
 * questa classe ha lo specifico compito di garantirci uno specifico messaggio di errore
 * quando non avviene correttaemnte l'auth
 */
public class AuthEntryPoint extends BasicAuthenticationEntryPoint {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private static String REALM = "REAME";

	@Override
	@SneakyThrows
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) {

		// questo è il messaggio di errore che andremo a visulaizzare in caso di errore
		String errMess = "Userid e/o password non corrette!";
		log.warn("Errore Sicurezza: " + authException.getMessage());

		// Authentication failed, send error response.
		// response.setContentType("application/json;charset=UTF-8")
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.addHeader("WWW-Autheticate", "Basic Realm= " + getRealmName() + "");

		PrintWriter writer = response.getWriter();
		writer.println(errMess);
	}

	@Override
	@SneakyThrows
	public void afterPropertiesSet() {

		setRealmName(REALM);
		super.afterPropertiesSet();
	}

}
