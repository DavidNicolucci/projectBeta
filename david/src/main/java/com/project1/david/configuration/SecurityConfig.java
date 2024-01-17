package com.project1.david.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//import com.project1.david.service.CustomUserSecurityDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
//@RequiredArgsConstructor
//@ComponentScan(basePackages = " com.project1.david.service")
public class SecurityConfig {

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;

	private static String REALM = "REAME";
	private static final String[] ADMIN_MACTHER = { 
			"/user/aggiungiuser/**"};

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(ADMIN_MACTHER)
		.hasAnyRole("ADMIN")
        .anyRequest().authenticated()
        .and()
	     // configurazione degli errori della web Api
		.httpBasic().realmName(REALM)
		.authenticationEntryPoint(getBasicAuthEntryPoint())
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		 auth.userDetailsService(userDetailsService)
		    .passwordEncoder(new BCryptPasswordEncoder());

	}

	@Bean
	public AuthEntryPoint getBasicAuthEntryPoint() {

		return new AuthEntryPoint();
	}

	/**
	 * questo metodo ignora tutti metodi che riguardano gli option devono essere
	 * ignorati dalla security Serve a far funzionare i FE come Angular
	 * 
	 * @param web
	 * @throws Exception
	 */
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

}
