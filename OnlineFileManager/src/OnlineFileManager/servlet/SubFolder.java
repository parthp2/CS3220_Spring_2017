package OnlineFileManager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OnlineFileManager.model.Folder;


@WebServlet("/SubFolder")
public class SubFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SubFolder() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
       List<Folder> folder=(List<Folder>) getServletContext().getAttribute("folder");
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("Id"));
		
		out.println("<html><head><title>SubFolders</title></head><body>");
		
		for(Folder f:folder)
		{
			
			if(f.getId()==id)
			{	
			out.println("<p>"+f.getName());
			
			out.println("[<a href='NewFolder?Id="+f.getId()+"' style='text-decoration:none'>New Folder</a>]");
			
			out.println("[<a href='EditFolder?Id="+f.getId()+"' style='text-decoration:none'>Edit Folder</a>]");
			
			out.println("[<a href='DeleteFolder?Id="+f.getId()+"' style='text-decoration:none'>Delete Folder</a>]</p>");
			
			if(f.getParent()!=0)
			{
			out.println("<p><a href='SubFolder?Id="+f.getParent()+"' style='text-decoration:none'>\\..</a></p>");
			}
			else
			{
				out.println("<p><a href='Homepage' style='text-decoration:none'>\\..</a></p>");
			}
				for(Folder m:folder)
				{
					if(m.getParent()==f.getId())
					{
						 out.println("<p>\\ <a href='SubFolder?Id="+m.getId()+"' style='text-decoration:none'>"+m.getName()+"</a></p>");
					}
				}
				
			}
			
			if(id==0)
			{
				response.sendRedirect("Homepage");
			}
			
		}
		
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
