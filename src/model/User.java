package model;

import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.List;
import java.util.Vector;
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
	
	public int getUserID() {
		return UserID;
	}

	public User(String userName2, String password2) {
		// TODO Auto-generated constructor stub
	}

	public User(String username2) {
		// TODO Auto-generated constructor stub
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

	
	PreparedStatement ps;
	public static void create(User user) {
		// TODO Auto-generated method stub			
		ConnectDB db = ConnectDB.getInstance();
		db.executePrepUpdate("INSERT INTO userclafes (UserName, Password, UserAge) VALUES (?, ?, ?)", ps->{
		try {
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getUserAge());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}); 
	}
	
	public static boolean checkUsername(String username) {
		ConnectDB db = ConnectDB.getInstance();
		boolean usernameExists = true;
		
		Vector<User> check = db.executePrepQuery("SELECT UserName FROM userclafes WHERE UserName = ?", ps->{
			try {
				ps.setString(1, username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, rs->{
			Vector<User> result = new Vector<>();
			try {
				while(rs.next()) {
					String Username = rs.getString("UserName");
					result.add(new User(Username));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return result;
		});
		
		if(check.isEmpty()) {
			usernameExists = false;
		}
		
	    return usernameExists;
	}
	
	public static boolean checkPassword(String name, String pass) {
		ConnectDB db = ConnectDB.getInstance();
		boolean passwordSame = true;
		
		Vector<User>check = db.executePrepQuery("SELECT * FROM userclafes WHERE UserName = ? AND Password = ?", ps->{
			try {
				ps.setString(1, name);
				ps.setString(2, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, rs->{
			Vector<User> result = new Vector<>();
			try {
				while(rs.next()) {
					String Username = rs.getString("UserName");
					String Password = rs.getString("Password");
					result.add(new User(Username, Password));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return result;
		});
		
		if(check.isEmpty()) {
			passwordSame = false;
		}
	    return passwordSame;
	}
	
}
