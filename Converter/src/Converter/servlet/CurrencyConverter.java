package Converter.servlet;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

import Converter.model.Currency;



@WebServlet("/CurrencyConverter")
public class CurrencyConverter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CurrencyConverter() {
        super();
 
    }

	
	public void init(ServletConfig config) throws ServletException 
	{

		super.init(config);
		
		List<Currency> currency=new ArrayList<Currency>();
		
		getServletContext().setAttribute("currency",currency);

		try
		{
			
		FileInputStream stream = new FileInputStream(getServletContext().getRealPath("/WEB-INF/rates.txt"));
		DataInputStream in = new DataInputStream(stream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String data;
	    while((data=br.readLine( )) != null)
	    {
	        String[] token=data.split(" ");
	        System.out.println(token[0]);
	        currency.add(new Currency(token[0],Double.parseDouble(token[1])));
	    }
		
		} catch ( IOException e)
		{
	
			
			e.printStackTrace();
		}
	
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Currency> cur=(List<Currency>) getServletContext().getAttribute("currency");
		
		PrintWriter out=response.getWriter();

        out.println("<html><head><title>Currency Converter</title></head><body>");
		
		out.println("<form action='Result' method='post'>");
		
		out.println("<input type='text' name='value'>");
		
		out.println("<select name='c1'>");
		
		for(int i=0;i<cur.size();i++)
		{
		   out.println("<option>"+cur.get(i).getCountry()+"</option>");
		}
		
		 out.println("</select>");
			
		out.println("=");
		
        out.println("<select name='c2'>");
		
		for(int i=0;i<cur.size();i++)
		{
		   out.println("<option>"+cur.get(i).getCountry()+"</option>");
		}
		
		 out.println("</select>");
			
		
		out.println("<input type='submit' value='Convert'>");
		
		out.println("</form></body></html>");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
