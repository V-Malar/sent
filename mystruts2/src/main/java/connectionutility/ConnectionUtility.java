package connectionutility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {
	private ConnectionUtility() {

	}

	static String url, username, password;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/vastpro";
			username = "root";
			password = "Gs#ry!@99";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro", "root", "Gs#ry!@99");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	synchronized public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro", "root", "Gs#ry!@99");
		if (con == null) {
			con.setAutoCommit(false);
			return con;
		} else {
			return con;
		}
	}
}
