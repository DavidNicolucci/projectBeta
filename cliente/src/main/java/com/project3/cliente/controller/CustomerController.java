package com.project3.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project3.cliente.dto.CustomerDto;
import com.project3.cliente.dto.UserDto;
import com.project3.cliente.service.CustomerService;
import com.project3.cliente.utils.FeignServiceUtil;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	CustomerService userService;
	
	@Autowired
	FeignServiceUtil feignService;

	@PostMapping("/aggiungicliente")
	public ResponseEntity<String> aggiungiAnagrafica(@RequestBody CustomerDto customerDto) throws Exception {

		try {
			String t = userService.aggiungiCustomer(customerDto);
		
			
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore durante l'aggiunta del cliente");// Messaggio di errore; 
		}
		
//		RestTemplate restTemplate= new RestTemplate();
//		String url="http://localhost:8080/user/idusertabella";
//		String test= restTemplate.getForObject(url, String.class);
				
		return ResponseEntity.ok(userService.aggiungiCustomer(customerDto)); // Messaggio di successo
	}
	
	
	
	@GetMapping("/test")
	public List<UserDto> getTest() {
		
		return feignService.recuperaListaUtenti();
		
	}
	
	
}
