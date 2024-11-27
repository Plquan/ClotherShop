package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserDTO;
import ultils.DbContext;

public class UserDAO extends DbContext {
	
	 private static final String LOGIN = "SELECT * FROM Users WHERE (username=? OR email = ?) AND password=? and status=1";

	    private static final String GET_DATA = "SELECT * FROM Users WHERE status = 1 Order by roleid asc";

	    private static final String GET_USER_BY_NAME = "SELECT * FROM Users WHERE username = ? AND status = 1";

	    private static final String GET_USER_BY_EMAIL = "SELECT * FROM Users WHERE email = ? AND status = 1";
	    
	    private static final String GET_USER_BY_ID = "SELECT * FROM Users WHERE id = ? AND status = 1";

	    private static final String GET_TOTAL_USERS = "SELECT COUNT(*) AS Total FROM Users WHERE status = 1 AND roleid=2";

	    private static final String UPDATE_USER = "UPDATE Users SET email = ?, address = ?, phone = ?, avatar = ?, roleid = ?,userName = ? WHERE id = ?";

	    private static final String UPDATE_PASSWORD_FOR_USER = "UPDATE Users SET password = ? WHERE username = ?";

	    private static final String CHECK_EMAIL_DUPLICATE = "SELECT * FROM Users WHERE email = ? and `status` = 1";

	    private static final String DELETE_USER = "UPDATE Users SET status = 0 WHERE id = ?";
	    
	    private static final String REGISTER_USER = "INSERT INTO Users "
	            + "(email, avatar, username, password, address, phone, roleid, status) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    

	  
	    public List<UserDTO> getData() throws SQLException {
	        List<UserDTO> users = new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	        try {
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(GET_DATA);
	                rs = ptm.executeQuery();
	                while (rs.next()) {
	                    int id = rs.getInt("id");
	                    String email = rs.getString("email");
	                    String avatar = rs.getString("avatar");
	                    String userName = rs.getString("username");
	                    String password = rs.getString("password");
	                    String address = rs.getString("address");
	                    String phone = rs.getString("phone");
	                    int roleId = rs.getInt("roleId");
	                    boolean status = rs.getBoolean("status");
	                    users.add(new UserDTO(id, email, avatar, userName, password, address, phone, roleId, status));
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ptm != null) {
	                ptm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        return users;
	    }
	    
	    public int getTotalUsers() throws SQLException {
	        int result = 0;
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	        try {
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(GET_TOTAL_USERS);
	                rs = ptm.executeQuery();
	                while (rs.next()) {
	                    result = rs.getInt("Total");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ptm != null) {
	                ptm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        return result;
	    }
	    
	    public UserDTO checkLogin(String userName, String password) throws SQLException {
	        UserDTO user = null;
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	        try {
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(LOGIN);
	                ptm.setString(1, userName);
	                ptm.setString(2, userName);
	                ptm.setString(3, password);
	                rs = ptm.executeQuery();
	                if (rs.next()) {
	                    int id = rs.getInt("id");
	                    String email = rs.getString("email");                    
	                    String userNamee = rs.getString("userName");
	                    String avatar = rs.getString("avatar");
	                    String address = rs.getString("address");
	                    String phone = rs.getString("phone");
	                    int roleid = rs.getInt("roleID");
	                    boolean roleID = rs.getBoolean("roleID");
	                    user = new UserDTO(id, email, avatar, userNamee, password, address, phone, roleid, roleID);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ptm != null) {
	                ptm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        return user;
	    }
    
	    public void registerUser(UserDTO user) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	        try {
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(REGISTER_USER);
	                ptm.setString(1, user.getEmail());
	                ptm.setString(2, user.getAvatar());
	                ptm.setString(3, user.getUserName());
	                ptm.setString(4, user.getPassword());
	                ptm.setString(5, user.getAddress());
	                ptm.setString(6, user.getPhone());
	                ptm.setInt(7, user.getRoleID());
	                ptm.setBoolean(8, user.isStatus());
	                ptm.executeUpdate();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ptm != null) {
	                ptm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	    }
	    
	    public void deleteUser(String uid) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	        try {
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(DELETE_USER);
	                ptm.setString(1, uid);
	                ptm.executeUpdate();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ptm != null) {
	                ptm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	    }
	        
	    public boolean checkEmailDuplicate(String email) throws SQLException {
	        boolean ok = false;
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	        try {
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(CHECK_EMAIL_DUPLICATE);
	                ptm.setString(1, email);
	                rs = ptm.executeQuery();
	                if (rs.next()) {
	                    ok = true;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ptm != null) {
	                ptm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        return ok;
	    }
	    
	    public UserDTO getUserByName(String userName) throws SQLException {
	        UserDTO user = null;
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	        try {
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(GET_USER_BY_NAME);
	                ptm.setString(1, userName);
	                rs = ptm.executeQuery();
	                while (rs.next()) {
	                    int id = rs.getInt("id");
	                    String email = rs.getString("email");
	                    String avatar = rs.getString("avatar");
	                    String address = rs.getString("address");
	                    String password = rs.getString("password");
	                    String phone = rs.getString("phone");
	                    int roleid = rs.getInt("roleID");
	                    boolean roleID = rs.getBoolean("roleID");
	                    user = new UserDTO(id, email, avatar, userName, password, address, phone, roleid, roleID);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ptm != null) {
	                ptm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        return user;
	    }
	    
	    public UserDTO getUserById(int userId) throws SQLException {
	        UserDTO user = null;
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	        try {
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(GET_USER_BY_ID);
	                ptm.setInt(1, userId);
	                rs = ptm.executeQuery();
	                while (rs.next()) {
	                    int id = rs.getInt("id");
	                    String userName = rs.getString("userName");
	                    String email = rs.getString("email");
	                    String avatar = rs.getString("avatar");
	                    String address = rs.getString("address");
	                    String password = rs.getString("password");
	                    String phone = rs.getString("phone");
	                    int roleid = rs.getInt("roleID");
	                    boolean roleID = rs.getBoolean("roleID");
	                    user = new UserDTO(id, email, avatar, userName, password, address, phone, roleid, roleID);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ptm != null) {
	                ptm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        return user;
	    }
	    
	    public void updateUser(int id,String email, String address, String phone, String userName, String avatar, int roleId) throws SQLException {
	        UserDTO user = null;
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	        try {
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(UPDATE_USER);
	                ptm.setString(1, email);
	                ptm.setString(2, address);
	                ptm.setString(3, phone);
	                ptm.setString(4, avatar);
	                ptm.setInt(5, roleId);
	                ptm.setString(6, userName);
	                ptm.setInt(7, id);
	                ptm.executeUpdate();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ptm != null) {
	                ptm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	    }
}
