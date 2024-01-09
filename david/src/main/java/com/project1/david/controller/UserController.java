/**
 * 
 */
package com.project1.david.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
import com.project1.david.dto.UserDto;
import com.project1.david.service.UserService;

/**
 * 
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/aggiungiuser")
	public ResponseEntity<String> aggiungiUtente(@RequestBody UserDto userDto) throws Exception {

		try {
			HashMap<Integer, String> t = userService.aggiungiUser(userDto);

			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8081/user/aggiungianagrafica";

			MasterDataDto requestBoby = new MasterDataDto();
			requestBoby.setAddress("via lazio");
			requestBoby.setAddressNumber("100");
			requestBoby.setCap("113");
			requestBoby.setCity("Roma");
			requestBoby.setNation("Italia");
			
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MasterDataDto> requestEntity = new HttpEntity<>(requestBoby, headers);

			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
					String.class);

			String responseBody = responseEntity.getBody();
			userService.aggiungiIdUserAIDIndirizzo(responseBody);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore durante l'aggiunta dell'utente");// Messaggio
																												// di
																												// errore;
		}
		return ResponseEntity.ok("Utente aggiunto con successo"); // Messaggio di successo
	}

	@PostMapping("/idusertabella")
	public ResponseEntity<String> aggiungiduserATabella() throws Exception {

		try {

			RestTemplate rest = new RestTemplate();

			String result = rest.getForObject("http://localhost:8081/user/aggiungianagrafica", String.class);
			userService.aggiungiIdUserAIDIndirizzo(result);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore durante l'aggiunta dell'utente");// Messaggio
																												// di
																												// errore;
		}
		return ResponseEntity.ok("Utente aggiunto con successo"); // Messaggio di successo
	}

	@GetMapping("/getutenti")
	public List<UserDto> recuperaListaUtenti() throws Exception {

		List<UserDto> ret = new ArrayList<UserDto>();
		try {

			ret = userService.recuperaListaUtenti();

		} catch (Exception e) {
			return ret;
		
		}
		return ret;

	}





}
