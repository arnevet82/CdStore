package webapp.cd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delete-cd.do")
public class DeleteCdServlet extends HttpServlet {	
	
	private CdService cdService = new CdService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cdService.deleteCd(new Cd("", 0, 0, Integer.parseInt(request.getParameter("id"))));
		response.sendRedirect("/store.do");

	}
	
}