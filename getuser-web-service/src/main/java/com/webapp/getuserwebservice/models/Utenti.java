/**
 * 
 */
package com.webapp.getuserwebservice.models;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection= "utenti")
@Data
/**
 * Classe che rappresenta il model, 
 * in mongo db non ci sono le Entity
 */
public class Utenti {

	@Id
	private String id;
	
	@Indexed(unique= true)//indica che il valore è univoco non accetta duplicati
	@Size(min=5, max=80, message= "{Size.Utenti.userId.Validation}")
	@NotNull(message= "{NotNull.Atricoli.userId.Validation}")
	private String userId;
	
	@Size(min= 8, max = 80, message= "{Size.Utenti.password.Validation}")
	private String password;
	
	private String attivo="SI";
	
	@NotNull(message= "{NotNull.Utenti.ruoli.Validation}")
	private List<String> ruoli;
	
	
}
