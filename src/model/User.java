package model;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import database.ConnectDB;

public class User {
	private static AtomicInteger counts; 
	private static int UserID;
	private String UserName;
	private String Password;
	private Integer UserAge;
	
	
	
	public User(int count, String userName, String password, Integer userAge) {
		super();
		counts  = new AtomicInteger(count);
		UserID = counts.incrementAndGet();
		UserName = userName;
		Password = password;
		UserAge = userAge;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Integer getUserAge() {
		return UserAge;
	}

	public void setUserAge(Integer userAge) {
		UserAge = userAge;
	}
	
	public static boolean checkUsernameAndPassword(String name, String pass){
		ConnectDB db = ConnectDB.getInstance();
		boolean registered = false;
		if(db.checkUsername(name) && db.checkPassword(pass)) {
			registered = true;
		}
		
		return registered;
	}

	public static void create(User user) {
		// TODO Auto-generated method stub			
		ConnectDB db = ConnectDB.getInstance();

		db.executePrepUpdate("INSERT INTO userclafes (UserName, Password, UserAge) VALUES (?, ?, ?)", preparedStatement->{
		try {
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getUserAge());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}); 
	}
	
}
