package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Commentdb {
	public void savecomment(String commentid, String contentid, String userid, String commenttext, String commentdate) throws SQLException, ClassNotFoundException {
		Connection con = Cmsdb.getconnection();
		PreparedStatement ps = con.prepareStatement("insert into comment value(?,?,?,?,?)");
		  
		ps.setInt(1, Integer.parseInt(commentid));
		ps.setInt(2, Integer.parseInt(contentid));
		ps.setInt(3, Integer.parseInt(userid));
		ps.setString(4, commenttext);
		ps.setString(5, commentdate);
		 ps.execute();
		  con.close();
}}
