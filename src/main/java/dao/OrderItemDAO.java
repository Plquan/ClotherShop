package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.OrderItemDTO;
import ultils.DbContext;

public class OrderItemDAO extends DbContext {
	private static final String ADD_ORDER_ITEM = "INSERT INTO  orderitem (id, productId,orderId,quantity,price) VALUES (?,?,?,?,?)";

	public void AddOrderItem(OrderItemDTO dto) {
		 Connection con = null;
	        PreparedStatement ptm = null;
	        try {
	            con = getConnection();
	            if (con != null) {
	                ptm = con.prepareStatement(ADD_ORDER_ITEM);
	                ptm.setInt(1, dto.id);
	                ptm.setInt(2, dto.productId);
	                ptm.setInt(3, dto.orderId);
	                ptm.setInt(4, dto.quantity);
	                ptm.setDouble(5, dto.price);	                         
	                ptm.executeUpdate();       
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }	        
	}
	

}
