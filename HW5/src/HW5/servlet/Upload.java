package HW5.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import HW5.model.Files;



@WebServlet("/Upload")
public class Upload extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Upload()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
		int id;
		
		if(request.getParameterMap().containsKey("Id"))
		{
			id=Integer.parseInt(request.getParameter("Id"));	
		}
		else
		{
			id=0;
		}
		
		getServletContext().setAttribute("id", id);
		
		request.getRequestDispatcher("WEB-INF/Upload.jsp").forward( request, response );
        //response.sendRedirect("Upload.html");
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	int rsize=0;
    	
    	int id=Integer.parseInt(request.getParameter("Id"));
    	
        HttpSession session = request.getSession();
		
		int uid=(int) session.getAttribute("uid");
		
		Connection c = null;
        try
        {
        	String url = "jdbc:mysql://localhost/cs3220stu49";
            String username = "cs3220stu49";
            String password = "l#jN!vq#";

            String sql = "insert into files (uid,name,type,size,parent,folder) values (?, ?,?,?,?,?)";

            c = DriverManager.getConnection( url, username, password );
           
           
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig()
                .getServletContext();
            File repository = (File) servletContext
                .getAttribute( getServletContext().getRealPath( "/WEB-INF/files" ));
            factory.setRepository( repository );

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload( factory );

            // Count how many files are uploaded
            int count = 0;
            // The directory we want to save the uploaded files to.
            String fileDir = getServletContext().getRealPath( "/WEB-INF/files" );
            
           
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT `auto_increment` as id FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'files';" );
            
           int fid = 0;
           
           while(rs.next())
           {
        	   if(rs.getObject("id") !=null)
        	   {
        	      fid=rs.getInt("id");
        	   }
           }
            
             List<FileItem> items = upload.parseRequest(request );
        
                for( FileItem item : items )
                {
                    // If the item is not a form field - meaning it's an uploaded
                    // file, we save it to the target dir
                    if( !item.isFormField() )
                    {
                        // item.getName() will return the full path of the uploaded
                        // file, e.g. "C:/My Documents/files/test.txt", but we only
                        // want the file name part, which is why we first create a
                        // File object, then use File.getName() to get the file
                        // name.
                        String fileName = (new File( item.getName() )).getName();
                        String type=new MimetypesFileTypeMap().getContentType(fileName);
                        long size=item.getSize();
                        
                        File file = new File( fileDir, "File_"+fid+"_"+fileName);
                        try {
							item.write( file );
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        ++count;
                        
                     
                        PreparedStatement pstmt = c.prepareStatement( sql ); 
                        pstmt.setInt( 1, uid );
                        pstmt.setString( 2, fileName );
                        pstmt.setString( 3, "File" );
                        pstmt.setLong(4, size);
                        pstmt.setInt( 5, id );
                        pstmt.setBoolean(6, false);
                        pstmt.executeUpdate();

                        c.close();
                   
                    }
                    
                   
                }
                
	        }
	        catch( SQLException | FileUploadException e )
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
                     

            
          if(id==0)
    		{
    		response.sendRedirect("Homepage");
    		}
    		else
    		{
    			response.sendRedirect("SubFolder?Id="+id);	
    		}
            
    }

}