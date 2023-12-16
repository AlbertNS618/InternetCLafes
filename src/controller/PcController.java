package controller;

import model.PC;

public class PcController {
	
	public static String AddNewPC(String condition) {
		if(!(condition.equals("Usable") || condition.equals("Maintenace") || condition.equals("Broken"))) {
			return "The conditions must be between Usable, Maintenance, or Broken";
		}
		PC.addPC(new PC(condition));
		return "Success";
	}
	
}
