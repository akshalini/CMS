package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import db.Contentdb;
import model.Content;

/**
 * Servlet implementation class StudentServlet
 */
// @WebServlet("/Scontent")
public class Scontent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Scontent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		Contentdb s = new Contentdb();
		try {
			ArrayList<Content> list = s.showcontent();
			Gson gson = new Gson();

			String employeeJsonString = gson.toJson(list);

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(employeeJsonString);
			out.flush();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String imagePath = "D:\\javaPrograms\\CMS\\WebContent\\images\\" ;
		MultipartRequest m = new MultipartRequest(request, imagePath, 99999999 );
		String title = m.getParameter("title");
		String content = m.getParameter("content");
		String authorid = m.getParameter("author_id");
		
		Contentdb s = new Contentdb();
		try {
			s.savecontent(title, content, authorid ,"\\images\\"+m.getFilesystemName("file"));
			response.sendRedirect("index.html");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
