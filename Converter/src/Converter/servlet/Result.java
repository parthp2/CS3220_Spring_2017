package Converter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Converter.model.Currency;


@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Result() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		List<Currency> cur=(List<Currency>) getServletContext().getAttribute("currency");
		
          double  value=Double.parseDouble(request.getParameter("value"));
		
		  String  c1=request.getParameter("c1");
		  
		  String c2=request.getParameter("c2");
		  
		  double v1=0,v2=0;
		  
		  for(int i=0;i<cur.size();i++)
		  {
			  
			  if(cur.get(i).getCountry().equals(c1))
			  { 
				 v1=cur.get(i).getRate(); 
				 
			  }
		  }
	     for(int i=0;i<cur.size();i++)
		  {  
			  if(cur.get(i).getCountry().equals(c2))
			  {
				 v2=cur.get(i).getRate(); 
			  }
		  }
		  
		  double result;
		  
		  result=(value/v1*v2);
		  
		  
		  
		  PrintWriter out=response.getWriter();
		  

	        out.println("<html><head><title>Currency Converter Result</title></head><body>");
	        
	      
			out.println("<p>"+value+" "+c1+" = "+result+" "+c2+"</p>");
			
			out.println("<a href='CurrencyConverter' >Back</a>");
			
			out.println("</body></html>");
		  
		  
	}

}
