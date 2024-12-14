package controller.admin.product;

import java.io.IOException;
import java.util.List;

import dao.CategoryDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CategoryDTO;
import model.ProductDTO;

@WebServlet(name = "ManageProductServlet", urlPatterns = {"/ManageProductServlet"})
public class ManageProductServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String PRODUCT_PAGE = "admin/admin_products.jsp";
    private final String INSERT_PRODUCT_PAGE = "admin/admin_products_insert.jsp";
    private final String DELETE_PRODUCT_CONTROLLER = "DeleteProductServlet";
    private final String INSERT_PRODUCT_CONTROLLER = "InsertProductServlet";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = PRODUCT_PAGE;
        try {
            String action = request.getParameter("action");
            ProductDAO pDao = new ProductDAO();
            CategoryDAO cDao = new CategoryDAO();

            List<ProductDTO> listProducts = pDao.getAll();
            List<CategoryDTO> listCategories = cDao.getData();
            if (action == null) {
                request.setAttribute("LIST_PRODUCTS", listProducts);
            } else if (action.equals("Insert")) {
                url = INSERT_PRODUCT_CONTROLLER;
            } else if (action.equals("Edit")) {
                request.setAttribute("LIST_PRODUCTS", listProducts);
                request.setAttribute("LIST_CATEGORIES", listCategories);
            }            
        } catch (Exception ex) {
            log("ManageProductServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}