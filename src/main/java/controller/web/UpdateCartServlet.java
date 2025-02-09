package controller.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CartItem;

@WebServlet(name = "UpdateCartServlet", urlPatterns = {"/UpdateCartServlet"})
public class UpdateCartServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
		 ProductDAO dao = new ProductDAO();
	    HttpSession session = req.getSession();

	    BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
	    StringBuilder sb = new StringBuilder();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        sb.append(line);
	    }

	    Gson gson = new Gson();
	    CartItem[] updatedItems = gson.fromJson(sb.toString(), CartItem[].class);

	    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
	    if (cart == null) {
	        cart = new ArrayList<>();
	    }

	    for (CartItem updatedItem : updatedItems) {
	        for (CartItem item : cart) {
	            if (item.getId() == updatedItem.getId()) {	                     	
						try {
							int cstock = dao.getById(updatedItem.getId()).getStock();
							if(updatedItem.getQuantity() <= cstock) {
		                    	 item.setQuantity(updatedItem.getQuantity());  
							}
							else {
								session.setAttribute("error", "Mã sản phẩm "+ updatedItem.getId()+ ": Số lượng đặt trong giỏ hàng không được vượt quá tồn kho.");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}                
	                break; 
	            }
	        }	       
	    }
	    session.setAttribute("cart", cart);
	    PrintWriter out = resp.getWriter();
	    Map<String, Object> result = new HashMap<>();
	    result.put("success", true);
	    result.put("data", updatedItems);
	    result.put("cart", cart);

	    out.print(gson.toJson(result));
	    out.flush();
	}

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doPost(req, resp);
	}
}
