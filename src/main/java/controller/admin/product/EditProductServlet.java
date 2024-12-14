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
@WebServlet(name = "EditProductServlet", urlPatterns = { "/EditProductServlet" })
public class EditProductServlet extends HttpServlet {
	private static final String EDIT_PAGE = "admin/admin_products_edit.jsp";
	private static final String INDEX_PAGE = "ManageProductServlet";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pId = Integer.parseInt(req.getParameter("pId"));
		ProductDAO dao = new ProductDAO();
		CategoryDAO cdao = new CategoryDAO();
		try {
			List<CategoryDTO> cdto = cdao.getData();
			ProductDTO dto = dao.getById(pId);
			req.setAttribute("id", dto.getId());
			req.setAttribute("name", dto.getName());
			req.setAttribute("description", dto.getDescription());
			req.setAttribute("price", dto.getPrice());
			req.setAttribute("categoryId", dto.getCategoryId());
			req.setAttribute("ListCategory", cdto);
			req.setAttribute("stock", dto.getStock());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher(EDIT_PAGE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ProductDAO dao = new ProductDAO();
			Part img = req.getPart("image") != null ? req.getPart("image") : null;
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			Double price = Double.parseDouble(req.getParameter("price"));
			int categoryId = Integer.parseInt(req.getParameter("categoryId"));
			int stock = Integer.parseInt(req.getParameter("stock"));
			String image;
			ProductDTO cproduct = dao.getById(id);
			if (img != null ) {
				image = FileUpload.saveFile(img, req);
			} else {
				image = cproduct.getImage();
			}
			String status = cproduct.getStatus();
			ProductDTO dto = new ProductDTO(id, name, categoryId, description, image, price, stock, status);
			dao.editProduct(dto);
			resp.sendRedirect(INDEX_PAGE);
		    } catch (Exception ex) {
		    	ex.printStackTrace();
		    }
		
	}
}
