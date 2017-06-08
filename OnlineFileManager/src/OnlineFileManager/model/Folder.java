package OnlineFileManager.model;

public class Folder
{
	private static int count = 1; 
    Integer id;
    String name;
    int parent;
    
    public Folder()
    {
    	
    }
    
    public Folder(String name,int parent)
    {
    	this.id=count++;
    	this.name=name;
    	this.parent=parent;
    	
    }

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Folder.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	
    
    
}