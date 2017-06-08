package HW2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW2.model.Files;



@WebServlet("/DeleteFolder")
public class DeleteFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteFolder() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Files> Files=(List<Files>) getServletContext().getAttribute("Files");
		
		List<Files> temp=new ArrayList<Files>();
		
		int pid = 0;
		 
        int did=Integer.parseInt(request.getParameter("Id"));
		
        for(int i=0;i<Files.size();i++)
        {
			 if(Files.get(i).getId()==did)
			 {
				 pid=Files.get(i).getParent();
				 
				 temp.add(Files.get(i));
				 
			 }
			 
       	     if(Files.get(i).getParent()==did)
			 {
       	    	
				temp.add(Files.get(i));

			 }
       	     
		 }
        
        Files.removeAll(temp);
        
        if(pid!=0)
        {
        response.sendRedirect("SubFolder?Id="+pid);
        }
        else
        {
        	response.sendRedirect("Homepage");	
        }
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
 
		
	}

}
