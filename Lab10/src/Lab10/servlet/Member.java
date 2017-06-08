package Lab10.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Member() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		            response.setContentType("text/html");
			
					PrintWriter out=response.getWriter();
					
					String user=(String) request.getSession().getAttribute("user");
					
					if(user.equals("cysun"))
					{
					
			        out.println("<html><head><title>Login</title></head><body>");
			        
			        out.println("<h2>Welcome to the Members Area</h2>");
			        
			        out.println("<a href='Logout'>Logout</a>");
			        
			        out.println("</body></html>");
			        
					}
					else
					{
						response.sendRedirect("Login");
					}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
