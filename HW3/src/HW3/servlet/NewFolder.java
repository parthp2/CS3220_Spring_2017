package HW3.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import HW3.model.Files;



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
	
		
		
		List<Files> files=(List<Files>) getServletContext().getAttribute("Files");
		
		int pf=0;
		
		String nfolder=request.getParameter("nfolder");
		
		int pfolder=Integer.parseInt(request.getParameter("pfolder"));
		
		DateFormat df = new SimpleDateFormat("MM/dd/yy hh:mm aa");
    	Date dateobj =new Date();
    	String temp=df.format(dateobj);
    		
		
		if(pfolder==0)
		{
			pf=0;
		}
		
		else
		{
			for(Files f:files)
			{
				if(f.getId()==pfolder)
				{
					 pf=pfolder;
				}
			}
		}
		
		
		
		try 
		{
			
			files.add(new Files(nfolder,"Folder",0,df.parse(temp),pf,true));
		} 
		catch (ParseException e)
		{
			
			e.printStackTrace();
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
