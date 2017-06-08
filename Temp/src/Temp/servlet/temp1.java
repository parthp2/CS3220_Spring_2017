package Temp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/temp1")
public class temp1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public temp1() {
        super();
   }


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html><head><title> Request Info</title></head><body>");
		
		out.println("<p>Method:"+request.getMethod()+"</p>");
		
		out.println("<p>ContextPath:"+request.getContextPath()+"</p>");
		
		out.println("<p>URL:"+request.getRequestURL()+"</p>");
		
		out.println("<p>URI:"+request.getRequestURI()+"</p>");
		
		out.println("<p>Remote Ad "+request.getRemoteAddr()+"</p>");
		
		
		if(request.getHeader("Accept-Encoding").indexOf("gzip")>=0)
		{
			out.println("<p>gzip supported</p>");
		}
		else
		{
			out.println("<p>gzip not supported</p>");
		}
				
		out.println("</body></html>");
		
		
		

}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
