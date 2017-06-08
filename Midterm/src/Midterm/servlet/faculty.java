package Midterm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Midterm.model.dept;
import Midterm.model.facultyinfo;


@WebServlet("/faculty")
public class faculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public faculty() {
        super();
      
    }


	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
        List<facultyinfo> faculty=new ArrayList<facultyinfo>();
		
		getServletContext().setAttribute("faculty",faculty);
		
		List<dept> dept=new ArrayList<dept>();
		
		getServletContext().setAttribute("dept",dept);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		request.getRequestDispatcher("WEB-INF/faculty.jsp").forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
