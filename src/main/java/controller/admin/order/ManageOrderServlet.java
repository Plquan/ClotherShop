package controller.admin.order;

import java.io.IOException;
import java.util.List;

import dao.OrderDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OrderDTO;

@WebServlet(name = "ManageOrderServlet", urlPatterns = {"/ManageOrderServlet"})
public class ManageOrderServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private final String ORDER_PAGE = "admin/admin_orders.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  try {         
	            OrderDAO dao = new OrderDAO();
	                List<OrderDTO> list = dao.getAll();
	                req.setAttribute("ListOrder", list);      
	            
	        } catch (Exception ex) {
	            log("ManageUserServlet error:" + ex.getMessage());
	        } 
	            req.getRequestDispatcher( ORDER_PAGE).forward(req, resp);
	}
}
