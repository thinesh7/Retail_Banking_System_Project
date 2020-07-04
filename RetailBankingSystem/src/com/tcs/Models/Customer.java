package com.tcs.Models;

public class Customer {
	
	public Customer(String custid, String custssnid, String customername, int age, String addressline1,
			String addressline2, String state, String city) {
		super();
		this.custid = custid;
		this.custssnid = custssnid;
		this.customername = customername;
		this.age = age;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.state = state;
		this.city = city;
	}
	private String custid;
	private String custssnid;
	private String customername;
	private int age;
	private String addressline1;
	private String addressline2;
	private String state;
	private String city;
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getCustssnid() {
		return custssnid;
	}
	public void setCustssnid(String custssnid) {
		this.custssnid = custssnid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
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
	
	
	
	
}
