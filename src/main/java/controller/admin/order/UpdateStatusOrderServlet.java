package controller.admin.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dao.OrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateStatusOrderServlet", urlPatterns = {"/UpdateStatusOrderServlet"})
public class UpdateStatusOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Đọc dữ liệu JSON từ body của request
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
	    Gson gson = new Gson();
        String jsonData = sb.toString();
        
        OrderDAO dao = new OrderDAO();
        JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();
        int orderId = jsonObject.get("orderId").getAsInt();
        String status = jsonObject.get("status").getAsString();

        boolean isUpdated = false;
		try {
			isUpdated = dao.UpdateStatus(status,orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

        JsonObject jsonResponse = new JsonObject();
        if (isUpdated) {
            jsonResponse.addProperty("message", "Cập nhật trạng thái thành công");
            jsonResponse.addProperty("status", "success");
        } else {
            jsonResponse.addProperty("message", "Cập nhật trạng thái thất bại");
            jsonResponse.addProperty("status", "error");
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(jsonResponse));
        out.flush();
	}
}
