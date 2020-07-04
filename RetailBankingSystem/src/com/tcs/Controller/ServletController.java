package com.tcs.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.tcs.Models.Account;
import com.tcs.Models.Accountstatus;
import com.tcs.Models.Customer;
import com.tcs.Models.CustomerandAccount;
import com.tcs.Models.Customerstatus;
import com.tcs.Models.Login;
import com.tcs.Models.Transaction;
import com.tcs.Service.Service;


/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session=null;

	Service service = new Service();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		
		session=request.getSession(false);

		if(action==null){
			response.sendRedirect(request.getContextPath()+"/JSP/Home.jsp");
			return;
			
		}
		else if (action.equalsIgnoreCase("Homepage")) {

			response.sendRedirect(request.getContextPath() + "/JSP/Home.jsp");
			return;
			
		}

		else if (action.equalsIgnoreCase("loginpage")) {
			response.sendRedirect(request.getContextPath() + "/JSP/Login.jsp");
			return;
		} else if (action.equalsIgnoreCase("bankemployeemanagement")) {

			processBankemployeemanagement(request, response);

		} else if (action.equalsIgnoreCase("Customerreg")) {

			processCustomerRegister(request, response);

		} else if (action.equalsIgnoreCase("CheckCustomerreg")) {

			processCustomerToRegister(request, response);
		}

		else if (action.equalsIgnoreCase("AllCustomer")) {
			processViewAllCustomers(request, response);
		} else if (action.equalsIgnoreCase("viewupdateCustomer")) {

			processViewUpdateCustomer(request, response);

		} else if (action.equalsIgnoreCase("UpadateCustomer")) {

			processCustomerUpdate(request, response);
		} else if (action.equalsIgnoreCase("addAccount")) {
			
			processAddAccount(request,response);
		} else if (action.equalsIgnoreCase("Accountregister")) {
			processaddAccount(request, response);
		} else if (action.equalsIgnoreCase("viewdeleteCustomer")) {
			processViewDeleteCustomer(request, response);
		}else if(action.equalsIgnoreCase("deleteCustomer"))
		{
			processDeleteCustomer(request, response);
		}
		else if(action.equalsIgnoreCase("deleteCustomercancel"))
		{
			processViewAllCustomers(request, response);
		}
		else if(action.equalsIgnoreCase("accountDetails"))
		{
			processViewAccountDetailsByCustid(request, response);
		}
		else if(action.equalsIgnoreCase("deleteAccount"))
		{
			processDeleteAccount(request, response);
		}
		else if(action.equalsIgnoreCase("searchbyssnIdandName"))
		{
			processSearchCustomerssnIdandName(request,response);
		}
		else if(action.equalsIgnoreCase("viewAllCustomerStatus"))
		{
			processViewAllCustomerStatus(request,response);
		}
		else if(action.equalsIgnoreCase("viewAllAccountStatus"))
		{
			processViewAllAccountStatus(request,response);
		}
		else if(action.equalsIgnoreCase("searchbyAccountIdandType"))
		{
			processSearchByAccountIdAndAccountType(request,response);
		}
		else if(action.equalsIgnoreCase("searchbyssnId"))
		{
			processSearchbySSNID(request,response);
		}
		else if(action.equalsIgnoreCase("viewCustomerandAccountDetails"))
		{
			processviewCustomerandAccountDetails(request,response);
		}
		else if(action.equalsIgnoreCase("depositform"))
		{
			processDepositform(request,response);
		}
		else if(action.equalsIgnoreCase("deposit"))
		{
			processDeposit(request,response);
		}
		else if(action.equalsIgnoreCase("withdrawform"))
		{
			processwithdrawform(request,response);
		}
		else if(action.equalsIgnoreCase("withdraw"))
		{
			processWithdraw(request,response);
		}
		else if(action.equalsIgnoreCase("transferform"))
		{
			processTransferform(request,response);
		}
		else if(action.equalsIgnoreCase("Transfer"))
		{
			processTransfer(request,response);
		}
		else if(action.equalsIgnoreCase("viewAllCustomerTransactions"))
		{
			processviewAllCustomerTransactions(request,response);
		}
		else if(action.equalsIgnoreCase("transferCancel"))
		{
			processTransferCancel(request,response);
		}
		else if(action.equalsIgnoreCase("searchbytxnIdandAccountid"))
		{
			processsearchbytxnIdandAccountid(request,response);
		}
		else if(action.equalsIgnoreCase("searchbyssnIdandAccountid"))
		{
			processsearchbyssnIdandAccountid(request,response);
		}
		else if(action.equalsIgnoreCase("Logout"))
		{
			session.invalidate();
        	response.sendRedirect(request.getContextPath()+"/JSP/Home.jsp");
			return;
		}

	}

   public void processsearchbytxnIdandAccountid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   String search=request.getParameter("search");
		 List<Transaction> transactionlist=null;     

		  transactionlist=service.searchByTransactionIDandAccountid(search);
		  System.out.println("processSearchbyssnid"+search);
		  
		  System.out.println(transactionlist.size());
	     if(transactionlist.size()>0){
	    
	    	 RequestDispatcher rd=request.getRequestDispatcher("/JSP/AllCustomerTransactions.jsp");
	    	 request.setAttribute("list",transactionlist);
	    	 rd.forward(request, response);
	     }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("/JSP/AllCustomerTransactions.jsp");
		     request.setAttribute("message","only search by Transaction ID and AccountID");
		     request.setAttribute("list",transactionlist);
		     rd.forward(request, response); 
	     }


		
	}

public void processTransferCancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	List<CustomerandAccount> customerandaccountlist = new ArrayList<>();
	customerandaccountlist = service.allCustomerAndAccountDetails();

	RequestDispatcher rd = request.getRequestDispatcher("/JSP/AllcustomersAndAccountsDetails.jsp");
	request.setAttribute("list", customerandaccountlist);
	rd.forward(request, response);
		
	}

	public void processsearchbyssnIdandAccountid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search=request.getParameter("search");
		
		List<CustomerandAccount> list=service.searchCustomerSSNandIDandAccountID(search);
	    
		  System.out.println("processSearchbyssnid"+search);
		  
		  System.out.println(list.size());
	     if(list.size()>0){
	    
	    	 RequestDispatcher rd=request.getRequestDispatcher("/JSP/AllcustomersAndAccountsDetails.jsp");
	    	 request.setAttribute("list",list);
	    	 rd.forward(request, response);
	     }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("/JSP/AllcustomersAndAccountsDetails.jsp");
		     request.setAttribute("message","only search by Customer SSNID And CustomerID and AccountID");
		     request.setAttribute("list",list);
		     rd.forward(request, response); 
	     }


		
		
		
	}

	private void processviewAllCustomerTransactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Transaction> transactionlist = new ArrayList<>();
		transactionlist = service.allTransactions();

		RequestDispatcher rd = request.getRequestDispatcher("/JSP/AllCustomerTransactions.jsp");
		request.setAttribute("list", transactionlist);
		rd.forward(request, response);
		
	}

	public void processTransfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sourceaccountid=request.getParameter("sourceaccid");
		String targetaccountid=request.getParameter("targetaccid");
		int amount=Integer.parseInt(request.getParameter("amount"));
		 
		 int sourcebalancebefore=service.getAmount(sourceaccountid);
		 int tagetbalancebefore=service.getAmount(targetaccountid);
		
		 boolean flag=service.withdrawtheAmount(sourceaccountid,amount);
		 
		 CustomerandAccount sourcecustandacc=service.getCustomerandAccountdetails(sourceaccountid);
		 if(flag)
		 {
			 flag=service.deposittheAmount(targetaccountid,amount);
			 if(flag)
			 {
				 Transaction transaction=new Transaction("",sourceaccountid,"Transfer completed",amount,"");
				 service.storeTransaction(transaction);
				 CustomerandAccount targetcustandacc=service.getCustomerandAccountdetails(targetaccountid);
				 RequestDispatcher rd = request.getRequestDispatcher("/JSP/TransferSuccess.jsp");
				 request.setAttribute("sourcecustandacc",sourcecustandacc);
				 request.setAttribute("soucebalancebefore",sourcebalancebefore);
				 request.setAttribute("targetcustandacc",targetcustandacc);
				 request.setAttribute("tagetbalancebefore",tagetbalancebefore);
				 rd.forward(request, response);
			 }
		}
		 else
		 {
			 
				System.out.println("else"+sourceaccountid);
				RequestDispatcher rd = request.getRequestDispatcher("/JSP/Transferform.jsp");
				request.setAttribute("accountid",sourceaccountid);
				request.setAttribute("msg","Withdraw not allowed,please choose smaller amount");
				rd.forward(request, response);
				
		 }
		
	}

	public void processTransferform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accountid=request.getParameter("accountid");
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/Transferform.jsp");
		request.setAttribute("accountid", accountid);
		
		rd.forward(request, response);
		
		
		
	}

	public void processWithdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accountid=request.getParameter("accid");
		int amount=Integer.parseInt(request.getParameter("amount"));
		 
		 int balancebefore=service.getAmount(accountid);
		
		 boolean flag=service.withdrawtheAmount(accountid,amount);
		 
		 CustomerandAccount custandacc=service.getCustomerandAccountdetails(accountid);
		 if(flag)
		 {
			 Transaction transaction=new Transaction("",accountid,"Withdrawn completed",amount,"");
			 service.storeTransaction(transaction);
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/withdrawSuccess.jsp");
			request.setAttribute("custandacc", custandacc);
			request.setAttribute("balancebefore",balancebefore);
			rd.forward(request, response);
		}
		 else
		 {
			 
			   session=request.getSession(false);
				
				//String accntid=request.getParameter("accountid");
				
				 Transaction transaction=new Transaction("",accountid,"Withdrawn failure",amount,"");
				 service.storeTransaction(transaction);
				
				RequestDispatcher rd = request.getRequestDispatcher("/JSP/Withdrawform.jsp");
				session.setAttribute("accountid",accountid);
				request.setAttribute("msg","Withdraw not allowed,please choose smaller amount");
				rd.forward(request, response);
				
		 }
		
		
	}

	public void processwithdrawform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       session=request.getSession(false);
		
		String accountid=request.getParameter("accountid");
		
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/Withdrawform.jsp");
		session.setAttribute("accountid",accountid);
		rd.forward(request, response);
		
		
	}

	public void processDepositform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession(false);
		
		String accountid=request.getParameter("accountid");
		
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/Depositform.jsp");
		session.setAttribute("accountid",accountid);
		rd.forward(request, response);
		}

	public void processDeposit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accountid=request.getParameter("accid");
		int amount=Integer.parseInt(request.getParameter("amount"));
		 
		 int balancebefore=service.getAmount(accountid);
		
		 boolean flag=service.deposittheAmount(accountid,amount);
		 
		 CustomerandAccount custandacc=service.getCustomerandAccountdetails(accountid);
		 if(flag)
		 {
			Transaction transaction=new Transaction("",accountid,"Deposit completed",amount,"");
			service.storeTransaction(transaction);
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/DepositSuccess.jsp");
			request.setAttribute("custandacc", custandacc);
			request.setAttribute("balancebefore",balancebefore);
			rd.forward(request, response);
			
		 }
		
	}

	public void processviewCustomerandAccountDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<CustomerandAccount> customerandaccountlist = new ArrayList<>();
		customerandaccountlist = service.allCustomerAndAccountDetails();

		RequestDispatcher rd = request.getRequestDispatcher("/JSP/AllcustomersAndAccountsDetails.jsp");
		request.setAttribute("list", customerandaccountlist);
		rd.forward(request, response);

		
	}

	public void processAddAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String custid = request.getParameter("custid");
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/AccountRegister.jsp");
		request.setAttribute("custid", custid);
		rd.forward(request, response);
		
	}

	public void processSearchbySSNID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String search=request.getParameter("search");
		 List<Customerstatus> customerstatuslist=null;     

		  customerstatuslist=service.searchByCustomerSSNID(search);
		  System.out.println("processSearchbyssnid"+search);
		  
		  System.out.println(customerstatuslist.size());
	     if(customerstatuslist.size()>0){
	    
	    	 RequestDispatcher rd=request.getRequestDispatcher("/JSP/viewAllcustomerstatus.jsp");
	    	 request.setAttribute("list",customerstatuslist);
	    	 rd.forward(request, response);
	     }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("/JSP/viewAllcustomerstatus.jsp");
		     request.setAttribute("message","only search by Customer SSN ID");
		     request.setAttribute("list",customerstatuslist);
		     rd.forward(request, response); 
	     }


		
	}

	public void processSearchByAccountIdAndAccountType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String search=request.getParameter("search");
		 List<Accountstatus> accountstatuslist=null;     

		  accountstatuslist=service.searchByAccountIdandType(search);
		  System.out.println("processSearchAccountIdandType"+search);
		  
		  System.out.println(accountstatuslist.size());
	     if(accountstatuslist.size()>0){
	    
	     RequestDispatcher rd=request.getRequestDispatcher("/JSP/viewAllAccountstatus.jsp");
	     request.setAttribute("list",accountstatuslist);
	     rd.forward(request, response);
	     }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("/JSP/viewAllAccountstatus.jsp");
		     request.setAttribute("message","only search by Account ID and Account type");
		     request.setAttribute("list",accountstatuslist);
		     rd.forward(request, response); 
	     }

		
	}

	public void processViewAllAccountStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Accountstatus> accountstatuslist = new ArrayList<>();
		accountstatuslist = service.viewallAccountStatus();

		RequestDispatcher rd = request.getRequestDispatcher("/JSP/viewAllAccountstatus.jsp");
		request.setAttribute("list", accountstatuslist);
		rd.forward(request, response);

		
	}

	public void processViewAllCustomerStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Customerstatus> customerstatuslist = new ArrayList<>();
		customerstatuslist = service.viewallCustomerStatus();

		RequestDispatcher rd = request.getRequestDispatcher("/JSP/viewAllcustomerstatus.jsp");
		request.setAttribute("list", customerstatuslist);
		rd.forward(request, response);

		
		
	}

	public void processSearchCustomerssnIdandName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String search=request.getParameter("search");
		 List<Customer> customerlist=null;     

		  customerlist=service.searchBySSNIdandName(search);
		  System.out.println("processSearchCustomerIdandName"+search);
		  
		  System.out.println(customerlist.size());
	     if(customerlist.size()>0){
	    
	     RequestDispatcher rd=request.getRequestDispatcher("/JSP/Allcustomers.jsp");
	     request.setAttribute("list",customerlist);
	     rd.forward(request, response);
	     }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("/JSP/Allcustomers.jsp");
		     request.setAttribute("message","only search by customer SSN ID and Name");
		     request.setAttribute("list",customerlist);
		     rd.forward(request, response); 
	     }
	}

	public void processDeleteAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accid=request.getParameter("accid");
		
		Account accnt=service.getAccountDetailsbyAccountID(accid);

		
		boolean flag=service.deleteACCount(accid);
		
		System.out.println("processDeleteAccount"+flag);
		
		if(flag)
		{
			
						 
			Accountstatus accstatus=new Accountstatus(accnt.getCustid(),accnt.getAccountid(),accnt.getAccounttype(),"Inactive","Account Deletion","");
			service.regAccountStatus(accstatus);
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/AccountDeleteSuccess.jsp");
			//request.setAttribute("list", list);
	        rd.forward(request, response);
		}
		else
		{
			List<Account> list=service.getAccountdetailsbyaccid(accid);
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/Accountdetails.jsp");
			request.setAttribute("message","Account can't closed with balance,The balance need to be closed before closing these account");
			request.setAttribute("list",list);
	        rd.forward(request, response);
		}
		
	}

	public void processViewAccountDetailsByCustid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String custid=request.getParameter("custid");
		List<Account> list=service.getaccountDetails(custid);
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/Accountdetails.jsp");
		request.setAttribute("list", list);
        rd.forward(request, response);
		
	}

	public void processDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String custssnid=request.getParameter("custssnid");
		
		System.out.println("processDeleteCustomer"+custssnid);
		
		Customer custom=service.getCustomerdetailsbyId(custssnid);
		
		boolean flag =service.deleteCustomer(custssnid);
		
		if(flag){
			
			
	        Customerstatus custstatus=new Customerstatus(custssnid,custom.getCustid(),"Inactive","Customer Deletion","");
			service.regCustomerStatus(custstatus);

		    RequestDispatcher rd = request.getRequestDispatcher("/JSP/CustomerDeletedSuccess.jsp");
		    request.setAttribute("custom",custom);

            rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/ViewDeleteCustomer.jsp");
			//request.setAttribute("customer", cust);
			request.setAttribute("msg","Customer has active accounts opened,can't delete this customer details");
			rd.forward(request, response);

		}
		
		
	}

	public void processViewDeleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		session=request.getSession(false);

		String custssnid = request.getParameter("custssnid");

		Customer customer = service.getCustomerdetailsbyId(custssnid);

		System.out.println(customer.getCustomername());

		RequestDispatcher rd = request.getRequestDispatcher("/JSP/ViewDeleteCustomer.jsp");
		session.setAttribute("customer", customer);
		session.setAttribute("custssnid",custssnid);

		rd.forward(request, response);

	}

	public void processaddAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custid = request.getParameter("custid");
		String accounttype = request.getParameter("accounttype");
		int deposit = Integer.parseInt(request.getParameter("deposit"));

		Account acc = new Account("",custid, accounttype, deposit);

		System.out.println("processaddAccount" + custid);

		boolean flag = service.checkAccountType(acc);

		if (flag) {

			RequestDispatcher rd = request.getRequestDispatcher("/JSP/AccountRegister.jsp");
			request.setAttribute("custid", custid);
			request.setAttribute("message", "Account already exist by this user");

			rd.forward(request, response);
		} else {
			
			Account account = service.accRegister(acc);
			
			Account accnt=service.getAccountDetailsbyAccount(account);
			 
			Accountstatus accstatus=new Accountstatus(accnt.getCustid(),accnt.getAccountid(),accnt.getAccounttype(),"Active","Account register","");
			service.regAccountStatus(accstatus);
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/AccountRegisterSuccess.jsp");
			request.setAttribute("account", account);
			rd.forward(request, response);
		}

	}

	
	public void processCustomerUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custid = request.getParameter("custid");
		String custssnid = request.getParameter("custssnid");
		String customername = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addressline1 = request.getParameter("addressline1");
		String addressline2 = request.getParameter("addressline2");
		String state = request.getParameter("state");
		String city = request.getParameter("city");

		Customer customer = new Customer(custid, custssnid, customername, age, addressline1, addressline2, state, city);
		System.out.println(customer.getCustssnid());
		Customer cust = service.updateCustomer(customer);
		
		Customer custom=service.getCustomerdetailsbyId(custssnid);
        Customerstatus custstatus=new Customerstatus(custssnid,custom.getCustid(),"Active","Customer Updation","");
		service.regCustomerStatus(custstatus);

		RequestDispatcher rd = request.getRequestDispatcher("/JSP/Customerupdatesuccess.jsp");
		request.setAttribute("customer", cust);
		rd.forward(request, response);

	}

	public void processViewUpdateCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custssnid = request.getParameter("custssnid");

		Customer customer = service.getCustomerdetailsbyId(custssnid);

		System.out.println(customer.getCustomername());

		// Customer customer = new Customer(custid, name, email, age, gender,
		// phone, address, city, state);

		RequestDispatcher rd = request.getRequestDispatcher("/JSP/viewUpdateCustomer.jsp");
		request.setAttribute("customer", customer);
		request.setAttribute("custssnid", custssnid);
		rd.forward(request, response);

	}

	public void processViewAllCustomers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Customer> customerlist = new ArrayList<>();
		customerlist = service.allCustomerDetails();

		RequestDispatcher rd = request.getRequestDispatcher("/JSP/Allcustomers.jsp");
		request.setAttribute("list", customerlist);
		rd.forward(request, response);

	}

	public void processCustomerToRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean flag = false;

		String custssnid = request.getParameter("custssnid");
		String customername = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addressline1 = request.getParameter("addressline1");
		String addressline2 = request.getParameter("addressline2");
		String state = request.getParameter("state");
		String city = request.getParameter("city");

		Customer customer = new Customer("", custssnid, customername, age, addressline1, addressline2, state, city);

		flag = service.customerRegistration(customer);

		if (flag) {
			
			Customer cust=service.getCustomerdetailsbyId(custssnid);
			 
			Customerstatus custstatus=new Customerstatus(custssnid,cust.getCustid(),"Active","Customer register","");
			service.regCustomerStatus(custstatus);
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/CustomerRegisterSuccess.jsp");
			request.setAttribute("customer", customer);
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/CustomerRegister.jsp");
			request.setAttribute("message", "Customer Not register successfully ");
			rd.forward(request, response);
		}

	}

	public void processCustomerRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.sendRedirect(request.getContextPath() + "/JSP/CustomerRegister.jsp");
		return;

	}

	public void processBankemployeemanagement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean flag = false;

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login(username, password);
		// Userstore us = new Userstore(username, password);

		flag = service.authenticateUser(login);
		System.out.println(flag);

		if (flag) {

			if (username.equals("manager")) {
				System.out.println(username);
				RequestDispatcher rd = request.getRequestDispatcher("/JSP/Manager.jsp");
				request.setAttribute("username", username);
				request.setAttribute("login", login);
				rd.forward(request, response);
			} else if (username.equals("cashier")) {
				RequestDispatcher rd = request.getRequestDispatcher("/JSP/Cashier.jsp");
				request.setAttribute("username", username);
				request.setAttribute("login", login);
				rd.forward(request, response);

			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/Login.jsp");
			request.setAttribute("message", "Invalid Username or Password");
			rd.forward(request, response);
		}

	}

}
