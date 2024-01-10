package com.project3.cliente.dto;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	
	private String nameUser;
	private String surnameUser;
	private Date dateOfBirth;
    private String fiscalCode;
    private String idTabella;
    private Integer deleted;
    private Integer active;
    private String roles;
	
	
}
