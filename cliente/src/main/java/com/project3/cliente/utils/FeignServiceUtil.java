package com.project3.cliente.utils;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.project3.cliente.dto.UserDto;

@FeignClient(value="feignDemo", url ="http://localhost:8080/user")
public interface FeignServiceUtil {

	@GetMapping("/getutenti")
	List<UserDto> recuperaListaUtenti();
	
	
}
