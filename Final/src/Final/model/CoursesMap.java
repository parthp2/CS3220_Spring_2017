package Final.model;

public class CoursesMap {
	
	public CoursesMap()
	{
		
	}
	
	int id;
	String qcname;
	String scname;
	
	public CoursesMap(int id,String qcname, String scname)
	{
		this.id=id;
		this.qcname=qcname;
		this.scname=scname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQcname() {
		return qcname;
	}

	public void setQcname(String qcname) {
		this.qcname = qcname;
	}

	public String getScname() {
		return scname;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	

}
