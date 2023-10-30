package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Categorydb {
	public void savecategory(String categoryid, String categoryname) throws SQLException, ClassNotFoundException {
		Connection con = Cmsdb.getconnection();
		PreparedStatement ps = con.prepareStatement("insert into category value(?,?)");
		  
		ps.setInt(1, Integer.parseInt(categoryid));
		ps.setString(2, categoryname);
		
		 ps.execute();
		  con.close();
}}