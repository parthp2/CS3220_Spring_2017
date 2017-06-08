package OnlineFileManager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OnlineFileManager.model.Folder;


@WebServlet("/NewFolder")
public class NewFolder extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
   
    public NewFolder() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
       
		
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html><head><title>NewFolder</title></head><body>");
		
		out.println("<form action='NewFolder' method='post'>");
		
		if(request.getParameterMap().containsKey("Id"))
		{
			int parent=Integer.parseInt(request.getParameter("Id"));
			
			out.println("<input type='hidden' name='pfolder' value='"+parent+"'>");
		}
		else
		{
			out.println("<input type='hidden' name='pfolder' value='0'>");
		}
		out.println("New Folder:<input type='text' name='nfolder'>");
		
		out.println("<input type='submit' value='Create'>");
		
		out.println("</form>");
		
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		List<Folder> folder=(List<Folder>) getServletContext().getAttribute("folder");
		
		int pf=0;
		
		String nfolder=request.getParameter("nfolder");
		
		int pfolder=Integer.parseInt(request.getParameter("pfolder"));
		
		
		if(pfolder==0)
		{
			pf=0;
		}
		
		else
		{
			for(Folder f:folder)
			{
				if(f.getId()==pfolder)
				{
					 pf=pfolder;
				}
			}
		}
		
		folder.add(new Folder(nfolder,pf));
		
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
