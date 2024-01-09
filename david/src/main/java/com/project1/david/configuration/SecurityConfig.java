//package com.project1.david.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//
//import com.project1.david.service.CustomUserSecurityDetailsService;
//
//import lombok.RequiredArgsConstructor;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@ComponentScan(basePackages = " com.project1.david.service")
//public class SecurityConfig extends AbstractSecurityWebApplicationInitializer {
//
//	@Autowired
//	private  CustomUserSecurityDetailsService customUser;
//
//	
//	
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// usa il customUser per ricavarsi il suo user
//		 auth.userDetailsService(customUser);
//	}
//
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//		.requestMatchers("/user/get/**").hasRole("ADMIN")
//		.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//		.anyRequest().authenticated()
//		.and()  
//		.formLogin(formLogin -> formLogin.loginPage("/login").permitAll());
////indica che stai configurando la protezione CSRF(Cross-Site Request Forgery)
////CookieCsrfTokenRepository(), indica che i token CSRF verranno gestiti attraverso i cookie.
////questo lo rene visibile all'Header		
//		http.csrf(csrf -> csrf.csrfTokenRepository(new CookieCsrfTokenRepository()));
//
//	}
//
//
//}
