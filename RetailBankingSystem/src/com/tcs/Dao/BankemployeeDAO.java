package com.tcs.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.Constants.Queryconstants;
import com.tcs.DatabaseUtil.OracleDatabaseUtil;
import com.tcs.Exception.DataLayerException;
import com.tcs.Models.Login;




public class BankemployeeDAO {

	public BankemployeeDAO() {
		// TODO Auto-generated constructor stub
	}

	
	public boolean checkUser(Login login) throws DataLayerException
	{
		
		boolean flag1=false;
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.GET_USERNAME_PASSWORD);
			ps.setString(1,login.getUsername());
			ps.setString(2,login.getPassword());
			

			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				System.out.println("welcome:"+rs.getString(1));
			         if(rs.getString(1).equals(login.getUsername()) && rs.getString(2).equals(login.getPassword()))
					{
						flag1=true;
						break;
					}
			
			}	
						
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return flag1;
	}
	
	public boolean  BankEmployeeUserStore(Login login)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.BANK_EMPLOYEE_STORE);
			ps.setString(1,login.getUsername());
			ps.setString(2,login.getPassword());
			
			int rows=ps.executeUpdate();
			if(rows>0) 
			{
				flag=true;
			}	
						
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		return flag;
		
	}
	}
