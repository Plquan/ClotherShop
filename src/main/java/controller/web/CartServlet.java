package controller.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CartItem;

@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CART_PAGE = "cart.jsp";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 ProductDAO dao = new ProductDAO();
		 String url = CART_PAGE;
		  HttpSession session = req.getSession();
		  int id = Integer.parseInt(req.getParameter("id"));
		  String name = req.getParameter("name");
		  Double price = Double.parseDouble(req.getParameter("price"));
		  String image = req.getParameter("image");
		  int quantity = Integer.parseInt(req.getParameter("quantity"));  
		  CartItem newItem = new CartItem(id, name, price, image, quantity);	  		
		  List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		  
		   if (cart == null) {

	            cart = new ArrayList<>();
	        }
		   
		   boolean itemExists = false;
	        for (CartItem item : cart) {
	            if (item.getId() == id) {
	            	
	            	try {
						int cstock = dao.getById(id).getStock();
						if(item.getQuantity() + quantity <= cstock) {
							item.setQuantity(item.getQuantity() + quantity);
						}
						else {
							session.setAttribute("error", " số lượng đặt trong giỏ hàng không được vượt quá tồn kho.");
							url = "ProductDetailServlet?pId=" + id;
						}
					} catch (SQLException e) {				
						e.printStackTrace();
					}
	                
	                itemExists = true;
	                break;
	            }
	        }   
	        if (!itemExists) {
	            cart.add(newItem);
	        }
	        session.setAttribute("cart", cart);
	        resp.sendRedirect(url);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		 
		 req.getRequestDispatcher(CART_PAGE).forward(req, resp);
	}
	
	
}
