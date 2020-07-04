package com.tcs.Models;

public class Transaction {
	
	private String transactionid;
	private String accountid;
	private String message;
	private int amount;
	private String lastupdated;
	public Transaction(String transactionid, String accountid, String message, int amount, String lastupdated) {
		super();
		this.transactionid = transactionid;
		this.accountid = accountid;
		this.message = message;
		this.amount = amount;
		this.lastupdated = lastupdated;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}
	
	

}
