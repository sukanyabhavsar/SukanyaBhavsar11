package com.rcpit.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcpit.data.connectDB;

/**
 * Servlet implementation class Add_Police_Station
 */
public class Add_Police_Station extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Police_Station() {
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
		
		int sid=0;
		String S_Name =request.getParameter("sname");
		String S_Address=request.getParameter("add");
		String S_contct=request.getParameter("cont");
		String S_Email=request.getParameter("emaill");
		String S_pass=request.getParameter("pass");
		
		try
		{
			Connection con=connectDB.connect();
			PreparedStatement p1=con.prepareStatement("insert into add_view_delete_t values(?,?,?,?,?,?)");
			p1.setInt(1,sid );
			p1.setString(2, S_Name);
			p1.setString(3, S_Address);
			p1.setString(4, S_contct);
			p1.setString(5, S_Email);
			p1.setString(6, S_pass);
			int i=p1.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("dashboard.html");
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
