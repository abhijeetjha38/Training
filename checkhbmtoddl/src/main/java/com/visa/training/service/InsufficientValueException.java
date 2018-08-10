package com.visa.training.service;

public class InsufficientValueException extends RuntimeException {

	public InsufficientValueException(String message) {
		super(message) ;
		
	
	}
	// exceptions originating out of a layer must be part of a layer !! 
	

}
