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
 * Servlet implementation class Police_Station_Login
 */
public class Police_Station_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Police_Station_Login() {
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
		
		String p_email=request.getParameter("pemail");	
		String p_pass=request.getParameter("ppassword");	
		int p_id = 0;
		try
		{
			Connection con=connectDB.connect();
			PreparedStatement p1=con.prepareStatement("select * from  police_login_table where ps_email=? and ps_password=?");
			p1.setString(1, p_email);
			p1.setString(2, p_pass);
            ResultSet rs=p1.executeQuery();
			
			if(rs.next() )			
			{
				response.sendRedirect("police_dashboard2.html");
			}
			else
			{
				response.sendRedirect("404_2.html");			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
