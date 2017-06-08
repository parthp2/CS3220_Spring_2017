package Midterm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Midterm.model.dept;
import Midterm.model.facultyinfo;


@WebServlet("/Addfaculty")
public class Addfaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Addfaculty() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<dept> dept=(List<dept>) getServletContext().getAttribute("dept");
	
		getServletContext().setAttribute("dept",dept);
		
		request.getRequestDispatcher("WEB-INF/Addfaculty.jsp").forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<facultyinfo> faculty= (List<facultyinfo>) getServletContext().getAttribute("faculty");
		
		String dname=request.getParameter("dname");
		String fname=request.getParameter("fname");
		boolean chair = false;
		
		if(request.getParameterMap().containsKey("chair"))
		{
			chair=true;
		}
		
		for(facultyinfo f:faculty)
		{
			if(chair==f.isChair() && dname.equals(f.getDname()))
			{
				request.getRequestDispatcher("WEB-INF/faculty.jsp").forward( request, response );
			}
		}
				faculty.add(new facultyinfo(dname,fname,chair));
				
				request.getRequestDispatcher("WEB-INF/faculty.jsp").forward( request, response );
		
		
	}

}
