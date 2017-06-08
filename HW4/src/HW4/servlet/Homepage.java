package HW4.servlet;

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


import HW4.model.Files;



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
		
		
		String uname=(String) request.getSession().getAttribute("uname");
		
		int uid=(Integer) request.getSession().getAttribute("uid");
		
		request.getRequestDispatcher("WEB-INF/Homepage.jsp").forward( request, response );
	
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

