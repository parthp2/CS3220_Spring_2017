package Temp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Temp.model.GuestBookEntry;


@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 public EditEntry() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		GuestBookEntry entry=entries.get(id);
		
		PrintWriter out=response.getWriter();
		
        out.println("<html><head><title>EditEntry</title></head><body>");
		
		out.println("<h2>Edit Entry</h2>");
		
		out.println("<form action='EditEntry' method='post'>");
		
		out.println("name:<input type='text' name='name' value='"+entry.getName()+"'></br>");
		
		out.println("<textarea name='message' cols='60' rows='5'>"+entry.getMessage()+"</textarea></br>");
		
		out.println("<input type='hidden' name='index' value='"+id+"'></br>");
		
		out.println("<input type='submit' value='Edit'>");
		
		out.println("</form></body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("name");
		
		String message=request.getParameter("message");
		
		int index=Integer.parseInt(request.getParameter("index"));
		
		
		@SuppressWarnings("unchecked")
		List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		entries.get(index).setName(name);
		
		entries.get(index).setMessage(message);;
		
		response.sendRedirect("GuestBook");
	
	}

}
