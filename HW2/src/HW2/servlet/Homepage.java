package HW2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicBorders.FieldBorder;


import HW2.model.Files;



@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public Homepage() {
        super();
       
    }
    
    public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		
		List<Files> Files=new ArrayList<Files>();
		
		getServletContext().setAttribute("Files",Files);
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Files> Files=(List<Files>) getServletContext().getAttribute("Files");
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm aa");
		
		out.println("<html><head><title>HomePage</title></head><body>");
		
		out.println("<p>[<a href='NewFolder' style='text-decoration:none'>New Folder</a>");
		
		out.println(" | <a href='Upload' style='text-decoration:none'>Upload File</a>]</p>");
		
		if(Files.size()>0)
		{
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
			
			for(Files f:Files)
			{
				if(f.getParent()==0)
				{
				 out.println("<tr>");
				
				 if(f.isFolder())
				 {	
				 out.println("<td><a href='SubFolder?Id="+f.getId()+"' style='text-decoration:none'>"+f.getName()+"</a></td>");
				 }
				 else
				 {
				 out.println("<td><a href='Download?Id="+f.getId()+"' style='text-decoration:none'>"+f.getName()+"</a></td>");
				 }
				 out.println("<td>"+sdf.format(f.getDate())+"</td>");
				 
				 if(f.isFolder())
				 {
					 out.println("<td></td>");
				 }
				 else
				 {
					    if(f.getSize()<1024)
	                    {
					    	out.println("<td>"+f.getSize()+" B</td>");
	                    }
	                    else if(f.getSize()>1024)
	                    {
	                    	out.println("<td>"+f.getSize()/1024+" KB</td>");
	                    } 
		
				 }
				 
				 out.println("<td><a href='EditFolder?Id="+f.getId()+"' style='text-decoration:none'>Rename</a> | <a href='DeleteFolder?Id="+f.getId()+"' style='text-decoration:none'>Delete</a></td>");
					
				 out.println("</tr>");
				}
			}
			
			out.println("</tbody>");
			
			out.println("</table>");
			
			out.println("</body></html>");
			
		}
	
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

