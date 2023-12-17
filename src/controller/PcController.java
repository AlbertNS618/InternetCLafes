package controller;

import model.PC;

public class PcController {
	
	public static String AddNewPC(int pcid, String condition) {
		if(PC.checkPCID(pcid)) {
			return "The PC already exist";
		}
		
		if(!(condition.equals("Usable") || condition.equals("Maintenance") || condition.equals("Broken"))) {
			return "The conditions must be between Usable, Maintenance, or Broken";
		}
		PC.addPC(new PC(pcid, condition));
		return "Success";
	}
	
	public static String removePC(int pcid) {
		if(!PC.checkPCID(pcid)) {
			return "The PC doesn't exist";
		}
		
		PC.deletePC(pcid);
		return "Success";
	}
	
	public static String updatePC(int pcid, String condition) {
		if(!PC.checkPCID(pcid)) {
			return "The PC doesn't exist";
		}
		
		if(!(condition.equals("Usable") || condition.equals("Maintenance") || condition.equals("Broken"))) {
			return "The conditions must be between Usable, Maintenance, or Broken";
		}
		
		PC.updatePC(pcid, condition);
		return "Success";
	}
}
