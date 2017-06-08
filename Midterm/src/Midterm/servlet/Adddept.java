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


@WebServlet("/Adddept")
public class Adddept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Adddept() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/Adddept.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<dept> dept=(List<dept>) getServletContext().getAttribute("dept");
		
		String dname=request.getParameter("dname");
		
//		for(dept f:dept)
//		{
//			if(dname.equals(f.getDname()))
//			{
//				request.getRequestDispatcher("WEB-INF/faculty.jsp").forward( request, response );
//			}
//		}
		
		dept.add(new dept(dname));
		
		request.getRequestDispatcher("WEB-INF/faculty.jsp").forward( request, response );
	}

}
