package controller.admin.category;

import java.io.IOException;

import dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "InsertCategoryServlet", urlPatterns = {"/InsertCategoryServlet"})
public class InsertCategoryServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private static final String MANAGE_CATEGORY_CONTROLLER = "ManageCategoryServlet";
    private static final String INSERT_PAGE = "admin/admin_categories_insert.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(INSERT_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDAO cDao = new CategoryDAO();
        String Name = request.getParameter("name");
        if (Name != null) {
            cDao.insertCategory(Name);
        }
        response.sendRedirect(MANAGE_CATEGORY_CONTROLLER);   
    }



}
