package Final.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddCourse() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/AddCourse.jsp").forward( request, response );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String cname=request.getParameter("cname");
		
		String term=request.getParameter("term");
		
		String letter=Character.toString(cname.charAt(0));
		
		int num=Integer.parseInt(Character.toString(cname.charAt(2)));
		
		Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";

            String sql = "insert into courses (cname,term,letter,num) values (?, ?,?,?)";

            c = DriverManager.getConnection( url, username, password );
           
      
            PreparedStatement pstmt = c.prepareStatement( sql ); 
            pstmt.setString( 1, cname );
            pstmt.setString( 2, term );
            pstmt.setString( 3, letter );
            pstmt.setInt( 4, num );
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
        
        response.sendRedirect("Homepage");
	}
		
		
}


