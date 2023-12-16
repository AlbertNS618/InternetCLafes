package model;

public class Job {
	private int Job_ID;
	private int User_ID;
	private String PC_ID;
	private String Job_Status;
	
	public Job(int job_ID, int user_ID, String pC_ID, String job_Status) {
		super();
		Job_ID = job_ID;
		User_ID = user_ID;
		PC_ID = pC_ID;
		Job_Status = job_Status;
	}

	public int getJob_ID() {
		return Job_ID;
	}

	public void setJob_ID(int job_ID) {
		Job_ID = job_ID;
	}

	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public String getPC_ID() {
		return PC_ID;
	}

	public void setPC_ID(String pC_ID) {
		PC_ID = pC_ID;
	}

	public String getJob_Status() {
		return Job_Status;
	}

	public void setJob_Status(String job_Status) {
		Job_Status = job_Status;
	}
	
	
}
