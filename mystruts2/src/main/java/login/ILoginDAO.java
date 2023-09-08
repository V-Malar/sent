package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Result;

import connectionutility.ConnectionUtility;

public class ILoginDAO implements ILogin {
	PreparedStatement ps;
	ResultSet rs;


	@Override
	public void updateLogin(LoginDTO login) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/vastpro","root","Gs#ry!@99"); 
			ps = con.prepareStatement("insert into login values(?,?)");
			ps.setString(1, login.getEmail());
			ps.setString(2, login.getPassword());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
