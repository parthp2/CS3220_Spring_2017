package HW6.servlet;

import java.io.File;
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

import HW6.model.Files;



@WebServlet("/DeleteFolder")
public class DeleteFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteFolder() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    
	  
//        if(pid!=0)
//        {
//           response.sendRedirect("SubFolder?Id="+pid);
//           
//                  
//        }
//        else
//        {
//        	response.sendRedirect("Homepage");	
//        }
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
 
       String fileDir = getServletContext().getRealPath( "/WEB-INF/files" );
		
		int pid = 0;
		 
        int did=Integer.parseInt(request.getParameter("Id"));
        
        Connection c = null;
   	     try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	            
	            String sql1 = "select * from files";
	           
	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( sql1 );
	            
	            while( rs.next() )
	            {
	            	if(rs.getInt("id")==did)
	            	{
	            		 String sql2 = "delete from files where id='"+did+"'";
	            		
	            		PreparedStatement pstmt = c.prepareStatement( sql2 );
	     	            pstmt.executeUpdate();
	     	            
	     	            pid=rs.getInt("parent");
	     	            
	     	           File file=new File(fileDir,"File_"+did+"_"+rs.getString("name"));
	  				   file.delete();
	            	}
	            	else if(rs.getInt("parent")==did)
	            	{
	           
	            		 String sql2 = "delete from files where parent='"+did+"'";
	            		
	            		PreparedStatement pstmt = c.prepareStatement( sql2 );
	     	            pstmt.executeUpdate();
	     	            
	     	           File file=new File(fileDir,"File_"+rs.getInt("id")+"_"+rs.getString("name"));
	  				   file.delete();
	     	            
	     	          
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
   	     
	}

}
