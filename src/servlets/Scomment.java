package servlets;

  
	
	import java.io.IOException;
	import java.sql.SQLException;
	import java.util.Date;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import db.Commentdb;

	/**
	 * Servlet implementation class StudentServlet
	 */
	//@WebServlet("/Scomment")
	public class Scomment extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Scomment() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
			String commentid= request.getParameter("commentid");
			String contentid=request.getParameter("contentid");
			String userid = request.getParameter("userid");
			String commenttext = request.getParameter("commentText");
			String commentdate=request.getParameter("commentDate");
			
			
		
			
			Commentdb c = new Commentdb();
			try {
				c.savecomment(commentid,contentid,userid,commenttext,commentdate);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}



