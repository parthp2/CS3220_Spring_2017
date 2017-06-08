package HW6.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW6.model.Files;


@WebServlet("/SubFolder")
public class SubFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SubFolder() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        int parent=0;
		
		if(request.getParameterMap().containsKey("Id"))
		{
			 parent=Integer.parseInt(request.getParameter("Id"));
			 
			 System.out.println(parent);
		}
		else
		{
			parent=0;
		}
		
		request.setAttribute("parent2", parent);
        
    
		List<Files> Files1=new ArrayList<Files>();
       
        List<Files> Files2=new ArrayList<Files>();
  
        String uname=(String) request.getSession().getAttribute("uname");
		
		int uid=(Integer) request.getSession().getAttribute("uid");
	
		int id=Integer.parseInt(request.getParameter("Id"));
		
		getServletContext().setAttribute("uid",uid);
	
		

        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";
            
            String sql = "select * from files where uid = '" + uid  + "' and id='"+ id+"'";
            
            
            c = DriverManager.getConnection( url, username, password );
            
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            
            
            
            while( rs.next() )
            {
                Files f = new Files();
                f.setId( rs.getInt( "id" ) );
                f.setUid(rs.getInt("uid"));
                f.setName(rs.getString("name"));
                f.setType(rs.getString("type"));
                f.setSize(rs.getLong("size"));
                f.setDate(rs.getTimestamp("date"));
                f.setParent(rs.getInt("parent"));
                f.setFolder(rs.getBoolean("folder"));
            
                Files1.add(f);
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
            
           
            String sql2 = "select * from files where uid = '" + uid  + "'";
            
            
            c = DriverManager.getConnection( url, username, password );
            
            Statement stmt = c.createStatement();
           
            ResultSet rs2 = stmt.executeQuery( sql2 );
            
         
            
            while( rs2.next() )
            {
                Files f = new Files();
                f.setId( rs2.getInt( "id" ) );
                f.setUid(rs2.getInt("uid"));
                f.setName(rs2.getString("name"));
                f.setType(rs2.getString("type"));
                f.setSize(rs2.getLong("size"));
                f.setDate(rs2.getTimestamp("date"));
                f.setParent(rs2.getInt("parent"));
                f.setFolder(rs2.getBoolean("folder"));
             
                Files2.add(f);
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

        request.getServletContext().setAttribute("Files1",Files1);
        request.getServletContext().setAttribute("Files2",Files2);
		
		if(id==0)
		{
				response.sendRedirect("Homepage");
		}
		else
		{
			request.getRequestDispatcher("WEB-INF/SubFolder.jsp").forward( request, response );
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
