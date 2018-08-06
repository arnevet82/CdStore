package webapp.cd;

import java.util.List;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DBObject;

import webapp.client.ClientService;
import webapp.cd.CdService;

@WebServlet(urlPatterns = "/store.do")
public class InventoryServlet extends HttpServlet {	
	
	private CdService cdService = new CdService();
	private ClientService clientService = new ClientService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cds", cdService.retrieveCds());
		request.setAttribute("clients", clientService.retrieveClients());
		request.setAttribute("soldCds", cdService.retrieveSoldCds());
		
		request.getRequestDispatcher("/WEB-INF/views/store.jsp").forward(request, response);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newCd = request.getParameter("cd");
		double price = Double.parseDouble(request.getParameter("price"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		int id = ThreadLocalRandom.current().nextInt(1000, 100000000 + 1);
		cdService.addCd(new Cd(newCd, price, amount, id));
		response.sendRedirect("/store.do");
	
	}
	
}