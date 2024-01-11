package com.project2.indirizzo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name= "MASTER_DATA")
@NoArgsConstructor
@Data//genera getter,setter,equals,tostringe hashcode  
public class MasterData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer idData;
	
	@Column(name = "address")
	private String address;
	
	@Column(name="address_number")
	private String adrresNumber;
	

	@Column(name="nation")
	private String nation;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "cap")
    private String cap;
	
	
}
