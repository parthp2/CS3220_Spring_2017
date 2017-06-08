package SampleFinal.servlet;

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

import SampleFinal.model.Contact;
import SampleFinal.model.Fields;


@WebServlet("/AddFields")
public class AddFields extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddFields() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Contact> Contact=new ArrayList<Contact>();
		List<Fields> Fields=new ArrayList<Fields>();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";
            
            String sql = "select * from contact where id='"+id+"'";
            
           
            
            c = DriverManager.getConnection( url, username, password );
            
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            
           
            
            while( rs.next() )
            {
                Contact f = new Contact();
                f.setId( rs.getInt( "id" ) );
                f.setName(rs.getString("name"));
                f.setContact(rs.getString("contact"));
                f.setLetter(rs.getString("letter"));
                
                Contact.add(f);
                
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
            
            String sql = "select * from field where uid='"+id+"'";
            
           
            
            c = DriverManager.getConnection( url, username, password );
            
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            
           
            
            while( rs.next() )
            {
                Fields f = new Fields();
            
                f.setFname(rs.getString("fname"));
                f.setFvalue(rs.getString("fvalue"));
               
                Fields.add(f);
                
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
        
        request.setAttribute( "Contact", Contact );
        request.setAttribute( "Fields", Fields );
		
		request.getRequestDispatcher("WEB-INF/AddFields.jsp").forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int uid=Integer.parseInt(request.getParameter("id"));
		
		String fname=request.getParameter("fname");
		
		String fvalue=request.getParameter("fvalue");
		
		
		Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";

            String sql = "insert into field (uid,fname,fvalue) values (?, ?,?)";

            c = DriverManager.getConnection( url, username, password );
           
      
            PreparedStatement pstmt = c.prepareStatement( sql ); 
            pstmt.setInt( 1, uid );
            pstmt.setString( 2, fname);
            pstmt.setString( 3, fvalue );
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
        
        response.sendRedirect("AddFields?id="+uid);
	}

}
