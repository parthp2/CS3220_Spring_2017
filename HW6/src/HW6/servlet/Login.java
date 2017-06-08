package HW6.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HW6.model.Users;


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
		
		HttpSession session = request.getSession();
		
		int id=0;
		
		String uname=request.getParameter("username");
		
		
		String pass=request.getParameter("password");
		
		
		Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";
            c = DriverManager.getConnection( url, username, password );
           
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where uname = '" + uname
                    + "' and pass = '" + pass + "'" );
            
            while( rs.next() )
            {
            	id=rs.getInt("uid");
            	
	            session.setAttribute("uname",rs.getString("uname"));  
	    				
	    		session.setAttribute("uid",rs.getInt("uid")); 
	    	    	
	    		
            }
            
            c.close();
            
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }
        
        if(id==0)
        {
        	response.sendRedirect("Login");
        }
        else
        {
        	response.sendRedirect("Homepage");
        }
	}

}
