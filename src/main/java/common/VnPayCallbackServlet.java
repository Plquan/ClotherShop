package common;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import dao.OrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "VnPayCallbackServlet", urlPatterns = {"/VnPayCallbackServlet"})
public class VnPayCallbackServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String THANKYOU_PAGE = "thankyou.jsp";
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		// check payment
		   Map fields = new HashMap();
           for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
               String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
               String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
               if ((fieldValue != null) && (fieldValue.length() > 0)) {
                   fields.put(fieldName, fieldValue);
               }
           }
           OrderDAO dao = new OrderDAO();
           String vnp_SecureHash = request.getParameter("vnp_SecureHash");
           if (fields.containsKey("vnp_SecureHashType")) {
               fields.remove("vnp_SecureHashType");
           }
           if (fields.containsKey("vnp_SecureHash")) {
               fields.remove("vnp_SecureHash");
           }
           String signValue = Config.hashAllFields(fields);
           
           if (signValue.equals(vnp_SecureHash)) {
               if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
            	   request.setAttribute("code", request.getParameter("vnp_TxnRef"));
                   request.setAttribute("InfoPayment","Payment Success");

                   try {
					dao.UpdatePaymentStatus("success",Integer.parseInt(request.getParameter("vnp_TxnRef")));
				} catch (SQLException e) {
					e.printStackTrace();
				}
               }
               else if ("24".equals(request.getParameter("vnp_TransactionStatus"))) {
            	   request.setAttribute("code", request.getParameter("vnp_TxnRef"));
                   request.setAttribute("InfoPayment","Payment Cancel");
                   try {
   					dao.UpdatePaymentStatus("cancel",Integer.parseInt(request.getParameter("vnp_TxnRef")));
   				} catch (SQLException e) {
   					e.printStackTrace();
   				}
               }
               else {
            	   request.setAttribute("code", request.getParameter("vnp_TxnRef"));
            	   request.setAttribute("InfoPayment","Payment error");
            	   try {
      					dao.UpdatePaymentStatus("error",Integer.parseInt(request.getParameter("vnp_TxnRef")));
      				} catch (SQLException e) {
      					e.printStackTrace();
      				}
               }
               request.getRequestDispatcher(THANKYOU_PAGE).forward(request, response);
           } 
	}
}
