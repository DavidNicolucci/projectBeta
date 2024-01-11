package com.project1.david.entity;

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
@Table(name= "USER")
@NoArgsConstructor
@Data//genera getter,setter,equals,tostringe hashcode  

public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer idUser;
	
	@Column(name = "name_user")
	private String nameUser;
	
	@Column(name="surname_user")
	private String surnameUser;
	
	@Column(name = "date_birth")
	private Date dateOfBirth;
	
	@Column(name = "fiscal_code")
    private String fiscalCode;
	
	@Column(name = "id_indirizzo")
	private Integer idIndirizzo;

    @Column(name = "roles")
	private String roles;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "active")
    private Integer active;
    
    @Column(name = "deleted")
    private Integer deleted;
    
	@Column(name = "id_customer")
    private Integer idCustomer;

}
