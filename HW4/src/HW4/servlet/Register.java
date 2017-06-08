package HW4.servlet;

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
import javax.servlet.http.HttpSession;

import HW4.model.Files;
import HW4.model.Users;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Register() {
        super();
    
    }
    
    public void init(ServletConfig config) throws ServletException 
   	{
   		super.init(config);
   		
   		List<Users> Users=new ArrayList<Users>();
   		
   		getServletContext().setAttribute("Users",Users);
   		
   		Users.add(new Users("cysun ","abcd"));
   		
   		
   	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("WEB-INF/Register.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Users> Users=(List<Users>) getServletContext().getAttribute("Users");
		
		String uname=request.getParameter("username");
		
		String pass=request.getParameter("password");
		
		for(Users user:Users)
		{
			if(user.getUname().equals(uname) || pass.equals(null))
			{
				request.getRequestDispatcher("WEB-INF/Register.jsp").forward( request, response );
			}
			
			else
			{
				System.out.println("username"+user.getUname());
				System.out.println("password"+user.getPass());
			}
		}
		
		Users.add(new Users(uname,pass));
		
		response.sendRedirect("Login");
	
	
	}

}
