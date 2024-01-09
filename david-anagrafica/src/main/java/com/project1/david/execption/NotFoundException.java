package com.project1.david.execption;

public class NotFoundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;

    public NotFoundException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
