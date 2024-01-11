package com.project1.david.dto;

//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.project1.david.entity.User;
//
//public class UserSecurityDetails implements UserDetails {

//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	private String username;
//	private String password;
//	private boolean enabled;// deleted
//	private boolean notLocked;// active
//	private List<GrantedAuthority> auth;
//
//	/**
//	 * costruttore per mappare l'entità
//	 */
//
//	public UserSecurityDetails(User user) {
//		this.username = user.getFiscalCode();
//     	this.password = user.getPassword();
//
//	
//		
//		if (user.getDeleted() != null) {
//			// se è ugulae a zero l'utente è attivo e lavaribile diventa true
//			this.enabled = user.getDeleted().equals(0);
//		} else {
//			// per test lo rendiamo sempre abilitato
//			this.enabled = true;
//		}
//		if (user.getActive() != null) {
//
//			this.notLocked = user.getActive().equals(0);
//		} else {
//			// per test lo rendiamo sempre abilitato
//			this.notLocked = true;
//		}
//
//		this.auth = Arrays.stream(user.getRoles().split(","))
////  Per ogni ruolo nello stream, aggiunge il prefisso "ROLE_" 
////	al ruolo corrente. Ad esempio, se il ruolo è "ADMIN", 
////	dopo questa operazione diventerà "ROLE_ADMIN".                 
//				.map(role -> "ROLE_".concat(role))
////  mappo il ruolo in un SimpleGrantedAuthority
//				.map(SimpleGrantedAuthority::new)
////	Raccoglie tutte le SimpleGrantedAuthority risultanti 
////  in una lista.                    
//				.collect(Collectors.toList());
//
//	}
//
//
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return auth;
//	}
//
//	@Override
//	public String getPassword() {
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		return username;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// settando a true indichiamo che non è scaduto
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return notLocked;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// serve per settare la scadenza della password
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return enabled;
//	}
//
//}
