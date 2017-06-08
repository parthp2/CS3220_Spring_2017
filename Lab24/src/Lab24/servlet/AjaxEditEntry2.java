package Lab24.servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

@WebServlet("/AjaxEditEntry2")
public class AjaxEditEntry2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AjaxEditEntry2()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
       
    	System.out.println("id");
    	System.out.println("name");
    	System.out.println("message");

        Connection c = null;
        try
        {
            String url = "jdbc:mysql://localhost/cs3220stu49?useSSL=false";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";

            String sql = "update guestbook set message=? where id=?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql);
            pstmt.setString( 1, request.getParameter( "message" ) );
            pstmt.setString( 2, request.getParameter( "id" ) );
            pstmt.executeUpdate();

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

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}