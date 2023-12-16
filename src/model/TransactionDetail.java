package model;

import java.sql.Date;

public class TransactionDetail {
	private int TransactionID;
	private int pcID;
	private String CustomerName;
	private Date BookedTime;
	
	public TransactionDetail(int transactionID, int pcID, String customerName, Date bookedTime) {
		super();
		TransactionID = transactionID;
		this.pcID = pcID;
		CustomerName = customerName;
		BookedTime = bookedTime;
	}

	public int getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}

	public int getPcID() {
		return pcID;
	}

	public void setPcID(int pcID) {
		this.pcID = pcID;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public Date getBookedTime() {
		return BookedTime;
	}

	public void setBookedTime(Date bookedTime) {
		BookedTime = bookedTime;
	}
	
	
	
}