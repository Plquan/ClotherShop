package controller.web;

import java.io.IOException;

import dao.ContactDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContactDTO;

@WebServlet(name = "ContactServlet", urlPatterns = {"/ContactServlet"})
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTACT_PAGE = "contact.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		      req.getRequestDispatcher(CONTACT_PAGE).forward(req, resp);
	}
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ContactDTO contact = new ContactDTO();
    	ContactDAO dao = new ContactDAO();
    	String name = req.getParameter("name");
    	String email = req.getParameter("email");
    	String phone = req.getParameter("phone");
    	String message = req.getParameter("message");
    	String status = "pending";
    	contact = new ContactDTO(0,name,email,phone,message,status);
    	boolean check = dao.CreateContact(contact);
    	if(check == false) {
    		req.setAttribute("mess", "Gửi thất bại!");
    	}
    	else {
    	  	req.setAttribute("mess", "Gửi thành công!");
    	}
    	req.getRequestDispatcher(CONTACT_PAGE).forward(req, resp);
    }
}
