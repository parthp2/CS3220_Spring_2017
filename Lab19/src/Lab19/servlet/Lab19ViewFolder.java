package Lab19.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lab19.model.Lab19Files;




@WebServlet("/Lab19ViewFolder")
public class Lab19ViewFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public Lab19ViewFolder() {
        super();
       
    }


	public void init(ServletConfig config) throws ServletException {
	
		 super.init( config );

	        try
	        {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        }
	        catch( ClassNotFoundException e )
	        {
	            throw new ServletException( e );
	        }
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Lab19Files> entries = new ArrayList<Lab19Files>();
		
		String id=request.getParameter("id");
		
		 int count=0;
		 
		Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs;
            if(id==null)
            {
             rs= stmt.executeQuery( "select * from files where owner_id=(select id from users where name='cysun') and parent_id is null order by is_folder desc" );
            }else
            {
             rs = stmt.executeQuery( "select * from files where owner_id=(select id from users where name='cysun') and parent_id='"+id+"' order  by is_folder desc" );	
            }
            
            rs.last();
            count=rs.getRow();
            rs.beforeFirst();
          
            while( rs.next() )
            {
                entries.add( new Lab19Files( rs.getInt( "id" ),
                    rs.getString( "name" ), rs.getBoolean( "is_folder" ),
                    rs.getInt( "parent_id" ),rs.getInt( "owner_id" ) ) );
          
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
        
        request.setAttribute( "entries", entries );
        
        if(count==0)
        {
        	 request.getRequestDispatcher( "/WEB-INF/Empty.jsp" )
             .forward( request, response );
        }
        else
        {
        request.getRequestDispatcher( "/WEB-INF/ViewFolders.jsp" )
        .forward( request, response );
        }

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet( request, response );
    
	}

}
