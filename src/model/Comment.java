package model;

public class Comment {
   int comment_id;
   public int getComment_id() {
	return comment_id;
}
public void setComment_id(int comment_id) {
	this.comment_id = comment_id;
}
public int getContent_id() {
	return content_id;
}
public void setContent_id(int content_id) {
	this.content_id = content_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getComment_text() {
	return comment_text;
}
public void setComment_text(String comment_text) {
	this.comment_text = comment_text;
}
public String getComment_date() {
	return comment_date;
}
public void setComment_date(String comment_date) {
	this.comment_date = comment_date;
}
int content_id;
   int user_id;
   String comment_text;
   String comment_date;
}
