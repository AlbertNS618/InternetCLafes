package model;

import java.sql.Date;

public class PCBook {
	private int Book_ID;
	private int PC_ID;
	private int User_ID;
	private Date Booked_Date;
	
	public PCBook(int book_ID, int pC_ID, int user_ID, Date booked_Date) {
		super();
		Book_ID = book_ID;
		PC_ID = pC_ID;
		User_ID = user_ID;
		Booked_Date = booked_Date;
	}

	public int getBook_ID() {
		return Book_ID;
	}

	public void setBook_ID(int book_ID) {
		Book_ID = book_ID;
	}

	public int getPC_ID() {
		return PC_ID;
	}

	public void setPC_ID(int pC_ID) {
		PC_ID = pC_ID;
	}

	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public Date getBooked_Date() {
		return Booked_Date;
	}

	public void setBooked_Date(Date booked_Date) {
		Booked_Date = booked_Date;
	}
	
}