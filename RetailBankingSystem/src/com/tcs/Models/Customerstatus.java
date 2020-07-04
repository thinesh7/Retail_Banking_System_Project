package com.tcs.Models;

public class Customerstatus {
	
	private String custssnid;
	private String custid;
	private String status;
	private String message;
	private String lastupdated;
	
	
	public Customerstatus(String custssnid, String custid, String status, String message, String lastupdated) {
		super();
		this.custssnid = custssnid;
		this.custid = custid;
		this.status = status;
		this.message = message;
		this.lastupdated = lastupdated;
	}
	public String getCustssnid() {
		return custssnid;
	}
	public void setCustssnid(String custssnid) {
		this.custssnid = custssnid;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
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
