package Lab15.model;

public class Available {
	
	String day;
	int slot;
	
	public Available()
	{
		
	}
	
	public Available(String day)
	{
		this.day=day;
	}
	
	public Available(int slot)
	{
		this.slot=slot;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	
}
