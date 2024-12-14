package controller.web;

import java.io.IOException;
import java.util.List;

import dao.CategoryDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ProductDTO;

@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {
    private  final  String HOME_PAGE = "home.jsp";
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        try {
	            ProductDAO pDao = new ProductDAO();
	            List<ProductDTO> listProducts = pDao.getAll();
	            	req.setAttribute("LIST_PRODUCTS", listProducts);	                  
	        } catch (Exception ex) {
	            log("ManageProductServlet error:" + ex.getMessage());
	        } 
		req.getRequestDispatcher(HOME_PAGE).forward(req, resp);
	}

}
