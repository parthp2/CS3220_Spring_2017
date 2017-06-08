package HW4.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HW4.model.Users;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Login() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("WEB-INF/Login.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Users> Users=(List<Users>) getServletContext().getAttribute("Users");
		
		HttpSession session = request.getSession();
		
		String uname=request.getParameter("username");
		
		System.out.println(uname);
		
		
		
		String pass=request.getParameter("password");
		
		System.out.println(pass);
		
		for(Users user:Users)
		{
			if(user.getUname().equals(uname) && user.getPass().equals(pass))
			{
				session.setAttribute("uname",user.getUname());  
				
				session.setAttribute("uid",user.getUid());  
	        	
				response.sendRedirect("Homepage");
			}
			
		}

	
	}

}
