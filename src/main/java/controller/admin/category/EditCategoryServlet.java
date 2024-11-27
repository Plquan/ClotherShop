package controller.admin.category;

import java.io.IOException;

import dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EditCategoryServlet", urlPatterns = {"/EditCategoryServlet"})
public class EditCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String MANAGE_CATEGORY_CONTROLLER = "ManageCategoryServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
