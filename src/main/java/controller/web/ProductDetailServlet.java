package controller.web;

import java.io.IOException;
import java.sql.SQLException;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ProductDTO;

@WebServlet(name = "ProductDetailServlet", urlPatterns = {"/ProductDetailServlet"})
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PRODUCTDETAIL_PAGE = "productDetail.jsp";
	private final String SHOP_PAGE = "ShopServlet";

  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String pId =  req.getParameter("pId");
	  ProductDAO dao = new ProductDAO();
	  try {
		if(pId != null && pId != "") {
			ProductDTO dto = dao.getById(Integer.parseInt(pId));
			req.setAttribute("id", dto.getId());
	        req.setAttribute("name", dto.getName());
	        req.setAttribute("description", dto.getDescription());
	        req.setAttribute("price", dto.getPrice());
	        req.setAttribute("stock", dto.getStock());     
	        req.setAttribute("image", dto.getImage());    
	  	  req.getRequestDispatcher(PRODUCTDETAIL_PAGE).forward(req, resp);
		}
		else {
			resp.sendRedirect(SHOP_PAGE);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}


	  
}
}
