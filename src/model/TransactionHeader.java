package model;

import java.sql.Date;

public class TransactionHeader {
	private int TransactionID;
	private int StaffID;
	private int StaffName;
	private Date TransactionDate;
	
	public TransactionHeader(int transactionID, int staffID, int staffName, Date transactionDate) {
		super();
		TransactionID = transactionID;
		StaffID = staffID;
		StaffName = staffName;
		TransactionDate = transactionDate;
	}

	public int getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}

	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}

	public int getStaffName() {
		return StaffName;
	}

	public void setStaffName(int staffName) {
		StaffName = staffName;
	}

	public Date getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}
	
	
}
