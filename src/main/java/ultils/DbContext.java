package ultils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbContext {
	private static String url = "jdbc:mysql://localhost:3306/tmdt?useSSL=false&serverTimezone=UTC";
	public Connection getConnection() {
	    Connection c = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        c = DriverManager.getConnection(url, "root", "");
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return c;
	}
	
	  
}

