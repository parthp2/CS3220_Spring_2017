package HW3.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW3.model.Files;

@WebServlet("/Download")
public class Download extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Download()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	List<Files> Files=(List<Files>) getServletContext().getAttribute("Files");
    	
    	int id=Integer.parseInt(request.getParameter("Id"));
	
    	System.out.println(id);
    	
    	String fname=null;
    	
    	for(Files files:Files)
    	{
    		if(files.getId()==id)
    		{
    			fname=files.getName();
    		}
    	}
    	
        String path = getServletContext()
            .getRealPath( "/WEB-INF/files/File_"+id+"_"+fname );
        File file = new File( path );

        // Set the response headers. File.length() returns the size of the file
        // as a long, which we need to convert to a String.
        response.setContentType( "application/octet-stream" );
        response.setHeader( "Content-Length", "" + file.length() );
        response.setHeader( "Content-Disposition",
            "attachment; filename="+fname );

        // Binary files need to read/written in bytes.
        FileInputStream in = new FileInputStream( file );
        OutputStream out = response.getOutputStream();
        byte buffer[] = new byte[2048];
        int bytesRead;
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );
        in.close();
        out.close();
    }

}