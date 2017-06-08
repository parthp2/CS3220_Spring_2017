package OnlineFileManager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OnlineFileManager.model.Folder;


@WebServlet("/DeleteFolder")
public class DeleteFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteFolder() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Folder> folder=(List<Folder>) getServletContext().getAttribute("folder");
		
		int pid = 0;
		 
        int did=Integer.parseInt(request.getParameter("Id"));
		 
        for(int i=0;i<folder.size();i++)
		 {
       	     if(folder.get(i).getParent()==did)
			 {
				 folder.remove(i);
			 }
       	 
			 if(folder.get(i).getId()==did)
			 {
				 pid=folder.get(i).getParent();
				 
				 folder.remove(i);
			 }
		 }
        
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
