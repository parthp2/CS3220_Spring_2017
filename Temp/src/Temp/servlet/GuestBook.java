package Temp.servlet;

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

import Temp.model.GuestBookEntry;

@WebServlet("/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public GuestBook() {
        super();
     }

	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		
		List<GuestBookEntry> entries=new ArrayList<GuestBookEntry>();
		
		entries.add(new GuestBookEntry(1,"Parth","Hello"));
		entries.add(new GuestBookEntry(2,"Chintu","hiiii"));
		
		getServletContext().setAttribute("entries",entries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html><head><title>GuestBook</title></head><body>");
		
		out.println("<table border='1'>");
		
		out.println("<h2>GuestBook</h2>");
		
		out.println("<tr><th>Name</th><th>Message</th><th>Operations</th></tr>");
		
		for(int i=0;i<entries.size();i++)
		{
			GuestBookEntry entry=entries.get(i);
		   out.println("<tr><td>"+entry.getName()+"</td><td>"+entry.getMessage()+"</td>"
		   		+ "<td><a href='EditEntry?id="+entry.getId()+"'>Edit</a> | <a href='DeleteEntry?index="+entry.getId()+"'>Delete</a></td></tr>");
		}
		out.println("</table></body></html>");
		
		out.println("<a href='AddComment'>Leave Comment</a>");
		
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

}
