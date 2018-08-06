package webapp.cd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.client.Client;
import webapp.client.ClientService;

@WebServlet(urlPatterns = "/buy-cd.do")
public class buyCdServlet extends HttpServlet {	
	
	private CdService cdService = new CdService();
	private ClientService clientService = new ClientService();


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Client client = new Client(request.getParameter("email"));
		
		cdService.buyCd(Integer.parseInt(request.getParameter("id")));
		clientService.addCdToClient(client, Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("email", request.getParameter("email"));
		response.sendRedirect("/cd.do");

	}
	
}