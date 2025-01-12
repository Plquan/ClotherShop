package controller.web;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserDTO;

@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_PAGE = "login.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		UserDTO user = null;
		String email = req.getParameter("userName");
		String pass = req.getParameter("password");
		user = dao.Login(email, pass);
		if(user == null) {
			req.setAttribute("mess","Email hoặc mật khẩu sai");
			req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
			return;
		}	
		if("inactive".equals(user.getStatus())) {
			req.setAttribute("mess","tài khoản bị khóa");
			req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
			return;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		resp.sendRedirect("HomeServlet");
	}
	
}
