package controller;

import database.ConnectDB;
import model.User;

public class UserController {
	public static boolean isAlphanumeric(String foo) {
		int alp = 0;
		int num = 0;
		for (int i = 0; i < foo.length(); i++) {
			if (alp != 0 && num != 0)
				return true;
			if (Character.isAlphabetic(foo.charAt(i)))
				alp++;
			if (Character.isDigit(foo.charAt(i)))
				num++;
		}
		return false;
	}
	
	public static String login(String name, String pass) {
		if(name.isEmpty()) {
			return "Please enter the username";
		}
		if(pass.isEmpty()) {
			return "Please enter the password";
		}
		
		if(!User.checkUsername(name)) {
			return "Username doesn't exist";
		}
		
		if(!User.checkPassword(name, pass)) {
			return "Password doesn't match";
		}
		
		return "Logged In";
	}

	public static String registerUser(String name, String pass, String coPass, int age) {
		ConnectDB db = ConnectDB.getInstance();
		int count = db.checkRow();
		
			if(name.length() < 7) {
				return "Name must be 7 or more characters";
			}
			
			if(User.checkUsername(name)) {
				return "Name already exists";
			}
			
			if(!isAlphanumeric(pass)) {
				return "Password is not alphanumeric";
			}
			
			if(pass.length() < 6) {
				return "Password is too short(minimal length 6)";
			}
			
			if(!pass.equals(coPass)) {
				return "Password doesn't match confirmation pass";
			}
			
			if(age < 13 || age > 65) {
				System.err.println("Age have to be between 13 and 65");
				return "Age have to be between 13 and 65";
			}
			
			User.create(new User(count, name, pass, age));
			return "Success";
	}
}
