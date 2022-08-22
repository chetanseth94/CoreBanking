package com.bank.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bank.model.BalanceInputs;
import com.bank.model.TransactionInputs;

public class TransactionView {
	
	static Scanner scn = new Scanner(System.in);
	TransactionInputs tInputs;
	BalanceInputs bInputs;
	
	public TransactionInputs depositView() {
		tInputs = new TransactionInputs();
		tInputs.setAccountNumber(accountNumberInput());
		tInputs.setAmount(amountInput("deposit"));
		scn.nextLine();
		tInputs.setPin(pinInput());
		return tInputs;
	}
	
	public TransactionInputs withdrawView() {
		tInputs = new TransactionInputs();
		tInputs.setAccountNumber(accountNumberInput());
		tInputs.setAmount(amountInput("withdraw"));
		scn.nextLine();
		tInputs.setPin(pinInput());
		return tInputs;
	}
	
	public BalanceInputs checkBalanceView() {
		bInputs = new BalanceInputs();
		bInputs.setAccountNumber(accountNumberInput());
		scn.nextLine();
		bInputs.setPin(pinInput());
		return bInputs;
	}
	
	private int accountNumberInput() {
		boolean valid = false;
		int accountNumber = 0;
		while(!valid) {
			try {
				System.out.print("Enter account number: ");
				accountNumber = scn.nextInt();
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
