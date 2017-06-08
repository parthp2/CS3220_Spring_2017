package Temp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Add() {
        super();
    }

protected void doGet(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
	
		int a=0,b=0;
		
		if(request.getParameter("a") != null)
			a=Integer.parseInt(request.getParameter("a"));
		
		if(request.getParameter("b") !=null)
			b=Integer.parseInt(request.getParameter("b"));
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html><head><title>AdD</title></head><body>");
		
		out.print("<p>"+ a +" + "+ b + "="+(a+b)+"</p>" );
		
}

protected void doPost(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
	 doGet( request,response);
		}

	    

}
