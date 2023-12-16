package model;


public class PC {
	private int pcID;
	 private String pcCond;
	
	 public PC(int pcID, String pcCond) {
	  super();
	  this.pcID = pcID;
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
	 
}