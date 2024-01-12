package com.webapp.getuserwebservice.service;



import java.util.List;

import com.webapp.getuserwebservice.models.Utenti;
public interface UtentiService {

    public List<Utenti> SelTutti();
	
	public Utenti SelUser(String UserId);
	
	public void Save(Utenti utente);
	
	public void Delete(Utenti utente);
	
}
