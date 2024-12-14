package controller.admin.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.UserDTO;
import ultils.FileUpload;
@MultipartConfig
@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUserServlet"})
public class EditUserServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private static final String EDIT_PAGE = "admin/admin_user_edit.jsp";
    private static final String MANAGE_USER_CONTROLLER = "ManageUserServlet";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 UserDAO dao = new UserDAO();
       	String userIdStr = request.getParameter("userId"); 
    	int userId = Integer.parseInt(userIdStr);
        UserDTO user;
		try {
			user = dao.getUserById(userId);
	        request.setAttribute("userId", user.getId());
	        request.setAttribute("userName", user.getUserName());
	        request.setAttribute("phone", user.getPhone());
	        request.setAttribute("role", user.getRole());
	        request.setAttribute("address", user.getAddress());
	        request.setAttribute("email", user.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.getRequestDispatcher(EDIT_PAGE).forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        try {               
        	    String url = MANAGE_USER_CONTROLLER;
                int id = Integer.parseInt(request.getParameter("userId"));
                String userName = request.getParameter("userName");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String role = request.getParameter("role");
                Part img = request.getPart("avatar");
                String avatar;
                if (img != null && !img.equals("")) {
                	String Cavatar = dao.getUserById(id).getAvatar();
                	 FileUpload.deleteFile(Cavatar, request);
                	 avatar = FileUpload.saveFile(img, request);             	
                } 
                else {
                	avatar = dao.getUserById(id).getAvatar();
                }
                dao.updateUser( id,email, address, phone, userName, avatar, role);
                request.setAttribute("mess", "Edit successfully!");
                response.sendRedirect(MANAGE_USER_CONTROLLER);    
            
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
