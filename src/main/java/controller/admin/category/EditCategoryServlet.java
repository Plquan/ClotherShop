package controller.admin.category;

import java.io.IOException;
import java.sql.SQLException;

import dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CategoryDTO;

@WebServlet(name = "EditCategoryServlet", urlPatterns = {"/EditCategoryServlet"})
public class EditCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String MANAGE_CATEGORY_CONTROLLER = "ManageCategoryServlet";
	private static final String EDIT_PAGE = "admin/admin_categories_edit.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     	int categoryId = Integer.parseInt(request.getParameter("categoryId"));
     	 CategoryDAO cDao = new CategoryDAO();
    	CategoryDTO category;
		try {
			category = cDao.getCategoryById(categoryId);
			request.setAttribute("categoryId", category.getId());
	        request.setAttribute("categoryName", category.getName());
	        request.getRequestDispatcher(EDIT_PAGE).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String url = MANAGE_CATEGORY_CONTROLLER;
        try {
            CategoryDAO dao = new CategoryDAO();
            String Id = request.getParameter("categoryId");
            String Name = request.getParameter("categoryName");
            dao.editCategory(Id,Name);
            request.setAttribute("mess", "Edit successfully!");
        } catch (Exception ex) {
            log("EditCategoryServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }


}
