package Lab20.model;


public class Faculty {

	private Integer id;
	
    private String name;
    
    private String dname;


    private boolean isChair;

    public Faculty()
    {
       
    }

    public Faculty(Integer id, String name,String dname,boolean isChair )
    {
        this();
        this.id=id;
        this.name = name;
        this.dname=dname;
        this.isChair=isChair;
    }
    
    

    public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public boolean isChair()
    {
        return isChair;
    }

    public void setChair( boolean isChair )
    {
        this.isChair = isChair;
    }

}
