package com.tcs.DatabaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tcs.Constants.OracleDatabaseConstants;



public class OracleDatabaseUtil {

	
	   public static Connection getConnection(){
		   
		   Connection con = null;
		   
            try {
				Class.forName(OracleDatabaseConstants.DRIVER_NAME);
				   
			    con =  DriverManager.getConnection(OracleDatabaseConstants.URL, OracleDatabaseConstants.USERNAME, OracleDatabaseConstants.PASSWORD);
				
			  
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		   
		   //Use Driver Manager to establish connection
		 
		   return con;
		   
	   }
	   
	   public static void closeConnection(Connection con){
		   if(con!=null){
			   try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
	   }

}
