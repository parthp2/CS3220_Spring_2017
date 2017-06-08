package Lab20.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private Integer id;

    private String name;

    private List<Faculty> faculty;

    public Department()
    {
        faculty = new ArrayList<Faculty>();
    }

    public Department( String name ,Integer id)
    {
        this();
        this.name = name;
        this.id=id;
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

    public List<Faculty> getFaculty()
    {
        return faculty;
    }

    public void setFaculty( List<Faculty> faculty )
    {
        this.faculty = faculty;
    }

}