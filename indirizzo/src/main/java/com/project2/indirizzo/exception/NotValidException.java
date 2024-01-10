package com.project2.indirizzo.exception;

import java.util.Set;

import org.springframework.http.HttpStatus;


public class NotValidException extends RuntimeException {

	
    private static final long serialVersionUID = 1L;
    private final HttpStatus status;
    private Set<String> errors;

    public NotValidException(HttpStatus status, Set<String> errors) {
        super("Errori di validazione");
        this.status = status;
        this.errors = errors;
    }
    
    
    public NotValidException(HttpStatus status, String messaggio) {
        super(messaggio);
        this.status = status;
    }
    
    public NotValidException(int code, String messaggio) {
        super(messaggio);
        this.status = HttpStatus.resolve(code);
    }

    public Set<String> getErrors() {
        return errors;
    }

    public HttpStatus getStatus() {
        return status;
    }
    
    
    
    
}
