package HW2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW2.model.Files;



@WebServlet("/SubFolder")
public class SubFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SubFolder() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
       List<Files> Files=(List<Files>) getServletContext().getAttribute("Files");
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm aa");
		
		int id=Integer.parseInt(request.getParameter("Id"));
		
		out.println("<html><head><title>SubFolders</title></head><body>");
		
		for(Files f:Files)
		{
			
			if(f.getId()==id)
			{
				
				if(f.getParent()!=0)
				{
				out.println("<p><a href='SubFolder?Id="+f.getParent()+"' style='text-decoration:none'>..</a>\\");
				}
				else
				{
					out.println("<p><a href='Homepage' style='text-decoration:none'>..</a>\\");
				}
				
			out.println(""+f.getName()+"");
			
			out.println("[<a href='NewFolder?Id="+f.getId()+"' style='text-decoration:none'>New Folder</a>]");
			
			out.println("[<a href='Upload?Id="+f.getId()+"' style='text-decoration:none'>Upload File</a>]</p>");
			
			out.println("<table border='1' cellpadding='1' cellspacing='1'>");
			
			out.println("<thead>");
			
			out.println("<tr>");
			
			out.println("<th scope='col'>Name</th>");
			
			out.println("<th scope='col'>Date</th>");
			
			out.println("<th scope='col'>Size</th>");
			
			out.println("<th scope='col'>Operation</th>");
			
			out.println("</tr>");
			
			out.println("</thead>");
			
			out.println("<tbody>");
			
			
			
				for(Files m:Files)
				{
					if(m.getParent()==f.getId())
					{
					
						 out.println("<tr>");
						 
						 if(m.getType().equals("Folder"))
						 {	
						 out.println("<td><a href='SubFolder?Id="+m.getId()+"' style='text-decoration:none'>"+m.getName()+"</a></td>");
						 }
						 else
						 {
						 out.println("<td><a href='Download?Id="+m.getId()+"' style='text-decoration:none'>"+m.getName()+"</a></td>");
						 }
						 
						 out.println("<td>"+sdf.format(m.getDate())+"</td>");
						 
						 if(m.getType().equals("Folder"))
						 {
							 out.println("<td></td>");
						 }
						 else
						 {
							    if(m.getSize()<1024)
			                    {
							    	out.println("<td>"+m.getSize()+" B</td>");
			                    }
			                    else if(m.getSize()>1024)
			                    {
			                    	out.println("<td>"+m.getSize()/1024+" KB</td>");
			                    } 
				
						 }
						 
						 
						 out.println("<td><a href='EditFolder?Id="+m.getId()+"' style='text-decoration:none'>Rename</a> | <a href='DeleteFolder?Id="+m.getId()+"' style='text-decoration:none'>Delete</a></td>");
							
						 out.println("</tr>");
					}
				}
				
				out.println("</tbody>");
				
				out.println("</table>");
				
				out.println("</body></html>");
				
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
