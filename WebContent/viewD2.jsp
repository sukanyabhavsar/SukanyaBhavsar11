<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%@page import="com.rcpit.data.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		int id=Integer.parseInt(request.getParameter("id"));
		
		try
		{
			 Connection con=connectDB.connect();
			 PreparedStatement p1 = con.prepareStatement("delete from add_spot where L_id=?");
			 p1.setInt(1,id);
     		 int rs=p1.executeUpdate();
     		 
     		 if(rs>0)
     		 {	
     			response.sendRedirect("View_Add_Spot.jsp");
     			 
     		 }
     		 else
     		 {
     			response.sendRedirect("police_dashboard2.html");
     		 }
     		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
%>
</body>
</html>