package SampleFinal.model;

public class Fields {
	

	int uid;
	String fname;
	String fvalue;
	
	public Fields()
	{
		
	}

	public Fields(int uid,String fname,String fvalue)
	{
		this.uid=uid;
		this.fname=fname;
		this.fvalue=fvalue;
		
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFvalue() {
		return fvalue;
	}

	public void setFvalue(String fvalue) {
		this.fvalue = fvalue;
	}
	
	
}
