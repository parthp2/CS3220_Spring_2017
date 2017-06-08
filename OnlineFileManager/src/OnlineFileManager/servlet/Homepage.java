package OnlineFileManager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicBorders.FieldBorder;

import OnlineFileManager.model.Folder;



@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public Homepage() {
        super();
       
    }
    
    public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		
		List<Folder> folder=new ArrayList<Folder>();
		
		getServletContext().setAttribute("folder",folder);
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Folder> folder=(List<Folder>) getServletContext().getAttribute("folder");
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html><head><title>HomePage</title></head><body>");
		
		out.println("<p>[<a href='NewFolder' style='text-decoration:none'>New Folder</a>]</p>");
		
	
		
		if(folder.size()>0)
		{
			for(Folder f:folder)
			{
				if(f.getParent()==0)
				{
			     out.println("<p>\\ <a href='SubFolder?Id="+f.getId()+"&parent="+f.getParent()+"'>"+f.getName()+"</a></p>");
				}
			}
		}
		
		out.println("</body></html>");
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
