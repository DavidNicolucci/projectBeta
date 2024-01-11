package com.project1.david.service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.project1.david.dto.UserSecurityDetails;
//import com.project1.david.entity.User;
//import com.project1.david.repository.UserRepositoty;
//
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//@Service
//public class CustomUserSecurityDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UserRepositoty userRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//	
//		
//		
//		User user = userRepo.findByFiscalCode(username)
//				.orElseThrow(() -> new UsernameNotFoundException("utente " + username + " non trovato"));
//	
//		
//		return new UserSecurityDetails(user);
//	}
//
//}
