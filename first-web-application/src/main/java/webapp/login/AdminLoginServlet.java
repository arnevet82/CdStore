package webapp.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.cd.CdService;


@WebServlet(urlPatterns = "/adminLogin.do")
public class AdminLoginServlet extends HttpServlet {	
	
	private LoginService adminValidationService = new LoginService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/adminLogin.jsp").forward(request, response);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		boolean isUserValid = adminValidationService.isUserValid(name, password);
		
		if(isUserValid) {
			request.getSession().setAttribute("name", name);
			response.sendRedirect("/store.do");
			
		}else {
			request.setAttribute("errorMessage", "Invalid Credentials!");
			request.getRequestDispatcher("/WEB-INF/views/adminLogin.jsp").forward(request, response);
		}
				
	}

}