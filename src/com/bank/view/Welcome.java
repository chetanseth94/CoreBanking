package com.bank.view;

public class Welcome {
	
	public void initiate() {
		displayMenu();
	}
	
	private static void displayMenu() {
		System.out.println("Enter your choice (1-5): ");
		System.out.println("1. Create New Account");
		System.out.println("2. Deposit Money Into Existing Account");
		System.out.println("3. Withdraw Money From Existing Account");
		System.out.println("4. Check Balance Of Existing Account");
		System.out.println("5. Exit");
	}

}
