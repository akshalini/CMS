package db;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;




public class Cmsdb {
	public static Connection getconnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmsdb", "root", "root");
        return con;
	}
	
}
