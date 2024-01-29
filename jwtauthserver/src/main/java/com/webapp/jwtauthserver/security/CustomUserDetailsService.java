package com.webapp.jwtauthserver.security;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

@Service("customUserDetailsService")
@Log
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserConfig Config;

	@Override
	@SneakyThrows
	/**
	 * con questo metodo otteniamo le specifiche dell'utente
	 */
	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		String ErrMsg = "";

		if (username == null || username.length() < 2) {
			ErrMsg = "Nome utente assente o non valido";

			log.warning(ErrMsg);

			throw new UsernameNotFoundException(ErrMsg);
		}

		Utenti utente = this.GetHttpValue(username);

		if (utente == null) {
			ErrMsg = String.format("Utente %s non Trovato!!", username);

			log.warning(ErrMsg);

			throw new UsernameNotFoundException(ErrMsg);
		}

		UserBuilder builder = null;
		builder = org.springframework.security.core.userdetails.User.withUsername(utente.getUserId());
		builder.disabled((utente.getAttivo().equals("SI") ? false : true));
		builder.password(utente.getPassword());

		String[] profili = utente.getRuoli().stream().map(a -> "ROLE_" + a).toArray(String[]::new);

		builder.authorities(profili);

		return builder.build();

	}

	private Utenti GetHttpValue(String UserId) {
		URI url = null;

		try {
			String SrvUrl = Config.getSrvUrl();

			url = new URI(SrvUrl + UserId);
		} catch (URISyntaxException e) {

			e.printStackTrace();
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors()
				.add(new BasicAuthenticationInterceptor(Config.getUserId(), Config.getPassword()));

		Utenti utente = null;

		try {
			utente = restTemplate.getForObject(url, Utenti.class);
		} catch (Exception e) {
			String ErrMsg = String.format("Connessione al servizio di autenticazione non riuscita!!");

			log.warning(ErrMsg);

		}

		return utente;

	}

}
