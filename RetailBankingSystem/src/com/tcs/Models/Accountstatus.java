package com.tcs.Models;

public class Accountstatus {
	
	private String customerid;
	private String accountid;
	private String accounttype;
	private String status;
	private String message;
	private String lastupdated;
	public Accountstatus(String customerid, String accountid, String accounttype, String status, String message,
			String lastupdated) {
		super();
		this.customerid = customerid;
		this.accountid = accountid;
		this.accounttype = accounttype;
		this.status = status;
		this.message = message;
		this.lastupdated = lastupdated;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}
	
	
	

}
