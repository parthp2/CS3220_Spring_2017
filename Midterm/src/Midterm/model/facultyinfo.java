package Midterm.model;

public class facultyinfo {
	
	String fname,dname;
	boolean chair;
	
	public facultyinfo()
	{
		
	}
	
	public facultyinfo(String dname,String fname,boolean chair)
	{
		this.dname=dname;
		this.fname=fname;
		this.chair=chair;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public boolean isChair() {
		return chair;
	}

	public void setChair(boolean chair) {
		this.chair = chair;
	}
	
	

}
