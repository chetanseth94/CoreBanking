package com.bank.exception;

public class InsufficientBalance extends Exception{

	private static final long serialVersionUID = 1L;

	public InsufficientBalance(String message) {
		super(message);
	}
}
