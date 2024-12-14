package controller.admin.product;

import java.io.IOException;
import java.sql.SQLException;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteProductServlet", urlPatterns = { "/DeleteProductServlet" })
public class DeleteProductServlet extends HttpServlet {
	private static final String INDEX_PAGE = "ManageProductServlet";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		   try {
			int pId = Integer.parseInt(req.getParameter("pId"));
			ProductDAO dao =new ProductDAO();
			dao.deleteProduct(pId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   resp.sendRedirect(INDEX_PAGE);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
