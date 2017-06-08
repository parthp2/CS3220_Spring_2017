package Lab12.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Lab12.model.Question;


@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DrivingTestBrowser() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		
         super.init(config);
		
		List<Question> Question=new ArrayList<Question>();
		
		getServletContext().setAttribute("Question",Question);
		
		getServletContext().setAttribute("index",0);
		

		try
		{
			
			File file = new File(getServletContext().getRealPath("/WEB-INF/DrivingTest.txt")); 
			
			Scanner sc=new Scanner(file);
			
			String description,answerA,answerB,answerC;
			int correctAnswer;
			
			while(sc.hasNextLine())
			{
				
				description = sc.nextLine();
				answerA = sc.nextLine();
				answerB = sc.nextLine();
				answerC = sc.nextLine();
				correctAnswer = Integer.parseInt(sc.nextLine());
			    Question.add(new Question(description,answerA,answerB,answerC,correctAnswer));
		        sc.nextLine();       
			}	
		sc.close();	
		}
		catch ( IOException e)
		{
			
			e.printStackTrace();
		}
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer index=(Integer)getServletContext().getAttribute("index");
		
		List<Question> Question=(List<Question>) getServletContext().getAttribute("Question");
		
	
		if(index==Question.size())
		{
			index=0;
			getServletContext().setAttribute("index",index);
		}
		
		Question qes=Question.get(index);
		getServletContext().setAttribute("qes",qes);
		
		
		index++;
		getServletContext().setAttribute("index",index);
		request.getRequestDispatcher("WEB-INF/displays.jsp").forward( request, response );

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}


//File file = new File(getServletContext().getRealPath("/WEB-INF/DrivingTest.txt")); 
//
//Scanner sc=new Scanner(file);
//
//String description,answerA,answerB,answerC;
//int correctAnswer;
//
//while(sc.hasNextLine())
//{
//	
//	description = sc.nextLine();
//	answerA = sc.nextLine();
//	answerB = sc.nextLine();
//	answerC = sc.nextLine();
//	correctAnswer = Integer.parseInt(sc.nextLine());
//    
//    Question.add(new Question(description,answerA,answerB,answerC,correctAnswer));
//    sc.nextLine();   
//}
//
//System.out.println(Question.size());