package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import model.Content;

public class Contentdb {
    
	public void savecontent( String title, String content, String authorid, String imagePath) throws SQLException, ClassNotFoundException {
		Connection con = Cmsdb.getconnection();
		PreparedStatement ps = con.prepareStatement("insert into content value(?,?,?,?,?,?)");
		  
		ps.setInt(1, 0);
		ps.setString(2, title);
		ps.setString(3, content);
		ps.setDate(4,  new Date(Calendar.getInstance().getTime().getTime()) );
		ps.setInt(5, Integer.parseInt(authorid));
		ps.setString(6, imagePath);
		 ps.executeUpdate();
		  con.close();
	}
	
	public ArrayList<Content> showcontent() throws SQLException, ClassNotFoundException {
		Connection con = Cmsdb.getconnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM cmsdb.content ORDER BY content_id DESC");
		ResultSet rs = ps.executeQuery(); 
		ArrayList<Content> contentLIst = new ArrayList<Content>();
		while(rs.next()) {
			Content cnt = new Content();
			cnt.setContent_id(rs.getInt(1));
			cnt.setTitle(rs.getString(2));
			cnt.setContent(rs.getString(3));
			cnt.setPublished_date(rs.getString(4));
			cnt.setAuthor_id(rs.getString(5));
			cnt.setImagePath(rs.getString(6));
			contentLIst.add(cnt);
		}  
		con.close();
		return contentLIst;
	}
}
