/**
 * 
 */
package com.project1.david.controller;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project1.david.dto.MasterDataDto;
import com.project1.david.service.MasterDataService;

/**
 * 
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class MasterDataController {

	@Autowired
	MasterDataService userService;

	@PostMapping("/aggiungianagrafica")
	public ResponseEntity<String> aggiungiAnagrafica(@RequestBody MasterDataDto userDto) throws Exception {

		try {
			String t = userService.aggiungiAnagrafica(userDto);
		
			
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore durante l'aggiunta dell'anagrafica");// Messaggio di errore; 
		}
		
//		RestTemplate restTemplate= new RestTemplate();
//		String url="http://localhost:8080/user/idusertabella";
//		String test= restTemplate.getForObject(url, String.class);
				
		return ResponseEntity.ok(userService.aggiungiAnagrafica(userDto)); // Messaggio di successo
	}
	
	
	
	
	
}
