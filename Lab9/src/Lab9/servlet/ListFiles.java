package Lab9.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lab9.model.Item;



@WebServlet("/ListFiles")
public class ListFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ListFiles() {
        super();
       
    }
    
    public void init(ServletConfig config) throws ServletException {
		
    	super.init(config);
    	
    	List<Item> item=new ArrayList<Item>();
    	
    	getServletContext().setAttribute("items",item);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Item> item=(List<Item>) getServletContext().getAttribute("items");
		
        response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
        out.println("<html><head><title>List Files</title></head><body>");
        
        out.println("<h3><a href='Upload' style='text-decoration:none;'>Upload File</a></h3>");
		
		out.println("<table border='1' cellpadding='1' cellspacing='1'>");
		
		out.println("<thead>");
		
		out.println("<tr><th>Name</th><th>Date Uploaded</th><th>Size</th><th>Operations</th></tr>");
		
		out.println("</thead>");
		
		if(!item.isEmpty())
		{
		
		for(Item i:item)
		{
		out.println("<tr><td><a  href='Download?name="+i.getName()+"' style='text-decoration:none;'>"+i.getName()+"</a></td><td>"+i.getDate()+"</td><td>"+i.getSize()+"</td><td><a  href='Delete?name="+i.getName()+"' style='text-decoration:none;'>Delete</a></td></tr>");
		}
		
		}
		out.println("</table></html>");
		
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}