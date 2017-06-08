package Lab19.model;

public class Lab19Files {
	
	int id;
	String name;
	boolean folder;
	int pid;
	int oid;
	
	public Lab19Files()
	{
		
	}
	
	public Lab19Files(int id,String name,boolean folder,int pid, int oid)
	{
		this.id=id;
		this.name=name;
		this.folder=folder;
		this.pid=pid;
		this.oid=oid;
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

	public boolean isFolder() {
		return folder;
	}

	public void setFolder(boolean folder) {
		this.folder = folder;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}
	
	

}
