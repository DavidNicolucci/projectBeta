/**
 * 
 */
package com.project1.david.service;

import org.springframework.http.HttpStatus;

import com.project1.david.dto.MasterDataDto;

/**
 * 
 */
public interface MasterDataService {

	public String aggiungiAnagrafica(MasterDataDto userDto) throws Exception;
}
