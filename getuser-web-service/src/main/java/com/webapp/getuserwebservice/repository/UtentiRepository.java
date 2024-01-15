package com.webapp.getuserwebservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.webapp.getuserwebservice.models.Utenti;

@Repository
public interface UtentiRepository extends MongoRepository<Utenti, String> {

	public Utenti findByUserId(String UserId);
	
}
