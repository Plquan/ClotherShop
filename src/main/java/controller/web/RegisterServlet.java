package controller.web;

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
@WebServlet(name = "RegisterServlet", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String REGISTER_PAGE = "register.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(REGISTER_PAGE).forward(req, resp);
	}
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   try {
           UserDAO dao = new UserDAO();
           Part img = req.getPart("avatar");
           String username = req.getParameter("name");
           String password = req.getParameter("password");
           String email = req.getParameter("email");
           String address = req.getParameter("address");
           String phone = req.getParameter("phone");
           String avatar = FileUpload.saveFile(img, req);
           if (dao.checkEmailDuplicate(email)) {              
        	   req.setAttribute("error", "Email tài khoản đã tồn tại!");
           }                                          
               UserDTO user = new UserDTO(0, email, avatar, username, password, address, phone,"user","active");
               dao.registerUser(user);
               req.setAttribute("mess", "Tạo tài khoản thành công!");
               resp.sendRedirect("login.jsp");    
       } catch (Exception ex) {
           log("InserUserServlet error:" + ex.getMessage());
       } 
}
}
