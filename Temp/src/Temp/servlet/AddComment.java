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


@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int id=100;
       
 public AddComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
        out.println("<html><head><title>AddComment</title></head><body>");
		
		out.println("<h2>AddComment</h2>");
		
		out.println("<form action='AddComment' method='post'>");
		
		out.println("name:<input type='text' name='name'></br>");
		
		out.println("<textarea name='message' cols='60' rows='5'></textarea></br>");
		
		out.println("<input type='submit' value='AddComment'>");
		
		out.println("</form></body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("name");
		
		String message=request.getParameter("message");
		
		
		@SuppressWarnings("unchecked")
		List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		entries.add(new GuestBookEntry(++id,name,message));
		
		response.sendRedirect("GuestBook");
	
	}

}
