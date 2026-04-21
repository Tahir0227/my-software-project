package com.main;

import java.util.Scanner;

import com.menudrive.Menu;
import com.menudrive.Menu.AuthResult;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		AuthResult auth = null;
		
		do {
			// Phase 1: Pre-Login Menu / Main Screen
			System.out.println("\n=============================================");
			System.out.println("        SERVICE CENTER SYSTEM - MAIN");
			System.out.println("=============================================");
			System.out.println("1. LOGIN");
			System.out.println("2. REGISTER NEW CUSTOMER");
			System.out.println("0. EXIT");
			System.out.println("---------------------------------------------");
			System.out.print("Enter choice: ");
			
			if (sc.hasNextInt()) {
				choice = sc.nextInt();
			} else {
				System.out.println("Invalid input. Please enter a number.");
				sc.next(); // consume invalid input
				continue;
			}
			
			switch(choice) {
				case 0 :
					System.out.println("Thank You For Visiting!!!");
					break;
				
				case 1 :
					// Attempt Login
					auth = Menu.login(sc);
					if (auth != null) {
						System.out.println("\n*** Login Successful! Welcome, " + auth.role.toUpperCase() + " ***");
						// Phase 2: Post-Login - Display Role-Specific Menu
						
						switch (auth.role) {
							case "admin":
								Menu.adminMenu(sc, auth);
								break;
							case "technician":
								Menu.technicianMenu(sc, auth);
								break;
							case "customer":
								Menu.customerMenu(sc, auth);
								break;
						}
					}
					// After logout (choice 0 in sub-menu), return to main login menu
					break;
					
				case 2 :
					Menu.addCustomer(sc);
					break;
					
				default:
					System.out.println("Invalid choice. Try again.");
			}
			
		} while(choice != 0 );
		sc.close();
	}

}
