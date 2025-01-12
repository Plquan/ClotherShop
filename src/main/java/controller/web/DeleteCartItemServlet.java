package controller.web;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CartItem;

@WebServlet(name = "DeleteCartItemServlet", urlPatterns = {"/DeleteCartItemServlet"})
public class DeleteCartItemServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int idToRemove = Integer.parseInt(req.getParameter("id"));


    HttpSession session = req.getSession();

    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

    if (cart != null) {
        cart.removeIf(item -> item.getId() == idToRemove);
        session.setAttribute("cart", cart);
    }

    resp.setContentType("text/plain");
    resp.getWriter().write("Item removed successfully");
}
}
