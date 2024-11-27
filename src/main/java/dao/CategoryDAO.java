package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CategoryDTO;
import ultils.DbContext;

public class CategoryDAO extends DbContext {
	private static final String GETDATA = "SELECT * FROM Categories";
	private static final String GET_QUANTITY_BY_NAME = "SELECT COUNT(*) AS Total FROM Categories WHERE categoryname = ?";
	private static final String GET_CATEGORY_BY_ID = "SELECT * FROM Categories WHERE categoryid = ?";
	private static final String INSERT_CATEGORY = "INSERT INTO Categories (categoryname) VALUES (?)";
	private static final String DELETE_CATEGORY = "DELETE FROM Categories WHERE categoryid = ?";
	private static final String UPDATE_CATEGORY = "UPDATE Categories SET  categoryname = ? WHERE categoryid = ?";

	public List<CategoryDTO> getData() throws SQLException {
		List<CategoryDTO> categories = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ptm = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			if (conn != null) {
				ptm = conn.prepareStatement(GETDATA);
				rs = ptm.executeQuery();
				while (rs.next()) {
					int categoryId = rs.getInt("categoryid");
					String categoryName = rs.getString("categoryname");
					categories.add(new CategoryDTO(categoryId, categoryName));
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
		return categories;
	}
	
    public CategoryDTO getCategoryById(int id) throws SQLException {
        CategoryDTO category = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CATEGORY_BY_ID);
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {                
                    int categoryId = rs.getInt("categoryid");
                    String categoryName = rs.getString("categoryname");
                    category = new CategoryDTO(categoryId, categoryName);
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
        return category;
    }
	
    public boolean insertCategory(String categoryName) {
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = getConnection();
            if (con != null) {
                ptm = con.prepareStatement(INSERT_CATEGORY);
                ptm.setString(1, categoryName);
                ptm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void deleteCategory(String cid) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_CATEGORY);
                ptm.setString(1, cid);
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

    public void editCategory( String id,String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_CATEGORY);     
                ptm.setString(1, name);
                ptm.setString(2, id);
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
