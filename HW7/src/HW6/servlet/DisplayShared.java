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



@WebServlet("/DisplayShared")
public class DisplayShared extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public DisplayShared() {
        super();
       
    }
    
    public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Files> Files=new ArrayList<Files>();
		
		
		String uname=(String) request.getSession().getAttribute("uname");
		
		int uid=(Integer) request.getSession().getAttribute("uid");
		

	        Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	            
	            String sql = "select * from shares where sid = '" + uid  + "' or sid=0";
	            
	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( sql );
	            
	            while( rs.next() )
	            {
	                Files f = new Files();
	                f.setId( rs.getInt( "fid" ) );
	                f.setUid(rs.getInt("oid"));
	                f.setName(rs.getString("name"));
	                f.setSize(rs.getLong("size"));
	                f.setDate(rs.getTimestamp("date"));
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
		
		    request.getRequestDispatcher("WEB-INF/DisplayShared.jsp").forward( request, response );
	
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

