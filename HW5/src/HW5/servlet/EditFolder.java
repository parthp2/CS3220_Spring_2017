package HW5.servlet;

import java.io.File;
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

import org.apache.commons.fileupload.FileItem;

import HW5.model.Files;




@WebServlet("/EditFolder")
public class EditFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EditFolder() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 
			int Id=Integer.parseInt(request.getParameter("Id"));
			
			Integer eid = null;
			String ename = null;
			
			 Connection c = null;
	    	 try
		        {
		        	String url = "jdbc:mysql://localhost/cs3220stu49";
		            String username = "cs3220stu49";
		            String password = "l#jN!vq#";
		           
		            String sql = "select * from files where id='"+Id+"'";
		         
		            c = DriverManager.getConnection( url, username, password );
		            
		            Statement stmt = c.createStatement();
		            ResultSet rs = stmt.executeQuery( sql );
		           
		            while( rs.next() )
		            {
		              eid=rs.getInt("id");
		              ename=rs.getString("name");
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
			
			
			getServletContext().setAttribute("eid",eid);
					
			getServletContext().setAttribute("ename",ename);
					
		
			request.getRequestDispatcher("WEB-INF/EditFolder.jsp").forward( request, response );
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String fileDir = getServletContext().getRealPath( "/WEB-INF/files" );
		 
		 int eid=Integer.parseInt(request.getParameter("eid"));
		 
		 String name=request.getParameter("efolder");
		 
		 int pid=0;
		 
		 Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	            
	            String sql1 = "select * from files where id='"+eid+"'";

	            
	          
	            c = DriverManager.getConnection( url, username, password );
	           
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( sql1 );
	           
	            while( rs.next() )
	            {
	            	if(rs.getBoolean("folder"))
	            	{
	            		String sql2 = "UPDATE files SET name=?  Where  id='"+eid+"'";
	            		
	            		 PreparedStatement pstmt = c.prepareStatement( sql2 ); 
	     	            pstmt.setString( 1, name );
	     	            pstmt.executeUpdate();
	     	            
	     	            pid=rs.getInt("parent");
	            	}
	            	else
	            	{
	            		
	            		File file=new File(fileDir,"File_"+eid+"_"+rs.getString("name"));
		  				  
	            		file.renameTo(new File(fileDir,"File_"+eid+"_"+name));
	            		
	            		String sql2 = "UPDATE files SET name=?  Where  id='"+eid+"'";
	            		
	            		PreparedStatement pstmt = c.prepareStatement( sql2 ); 
	     	            pstmt.setString( 1, name );
	     	            pstmt.executeUpdate();
	     	            
	     	           pid=rs.getInt("parent");
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
		 
		
		
		 if(pid==0)
		 {
			 response.sendRedirect("Homepage");
		 }
		 else
		 {
		 response.sendRedirect("SubFolder?Id="+pid+"");
		 }
		
	}

}
