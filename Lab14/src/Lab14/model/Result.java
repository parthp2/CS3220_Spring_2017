package Lab14.model;

public class Result {
	
	int question,cans;
	
	String yans;
	
	public Result()
	{
		
	}
	
	public Result(int question,int cans, String yans)
	{
		this.question=question;
		this.cans=cans;
		this.yans=yans;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public int getCans() {
		return cans;
	}

	public void setCans(int cans) {
		this.cans = cans;
	}

	public String getYans() {
		return yans;
	}

	public void setYans(String yans) {
		this.yans = yans;
	}

	
	
	

}
