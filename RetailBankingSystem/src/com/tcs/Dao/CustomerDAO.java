package com.tcs.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tcs.Constants.Queryconstants;
import com.tcs.DatabaseUtil.OracleDatabaseUtil;
import com.tcs.Exception.CustomerIdAlreadyExistException;
import com.tcs.Exception.DataLayerException;
import com.tcs.Models.Account;
import com.tcs.Models.Customer;
import com.tcs.Models.CustomerandAccount;
import com.tcs.Models.Customerstatus;








public class CustomerDAO {

	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public String generateCustomerId(){
		Connection con=null;
		PreparedStatement ps=null;
		StringBuffer sb=null;
		String customerid=null;
		try {
			
			sb=new StringBuffer("CUST_");
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.CUSTOMER_ID);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				int id=rs.getInt(1);
				sb.append(id);
				 customerid=sb.toString();
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return customerid;
		
	}
	
	public boolean customerRegister(Customer cust) throws DataLayerException{
		
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement ps=null;
        String customerid=generateCustomerId();
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.REG_CUST);
			ps.setString(1,customerid);
			ps.setString(2,cust.getCustssnid());
			ps.setString(3,cust.getCustomername());
			ps.setInt(4,cust.getAge());
			ps.setString(5,cust.getAddressline1());
			ps.setString(6,cust.getAddressline2());
			ps.setString(7,cust.getState());
			ps.setString(8,cust.getCity());
			
			int rows=ps.executeUpdate();
			
			
			if(rows>0)
			{ 
			
				
				flag=true;
				System.out.println("registerdao"+flag);
				System.out.println(cust.getCustssnid());
				
			}
				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		if(!flag){
			throw new DataLayerException("Customer not register Exception");
		}
		System.out.println(flag);
		return flag;
		
	}
	
	public boolean deleteCustomerbyid(String custssnid) throws DataLayerException{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.DELETE_CUSTOMER);
			ps.setString(1,custssnid);
			int rows=ps.executeUpdate();
			
			//System.out.println(cust.getId());
			
			if(rows>0)
			{
				flag=true;
			}
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		if(!flag)
		{
			throw new DataLayerException("Customer has active accounts opened,can't delete this customer details");
		}
		return flag;
	
	}
	
	public List<Customer> viewAllcustomers(){
		List<Customer> listcustomer=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.ALL_CUSTOMERS);
			
			ResultSet rs=ps.executeQuery();
			
			//System.out.println(cust.getId());
			
			while(rs.next()){
				
				
				String custid=rs.getString(1);
				String custssnid=rs.getString(2);
				String customername=rs.getString(3);
				int age=rs.getInt(4);
				String addressline1=rs.getString(5);
				String addressline2=rs.getString(6);
				String state=rs.getString(7);
				String city=rs.getString(8);
				 Customer cust=new Customer(custid,custssnid, customername, age, addressline1, addressline2, state, city);
				 listcustomer.add(cust);
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return listcustomer;
	
	}
	public boolean checkCustomerbyId(String custid) throws CustomerIdAlreadyExistException
	{
		boolean flag=true;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.CHECK_CUSTOMER_ID);
			ps.setString(1,custid);
	
			 rs=ps.executeQuery();
			if(rs.next())
			{
				if((rs.getString(1)).equals(custid))
				{
					flag=false;
				}
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		if(flag==false){
			throw new CustomerIdAlreadyExistException("Customer by id "+custid+"Already Exist Exception"); 
		}
		System.out.println("dao"+flag);
		return flag;
		
	}
	
	public Customer customerUpdate(Customer c){
		Connection con=null;
		PreparedStatement ps=null;
		Customer customer=null;
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.UPDATE_CUSTOMER);
			ps.setString(1,c.getCustomername());
			ps.setInt(2,c.getAge());
			ps.setString(3,c.getAddressline1());
			ps.setString(4,c.getAddressline2());
			ps.setString(5,c.getState());
			ps.setString(6,c.getCity());
			ps.setString(7,c.getCustssnid());
			  
			int rows=ps.executeUpdate();
			  
			if(rows>0)
			{
				customer=c;
				System.out.println(c.getCustomername());
				
			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return customer;	
	}

	public Customer getCustomerDetailsbyId(String customerssnid) {

		Customer cust=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.VIEW_CUSTOMER_SSNID);
			ps.setString(1,customerssnid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				String custid=rs.getString(1);
				String custssnid=rs.getString(2);
				String customername=rs.getString(3);
				int age=rs.getInt(4);
				String addressline1=rs.getString(5);
				String addressline2=rs.getString(6);
				String state=rs.getString(7);
				String city=rs.getString(8);
				cust=new Customer(custid,custssnid, customername, age, addressline1, addressline2, state, city);
					
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		System.out.println(cust.getCustomername());
		return cust;
	}

	public boolean checkAccountbyCustid(String customerid) {
		
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.CHECK_CUSTOMER_ID);
			ps.setString(1,customerid);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
					flag=true;
				
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public String addacc(Account acc) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> searchbyssnIDandName(String keyword) {
		Connection con=null;
		PreparedStatement ps=null;
		List<Customer> custlist=new ArrayList<>();
		
		Customer cust=null;
		
	
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.SEARCH_BYSSNID_NAME);
			ps.setString(1,"%"+keyword+"%");
			ps.setString(2,"%"+keyword+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			
		    String customerid=rs.getString(1);
		    String customerssnid=rs.getString(2);
			String customername=rs.getString(3);
			int age=rs.getInt(4);
			String addressline1=rs.getString(5);
			String addressline2=rs.getString(6);
			String state=rs.getString(7);
			String city=rs.getString(8);
			
			cust=new Customer(customerid, customerssnid, customername, age, addressline1, addressline2, state, city);
			custlist.add(cust);
			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return custlist;	
		
	}
	
	//CUSTOMER STATUS 
	
		public boolean storeCustomerStatus(Customerstatus cust) throws DataLayerException{
			boolean flag=false;
			Connection con=null;
			PreparedStatement ps=null;
		
			
			try {
				con=OracleDatabaseUtil.getConnection();
				ps=con.prepareStatement(Queryconstants.REG_CUST_STATUS);
				ps.setString(1,cust.getCustssnid());
				ps.setString(2,cust.getCustid());
				ps.setString(3,cust.getStatus());
				ps.setString(4,cust.getMessage());
			
				
				int rows=ps.executeUpdate();
				
				
				if(rows>0)
				{ 
				
					
					flag=true;
					System.out.println("storecustomerstatusdao"+flag);
					System.out.println(cust.getCustssnid());
					
				}
				else
				{
					throw new DataLayerException("Customer status not register Exception");
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			System.out.println(flag);
			return flag;
		
		}

		public List<Customerstatus> viewAllCustomerstatus() {
			
			List<Customerstatus> listcustomerstatus=new ArrayList<>();
			Connection con=null;
			PreparedStatement ps=null;
			
			try {
				con=OracleDatabaseUtil.getConnection();
				ps=con.prepareStatement(Queryconstants.ALL_CUSTOMERS_STATUS);
				
				ResultSet rs=ps.executeQuery();
				
				//System.out.println(cust.getId());
				
				while(rs.next()){
					
					String custssnid=rs.getString(1);
					String custid=rs.getString(2);
					
					String status=rs.getString(3);
					String message=rs.getString(4);
					String lastupdated=rs.getString(5);
					 Customerstatus custstatus=new Customerstatus(custssnid, custid, status, message, lastupdated);
					 listcustomerstatus.add(custstatus);
					
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			return listcustomerstatus;
		
				}

		public List<Customerstatus> searchbyCustomerssnid(String keyword) {
			
			List<Customerstatus> listcustomerstatus=new ArrayList<>();
			Connection con=null;
			PreparedStatement ps=null;
			
			try {
				con=OracleDatabaseUtil.getConnection();
				ps=con.prepareStatement(Queryconstants.SEARCH_BY_CUSTOMER_SSN_ID);
				ps.setString(1,"%"+keyword+"%");
				ResultSet rs=ps.executeQuery();
				
				
				
				while(rs.next()){
					
					String custssnid=rs.getString(1);
					String custid=rs.getString(2);
					
					String status=rs.getString(3);
					String message=rs.getString(4);
					String lastupdated=rs.getString(5);
					Customerstatus custstatus=new Customerstatus(custssnid, custid, status, message, lastupdated);
					listcustomerstatus.add(custstatus);
					
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			return listcustomerstatus;
		
				}

		public List<CustomerandAccount> allcustomerandaccountdetails() {
			
			List<CustomerandAccount> listcustomerandaccount=new ArrayList<>();
			Connection con=null;
			PreparedStatement ps=null;
			
			try {
				con=OracleDatabaseUtil.getConnection();
				ps=con.prepareStatement(Queryconstants.ALL_CUSTOMER_ACCOUNT_DETAILS);
				
				ResultSet rs=ps.executeQuery();
				
				//System.out.println(cust.getId());
				
				while(rs.next()){
					
					
					String custid=rs.getString(1);
					String custssnid=rs.getString(2);
					String customername=rs.getString(3);
					int age=rs.getInt(4);
					String addressline1=rs.getString(5);
					String addressline2=rs.getString(6);
					String state=rs.getString(7);
					String city=rs.getString(8);
					String accountid=rs.getString(9);
					String accounttype=rs.getString(11);
					int balance=rs.getInt(12);
					 CustomerandAccount custandacc=new CustomerandAccount(custid, custssnid, customername, age, addressline1, addressline2, state, city, accountid, accounttype, balance);
					 listcustomerandaccount.add(custandacc);
					
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			return listcustomerandaccount;
				}

		public CustomerandAccount getCustomerandAccountDetailsByAccountId(String accid) {
			
			CustomerandAccount customerandaccount=null;
			Connection con=null;
			PreparedStatement ps=null;
			
			try {
				con=OracleDatabaseUtil.getConnection();
				ps=con.prepareStatement(Queryconstants.GET_CUSTOMER_ACCOUNT_BY_ACCID);
				ps.setString(1,accid);
				
				
				ResultSet rs=ps.executeQuery();
				
				//System.out.println(cust.getId());
				
				while(rs.next()){
					
					
					String custid=rs.getString(1);
					String custssnid=rs.getString(2);
					String customername=rs.getString(3);
					int age=rs.getInt(4);
					String addressline1=rs.getString(5);
					String addressline2=rs.getString(6);
					String state=rs.getString(7);
					String city=rs.getString(8);
					String accountid=rs.getString(9);
					String accounttype=rs.getString(11);
					int balance=rs.getInt(12);
				customerandaccount=new CustomerandAccount(custid, custssnid, customername, age, addressline1, addressline2, state, city, accountid, accounttype, balance);
					
					
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			return customerandaccount;		
			}

		public List<CustomerandAccount> searchCustomerssnIDandcustIDandAccountid(String keyword) {
			
			List<CustomerandAccount> listcustomerandaccount=new ArrayList<>();
			Connection con=null;
			PreparedStatement ps=null;
			
			try {
				con=OracleDatabaseUtil.getConnection();
				ps=con.prepareStatement(Queryconstants.SEARCH_SSNID_ACCOUNTID);
				ps.setString(1,"%"+keyword+"%");
				ps.setString(2,"%"+keyword+"%");
				ps.setString(3,"%"+keyword+"%");
				
				ResultSet rs=ps.executeQuery();
				
				//System.out.println(cust.getId());
				
				while(rs.next()){
					
					
					String custid=rs.getString(1);
					String custssnid=rs.getString(2);
					String customername=rs.getString(3);
					int age=rs.getInt(4);
					String addressline1=rs.getString(5);
					String addressline2=rs.getString(6);
					String state=rs.getString(7);
					String city=rs.getString(8);
					String accountid=rs.getString(9);
					String accounttype=rs.getString(11);
					int balance=rs.getInt(12);
					 CustomerandAccount custandacc=new CustomerandAccount(custid, custssnid, customername, age, addressline1, addressline2, state, city, accountid, accounttype, balance);
					 listcustomerandaccount.add(custandacc);
					
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			return listcustomerandaccount;

		}

		}


	
	


