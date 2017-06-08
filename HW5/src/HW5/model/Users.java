package HW5.model;

public class Users {
	
	private static int count = 1; 
	Integer uid;
	String uname,pass;
	
	public Users()
	{
		
	}
	
	public Users(String uname,String pass)
	{
		this.uid=count++;
		this.uname=uname;
		this.pass=pass;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
