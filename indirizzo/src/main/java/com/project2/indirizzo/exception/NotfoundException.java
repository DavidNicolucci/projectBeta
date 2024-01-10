package com.project2.indirizzo.exception;

public class NotfoundException extends Exception{

	
	private static final long serialVersionUID = 1L;
	private int code;

    public NotfoundException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
