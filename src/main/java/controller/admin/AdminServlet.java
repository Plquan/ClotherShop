package controller.admin;

import java.io.IOException;

import dao.ContactDAO;
import dao.OrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OrderDTO;

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet{
   private static final String DASHBOARD = "admin/Dashboard.jsp";
	private static final long serialVersionUID = 1L;
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 OrderDAO order = new OrderDAO();
	 ContactDAO contact = new ContactDAO();
	 int orderCount = order.GetCountOrder();
	 int totalAmount = order.GetTotalAmount();
	 int cancelOrder = order.GetCancelOrder();
	 int pendingStatus = contact.GetCountContact();
	 req.setAttribute("orderCount", orderCount);
	 req.setAttribute("totalAmount", totalAmount);
	 req.setAttribute("cancelOrder", cancelOrder);
	 req.setAttribute("pendingStatus", pendingStatus);
;	 req.getRequestDispatcher(DASHBOARD).forward(req, resp);
}
	
	
}
