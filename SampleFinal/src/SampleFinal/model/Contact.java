package SampleFinal.model;

public class Contact {
	
	int id;
	String name;
	String contact;
	String letter;

	public Contact()
	{
		
	}
	
	public Contact(int id,String name,String contact,String letter)
	{
		this.id=id;
		this.name=name;
		this.contact=contact;
		this.letter=letter;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}
	
	
	
	
}
