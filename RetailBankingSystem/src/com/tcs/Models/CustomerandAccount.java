package com.tcs.Models;

public class CustomerandAccount {
	
	private String customerid;
	private String customerssnid;
	private String custname;
	private int age;
	private String addressline1;
	private String addressline2;
	private String state;
	private String city;
	private String accountid;
	private String accounttype;
	private int balance;
	public CustomerandAccount(String customerid, String customerssnid, String custname, int age, String addressline1,
			String addressline2, String state, String city, String accountid, String accounttype, int balance) {
		super();
		this.customerid = customerid;
		this.customerssnid = customerssnid;
		this.custname = custname;
		this.age = age;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.state = state;
		this.city = city;
		this.accountid = accountid;
		this.accounttype = accounttype;
		this.balance = balance;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomerssnid() {
		return customerssnid;
	}
	public void setCustomerssnid(String customerssnid) {
		this.customerssnid = customerssnid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
	

}
