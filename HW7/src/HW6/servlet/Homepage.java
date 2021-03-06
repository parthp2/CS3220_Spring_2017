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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicBorders.FieldBorder;


import HW6.model.Files;



@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public Homepage() {
        super();
       
    }
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        int parent=0;
		
		if(request.getParameterMap().containsKey("Id"))
		{
			 parent=Integer.parseInt(request.getParameter("Id"));

		}
		else
		{
			parent=0;
		}
		
        request.setAttribute("parent", parent);
		
      
		
		List<Files> Files=new ArrayList<Files>();
		
		
		String uname=(String) request.getSession().getAttribute("uname");
		
		int uid=(Integer) request.getSession().getAttribute("uid");
		
		

	        Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	            
	            String sql = "select * from files where uid = '" + uid  + "'";
	            
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
	               
	                Files.add(f);
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

	        request.setAttribute( "Files", Files );
	        
	       
		    request.getRequestDispatcher("WEB-INF/Homepage.jsp").forward( request, response );
		    
		    
	
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

