package HW3.model;

import java.util.Date;

public class Files {
	
	    private static int count = 1; 
	    Integer id;
	    String name;
	    String type; // content type of the uploaded file
	    long size;
	    Date date;
	    int parent;
	    boolean folder;
	    
	    public Files()
	    {
	    	
	    }
	    
	    public Files(String name,String type,long size,Date date,int parent,boolean folder)
	    {
	    	this.id=count++;
	    	this.name=name;
	    	this.type=type;
	    	this.size=size;
	    	this.date=date;
	    	this.parent=parent;
	    	this.folder=folder;
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

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public long getSize() {
			return size;
		}

		public void setSize(long size) {
			this.size = size;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getParent() {
			return parent;
		}

		public void setParent(int parent) {
			this.parent = parent;
		}

		public boolean isFolder() {
			return folder;
		}

		public void setFolder(boolean folder) {
			folder = folder;
		}

		

		
}
