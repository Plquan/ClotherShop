/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.user;


import java.io.IOException;
import java.util.List;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserDTO;

@WebServlet(name = "ManageUserServlet", urlPatterns = {"/ManageUserServlet"})
public class ManageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String MANAGE_USER_PAGE = "admin/admin_users.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            UserDAO dao = new UserDAO();
            if (action == null) {
                List<UserDTO> list = dao.getData();
                request.setAttribute("LISTUSERS", list);
                
            } 
        } catch (Exception ex) {
            log("ManageUserServlet error:" + ex.getMessage());
        } 
            request.getRequestDispatcher( MANAGE_USER_PAGE).forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
