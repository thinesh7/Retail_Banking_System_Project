package com.tcs.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tcs.Constants.Queryconstants;
import com.tcs.DatabaseUtil.OracleDatabaseUtil;
import com.tcs.Exception.DataLayerException;
import com.tcs.Models.Account;
import com.tcs.Models.Accountstatus;
import com.tcs.Models.Customer;



public class AccountDAO {

	public AccountDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public String generateAccountId(){
		Connection con=null;
		PreparedStatement ps=null;
		StringBuffer sb=null;
		String accountid=null;
		try {
			
			sb=new StringBuffer("");
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.ACCOUNT_ID);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				int id=rs.getInt(1);
				sb.append(id);
				 accountid=sb.toString();
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return accountid;
		
	}
	
	
	
     public boolean accountRegister(Account acc) throws DataLayerException{
		
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement ps=null;
        String accountid=generateAccountId();
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.REG_ACCOUNT_CUSTID);
			ps.setString(1,accountid);
			ps.setString(2,acc.getCustid());
			ps.setString(3,acc.getAccounttype());
			ps.setDouble(4,acc.getDeposit());
			
			
			int rows=ps.executeUpdate();
			
			System.out.println(acc.getAccounttype());
			if(rows>0)
			{ 
			    flag=true;
			}
				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		if(!flag){
			throw new DataLayerException("Account not register Exception");
		}
		System.out.println("accountRegister"+flag);
		return flag;
		
	}

    public boolean checkaccountforCustid(String custid){
    	
          boolean flag=false;
		
		Connection con=null;
		PreparedStatement ps=null;
		try 
		{
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.GET_CUST_DETAILS_BYID);
			ps.setString(1,custid);
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next())
			{ 
			
				System.out.println(flag);
				flag=true;
				
			}
				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(flag);
		return flag;
		}
    
    public boolean checkAccounttype(Account acc){
    	boolean flag=false;
    	Connection con=null;
		PreparedStatement ps=null;
		try 
		{
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.CHECK_ACCOUNTTYPE);
			ps.setString(1,acc.getAccounttype());
			ps.setString(2,acc.getCustid());
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next())
			{ 
				String accounttype=rs.getString(1);
				if(accounttype.equals(acc.getAccounttype()))
				{
				flag=true;
				}
				
			}
				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(flag);
		return flag;
		
    }
    
    public List<Account> getAccountDetails(String custid){
    	boolean flag=false;
    	Connection con=null;
		PreparedStatement ps=null;
		List<Account> acclist=null;
		Account acc=null;
		try 
		{
			acclist=new ArrayList<>();
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.GET_CUST_DETAILS_BYID);
			ps.setString(1,custid);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next())
			{ 
				String accountid=rs.getString(1);
				String customerid=rs.getString(2);
				String accounttype=rs.getString(3);
				int deposit=rs.getInt(4);
				
				acc=new Account(accountid,customerid, accounttype, deposit);
				acclist.add(acc);
				
				
			}
				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(flag);
		return acclist;
		
    }
    public int checkBalanceExist(String accid)
    {
    
    	int balance=0;
   		Connection con=null;
   		PreparedStatement ps=null;
   		try 
   		{
   			con=OracleDatabaseUtil.getConnection();
   			ps=con.prepareStatement(Queryconstants.CHECK_BALANCE_ACCOUNTID);
   			ps.setString(1,accid);
   			ResultSet rs=ps.executeQuery();
   			
   			
   			if(rs.next())
   			{ 
   			
   				    balance=rs.getInt(1);
//   				System.out.println(flag);
//   				flag=true;
   				
   			}
   				

   		}catch (SQLException e) {
   			// TODO Auto-generated catch block
   			System.out.println(e.getMessage());
   		}

   		//System.out.println(flag);
   		return balance;

    	
    }
    
    public boolean deleteAccount(String accid)
    {
    	  boolean flag=false;
  		
  		Connection con=null;
  		PreparedStatement ps=null;
  		try 
  		{
  			con=OracleDatabaseUtil.getConnection();
  			ps=con.prepareStatement(Queryconstants.DELETE_BY_ACCOUNTID);
  			ps.setString(1,accid);
  			int rows=ps.executeUpdate();
  			
  			
  			if(rows>0)
  			{ 
  			
  				System.out.println(flag);
  				flag=true;
  				
  			}
  				

  		}catch (SQLException e) {
  			// TODO Auto-generated catch block
  			System.out.println(e.getMessage());
  		}

  		System.out.println(flag);
  		return flag;

    }
    
    public List<Account> getAccountDetailsbyAccountID(String accid){
    	boolean flag=false;
    	Connection con=null;
		PreparedStatement ps=null;
		List<Account> acclist=null;
		Account acc=null;
		try 
		{
			acclist=new ArrayList<>();
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.GET_ACCOUNT_DETAILS_ACCID);
			ps.setString(1,accid);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next())
			{ 
				String accountid=rs.getString(1);
				String customerid=rs.getString(2);
				String accounttype=rs.getString(3);
				int deposit=rs.getInt(4);
				
				acc=new Account(accountid,customerid, accounttype, deposit);
				acclist.add(acc);
				
				
			}
				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(flag);
		return acclist;
		
    }
    
 public boolean accountStatusRegister(Accountstatus acc) throws DataLayerException{
		
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement ps=null;
       
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.REG_ACCOUNT_STATUS);
			ps.setString(1,acc.getCustomerid());
			ps.setString(2,acc.getAccountid());
			ps.setString(3,acc.getAccounttype());
			ps.setString(4,acc.getStatus());
			ps.setString(5,acc.getMessage());
			
			
			int rows=ps.executeUpdate();
			
			
			if(rows>0)
			{ 
			
				
				flag=true;
			//	System.out.println("registerdao"+flag);
				System.out.println(acc.getAccounttype());
				
			}
				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		if(!flag){
			throw new DataLayerException("Account status not register Exception");
		}
		System.out.println(flag);
		return flag;
		
	}
 
 public Account getAccountDetailBYAccount(Account acc){
 	//boolean flag=false;
 	Connection con=null;
		PreparedStatement ps=null;

		Account account=null;
		try 
		{
		
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.GET_ACCOUNT_DETAILS_ACCOUNT);
			ps.setString(1,acc.getCustid());
			ps.setString(2,acc.getAccounttype());
			
			System.out.println("getAccountDetailBYAccount"+acc.getCustid());
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next())
			{ 
				String accountid=rs.getString(1);
				String customerid=rs.getString(2);
				String accounttype=rs.getString(3);
				int deposit=rs.getInt(4);
				
				account=new Account(accountid,customerid, accounttype, deposit);

				
				
			}
				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		//System.out.println(flag);
		return account;
		
 }

public Account getAccountDetailByAccountID(String accid) {
	
	Connection con=null;
	PreparedStatement ps=null;

	Account account=null;
	try 
	{
	
		con=OracleDatabaseUtil.getConnection();
		ps=con.prepareStatement(Queryconstants.GET_ACCOUNT_DETAILS_ACCID);
		ps.setString(1,accid);
		
		System.out.println("getAccountDetailByAccountid"+accid);
		ResultSet rs=ps.executeQuery();
		
		
		while(rs.next())
		{ 
			String accountid=rs.getString(1);
			String customerid=rs.getString(2);
			String accounttype=rs.getString(3);
			int deposit=rs.getInt(4);
			
			account=new Account(accountid,customerid, accounttype, deposit);

			
			
		}
			

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}

	//System.out.println(flag);
	return account;

	
}

public List<Accountstatus> viewAllAccountsatus() {

	
	List<Accountstatus> listaccountstatus=new ArrayList<>();
	Connection con=null;
	PreparedStatement ps=null;
	
	try {
		con=OracleDatabaseUtil.getConnection();
		ps=con.prepareStatement(Queryconstants.ALL_ACCOUNT_STATUS);
		
		ResultSet rs=ps.executeQuery();
		
		//System.out.println(cust.getId());
		
		while(rs.next()){
			
			String customerid=rs.getString(1);
			String accountid=rs.getString(2);
			String accounttype=rs.getString(3);
			String status=rs.getString(4);
			String message=rs.getString(5);
			String lastupdated=rs.getString(6);
			 Accountstatus accstatus=new Accountstatus(customerid, accountid, accounttype, status, message, lastupdated);
			 listaccountstatus.add(accstatus);
			
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	return listaccountstatus;

}

public List<Accountstatus> searchbyAccountidandAccounttype(String keyword) {
	
	
	List<Accountstatus> listaccountstatus=new ArrayList<>();
	Connection con=null;
	PreparedStatement ps=null;
	
	try {
		con=OracleDatabaseUtil.getConnection();
		ps=con.prepareStatement(Queryconstants.SEARCH_ACOUNT_ID_AND_TYPE);
		ps.setString(1,"%"+keyword+"%");
		ps.setString(2,"%"+keyword+"%");
		
		ResultSet rs=ps.executeQuery();
		
		//System.out.println(cust.getId());
		
		while(rs.next()){
			
			String customerid=rs.getString(1);
			String accountid=rs.getString(2);
			String accounttype=rs.getString(3);
			String status=rs.getString(4);
			String message=rs.getString(5);
			String lastupdated=rs.getString(6);
			 Accountstatus accstatus=new Accountstatus(customerid, accountid, accounttype, status, message, lastupdated);
			 listaccountstatus.add(accstatus);
			
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	return listaccountstatus;
}

public boolean depositAmount(String accountid,int amount) {
	
	Connection con=null;
	PreparedStatement ps=null;
	boolean flag=false;
	
	
	try {
		con=OracleDatabaseUtil.getConnection();
		ps=con.prepareStatement(Queryconstants.DEPOSIT_AMOUNT);
		ps.setInt(1,amount);
		ps.setString(2,accountid);
		
		  
		int rows=ps.executeUpdate();
		  
		if(rows>0)
		{
		
			flag=true;
			//System.out.println(c.getCustomername());
			
		}

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
	return flag;	
	}

public int getAmount(String accountid) {
	 
	Connection con=null;
	PreparedStatement ps=null;

	int amount=0;
	try 
	{
	
		con=OracleDatabaseUtil.getConnection();
		ps=con.prepareStatement(Queryconstants.GET_AMOUNT);
		ps.setString(1,accountid);
		
		System.out.println("getAmount"+accountid);
		ResultSet rs=ps.executeQuery();
		
		
		if(rs.next())
		{ 
			amount=rs.getInt(1);
		
         }
			

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}

	//System.out.println(flag);
	return amount;

	
	
}




    
    
    
    
}
