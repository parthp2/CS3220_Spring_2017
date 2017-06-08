package Lab15.model;

public class Reserve {
	
	String day,faculty;
	int slot;
	
	public Reserve()
	{
		
	}
	
	public Reserve(String day,String faculty,int slot)
	{
		this.day=day;
		this.faculty=faculty;
		this.slot=slot;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	

}
