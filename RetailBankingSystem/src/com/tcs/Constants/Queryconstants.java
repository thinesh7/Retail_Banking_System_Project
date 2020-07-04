package com.tcs.Constants;



public interface Queryconstants extends OracleDatabaseConstants{
	
	
	//Authenticate table
	
	String GET_USERNAME_PASSWORD="select * from Bankemployees where username=? and password=?";
	
	String BANK_EMPLOYEE_STORE="insert into Userstore values(?,?,systimestamp)";
	
	
	//Customer table queries
	
	String CHECK_CUSTOMER_ID="select customerid from customer_retail where customerssnid=?";
	
	String CUSTOMER_ID="select customer_retail_seq.nextval from dual"; 
	
	
	
	String REG_CUST="insert into customer_retail values(?,?,?,?,?,?,?,?)";
	
	String DELETE_CUSTOMER="delete from customer_retail where customerssnid=?";
	
	String ALL_CUSTOMERS="select * from customer_retail";
	
	
	String VIEW_CUSTOMER_SSNID="select * from customer_retail where customerssnid=?";
	
	String UPDATE_CUSTOMER="update customer_retail set customername=?,age=?,addressline1=?,addressline2=?,state=?,city=? where customerssnid=?";
	
	String SEARCH_BYSSNID_NAME="select * from customer_retail where customerssnid like ? or customername like ?";
	
	//Account table queries
	
	String ACCOUNT_ID="select account_seq.nextval from dual";
	
	String REG_ACCOUNT_CUSTID="insert into Account values(?,?,?,?)";
	
	String GET_CUST_DETAILS_BYID="select * from Account where customerid=?";
	
	String CHECK_ACCOUNTTYPE="select accounttype from Account where accounttype=? and customerid=?";
	
	
	String CHECK_BALANCE_ACCOUNTID="select deposit from account where accountid=?";
	
	String DELETE_BY_ACCOUNTID="delete from Account where accountid=?";
	
	String GET_ACCOUNT_DETAILS_ACCOUNT="select * from account where customerid=? and accounttype=?";
	
	String GET_ACCOUNT_DETAILS_ACCID = "select * from account where accountid=?";
	
	
	// CUSTOMER STATUS 
	
	String REG_CUST_STATUS="insert into customer_status values(?,?,?,?,systimestamp)";
	
    String ALL_CUSTOMERS_STATUS = "select * from customer_status";

    String SEARCH_BY_CUSTOMER_SSN_ID ="select * from customer_status where customerssnid like ?";

	//ACCOUNT STATUS
	
	String REG_ACCOUNT_STATUS="insert into account_status values(?,?,?,?,?,systimestamp)";

	String ALL_ACCOUNT_STATUS = "select * from account_status";
	
	String SEARCH_ACOUNT_ID_AND_TYPE ="select * from account_status where accountid like ? or accounttype like ?";

  //CUSTOMER-ACCOUNT
	
	String ALL_CUSTOMER_ACCOUNT_DETAILS="select * from customer_retail c inner join account a on c.customerid=a.customerid";

	String DEPOSIT_AMOUNT ="update account set deposit=? where accountid=?";

	String GET_AMOUNT ="select deposit from account where accountid=?";

	String GET_CUSTOMER_ACCOUNT_BY_ACCID = "select * from customer_retail c inner join account a on c.customerid=a.customerid where accountid=?";
	
	String SEARCH_SSNID_ACCOUNTID="select * from customer_retail c inner join account a on c.customerid=a.customerid where a.accountid like ? or c.customerid like ? or c.customerssnid like ?";	
	
	//TRANSACTION TABLE

	String TRANSACTION_ID ="select transaction_seq.nextval from dual";

	String REG_TRANSACTION_QUERY ="insert into transaction_table values(?,?,?,?,systimestamp)";

	String ALL_TRANSACTIONS ="select * from transaction_table";

	String SEARCH_BY_TRANSACTIONID_ACCOUNTID = "select * from transaction_table where accountid like ? or transactionid like ?";
	

}
