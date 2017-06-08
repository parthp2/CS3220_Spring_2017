package HW2.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import HW2.model.Files;



@WebServlet("/EditFolder")
public class EditFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EditFolder() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		    List<Files> Files=(List<Files>) getServletContext().getAttribute("Files");
		
		    response.setContentType("text/html");
			
			PrintWriter out=response.getWriter();
			
			int Id=Integer.parseInt(request.getParameter("Id"));
			
			out.println("<html><head><title>Edit Name</title></head><body>");
			
			out.println("<form action='EditFolder' method='post'>");
			
			
			
			for(Files f:Files)
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
		
		 String fileDir = getServletContext().getRealPath( "/WEB-INF/files" );
		
		List<Files> Files=(List<Files>) getServletContext().getAttribute("Files");
		 
		 int eid=Integer.parseInt(request.getParameter("eid"));
		 
		 String name=request.getParameter("efolder");
		 
		 int pid=0;
		 
		 for(Files f:Files)
		 {
			 if(f.getId()==eid)
			 {
				 if(f.getType().equals("Folder"))
				 {
				 f.setName(name);
				 pid=f.getParent();
				 }
				 else
				 {
				 File file=new File(fileDir,"File_"+f.getId()+"_"+f.getName());
				 file.renameTo(new File(fileDir,"File_"+f.getId()+"_"+name));
				 
				 f.setName(name);
				 pid=f.getParent();	
				 }
				 
			 }
		 }
		
		 if(pid==0)
		 {
			 response.sendRedirect("Homepage");
		 }
		 else
		 {
		 response.sendRedirect("SubFolder?Id="+pid+"");
		 }
		
	}

}
