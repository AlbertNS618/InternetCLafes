package model;


public class PC {
	 private String pcID, pcCond;
	
	 public PC(String pcID, String pcCond) {
	  super();
	  this.pcID = pcID;
	  this.pcCond = pcCond;
	 }
	
	 public String getPcID() {
	  return pcID;
	 }
	
	 public void setPcID(String pcID) {
	  this.pcID = pcID;
	 }
	
	 public String getPcCond() {
	  return pcCond;
	 }
	
	 public void setPcCond(String pcCond) {
	  this.pcCond = pcCond;
	 }
	 
}