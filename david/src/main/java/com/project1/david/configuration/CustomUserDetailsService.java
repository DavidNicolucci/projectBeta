package com.project1.david.configuration;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;

//serve a customizzare il nome del service
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserConfig config;

	/**
	 * questo metodo ci permette di caricare le credenziali di accesso attraverso
	 * username passato come parametro
	 */
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String username) {

		String errMsg = "";

		// verifico se l'utente è null o la sua lunghezza è inferiore a 5
		if (username == null || username.length() < 5) {

			errMsg = "Nome utente assente o non valido";
			log.warn(errMsg);
			throw new UsernameNotFoundException(errMsg);

		}

		Utenti utente = this.getHttpValue(username);

		if (utente == null) {

			errMsg = String.format("Utente %s non Trovato", username);
			log.warn(errMsg);
			throw new UsernameNotFoundException(errMsg);

		}

		UserBuilder builder = null;
		builder = org.springframework.security.core.userdetails.User.withUsername(utente.getUserId());
		builder.disabled(utente.getAttivo().equals("SI") ? false : true);
		builder.password(utente.getPassword());

		// verifca se sono presenti ruoli con il tipo di ruolo che abbiamo passato noi
		String[] profili = utente.getRuoli()
				.stream()
				.map(utenti -> "ROLE_" + utenti)
				.toArray(String[]::new);

		builder.authorities(profili);

		return builder.build();
	}

	/**
	 * questo metodo richiede materilamente le informazioni necessarie al ms-getuser
	 * per l'autenticazione
	 * 
	 * @param userId
	 * @return
	 */
	private Utenti getHttpValue(String userId) {

		URI url = null;

		try {

//			http://localhost:8019/api/utenti/cerca/userid/
			String srvUrl = config.getSrvUrl();

			// va aggiunto alla variabile srvUrl lo userId
			url = new URI(srvUrl + userId);

		} catch (URISyntaxException e) {

			e.printStackTrace();
		}

		RestTemplate rest = new RestTemplate();

		// serve ad inviare le credenziali per accedere alle info, visto che il ms
		// getuser è protetto da security
		rest.getInterceptors().add(new BasicAuthenticationInterceptor(config.getUserId(), config.getPassword()));

		Utenti utente = null;

		try {

			// viene passato l'url per effettuare la chiamata e il tipo
			// di oggetto in questo caso di tipo Utenti
			utente = rest.getForObject(url, Utenti.class);

		} catch (Exception e) {

			String errMsg = String.format("Connessione al servizio di autenticazione non riuscita");

			log.warn(errMsg);

		}

		return utente;

	}

}
