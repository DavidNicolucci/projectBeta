package com.project2.indirizzo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MasterDataDto {

	
    private long id;
	private String address;
	private String addressNumber;
	private String nation;
	private String city;
    private String cap;
	
	
}
