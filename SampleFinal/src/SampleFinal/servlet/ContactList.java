package SampleFinal.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

import SampleFinal.model.Contact;


@WebServlet(urlPatterns ="/ContactList",loadOnStartup = 1)
public class ContactList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ContactList() {
        super();
       
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		 super.init( config );

	        try
	        {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        }
	        catch( ClassNotFoundException e )
	        {
	            throw new ServletException( e );
	        }
	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Contact> Contact=new ArrayList<Contact>();
		List<Contact> Contact2=new ArrayList<Contact>();
		
		 Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	            
	            String sql = "select * from contact";
	            
	           
	            
	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( sql );
	            
	           
	            
	            while( rs.next() )
	            {
	                Contact f = new Contact();
	                f.setId( rs.getInt( "id" ) );
	                f.setName(rs.getString("name"));
	                f.setContact(rs.getString("contact"));
	                f.setLetter(rs.getString("letter"));
	                
	                Contact.add(f);
	                
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

	        
	        
	        try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	            
	            
	            
	            String sql2 = "select distinct letter from contact group by letter order by letter asc";
	            
	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	          
	            ResultSet rs2 = stmt.executeQuery( sql2 );
	            
	           
	            
	            while( rs2.next() )
	            {
	                Contact f = new Contact();
	                f.setLetter(rs2.getString("letter"));
	                
	               
	                Contact2.add(f);
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
	        request.setAttribute( "Contact", Contact );
	        request.setAttribute( "Contact2", Contact2 );
		
		  
		
		request.getRequestDispatcher("WEB-INF/ContactList.jsp").forward( request, response );
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
