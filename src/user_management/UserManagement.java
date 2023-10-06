package user_management;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;


public class UserManagement {
	static ArrayList<User> al = new ArrayList<> ();
	static {
		try {
			loaddatafromfiletoArrayList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void userManagement() throws IOException{
		Scanner scanner = new Scanner(System.in);
		boolean canikeeprunningprogram = true;
		while(canikeeprunningprogram == true) {
			System.out.println("###WELLCOME TO USER MANAGEMENT##");
			System.out.println("\n");
			System.out.println("1. Add User:");
			System.out.println("2. Edit User:");
			System.out.println("3. Delete User:");
			System.out.println("4. Search User:");
			System.out.println("5. Quit User:");
			
			int optionselectedbyuser = scanner.nextInt();
			if(optionselectedbyuser == userOptions.Quit_User) {
				File file = new File("\\Users\\hemag\\eclipse-workspace\\ShopManagement5\\src\\user_management\\User.csv ");
				FileWriter fileWriter = new FileWriter(file,false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for(User user:al) {
					bufferedWriter.write(user.username+","+user.loginname+","+user.password+","+user.confirmpassword+","+user.userrole+"\n");
				}
				bufferedWriter.close();
				fileWriter.close();
				file = null;
				
				System.out.println("!!Program closed....");
				System.out.println("\n");
				canikeeprunningprogram = false;
			}
			else if(optionselectedbyuser == userOptions.Add_User) {
				addUser();
				System.out.println("\n");
			}
			else if(optionselectedbyuser == userOptions.Search_User) {
				System.out.println("Enter the username to Search user: ");
				scanner.nextLine();
				String searchusername = scanner.nextLine();
				SearchUser(searchusername);
				System.out.println("\n");
			}
			else if(optionselectedbyuser == userOptions.Delete_User) {
				System.out.println("Enter the username to Delete user :");
				scanner.nextLine();
				String deleteusername = scanner.nextLine();
				DeleteUser(deleteusername);
			}
			else if(optionselectedbyuser == userOptions.Edit_User) {
				System.out.println("Enter username to Edit User :");
				scanner.nextLine();
				String editusername = scanner.nextLine();
				EditUser(editusername);
			}
		}
		System.out.println("After while loop....");
		for(User u:al) {
			System.out.println(u.username);
			System.out.println(u.loginname);
			System.out.println(u.password);
			System.out.println(u.confirmpassword);
			System.out.println(u.userrole);
		}
	}
	public static void addUser() {
		Scanner scanner = new Scanner(System.in);
		User userObject = new User();
		System.out.println("User name:");
		userObject.username = scanner.nextLine();
		System.out.println("Login name:");
		userObject.loginname = scanner.nextLine();
		System.out.println("Password:");
		userObject.password = scanner.nextLine();
		System.out.println("Confirm password:");
		userObject.confirmpassword = scanner.nextLine();
		System.out.println("User role:");
		userObject.userrole = scanner.nextLine();
		
		System.out.println("User name :"+userObject.username);
		System.out.println("Login name :"+userObject.loginname);
		System.out.println("Password:"+userObject.password);
		System.out.println("Confirm password:"+userObject.confirmpassword);
		System.out.println("Userrole :"+userObject.userrole);
		al.add(userObject);
		
	}
	public static void SearchUser(String username) {
		for(User user:al) {
			if(user.username.equalsIgnoreCase(username)) {
				System.out.println("User name:"+user.username);
				System.out.println("Login name:"+user.loginname);
				System.out.println("Password:"+user.password);
				System.out.println("Confirm password:"+user.confirmpassword);
				System.out.println("User role:"+user.userrole);
				return;
			}
         }
		System.out.println("!!User not found...");
	}
	public static void EditUser(String username) {
		for(User user:al) {
			if(user.username.equalsIgnoreCase(username)) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Editing username:"+user.username);
				System.out.println("New username:");
			    user.username = scanner.nextLine();
			    System.out.println("New Loginname:");
			    user.loginname = scanner.nextLine();
			    System.out.println("Password:");
			    user.password = scanner.nextLine();
			    System.out.println("Confirm password:");
			    user.confirmpassword = scanner.nextLine();
			    System.out.println("User role:");
			    user.userrole = scanner.nextLine();
			    System.out.println("Information updated!!!!");
			    return;
			}
		}
		System.out.println("USer not found........");
		}
	public static void DeleteUser(String username) {
		Iterator<User> userIterator = al.iterator();
	    while(userIterator.hasNext()) {
	    	User user = userIterator.next();
	    	if(user.username.equalsIgnoreCase(username)) {
	    		userIterator.remove();
	    		System.out.println("User "+user.username+" has been deleted...");
				break;
	    	}
	    }
		
	}
	public static void loaddatafromfiletoArrayList() throws IOException{
		File file = new File("\\Users\\hemag\\eclipse-workspace\\ShopManagement5\\src\\user_management\\User.csv ");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = " ";
		while((line= bufferedReader.readLine())!= null) {
			User user = new User();
			String[] userDataArray = line.split(",");
			if(userDataArray.length>4) {
				user.username =userDataArray[0];
				user.loginname = userDataArray[1];
				user.password = userDataArray[2];
				user.confirmpassword = userDataArray[3];
				user.userrole = userDataArray[4];
				al.add(user);
			}
		}
		fileReader.close();
		bufferedReader.close();
		file =null;
		
	}
	public static boolean validateUserandPassword(String loginname, String password) {
		Iterator<User> userIterator = al.iterator();
		while(userIterator.hasNext()) {
			User user = userIterator.next();
			if(user.loginname.equalsIgnoreCase(loginname) && user.password.equalsIgnoreCase(password)) {
				return true;
	   }
	}
		return false;
	}
}
