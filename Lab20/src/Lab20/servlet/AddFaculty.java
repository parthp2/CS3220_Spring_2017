package Lab20.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lab20.model.Department;
import Lab20.model.Faculty;

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
    	List<Department> dept=new ArrayList<Department>();
    	
    	 Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	            
	            String sql = "select * from departments";
	         
	            
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
	        
	        
	      request.setAttribute("departments", dept);  
    	
        request.getRequestDispatcher( "/WEB-INF/AddFaculty.jsp" )
            .forward( request, response );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	boolean chair;
        String dname = request.getParameter( "department" );
        String faculty = request.getParameter( "faculty" );
       
        if( request.getParameter( "chair" ) != null ) 
        	chair= true;
        else
        	chair=false;
        
      
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";

            String sql = "insert into faculty (dname,fname,chair) values (?,?,?)";

            c = DriverManager.getConnection( url, username, password );
           
                 	
            PreparedStatement pstmt = c.prepareStatement( sql ); 
            pstmt.setString( 1, dname );
            pstmt.setString( 2, faculty);
            pstmt.setBoolean( 3, chair );
            pstmt.executeUpdate();

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
        

        response.sendRedirect( "DisplayFaculty" );
    }

}