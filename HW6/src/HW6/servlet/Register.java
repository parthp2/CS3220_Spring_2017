package HW6.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HW6.model.Files;
import HW6.model.Users;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Register() {
        super();
    
    }
    
    public void init(ServletConfig config) throws ServletException 
   	{
   		super.init(config);
   		
   		
   		
   	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("WEB-INF/Register.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int count=0;
		
		String uname=request.getParameter("username");
		
		String pass=request.getParameter("password");
		
		Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";

            String sql = "insert into users (uname,pass) values (?, ?)";

            c = DriverManager.getConnection( url, username, password );
           
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from users" );
            
            while( rs.next() )
            {
            	if(!rs.getString("uname").equals(null))
            	{
	            	if(rs.getString("uname").equals(uname) )
	            	{
	            		count++;
	            	}
            	}
            }
            
            if(count==0)
            {
            	
            		PreparedStatement pstmt = c.prepareStatement( sql ); 
                    pstmt.setString( 1, uname );
                    pstmt.setString( 2, pass );
                    pstmt.executeUpdate();
            
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

        if(count==0)
        {
		    response.sendRedirect("Login");
        }
        else
        {
        	response.sendRedirect("Register");
        }
	
	
	}

}
