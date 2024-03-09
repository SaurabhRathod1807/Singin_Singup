package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Singupdata
 */
@WebServlet("/Singupdata")
public class Singupdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Singupdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	try {
		PrintWriter	w=response.getWriter();
		String us = request.getParameter("name1");
		String ps = request.getParameter("pass1");
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Singin", "root", "root");
		PreparedStatement st= c.prepareStatement("insert into user values(?,?)");
		st.setString(1, us);
		st.setString(2, ps);
		int rs=st.executeUpdate();
		
		if(rs >0) {
			response.setContentType("text/html");
			w.println("<h3>User successfully Singup!</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/Singinpage.jsp");
			rd.include(request, response);
		}
		else {
			response.setContentType("text/html");
			w.println("<h3>User Not Singup!</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/Singup.jsp");
			rd.include(request, response);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
