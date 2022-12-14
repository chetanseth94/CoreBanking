package com.bank.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bank.controller.AccountController;
import com.bank.exception.InsufficientBalance;
import com.bank.exception.InvalidAccountException;
import com.bank.exception.InvalidPin;
import com.bank.model.BalanceInputs;
import com.bank.model.TransactionInputs;
import com.bank.model.UserDetails;

public class WelcomeView {
	
	static Scanner scn = new Scanner(System.in);
	
	public void initiate() {
		boolean run = true;
		while(run) {
			int input = mainMenu();
			switch (input) {
				case 1: 
					createAccountMenu();
					run = continueOrExit();
					break;
				case 2: 
					depositMenu();
					run = continueOrExit();
					break;
				case 3: 
					withdrawMenu();
					run = continueOrExit();
					break;
				case 4: 
					checkBalanceMenu();
					run = continueOrExit();
					break;
				case 5: return;
				default: return;
			}
		}
	}
	
	private static int mainMenu() {
		boolean valid = false;
		int input = 0;
		System.out.println("Enter your choice (1-5): ");
		System.out.println("1. Create New Account");
		System.out.println("2. Deposit Money Into Existing Account");
		System.out.println("3. Withdraw Money From Existing Account");
		System.out.println("4. Check Balance Of Existing Account");
		System.out.println("5. Exit");
		while(!valid) {
			try {
				input = scn.nextInt();
				if(input < 1 || input > 5)	System.err.println("Please choose a number between 1 and 5.");
				else valid = true;
			} catch (InputMismatchException e) {
				scn.next();
				System.err.println("Only numbers are allowed.");
			}
		}
		return input;
	}
	
	private static void createAccountMenu() {
		AccountController accountController = new AccountController();
		
		NewUserView newUser = new NewUserView();
		UserDetails user = newUser.createNewUser();
		
		long accountNumber = accountController.createAccount(user);
		
		System.out.println("Your account has been successfully created.");
		System.out.println("Kindly note down your account number: "+accountNumber);
	}
	
	private static void depositMenu() {
		AccountController accountController = new AccountController();

		TransactionView transactionView = new TransactionView();
		TransactionInputs tInputs = transactionView.depositView();
		
		int accountNumber = tInputs.getAccountNumber();
		double amount = tInputs.getAmount();
		int pin = tInputs.getPin();
		
		try {
			System.out.println(
				"Updated account balance: " + 
				accountController.deposit(accountNumber, amount, pin)
			);
		} catch (InvalidAccountException e) {
			System.err.println(e.getMessage());
			System.err.println("Try later.");
		} catch (InvalidPin e) {
			System.err.println(e.getMessage());
			System.err.println("Try later.");
		}
	}
	
	private static void withdrawMenu() {
		AccountController accountController = new AccountController();
		
		TransactionView transactionView = new TransactionView();
		TransactionInputs tInputs = transactionView.withdrawView();
		
		int accountNumber = tInputs.getAccountNumber();
		double amount = tInputs.getAmount();
		int pin = tInputs.getPin();
		try {
			System.out.println(
				"Updated account balance: " + 
				accountController.withdraw(accountNumber, amount, pin)
			);
		} catch (InvalidAccountException e) {
			System.err.println(e.getMessage());
			System.err.println("Try later.");
		} catch(InsufficientBalance e) {
			System.err.println(e.getMessage());
			System.err.println("Try later.");
		} catch (InvalidPin e) {
			System.err.println(e.getMessage());
			System.err.println("Try later.");
		}
	}
	
	private static void checkBalanceMenu() {
		AccountController accountController = new AccountController();

		TransactionView transactionView = new TransactionView();
		BalanceInputs bInputs = transactionView.checkBalanceView();
		
		int accountNumber = bInputs.getAccountNumber();
		int pin = bInputs.getPin();
		
		try {
			System.out.println(
				"Account balance: " + 
				accountController.getAccountBalance(accountNumber, pin)
			);
		} catch (InvalidAccountException e) {
			System.err.println(e.getMessage());
			System.err.println("Try later.");
		} catch (InvalidPin e) {
			System.err.println(e.getMessage());
			System.err.println("Try later.");
		}
	}
	
	private static boolean continueOrExit() {
		int input = 0;
		boolean valid = false;
		System.out.println("Enter your choice (1-2): ");
		System.out.println("1. Main Menu");
		System.out.println("2. Exit");
		while(!valid) {
			try {
				input = scn.nextInt();
				if(input < 1 || input > 2)	System.err.println("Enter 1 or 2 only.");
				else valid = true;
			} catch(InputMismatchException e) {
				scn.next();
				System.err.println("Only numbers are allowed.");
			}
		}
		return input==1 ? true:false;
	}
}
