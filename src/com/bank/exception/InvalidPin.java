package com.bank.exception;

public class InvalidPin extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidPin(String message) {
		super(message);
	}
}
