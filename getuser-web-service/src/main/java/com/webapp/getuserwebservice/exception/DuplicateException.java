package com.webapp.getuserwebservice.exception;

public class DuplicateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
private String messaggio;
	
	public DuplicateException()
	{
		super();
	}
	
	public DuplicateException(String messaggio)
	{
		super(messaggio);
		this.messaggio = messaggio;
	}
}
