package com.bank.view;

import java.util.Scanner;

import com.bank.model.User;

public class NewAccount {
	
	static Scanner scn = new Scanner(System.in);
	
	public User createNewAccount() {
		User user = new User();
		user.setFullName(takeFullnameInput());
		//user.setDob(takeDOBInput());
		user.setAddress(takeAddressInput());
		user.setPin(takePinInput());
		return user;
	}
	
	private String takeFullnameInput() {
		System.out.println("Enter full name: ");
		return scn.nextLine();
	}
	
	private String takeDOBInput() {
		System.out.println("Enter your date of birth: ");
		return scn.nextLine();
	}
	
	private String takeAddressInput() {
		System.out.println("Enter your address: ");
		return scn.nextLine();
	}
	
	private int takePinInput() {
		System.out.println("Set your security pin: ");
		return scn.nextInt();
	}

}
