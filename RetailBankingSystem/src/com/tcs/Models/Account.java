package com.tcs.Models;

public class Account {
	
	private String accountid;
	private String custid;
	private String accounttype;
	private double deposit;
	
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public Account(String accountid, String custid, String accounttype, double deposit) {
		super();
		this.accountid = accountid;
		this.custid = custid;
		this.accounttype = accounttype;
		this.deposit = deposit;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	
	

}
