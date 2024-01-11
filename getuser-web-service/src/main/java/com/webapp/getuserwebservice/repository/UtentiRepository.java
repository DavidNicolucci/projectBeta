package com.webapp.getuserwebservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webapp.getuserwebservice.models.Utenti;

public interface UtentiRepository extends MongoRepository<Utenti, String> {

	public Utenti findByUserId(String UserId);
	
}
