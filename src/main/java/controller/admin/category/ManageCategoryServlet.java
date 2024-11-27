package controller.admin.category;

import java.io.IOException;
import java.util.List;

import dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CategoryDTO;

@WebServlet(name = "ManageCategoryServlet", urlPatterns = {"/ManageCategoryServlet"})
public class ManageCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String MANAGE_CATEGORY_PAGE = "admin/admin_categories.jsp";
    private static final String INSERT_CATEGORY_PAGE = "admin/admin_categories_insert.jsp";
    private static final String EDIT_CATEGORY_PAGE = "admin/admin_categories_edit.jsp";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = MANAGE_CATEGORY_PAGE;
        try {
            CategoryDAO cDao = new CategoryDAO();
            String action = request.getParameter("action");
            if(action == null) {
            	List<CategoryDTO> list = cDao.getData();
                request.setAttribute("LIST_CATEGORIES", list);
            }
            else if (action.equals("Insert")) {
                url = INSERT_CATEGORY_PAGE;              
            }
            else if(action.equals("Edit")) {
            	url = EDIT_CATEGORY_PAGE;
            	int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            	CategoryDTO category = cDao.getCategoryById(categoryId);
            	request.setAttribute("categoryId", category.getCategoryId());
                request.setAttribute("categoryName", category.getCategoryName());
            	
            }               
        } catch (Exception ex) {
            log("ManageCategoryServlet error:" + ex.getMessage());
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
