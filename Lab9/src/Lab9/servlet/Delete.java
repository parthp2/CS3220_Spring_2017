package Lab9.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lab9.model.Item;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Delete() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Item> item=(List<Item>) getServletContext().getAttribute("items");
		
		String name=request.getParameter("name");
		
		for(int i=0;i<item.size();i++)
		{
			if(item.get(i).getName().equals(name))
			{
				item.remove(i);
				
				File deleteFile=new File("WEB-INF/files"+name);
				
				if( deleteFile.exists() )
				{
					deleteFile.delete() ;
				}
			}
		}
		
		response.sendRedirect("ListFiles");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
