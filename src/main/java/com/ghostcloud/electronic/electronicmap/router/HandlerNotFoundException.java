package com.ghostcloud.electronic.electronicmap.router;

public class HandlerNotFoundException extends Exception {
	
	private static final long serialVersionUID = -6462606299072087869L;

	public HandlerNotFoundException(){
		super();
	}
	
	public HandlerNotFoundException(String message){
		super(message);
	}

}
