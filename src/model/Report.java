package model;

import java.sql.Date;

public class Report {
	private int Report_ID;
	private String User_Role;
	private int PC_ID;
	private String Report_Note;
	private Date Report_Date;
	
	public Report(int report_ID, String user_Role, int pC_ID, String report_Note, Date report_Date) {
		super();
		Report_ID = report_ID;
		User_Role = user_Role;
		PC_ID = pC_ID;
		Report_Note = report_Note;
		Report_Date = report_Date;
	}

	public int getReport_ID() {
		return Report_ID;
	}

	public void setReport_ID(int report_ID) {
		Report_ID = report_ID;
	}

	public String getUser_Role() {
		return User_Role;
	}

	public void setUser_Role(String user_Role) {
		User_Role = user_Role;
	}

	public int getPC_ID() {
		return PC_ID;
	}

	public void setPC_ID(int pC_ID) {
		PC_ID = pC_ID;
	}

	public String getReport_Note() {
		return Report_Note;
	}

	public void setReport_Note(String report_Note) {
		Report_Note = report_Note;
	}

	public Date getReport_Date() {
		return Report_Date;
	}

	public void setReport_Date(Date report_Date) {
		Report_Date = report_Date;
	}
	
	
}
