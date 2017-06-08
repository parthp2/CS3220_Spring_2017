package HW3.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import HW3.model.Files;



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
        
        List<Files> Files=(List<Files>) getServletContext().getAttribute("Files");
        
        int id=Integer.parseInt(request.getParameter("Id"));
        
        int fid;
        
        
        if(Files.size()>0)
        {
        	fid=Files.get(Files.size()-1).getId()+1;
        }
        else
        {
        	fid=1;
        }
       	
        
        // Parse the request
        try
        {
        	DateFormat df = new SimpleDateFormat("MM/dd/yy hh:mm aa");
        	String temp=df.format(new Date());
        	Date dateobj =df.parse(temp);
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
                    item.write( file );
                    ++count;
                
                    Files.add(new Files(fileName,type,size,dateobj,id,false));
                  
                }
                
               
            }
                 

        }
        catch( Exception e )
        {
            throw new IOException( e );
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