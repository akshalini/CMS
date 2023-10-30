package model;

public class User {
   int userid;
   String username;
   String password;
   String Email;
   String user_role;
	
   public String getUser_role() {
	return user_role;
}
public void setUser_role(String user_role) {
	this.user_role = user_role;
}
public int getUserid() {
	return userid;   
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
   
}
