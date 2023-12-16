package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectDB;

public class PC {
	private int pcID;
	 private String pcCond;
	
	 public PC(int pcID, String pcCond) {
	  super();
	  this.pcID = pcID;
	  this.pcCond = pcCond;
	 }
	
	 public PC(String pcCond) {
		// TODO Auto-generated constructor stub
		 super();
		 this.pcCond = pcCond;
	}

	public int getPcID() {
	  return pcID;
	 }
	 public void setPcID(int pcID) {
	  this.pcID = pcID;
	 }
	
	 public String getPcCond() {
	  return pcCond;
	 }
	
	 public void setPcCond(String pcCond) {
	  this.pcCond = pcCond;
	 }
	 
	 static ConnectDB db = ConnectDB.getInstance();
	 static PreparedStatement ps;
	 public static void addPC(PC pc) {
		 db.executePrepUpdate("INSERT INTO pcclafes (PC_cond) VALUES (?)", ps->{
				try {
					ps.setString(1, pc.getPcCond());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}); 
	 }
	 
	 public static void deletePC(int id) {
		 db.executePrepUpdate("INSERT FROM pcclafes WHERE PCid = ?", ps->{
				try {
					ps.setInt(1, id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}); 
	 }
	 
	 public static void updatePC(int id, String cond) {
		 db.executePrepUpdate("UPDATE pcclafes SET PC_cond = ? WHERE PCid = ?", ps->{
				try {
					ps.setString(1, cond);
					ps.setInt(2, id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}); 
	 }
	 
}