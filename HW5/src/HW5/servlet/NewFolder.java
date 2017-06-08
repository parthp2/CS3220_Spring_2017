package HW5.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HW5.model.Files;



@WebServlet("/NewFolder")
public class NewFolder extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
   
    public NewFolder() {
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
		
        getServletContext().setAttribute("parent", parent);
		
		request.getRequestDispatcher("WEB-INF/NewFolder.jsp").forward( request, response );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		int uid=(int) session.getAttribute("uid");
	
		int pf=0;
		
		String nfolder=request.getParameter("nfolder");
		
		int pfolder=Integer.parseInt(request.getParameter("pfolder"));
		    	
    	Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";

            String sql = "insert into files (uid,name,type,size,parent,folder) values (?, ?,?,?,?,?)";

            c = DriverManager.getConnection( url, username, password );
           
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from files" );
            
            if(pfolder==0)
    		{
    			pf=0;
    		}
            else
    		{
            	int t=0;
            	
            	 while( rs.next() )
                 {
            		 
                 	if(!rs.getObject("id").equals(null))
                 	{
     	            	if(rs.getInt("id")==pfolder) 
     	            	{
     	            		pf=rs.getInt("id");
     	            	}
                 	}
                 }
    		}
            
                    	
            PreparedStatement pstmt = c.prepareStatement( sql ); 
            pstmt.setInt( 1, uid );
            pstmt.setString( 2, nfolder );
            pstmt.setString( 3, "Folder" );
            pstmt.setLong(4, 0);
            pstmt.setInt( 5, pf );
            pstmt.setBoolean(6, true);
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

	  
		if(pfolder==0)
		{
		response.sendRedirect("Homepage");
		}
		else
		{
			response.sendRedirect("SubFolder?Id="+pfolder);	
		}
	}

}
