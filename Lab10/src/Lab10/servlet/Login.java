package Lab10.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Login() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		     response.setContentType("text/html");
			
			PrintWriter out=response.getWriter();
			
	        out.println("<html><head><title>Login</title></head><body>");
	        
	        out.println("<form action='Login' method='post'>");
	        
	       
	        out.println("Username:<input type='text' name='username' ><br/>");
	        
	        out.println("Password:<input type='password' name='password'><br/>");
	        
	        out.println("<input type='submit' value='Login'>");
			
			out.println("</form></body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String user=request.getParameter("username");
		
		String pass=request.getParameter("password");
		
		if(user.equals("cysun") && pass.equals("abcd"))
		{
		        	session.setAttribute("user","cysun");  
		        	
		        	response.sendRedirect("Member");
		}
		else
		{
			response.sendRedirect("Login");
		}
	
	}

}
