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

@WebServlet("/EditDepartment")
public class EditDepartment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EditDepartment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	List<Department> dept=new ArrayList<Department>();
    	String id=request.getParameter("id");
    	
         Connection c = null;
    	 
    	 
    	 try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	           
	            String sql = "select * from departments where id='"+id+"'";
	         
	            
	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( sql );
	           
	            
	            String d;
	            
	            while( rs.next() )
	            {
	                Department f = new Department();
	              
	               
	                f.setName(rs.getString("dname"));
	                System.out.println(rs.getString("dname"));
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
	        
    	 System.out.println(dept.size());
	        
	        
	        request.setAttribute("departments", dept);  
   	
        request.getRequestDispatcher( "/WEB-INF/EditDepartment.jsp" )
            .forward( request, response );;
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	String id=request.getParameter("id");
        String dname=request.getParameter("dname");
        
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";

            String sql = "UPDATE departments SET dname=?  Where  id='"+id+"'";
          
            c = DriverManager.getConnection( url, username, password );
           
                 	
            PreparedStatement pstmt = c.prepareStatement( sql ); 
            pstmt.setString( 1, dname );
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