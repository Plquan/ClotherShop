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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = MANAGE_CATEGORY_CONTROLLER;
        CategoryDAO cDao = new CategoryDAO();
        String Name = request.getParameter("categoryName");
        if (Name != null) {
            cDao.insertCategory(Name);
        }
        request.getRequestDispatcher(url).forward(request, response);
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
