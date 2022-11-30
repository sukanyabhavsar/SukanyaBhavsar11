package com.rcpit.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcpit.data.connectDB;

/**
 * Servlet implementation class LoginS
 */
public class LoginS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginS() {
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
		
		String email=request.getParameter("email");	
		String pass=request.getParameter("password");	
		
		try
		{
			Connection con=connectDB.connect();
			PreparedStatement p1=con.prepareStatement("select * from login_table where L_Email=? and L_Password=? ");
			p1.setString(1, email);
			p1.setString(2, pass);
            ResultSet rs=p1.executeQuery();
			
			if(email.equals("Sukanya@gmail.com") && pass.equals("1105"))
			{
				response.sendRedirect("dashboard.html");
			}
			else
			{
				response.sendRedirect("login.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
		

}
