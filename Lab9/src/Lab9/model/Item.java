package Lab9.model;

import java.text.DateFormat;
import java.util.Date;

public class Item {

	String name;
	String date;
	String size;
	
	public Item()
	{
		
	}
	
	public Item(String name,String  date, String size)
	{
		this.name=name;
		this.date=date;
		this.size=size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
	
	
}
