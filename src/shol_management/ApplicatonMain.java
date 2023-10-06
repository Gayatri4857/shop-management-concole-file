package shol_management;

import product_management.ProductManagement;
import user_management.UserManagement;
import java.util.Scanner;
import java.io.IOException;
public class ApplicatonMain {
	public static void main(String args[]) throws IOException {
		Scanner scanner = new Scanner(System.in);
		boolean canikeeprunningprogram = true;
		System.out.println("##WELLCOME TO SHOP MANAGEMENT##");
		System.out.println("\n");
		System.out.println("Login name:");
		String loginname = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		
		if(!UserManagement.validateUserandPassword(loginname,password)) {
			System.out.println("Login failed..Closing the application..");
			return;
		}
			while(canikeeprunningprogram == true) {
				System.out.println("###WELLCOME TO SHOP MANAGEMENT##");
				System.out.println("\n");
				System.out.println("What would you like to do?:");
				System.out.println("1. User Management");
				System.out.println("2 Product Management");
				System.out.println("5. Quit");
				
				int optionselectedbyuser = scanner.nextInt();
				if(optionselectedbyuser == 1) {
					UserManagement.userManagement();
				}
				else if(optionselectedbyuser == 2) {
					ProductManagement.productManagement();
				}
				else if(optionselectedbyuser ==5) {
					break;
			
			}
			}
		}
		

}
