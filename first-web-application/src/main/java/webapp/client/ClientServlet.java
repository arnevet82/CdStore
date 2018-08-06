package webapp.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webapp.cd.CdService;

@WebServlet(urlPatterns = "/client.do")
public class ClientServlet extends HttpServlet {	
	
	private ClientService clientService = new ClientService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		request.setAttribute("email", request.getParameter("email"));
		request.setAttribute("client", clientService.retrieveOneClient(email));
		System.out.println(clientService.retrieveOneClient(email));
		request.getRequestDispatcher("/WEB-INF/views/client.jsp").forward(request, response);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/cd.do");
	
	}
	
}