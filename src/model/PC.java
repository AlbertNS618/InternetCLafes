package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import database.ConnectDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

	public PC(int pcid2) {
		// TODO Auto-generated constructor stub
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
	 
	 //Main Functions
	 public static void addPC(PC pc) {
		 db.executePrepUpdate("INSERT INTO pcclafes (PCid, PC_cond) VALUES (?, ?)", ps->{
				try {
					ps.setInt(1, pc.getPcID());
					ps.setString(2, pc.getPcCond());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}); 
	 }
	 
	 public static void deletePC(int id) {
		 db.executePrepUpdate("DELETE FROM pcclafes WHERE PCid = ?", ps->{
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
	 
	 // Util Functions
//	 public static ObservableList<PC> displayAllPC(){
//		 ObservableList<PC> pcs = db.getAllPC();
//		 return pcs;
//	 }
	 
	 public static ObservableList<PC> getAllPC() {
			ConnectDB db = ConnectDB.getInstance();
			
			Vector<PC> check = db.executePrepQuery("SELECT * FROM pcclafes", ps->{}, rs->{
				Vector<PC> result = new Vector<>();
				try {
					while(rs.next()) {
						int pcid = rs.getInt("PCid");
						String pccond = rs.getString("PC_cond");
						result.add(new PC(pcid, pccond));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return result;
			});
			ObservableList<PC> pcs = FXCollections.observableArrayList(check);
			return pcs;
			
		}
	 
	 public static boolean checkPCID(int id) {
			ConnectDB db = ConnectDB.getInstance();
			boolean pcExists = true;
			
			Vector<PC> check = db.executePrepQuery("SELECT PCid FROM pcclafes WHERE PCid = ?", ps->{
				try {
					ps.setInt(1, id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}, rs->{
				Vector<PC> result = new Vector<>();
				try {
					while(rs.next()) {
						int pcid = rs.getInt("PCid");
						result.add(new PC(pcid));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return result;
			});
			
			if(check.isEmpty()) {
				pcExists = false;
			}
			
		    return pcExists;
		}
	 
}