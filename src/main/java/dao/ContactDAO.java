package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CategoryDTO;
import model.ContactDTO;
import ultils.DbContext;

public class ContactDAO extends DbContext {

	private final String GET_ALL = "select * from contact";
	private static final String INSERT = "INSERT INTO contact (name,email,phone,message,status) VALUES (?,?,?,?,?)";
	private static final String DELETE= "DELETE FROM contact WHERE id = ?";
	private static final String UPDATE = "UPDATE contact SET name = ? WHERE id = ?";
	private static final String GET_BY_ID = "SELECT * FROM contact WHERE id = ?";
	private static final String UPDATE_STATUS = "UPDATE contact SET status = ? WHERE id = ?";
	
	public List<ContactDTO> GetAll() throws SQLException{
		List<ContactDTO> contacts = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ptm = null;
		ResultSet rs = null;
			conn = getConnection();
			if (conn != null) {
				ptm = conn.prepareStatement(GET_ALL);
				rs = ptm.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					String message = rs.getString("message");
					String status = rs.getString("status");				
					contacts.add(new ContactDTO(id,name,email,phone,message,status));
				}
			}
		return contacts;
	}
	
	public boolean CreateContact(ContactDTO model) {
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = getConnection();
            if (con != null) {
                ptm = con.prepareStatement(INSERT);
                ptm.setString(1, model.name);
                ptm.setString(2, model.email);
                ptm.setString(3, model.phone);
                ptm.setString(4, model.message);
                ptm.setString(5, model.status);
                ptm.executeUpdate();                       
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
	}
	
    public ContactDTO getContactById(int id) throws SQLException {
    	ContactDTO contact = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_BY_ID);
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {                
                    int cid = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String message = rs.getString("message");
                    String status = rs.getString("status");
                    contact = new ContactDTO(cid, name,email,phone,message,status);
                }
            }
        return contact;
    }
    
       public void updateStatus(String status,int id) throws SQLException {
    	   Connection conn = null;
           PreparedStatement ptm = null;
           conn = getConnection();
           if (conn != null) {
               ptm = conn.prepareStatement(UPDATE_STATUS);
               ptm.setInt(2, id);
               ptm.setString(1, status);
               ptm.executeUpdate();
           }
       }
	
}
