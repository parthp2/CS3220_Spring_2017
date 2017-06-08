package Temp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Temp.model.GuestBookEntry;


@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public DeleteEntry() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		for(int i=0;i<entries.size();i++)
		{
		
			if(entries.get(i).getId()==id)
		       entries.remove(i);
		}
		
		response.sendRedirect("GuestBook");
		
	}


}
