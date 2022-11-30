package com.rcpit.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		
		
		String u_email=request.getParameter("uemail");	
		String u_pass=request.getParameter("upassword");	
		int u_id=0;
		try
		{
			Connection con=connectDB.connect();
			PreparedStatement p1=con.prepareStatement("select * from  user_register_table where user_email=? and user_password=?");
			p1.setString(1, u_email);
			p1.setString(2 ,u_pass);
            ResultSet rs=p1.executeQuery();
			
			if(rs.next())
			{
				response.sendRedirect("user_dashboard3.html");
			}
			else
			{
				response.sendRedirect("404.html");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			
		}
	}

}
