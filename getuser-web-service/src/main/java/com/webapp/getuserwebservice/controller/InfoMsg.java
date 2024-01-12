package com.webapp.getuserwebservice.controller;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
/**
 * Questa classe viene usata nella classe UtentiController
 */
public class InfoMsg {

	public LocalDate data;
	
	public String message;
	
}
