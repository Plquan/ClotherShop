package controller.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CartItem;
import model.OrderDTO;
import model.OrderItemDTO;
import ultils.CodeGenerate;
import ultils.OnlinePayment;

@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String CHECKOUT_PAGE = "checkout.jsp";
	private static final String THANKYOU_PAGE = "thankyou.jsp";
	private static final String CART_SERVLET = "CartServlet";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(CHECKOUT_PAGE).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String url = THANKYOU_PAGE;
	      OrderDAO odao = new OrderDAO();
	      ProductDAO pdao = new ProductDAO();
	      OrderItemDAO oidao = new OrderItemDAO();
	      
	      String code = CodeGenerate.generateCode();
	      String userName = req.getParameter("userName");
	      String email = req.getParameter("email");
	      String phone = req.getParameter("phone");
	      String address = req.getParameter("address");
	      String note = req.getParameter("note");	   
	      Double totalPrice = Double.parseDouble(req.getParameter("totalPrice"));
	      Date createdAt = new Date(System.currentTimeMillis());	     
	      String status = "pending";
	      String paymentMethod = req.getParameter("paymentMethod");
	      if (paymentMethod == null || paymentMethod.isEmpty()) {
	          paymentMethod = "COD";
	      }
          OrderDTO dto = new OrderDTO(0,code,userName,email,phone,address,note,totalPrice,createdAt,paymentMethod,"pending",status);      
      
          String newcode = odao.CreateOrder(dto);
          int OrderId = odao.GetOrderByCode(newcode).getId();
	      
	      HttpSession session = req.getSession();
	      List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
	   
	   if (cart == null || cart.isEmpty()) {
           resp.getWriter().println("Cart is empty. No products to save.");
           return;
       }
	   List<OrderItemDTO> orderItems = new ArrayList<>();
	   for (CartItem cartItem : cart) {       
         OrderItemDTO item = new OrderItemDTO( 0,cartItem.getId(),OrderId,cartItem.getQuantity(), cartItem.getPrice());
             try {
				int cStock = pdao.getById(cartItem.getId()).getStock();
				if(cStock < cartItem.getQuantity()) {
					odao.DeleteOrder(OrderId);
					session.setAttribute("error","Mã sản phẩm "+cartItem.getId()+": Số lượng tồn kho không đủ !!!");
					url = CART_SERVLET;
					break;
				}
				else {
					oidao.AddOrderItem(item);
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}      
	    }
	   if ("vnpay".equals(paymentMethod)) {
		   url = OnlinePayment.CreateUrl(req, resp,OrderId);
		   resp.sendRedirect(url);
	   }
	   else {
		   req.setAttribute("code", newcode);
		     req.setAttribute("InfoPayment", "Payment Success");
		     req.getRequestDispatcher(url).forward(req, resp);
	   }
	    	      
	}
}
