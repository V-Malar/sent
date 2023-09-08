package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connectionutility.ConnectionUtility;

public class IRegisterDAO implements IRegister {
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public void updateRegister(RegisterDTO register) {
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/vastpro";
			String username = "root";
			String password = "Gs#ry!@99";
			Connection con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("insert into register values(?,?,?,?)");
			ps.setString(2, register.getEmail());
			ps.setString(3, register.getPassword());
			ps.setString(1, register.getName());
			ps.setString(4, register.getAge());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
