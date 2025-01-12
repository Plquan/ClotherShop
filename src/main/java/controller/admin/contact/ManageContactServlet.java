package controller.admin.contact;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import dao.ContactDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ContactDTO;
import ultils.EmailService;
@WebServlet(name = "ManageContactServlet", urlPatterns = {"/ManageContactServlet"})
public class ManageContactServlet extends HttpServlet{
	private static final String INDEX =  "admin/admin_contact.jsp";

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContactDAO dao = new ContactDAO();
		try {
			List<ContactDTO> contacts = dao.GetAll();
			req.setAttribute("ListContact", contacts);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher(INDEX).forward(req, resp);
	}
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   ContactDAO dao = new ContactDAO();
	   String toEmail = req.getParameter("toEmail");
	   String cId = req.getParameter("contactId");
	   String message = req.getParameter("replyMessage");
	   String subject = "Phản hồi khách hàng";
	    try {
			EmailService.sendEmail(toEmail, subject, message);		
			dao.updateStatus("Replied", Integer.parseInt(cId));
			HttpSession session = req.getSession();
			session.setAttribute("mess", "Đã gửi email thành công!");
			resp.sendRedirect("ManageContactServlet");

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
}
   
}
