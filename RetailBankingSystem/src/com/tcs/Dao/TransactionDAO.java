package com.tcs.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tcs.Constants.Queryconstants;
import com.tcs.DatabaseUtil.OracleDatabaseUtil;
import com.tcs.Exception.DataLayerException;
import com.tcs.Models.Transaction;

public class TransactionDAO {

	
	public String generateTransactionId(){
		Connection con=null;
		PreparedStatement ps=null;
		StringBuffer sb=null;
		String transactionid=null;
		try {
			
			sb=new StringBuffer("TRANS_");
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.TRANSACTION_ID);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				int id=rs.getInt(1);
				sb.append(id);
				 transactionid=sb.toString();
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return transactionid;
		
	}
	
	public boolean registerTransaction(Transaction transaction) throws DataLayerException{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		String id=generateTransactionId();
	
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.REG_TRANSACTION_QUERY);
			ps.setString(1,id);
			ps.setString(2,transaction.getAccountid());
			ps.setString(3,transaction.getMessage());
			ps.setInt(4,transaction.getAmount());
	
		
			
			int rows=ps.executeUpdate();
			
			
			if(rows>0)
			{ 
			
				
				flag=true;
				System.out.println("storetransaction"+flag);
				System.out.println(transaction.getAccountid());
				
			}
			else
			{
				throw new DataLayerException("Transaction not register Exception");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(flag);
		return flag;
	
	}

	public List<Transaction> allTransactions() {
	
		List<Transaction> transactionlist=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.ALL_TRANSACTIONS);
			
			ResultSet rs=ps.executeQuery();
			
			//System.out.println(cust.getId());
			
			while(rs.next()){
				
				
				String transactionid=rs.getString(1);
				String accountid=rs.getString(2);
				String message=rs.getString(3);
				int amount=rs.getInt(4);
				String lastupdated=rs.getString(5);
				 Transaction transaction=new Transaction(transactionid, accountid, message, amount, lastupdated);
				 transactionlist.add(transaction);
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return transactionlist;
	
	}

	public List<Transaction> searchbyTrnsactionidandAccountid(String search) {
		List<Transaction> transactionlist=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=OracleDatabaseUtil.getConnection();
			ps=con.prepareStatement(Queryconstants.SEARCH_BY_TRANSACTIONID_ACCOUNTID);
			ps.setString(1,"%"+search+"%");
			ps.setString(2,"%"+search+"%");
			
			ResultSet rs=ps.executeQuery();
			
			//System.out.println(cust.getId());
			
			while(rs.next()){
				
				
				String transactionid=rs.getString(1);
				String accountid=rs.getString(2);
				String message=rs.getString(3);
				int amount=rs.getInt(4);
				String lastupdated=rs.getString(5);
				 Transaction transaction=new Transaction(transactionid, accountid, message, amount, lastupdated);
				 transactionlist.add(transaction);
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return transactionlist;
	}

	
}
