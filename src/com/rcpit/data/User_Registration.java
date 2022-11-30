package com.rcpit.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_Registration
 */
public class User_Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Registration() {
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
		int uid=0;
		String u_Name =request.getParameter("urname");
		String u_Email=request.getParameter("uremail");
		String u_mobile=request.getParameter("urmob");
		String u_pass=request.getParameter("urpass");
		String u_city=request.getParameter("urcity");
		
		try
		{
			Connection con=connectDB.connect();
			PreparedStatement p1=con.prepareStatement("insert into user_register_table values(?,?,?,?,?,?)");
			p1.setInt(1,uid );
			p1.setString(2, u_Name);
			p1.setString(3, u_Email);
			p1.setString(4, u_mobile);
			p1.setString(5, u_pass);
			p1.setString(6, u_city);             
			int i=p1.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("userlogin.html");
			}
			else
			{
				response.sendRedirect("404.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		
	}

}
