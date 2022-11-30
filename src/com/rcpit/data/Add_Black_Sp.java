package com.rcpit.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add_Black_Sp
 */
public class Add_Black_Sp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Black_Sp() {
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
		int aid=0;
		String a_Name =request.getParameter("lname");
		String a_Address=request.getParameter("ladd");
		String a_reasonT=request.getParameter("rt");
		int a_lati=Integer.parseInt(request.getParameter("lati"));
		int a_log=Integer.parseInt(request.getParameter("log"));
		int a_level=Integer.parseInt(request.getParameter("lev"));;
		String a_city=request.getParameter("city");
		
		try
		{
			Connection con=connectDB.connect();
			PreparedStatement p1=con.prepareStatement("insert into add_spot values(?,?,?,?,?,?,?,?)");
			p1.setInt(1,aid);
			p1.setString(2, a_Name);
			p1.setString(3, a_Address);
			p1.setString(4, a_reasonT);
			p1.setInt(5, a_lati);
			p1.setInt(6, a_log);
			p1.setInt(7, a_level);
			p1.setString(8, a_city);
			int i=p1.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("police_dashboard2.html");
			}
			else
			{
				response.sendRedirect("404.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.out.println(e);
		}
		
		
		
	}

}
