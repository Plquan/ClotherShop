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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserDTO;

@WebServlet(name = "ManageUserServlet", urlPatterns = {"/ManageUserServlet"})
public class ManageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String MANAGE_USER_PAGE = "admin/admin_users.jsp";
    private final String INSERT_USER_PAGE = "admin/admin_user_insert.jsp";
    private static final String EDIT_PAGE = "admin/admin_user_edit.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = MANAGE_USER_PAGE;
        try {
            String action = request.getParameter("action");
            UserDAO dao = new UserDAO();
            if (action == null) {
                List<UserDTO> list = dao.getData();
                request.setAttribute("LISTUSERS", list);
//                request.setAttribute("CURRENTSERVLET", "User");
                url = MANAGE_USER_PAGE;
            } else if (action.equals("Insert")) {
                url = INSERT_USER_PAGE;
            } else if (action.equals("Update")) {
            	url = EDIT_PAGE;
            	String userIdStr = request.getParameter("userId"); 
            	int userId = Integer.parseInt(userIdStr);
                UserDTO user = dao.getUserById(userId);
                request.setAttribute("userId", user.getId());
                request.setAttribute("username", user.getUserName());
                request.setAttribute("phone", user.getPhone());
                request.setAttribute("roleId", user.getRoleID());
                request.setAttribute("address", user.getAddress());
                request.setAttribute("email", user.getEmail());
                request.setAttribute("avatar", user.getAvatar());
            }
        } catch (Exception ex) {
            log("ManageUserServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
