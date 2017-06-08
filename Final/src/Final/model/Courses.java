package Final.model;

public class Courses {
	
	public Courses()
	{
		
	}
	
	int id;
	String cname;
	String term;
	String letter;
	int num;
	
	public Courses(int id,String cname,String term,String letter,int num)
	{
		this.id=id;
		this.cname=cname;
		this.term=term;
		this.letter=letter;
		this.num=num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	

}
