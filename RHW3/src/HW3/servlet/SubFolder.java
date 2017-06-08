package HW3.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW3.model.Files;



@WebServlet("/SubFolder")
public class SubFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SubFolder() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
       List<Files> Files=(List<Files>) getServletContext().getAttribute("Files");

		
		int id=Integer.parseInt(request.getParameter("Id"));
		
		getServletContext().setAttribute("sid",id);
	
		
		if(id==0)
		{
				response.sendRedirect("Homepage");
		}
		else
		{
			request.getRequestDispatcher("WEB-INF/SubFolder.jsp").forward( request, response );
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
