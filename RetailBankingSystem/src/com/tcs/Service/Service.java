package com.tcs.Service;

import java.util.List;

import com.tcs.Dao.AccountDAO;
import com.tcs.Dao.BankemployeeDAO;
import com.tcs.Dao.CustomerDAO;
import com.tcs.Dao.TransactionDAO;
import com.tcs.Exception.AccountAlreadyExistException;
import com.tcs.Exception.CustomerIdAlreadyExistException;
import com.tcs.Exception.CustomerNotExistException;
import com.tcs.Exception.DataLayerException;
import com.tcs.Models.Account;
import com.tcs.Models.Accountstatus;
import com.tcs.Models.Customer;
import com.tcs.Models.CustomerandAccount;
import com.tcs.Models.Customerstatus;
import com.tcs.Models.Login;
import com.tcs.Models.Transaction;

public class Service {
	

	BankemployeeDAO bankemployeedao=new BankemployeeDAO();
	CustomerDAO customerdao=new CustomerDAO();
	AccountDAO accountdao=new AccountDAO();
	TransactionDAO transactiondao=new TransactionDAO();

	
	public boolean authenticateUser(Login login){
		boolean flag=false;
		try {
			flag=bankemployeedao.checkUser(login);
			if(flag){
				bankemployeedao.BankEmployeeUserStore(login);

			}
					} catch (DataLayerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return flag;
		 
	}
	
	public boolean customerRegistration(Customer customer){
		
		boolean flag=false;

			 try {
				flag=customerdao.checkCustomerbyId(customer.getCustssnid());
				if(flag){
					 flag=customerdao.customerRegister(customer);
				}
			} catch (CustomerIdAlreadyExistException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			 System.out.println("customerregister"+flag);
	
		 return flag;
	}
	
	public boolean deleteCustomer(String customerssnid){
		boolean flag=false;
		//Customer customer=null;
		
		 try {
			flag=customerdao.deleteCustomerbyid(customerssnid);
			
//			if(flag)
//			{
//				customer=customerdao.getCustomerDetailsbyId(customerssnid);
//				
//				System.out.println(customer.getCity());
//			}
		} catch (DataLayerException e) {
			// TODO Auto-generated catch block
		    System.out.println(e.getMessage());
		}
		 return flag;
	}
	public List<Customer> allCustomerDetails(){
		List<Customer> customerlist=null;
		 customerlist=customerdao.viewAllcustomers();
		 return customerlist;
	}
	public String checkcustomerbyId(String customerid,Account acc)throws CustomerNotExistException, AccountAlreadyExistException, CustomerIdAlreadyExistException{
		String msg="";
		boolean flag=customerdao.checkCustomerbyId(customerid); 
		
		if(flag)
		{
			boolean flag2=customerdao.checkAccountbyCustid(customerid);
			if(flag2)
			{
				throw new AccountAlreadyExistException("AccountAlreadyExistException");
			}
			else
			{
				 msg=customerdao.addacc(acc);
			}
		}
		else
		{
			throw new CustomerNotExistException("CustomerNotExistException");
		}
		
		return msg;
	}
	
	public Customer getCustomerdetailsbyId(String customerssnid){
		
		Customer cust=customerdao.getCustomerDetailsbyId(customerssnid); 
		
		return cust;
	}
	public Customer updateCustomer(Customer customer)
	{
	
	  Customer cust=customerdao.customerUpdate(customer);
		System.out.println(customer.getCustomername());
		return cust;
	}
	public boolean chechAccountforCustid(String custid)
	{
		boolean flag=accountdao.checkaccountforCustid(custid);
		return flag;
		
	}
	
	public boolean checkAccountType(Account acc){
		
	  return accountdao.checkAccounttype(acc);
	}
	
	public Account accRegister(Account acc){
		
		boolean flag=false;
		Account ac=null;
		flag=accountdao.accountRegister(acc);
		if(flag){
		ac=accountdao.getAccountDetailBYAccount(acc);
		System.out.println("accregister"+ac.getAccountid());
		}
		return ac;
	}
	
	public List<Account> getaccountDetails(String custid)
	{
		return accountdao.getAccountDetails(custid);
		
	}
	public boolean deleteACCount(String accid)
	{
		boolean flag=false;
		int balance=accountdao.checkBalanceExist(accid);
		if(balance>0){
			flag=false;
		}
		else
		{
			flag=accountdao.deleteAccount(accid);
		}
		return flag;
		
	}
	
	public List<Account> getAccountdetailsbyaccid(String accid)
	{
		return accountdao.getAccountDetailsbyAccountID(accid);
		
	}

	public List<Customer> searchBySSNIdandName(String search) {
		
		return customerdao.searchbyssnIDandName(search);
		
	}
	
	public boolean regCustomerStatus(Customerstatus cust)
	{
		//Customer customer=null;
		return customerdao.storeCustomerStatus(cust);
		
	}
	
	public boolean regAccountStatus(Accountstatus acc)
	{
		return accountdao.accountStatusRegister(acc);
		
	}
	public Account getAccountDetailsbyAccount(Account acc)
	{
		return accountdao.getAccountDetailBYAccount(acc);
	}
	public Account getAccountDetailsbyAccountID(String accid){
		
		
		return accountdao.getAccountDetailByAccountID(accid);
	}

	public List<Customerstatus> viewallCustomerStatus() {
		
		return customerdao.viewAllCustomerstatus();
	}

	public List<Accountstatus> viewallAccountStatus() {
		
		return accountdao.viewAllAccountsatus();
	}

	public List<Accountstatus> searchByAccountIdandType(String search) {
	
		return accountdao.searchbyAccountidandAccounttype(search);
	}

	public List<Customerstatus> searchByCustomerSSNID(String search) {
		// TODO Auto-generated method stub
		return customerdao.searchbyCustomerssnid(search);
	}

	public List<CustomerandAccount> allCustomerAndAccountDetails() {
	
		return customerdao.allcustomerandaccountdetails();
	}
	public CustomerandAccount getCustomerandAccountdetails(String accid){
		
		return customerdao.getCustomerandAccountDetailsByAccountId(accid);
	}
	public int getAmount(String accountid)
	{
		return accountdao.getAmount(accountid);
	}

	public boolean deposittheAmount(String accountid,int amount) {
		int balance=accountdao.getAmount(accountid);
		int deposit=balance+amount;
		return accountdao.depositAmount(accountid,deposit);
		
	}

	public boolean withdrawtheAmount(String accountid, int amount) {
		int balance=accountdao.getAmount(accountid);
		boolean flag=false;
         if(amount<=balance)
         {
        	 int deposit=balance-amount;
        	 flag=accountdao.depositAmount(accountid,deposit);
        	 
         }
         return flag;
	}
	
	public boolean storeTransaction(Transaction transaction)
	{
		return transactiondao.registerTransaction(transaction);
	}

	public List<Transaction> allTransactions() {
		// TODO Auto-generated method stub
		return transactiondao.allTransactions();
	}

	public List<CustomerandAccount> searchCustomerSSNandIDandAccountID(String search) {
		
		return customerdao.searchCustomerssnIDandcustIDandAccountid(search);
		
	}

	public List<Transaction> searchByTransactionIDandAccountid(String search) {
		// TODO Auto-generated method stub
		return transactiondao.searchbyTrnsactionidandAccountid(search);
	}

	
	}
