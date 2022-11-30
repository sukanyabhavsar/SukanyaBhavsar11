package com.rcpit.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB
{

		static Connection con=null;
		public static Connection connect()
		{
			try
			{
				if(con == null)
				{
					Class.forName("com.mysql.jdbc.Driver");
					//System.out.println("Driver loaded");
				    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/blackspot","root","");
				    //System.out.println("Connection established....");
			     }
			}
			catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
			return con;
			
		}
		

}
