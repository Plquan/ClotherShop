package controller.admin.user;

import java.io.IOException;

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
@WebServlet(name = "InsertUserServlet", urlPatterns = {"/InsertUserServlet"})
public class InsertUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String MANAGE_USER_CONTROLLER = "ManageUserServlet";
    private static final String INSERT_USER_PAGE = "admin/admin_user_insert.jsp";

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             request.getRequestDispatcher(INSERT_USER_PAGE).forward(request, response);;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserDAO dao = new UserDAO();
            Part img = request.getPart("avatar");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String role = request.getParameter("role"); 
            String avatar = FileUpload.saveFile(img, request);
            if (dao.checkEmailDuplicate(email)) {              
                request.setAttribute("error", "Tên tài khoản đã tồn tại!");
            }                                          
                UserDTO user = new UserDTO(0, email, avatar, username, password, address, phone, role,"inactive");
                dao.registerUser(user);
                request.setAttribute("mess", "Thêm thành công!");
                response.sendRedirect(MANAGE_USER_CONTROLLER);    
        } catch (Exception ex) {
            log("InserUserServlet error:" + ex.getMessage());
        } 
    }

}
