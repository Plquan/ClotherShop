package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CategoryDTO;
import model.ProductDTO;
import ultils.DbContext;

public class ProductDAO  extends DbContext{
	 private static final String GET_DATA = "SELECT * FROM Products";
	    private static final String GET_TOTAL_PRODUCTS = "SELECT * FROM Products";
	    private static final String GET_QUANTITY_SOLD = "SELECT SUM(unitSold) AS Total from Products";
	    private static final String GET_STOCK = "SELECT stock AS Total FROM Products WHERE id = ?";
	    private static final String GET_PRODUCTS_BY_ID = "SELECT * FROM Products WHERE id = ?";
	    private static final String GET_PRODUCTS_BY_TYPE_ID = "SELECT * FROM Products WHERE typeid = ? AND status = 1";
	    private static final String GET_PRODUCTS_BY_SEARCH = "SELECT * FROM Products WHERE productname LIKE ? AND status = 1";
	    private static final String UPDATE_QUANTITY_PRODUCT = "UPDATE Products SET [stock] = ? WHERE id = ?";
	    private static final String INSERT_PRODUCT = "INSERT INTO products(name,categoryId,description,image,price,stock,status) VALUES (?,?,?,?,?,?,?)";
		private static final String DELETE_PRODUCT = "DELETE FROM Products WHERE id = ?";
	    private static final String UPDATE_PRODUCT = "UPDATE Products SET name = ?, categoryId = ?, description = ?,"
				+ " image = ?,price = ?,stock = ?,status = ? WHERE id = ?";

	    public List<ProductDTO> getAll() throws SQLException {
	        List<ProductDTO> products = new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        ResultSet rs = null;
	            conn = getConnection();
	            if (conn != null) {
	                ptm = conn.prepareStatement(GET_TOTAL_PRODUCTS);
	                rs = ptm.executeQuery();
	                while (rs.next()) {
	                    String name = rs.getString("name");
	                    int id = rs.getInt("id");	     
	                    int categoryId = rs.getInt("categoryId");	
	                    String description = rs.getString("description");
	                    double price = rs.getDouble("price");
	                    String status = rs.getString("status");                 
	                    String image = rs.getString("image");
	                    int stock = rs.getInt("stock");
	                    ProductDTO product = new ProductDTO(id, name,categoryId, description, image, price,stock,status);
	                    products.add(product);
	                }
	            }
	        return products;
	    }
	    
	    public void addProduct(ProductDTO product) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ptm = null;
	        conn = getConnection();
	        if(conn != null) {
	         ptm = conn.prepareStatement(INSERT_PRODUCT);
	                ptm.setString(1, product.getName());
	                ptm.setInt(2, product.getCategoryId());
	                ptm.setString(3, product.getDescription());            
	                ptm.setString(4, product.getImage());
	                ptm.setDouble(5, product.getPrice());
	                ptm.setInt(6,product.getStock());
	                ptm.setString(7, product.getStatus());
	                ptm.executeUpdate();
	        }	
	    }
	   
	     public ProductDTO getById(int pid) throws SQLException {
	        	  ProductDTO dto = null;
	              Connection conn = null;
	              PreparedStatement ptm = null;
	              ResultSet rs = null;
	                  conn = getConnection();
	                  if (conn != null) {
	                      ptm = conn.prepareStatement(GET_PRODUCTS_BY_ID);
	                      ptm.setInt(1, pid);
	                      rs = ptm.executeQuery();
	                      while (rs.next()) {                
	                          int id = rs.getInt("id");
	                          String name = rs.getString("name");
	                          String description = rs.getString("description");
	                          Double price = rs.getDouble("price");
	                          int categoryId = rs.getInt("categoryId");
	                          String status = rs.getString("status");
	                          String image = rs.getString("image");
	                          int stock = rs.getInt("stock");
	                          dto = new ProductDTO(id,name,categoryId,description,image,price,stock,status);
	                      }
	                  }
	              return dto;
	        }
	    
	     public void editProduct(ProductDTO product) throws SQLException {
	            Connection conn = null;
	            PreparedStatement ptm = null;
	                conn = getConnection();
	                if (conn != null) {
	                    ptm = conn.prepareStatement(UPDATE_PRODUCT);     
	                    ptm.setString(1, product.name);
	                    ptm.setInt(2, product.categoryId);
	                    ptm.setString(3, product.description);
	                    ptm.setString(4, product.image);
	                    ptm.setDouble(5, product.price);
	                    ptm.setInt(6, product.stock);
	                    ptm.setString(7, product.status);
	                    ptm.setInt(8, product.id);	                    
	                    ptm.executeUpdate();
	                }
	        }
	        
	        public void deleteProduct(int pid) throws SQLException {
	        	  Connection conn = null;
	              PreparedStatement ptm = null;
	                  conn = getConnection();
	                  if (conn != null) {
	                      ptm = conn.prepareStatement(DELETE_PRODUCT);
	                      ptm.setInt(1, pid);
	                      ptm.executeUpdate();
	                  }
	        }
	     
}
