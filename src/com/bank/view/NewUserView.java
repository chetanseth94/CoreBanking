package com.bank.view;

import java.sql.Date;
import java.util.Scanner;

import com.bank.model.User;

public class NewUserView {
	
	static Scanner scn = new Scanner(System.in);
	
	public User createNewUser() {
		User user = new User();
		user.setFullName(takeFullnameInput());
		user.setDob(takeDOBInput());
		user.setAddress(takeAddressInput());
		user.setPin(takePinInput());
		return user;
	}
	
	private String takeFullnameInput() {
		boolean valid = false;
		String name = "";
		while(!valid) {
			System.out.print("Enter full name: ");
			name = scn.nextLine();
			if(name.length() < 3)	System.err.println("Enter atleast 3 characters.");
			else if(!((name.charAt(0) >=65) && (name.charAt(0) <= 90)) && !((name.charAt(0) >=97) && (name.charAt(0) <= 122)))
				System.err.println("Name can only start with a letter.");
			else valid = true;
		}
		return name;
	}
	
	private Date takeDOBInput() {
		boolean valid = false;
		Date DOB=null;;
		while(!valid) {
			try {
				System.out.println("Enter your date of birth in yyyy-mm-dd format: ");
				System.out.println("Example: 1990-08-21");
				String dob = scn.nextLine();
				DOB = Date.valueOf(dob);
				valid = true;
			}
			catch (IllegalArgumentException e) {
				System.err.println("Enter date in specified format only.");
			}
		}
		return DOB;
	}
	
	private String takeAddressInput() {
		boolean valid = false;
		String address = "";
		while(!valid) {
			System.out.print("Enter your address: ");
			address = scn.nextLine();
			if(address.length() < 10) {
				System.err.println("Enter minimum 10 characters.");
			}
			else valid = true;
		}
		return address;
	}
	
	private int takePinInput() {
		boolean valid = false;
		int pin = 0;
		while(!valid) {
			try {
				System.out.print("Set your 4 digit security pin: ");
				String PIN = scn.nextLine();
				pin = Integer.parseInt(PIN);
				if(PIN.length() != 4 || pin<0) {
					System.err.println("Enter an exact 4 digit positive pin.");
				}
				else valid = true;
			}
			catch(IllegalArgumentException e) {
				System.err.println("Please enter numbers only.");
			}
		}
		return pin;
	}

}
