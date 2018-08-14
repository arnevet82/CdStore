package webapp.cd;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import webapp.cd.CdService;

@WebServlet(urlPatterns = "/cd.do")
public class CdServlet extends HttpServlet {	
	
	private CdService cdService = new CdService();
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cds", cdService.retrieveCds());
		request.setAttribute("soldCds", cdService.retrieveSoldCds());
		request.setAttribute("currentlyBoughtCds", cdService.retrieveCurrentlyBoughtCds());
		
		request.getRequestDispatcher("/WEB-INF/views/cd.jsp").forward(request, response);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String remove = request.getParameter("remove");
		System.out.println(remove);
		if(remove.equals("true")) {
			cdService.currentlyBought.clear();
		}
		response.sendRedirect("/cd.do");
	
	}
	
	
}