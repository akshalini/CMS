package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Userdb {

	public void saveuser(String userid, String username, String password, String profilepicture, String email,
			String userrole) throws SQLException, ClassNotFoundException {
		Connection con = Cmsdb.getconnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO user VALUES (?,?, ?, ?, ?)");
		ps.setInt(1, 0);
		ps.setString(2, username);
		ps.setString(3, password);
		// ps.setString(, profilepicture);
		ps.setString(4, email);
		ps.setString(5, userrole);
		ps.executeUpdate();
		con.close();
	}

	public boolean checkUser(String email) throws SQLException, ClassNotFoundException {
		Connection con = Cmsdb.getconnection();
		PreparedStatement ps = con.prepareStatement("SELECT Email FROM user where Email = ?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
 		boolean result = false;
 		 
 		
		if (rs.next() && rs.getString(1).equals(email))
			result = true;
        rs.close();
		con.close();
		return result;
	}
	
	public int authkUser(String email, String password) throws SQLException, ClassNotFoundException {
		Connection con = Cmsdb.getconnection();
		PreparedStatement ps = con.prepareStatement("SELECT Email,Password,idUser FROM user where Email = ? and Password ? ");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
 		int result =0;
 		 
 		
		if (rs.next() && rs.getString(1).equals(email) && rs.getString(2).equals(password))
			result = rs.getInt(3);
        rs.close();
		con.close();
		return result;
	}
}