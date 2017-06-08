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


@WebServlet("/EditFolder")
public class EditFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EditFolder() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		    List<Folder> folder=(List<Folder>) getServletContext().getAttribute("folder");
		
		    response.setContentType("text/html");
			
			PrintWriter out=response.getWriter();
			
			int Id=Integer.parseInt(request.getParameter("Id"));
			
			out.println("<html><head><title>Edit Folder</title></head><body>");
			
			out.println("<form action='EditFolder' method='post'>");
			
			
			
			for(Folder f:folder)
			{
			
				if(f.getId()==Id)
				{
			
			     out.println("<input type='hidden' name='eid' value='"+Id+"'>");
			
			     out.println("Edit Folder:<input type='text' name='efolder' value='"+f.getName()+"'>");
				}
			
			}
			
			out.println("<input type='submit' value='Save'>");
			
			out.println("</form>");
			
			out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 List<Folder> folder=(List<Folder>) getServletContext().getAttribute("folder");
		 
		 int eid=Integer.parseInt(request.getParameter("eid"));
		 
		 String name=request.getParameter("efolder");
		 
		 for(Folder f:folder)
		 {
			 if(f.getId()==eid)
			 {
				 f.setName(name);
			 }
		 }
		
		 response.sendRedirect("SubFolder?Id="+eid+"");
		
	}

}
