package controller.admin.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.CategoryDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.CategoryDTO;
import model.ProductDTO;
import ultils.FileUpload;

@MultipartConfig
@WebServlet(name = "InsertProductServlet", urlPatterns = {"/InsertProductServlet"})
public class InsertProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private static final String INSERT_PAGE = "admin/admin_product_insert.jsp";
    private static final String INDEX_PAGE = "ManageProductServlet";
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDAO dao = new CategoryDAO();
		try {
			List<CategoryDTO> dto = dao.getData();
			req.setAttribute("ListCategory", dto);
			req.getRequestDispatcher(INSERT_PAGE).forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
	           ProductDAO dao = new ProductDAO();
	            Part img = req.getPart("img");
	            String name = req.getParameter("name");
	            String description = req.getParameter("description");
	            Double price = Double.parseDouble(req.getParameter("price"));
	            int categoryId =  Integer.parseInt(req.getParameter("categoryId"));
	            int stock =  Integer.parseInt(req.getParameter("stock"));
	            String image = FileUpload.saveFile(img, req);                                       
	              ProductDTO dto = new ProductDTO(0,name,categoryId,description,image,price,stock,"active");
	                dao.addProduct(dto);
	                resp.sendRedirect(INDEX_PAGE);    
	        } catch (Exception ex) {
	            log(" error:" + ex.getMessage());
	        } 
	}
}
