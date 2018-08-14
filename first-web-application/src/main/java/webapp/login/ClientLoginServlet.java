package webapp.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import webapp.client.Client;
import webapp.client.ClientService;
import webapp.cd.CdService;

@WebServlet(urlPatterns = "/clientLogin.do")
public class ClientLoginServlet extends HttpServlet {	
	
	private LoginService validationService = new LoginService();
	private ClientService clientService = new ClientService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/customerLogin.jsp").forward(request, response);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		request.getSession().setAttribute("firstName", firstName);
		request.getSession().setAttribute("email", email);
		Client client = new Client(email);
		client.setFirstName(firstName);
		client.setLastName(lastName);
		client.setPassword(password);
		clientService.addClient(client);
//		response.sendRedirect("/cd.do");
		response.sendRedirect("/rest/restCd.do");
			
		
	}

}