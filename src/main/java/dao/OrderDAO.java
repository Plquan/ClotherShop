package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OrderDTO;
import model.ProductDTO;
import ultils.DbContext;

public class OrderDAO extends DbContext{
	private static final String CREATE_ORDER = "INSERT INTO orders(id, code,userName,email,phone,address, note,totalPrice,createdAt,paymentMethod,paymentStatus,status)"
			+" VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?)";
	private static final String GET_ORDER_BY_CODE = "select * from orders where code = ?";
	private static final String DELETE_ORDER = "DELETE FROM orders WHERE id = ?";
	private static final String UPDATE_PAYMENTSTATUS = "UPDATE orders SET paymentStatus = ? WHERE id = ?";
	private static final String GET_ALL = "select * from orders";
	private static final String UPDATE_STATUS = "UPDATE orders SET status = ? WHERE id = ?";
	private static final String UPDATE_STOCK = "UPDATE products p join orderitem o on o.productId = p.id\r\n"
			+ "set p.stock = o.quantity + p.stock\r\n"
			+ "where o.orderId = ?";
	
	public String CreateOrder(OrderDTO dto) {
		  Connection con = null;
	        PreparedStatement ptm = null;
	        try {
	            con = getConnection();
	            if (con != null) {
	                ptm = con.prepareStatement(CREATE_ORDER);
	                ptm.setInt(1, dto.id);
	                ptm.setString(2, dto.code);
	                ptm.setString(3, dto.userName);
	                ptm.setString(4, dto.email);
	                ptm.setString(5, dto.phone);
	                ptm.setString(6, dto.address);
	                ptm.setString(7, dto.note);
	                ptm.setDouble(8, dto.totalPrice);
	                ptm.setDate(9, dto.createdAt);
	                ptm.setString(10, dto.paymentMethod);
	                ptm.setString(11, dto.paymentStatus);
	                ptm.setString(12, dto.status);                
	                ptm.executeUpdate();       
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dto.code;
	}
	public OrderDTO GetOrderByCode(String ccode) {
		    Connection con = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	        OrderDTO dto = null;
	        try {
	            con = getConnection();
	            if (con != null) {
	                ptm = con.prepareStatement(GET_ORDER_BY_CODE);
	                ptm.setString(1, ccode);            
	                rs = ptm.executeQuery();   
	                while (rs.next()) {                
	                    int id = rs.getInt("id");	
	                    String code = rs.getString("code");
	                    String userName = rs.getString("userName");
	                    String email = rs.getString("email");
	                    String phone = rs.getString("phone");
	                    String address = rs.getString("address");
	                    String note = rs.getString("note");
	                    Double totalPrice = rs.getDouble("totalPrice");
	                    Date createdAt = rs.getDate("createdAt");
	                    String status = rs.getString("status");
	                    String paymentMethod = rs.getString("paymentMethod");
	                    String paymentStatus = rs.getString("paymentStatus");
	                     dto = new OrderDTO(id,code,userName,email,phone,address,note,totalPrice,createdAt,paymentMethod,paymentStatus,status);                    
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dto;
	}
	
	public void DeleteOrder(int oid) throws SQLException {
		 Connection conn = null;
	        PreparedStatement ptm = null;
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(DELETE_ORDER);
	                ptm.setInt(1, oid);
	                ptm.executeUpdate();
	            }
	}

    public void UpdatePaymentStatus(String status,int pId) throws SQLException {
    	 Connection conn = null;
         PreparedStatement ptm = null;
             conn = getConnection();
             if (conn != null) {
                 ptm = conn.prepareStatement(UPDATE_PAYMENTSTATUS);     
                 ptm.setString(1, status);
                 ptm.setInt(2, pId);
                 ptm.executeUpdate();
             }
	        
    }
    public boolean UpdateStatus(String status,int pId) throws SQLException {
   	 Connection conn = null;
        PreparedStatement ptmstatus = null;
        PreparedStatement ptmstock = null;
            conn = getConnection();
            if (conn != null) {
            	
            	if("cancelled".equals(status)) {
            		ptmstock = conn.prepareStatement(UPDATE_STOCK);    
            		ptmstock.setInt(1, pId);
            		ptmstock.executeUpdate();
            	}
            	ptmstatus = conn.prepareStatement(UPDATE_STATUS);     
            	ptmstatus.setString(1, status);
            	ptmstatus.setInt(2, pId);
            	ptmstatus.executeUpdate();
                return true;
            }
            else {
            	return false;
            }     
   }

    public List<OrderDTO> getAll() throws SQLException {
        List<OrderDTO> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL);
                rs = ptm.executeQuery();
                while (rs.next()) {             
                    int id = rs.getInt("id");	     
                    String code = rs.getString("code");
                    String userName = rs.getString("userName");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    String note = rs.getString("note");
                    Double totalPrice = rs.getDouble("totalPrice");
                    Date createdAt = rs.getDate("createdAt");
                    String paymentMethod = rs.getString("paymentMethod");
                    String paymentStatus = rs.getString("paymentStatus");
                    String status = rs.getString("status");
                    
                    OrderDTO dto = new OrderDTO(id,code,userName,email,phone,address,note,totalPrice,createdAt,paymentMethod,paymentStatus,status);
                    orders.add(dto);
                }
            }
        return orders;
    }



}
