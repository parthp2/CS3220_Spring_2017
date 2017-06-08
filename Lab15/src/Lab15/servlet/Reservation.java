package Lab15.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lab15.model.Available;

import Lab15.model.Reserve;



@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Reservation() {
        super();
        
    }

		public void init(ServletConfig config) throws ServletException {
			
			super.init(config);
			
			List<Available> Day=new ArrayList<Available>();
			
			getServletContext().setAttribute("Day",Day);
			
            List<Available> Slot=new ArrayList<Available>();
			
			getServletContext().setAttribute("Slot",Slot);
			
			Day.add(new Available("MON"));
			Day.add(new Available("TUE"));
			Day.add(new Available("WED"));
			Day.add(new Available("THU"));
			Day.add(new Available("FRI"));
			
			for(int i=1;i<10;i++)
			{
				
				Slot.add(new Available(i));
			}
			
			
			
			List<Reserve> Reserve=new ArrayList<Reserve>();
			
			getServletContext().setAttribute("Reserve",Reserve);
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Available> Day=(List<Available>)  getServletContext().getAttribute("Day");
		
		
		getServletContext().setAttribute("Day",Day);
		
        List<Available> Slot=(List<Available>)  getServletContext().getAttribute("Slot");
		
		
		getServletContext().setAttribute("Slot",Slot);  
		
		request.getRequestDispatcher("WEB-INF/display.jsp").forward( request, response );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String faculty=request.getParameter("faculty");
		String day=request.getParameter("day");
		int slot=Integer.parseInt(request.getParameter("slot"));
		
		List<Reserve> Res=(List<Reserve>)  getServletContext().getAttribute("Reserve");
		
		Res.add(new Reserve(day,faculty,slot));
		
		//List<Integer> Res1=Res.stream().map(p->p.getSlot()).collect(Collectors.toList());
		
		getServletContext().setAttribute("Res",Res);
		
		
		request.getRequestDispatcher("WEB-INF/display.jsp").forward( request, response );
		
	}

}
