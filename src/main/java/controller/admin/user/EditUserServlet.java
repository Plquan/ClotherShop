package controller.admin.user;

import java.io.IOException;
import java.io.PrintWriter;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserDTO;

@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUserServlet"})
public class EditUserServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private static final String EDIT_PAGE = "admin/admin_user_edit.jsp";
    private static final String MANAGE_USER_CONTROLLER = "ManageUserServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditUserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        try {               
        	    String url = MANAGE_USER_CONTROLLER;
                int id = Integer.parseInt(request.getParameter("userId"));
                String username = request.getParameter("username");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String permission = request.getParameter("permission");
                String avatar = request.getParameter("avatar");
                
                if (avatar != null && !avatar.equals("")) {
                	avatar = "admin/assets/img/users/" + avatar;
                } else {
                    avatar = dao.getUserById(id).getAvatar();
                }
                
                int roleid = (permission.equals("True") ? 1 : 2);
                dao.updateUser( id,email, address, phone, username, avatar, roleid);

                request.setAttribute("mess", "Edit successfully!");
                request.getRequestDispatcher(url).forward(request, response);
            
        } catch (Exception ex) {
            log("EditProductServlet error:" + ex.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
