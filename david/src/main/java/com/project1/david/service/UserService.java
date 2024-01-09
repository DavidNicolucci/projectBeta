/**
 * 
 */
package com.project1.david.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.project1.david.dto.UserDto;

/**
 * 
 */
public interface UserService {

	public  HashMap<Integer, String> aggiungiUser(UserDto userDto) throws Exception;
	public HttpStatus aggiungiIdUserAIDIndirizzo(String idIndirizzo) throws Exception;
    public List<UserDto> recuperaListaUtenti() throws Exception;
	
	
}
