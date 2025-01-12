package controller.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AboutServlet", urlPatterns = {"/AboutServlet"})
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ABOUT_PAGE = "about.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		              req.getRequestDispatcher(ABOUT_PAGE).forward(req, resp);;
	}

}
