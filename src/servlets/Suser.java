package servlets;

  
	import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
	import java.util.Date;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.Userdb;

	/**
	 * Servlet implementation class StudentServlet
	 */
	//@WebServlet("/Suser")
	public class Suser extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Suser() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub\
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			Userdb u = new Userdb();
			try {
				Gson gson = new Gson();

				

				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				
				out.flush();
				int userid = u.authkUser(email, password);
				String respose = gson.toJson(userid);
				if (userid == 0) {
					
					out.print(respose);
				}else {
					out.print("user is not vailid");
				}
					
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
     		String userid= request.getParameter("UserId");
			String password=request.getParameter("password");
			String username = request.getParameter("username");
			String profilepicture = request.getParameter("ProfilePicture");
			String email=request.getParameter("email");
			String userrole= request.getParameter("user_role");
			
			
			Userdb u = new Userdb();
			try {
			if (!u.checkUser(email)) {

				u.saveuser(userid, password, username, profilepicture, email, userrole);
				response.getWriter().append("Saved success: ").append(request.getContextPath());
			}else {
				response.getWriter().append("Usser may already exist: ");
			}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}





