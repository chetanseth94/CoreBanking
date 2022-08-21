package com.bank.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TransactionView {
	
	static Scanner scn = new Scanner(System.in);
	
	public void depositView() {
		accountNumberInput();
		amountInput("deposit");
		scn.nextLine();
		pinInput();
		return;
	}
	
	public void withdrawView() {
		accountNumberInput();
		amountInput("withdraw");
		scn.nextLine();
		pinInput();
		return;
	}
	
	public void checkBalanceView() {
		accountNumberInput();
		scn.nextLine();
		pinInput();
	}
	
	private long accountNumberInput() {
		boolean valid = false;
		long accountNumber = 0;
		while(!valid) {
			try {
				System.out.print("Enter account number: ");
				accountNumber = scn.nextLong();
				valid = true;
			} catch(InputMismatchException e) {
				scn.nextLine();
				System.err.println("Only numbers are allowed.");
			}
		}
		return accountNumber;
	}
	
	private double amountInput(String type) {
		boolean valid = false;
		double amount = 0;
		while(!valid) {
			try {
				System.out.print("Enter "+type+" amount: ");
				amount = scn.nextDouble();
				if(amount <= 0)	System.err.println("Enter amount greater than 0");
				else valid = true;
			} catch(InputMismatchException e) {
				scn.nextLine();
				System.err.println("Only numbers are allowed.");
			}
		}
		return amount;
	}
	
	private int pinInput() {
		boolean valid = false;
		int pin = -1;
		while(!valid) {
			try {
				System.out.print("Enter 4 digit pin: ");
				String PIN = scn.nextLine();
				pin = Integer.parseInt(PIN);
				if(PIN.length() != 4 || pin<0)	System.err.println("Enter an exact 4 digit positive pin.");
				else valid = true;
			} catch(IllegalArgumentException e) {
				System.err.println("Only numbers are allowed.");
			}
		}
		return pin;
	}

}
