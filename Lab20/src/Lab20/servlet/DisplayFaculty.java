package Lab20.servlet;

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


import Lab20.model.Department;
import Lab20.model.Faculty;

@WebServlet(urlPatterns = "/DisplayFaculty", loadOnStartup = 1)
public class DisplayFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DisplayFaculty()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }

        List<Department> departments = new ArrayList<Department>();
        
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	List<Department> dept=new ArrayList<Department>();
    	List<Faculty> faculty=new ArrayList<Faculty>();
    	
    	 Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	            
	            String sql = "select * from departments ";
	         
	            
	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( sql );
	           
	            
	            String d;
	            
	            while( rs.next() )
	            {
	                Department f = new Department();
	              
	               
	                f.setName(rs.getString("dname"));
	                f.setId(rs.getInt("id"));
	               
	                dept.add(f);
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
	            
	           
	            String sql2 = "select * from faculty";
	            
	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	           
	            ResultSet rs2 = stmt.executeQuery( sql2 );
	            
	            String d;
	            
	           
	            while( rs2.next() )
	            {
	                Faculty m = new Faculty();
	            
	                m.setId(rs2.getInt("id"));
	                m.setName(rs2.getString("fname"));
	                m.setChair(rs2.getBoolean("chair"));
	                m.setDname(rs2.getString("dname"));
	               
	                faculty.add(m);
	                
	                for(Department h:dept)
	                {
	                	if(h.getName().equals(rs2.getString("dname")))
	                	{
	                		h.getFaculty().add(m);
	                	}
	                }
	              
	                
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

	        request.setAttribute( "departments", dept);
        request.getRequestDispatcher( "/WEB-INF/DisplayFaculty.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}