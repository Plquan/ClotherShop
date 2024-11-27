package controller.admin.category;

import java.io.IOException;

import dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteCategoryServlet", urlPatterns = {"/DeleteCategoryServlet"})
public class DeleteCategoryServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private static final String MANAGE_CATEGORY_CONTROLLER = "ManageCategoryServlet";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String categoryId = request.getParameter("categoryId");
            CategoryDAO dao = new CategoryDAO();
            dao.deleteCategory(categoryId);
            request.setAttribute("mess", "Delete successfully!");
        } catch (Exception ex) {
            log("DeleteCategoryServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(MANAGE_CATEGORY_CONTROLLER).forward(request, response);
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
