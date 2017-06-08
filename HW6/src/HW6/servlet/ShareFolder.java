package HW6.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import HW6.model.Users;



@WebServlet("/ShareFolder")
public class ShareFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public ShareFolder() {
        super();
       
    }
    
    public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		
	}

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameterMap().containsKey("UId"))
		{
			System.out.println("hello hii");
			 doPost(request,response);
		}
		
		
        String uname=(String) request.getSession().getAttribute("uname");
		
		int uid=(Integer) request.getSession().getAttribute("uid");
		
		List<Users> users=new ArrayList<Users>();
		
		String Fid=request.getParameter("FId");
		
		System.out.println(Fid);

	        Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	            
	            String sql = "select * from users";
	            
	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( sql );
	            
	            while( rs.next() )
	            {
	                Users f = new Users();
	                f.setUid(rs.getInt("uid"));
	                f.setUname(rs.getString("uname"));
	                f.setPass(rs.getString("pass"));
	              
	                users.add(f);
	                
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

	      
	        request.setAttribute( "users", users );
	        
	        request.setAttribute( "FID", Fid );
		
		    request.getRequestDispatcher("WEB-INF/Share.jsp").forward( request, response );
	
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        
		int Fid=Integer.parseInt(request.getParameter("FId"));
		
		int Uid=Integer.parseInt(request.getParameter("UId"));
		
	        Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://localhost/cs3220stu49";
	            String username = "cs3220stu49";
	            String password = "l#jN!vq#";
	            
	            String sql = "select * from UserFile where id="+Fid+"";
	            
	            String sql2 = "insert into shares (oid,fid,sid,name,size) values (?,?,?,?,?)";
	            
	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( sql );
	            
	            PreparedStatement pstmt = c.prepareStatement( sql2 ); 
	            
	            
	            while( rs.next() )
	            {
	            pstmt.setInt( 1,rs.getInt("uid") );
	            pstmt.setInt( 2,rs.getInt("id")  );
	            pstmt.setInt( 3, Uid );
	            pstmt.setString(4,rs.getString("name"));
	            pstmt.setLong( 5, rs.getLong("size"));
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


	}

}

