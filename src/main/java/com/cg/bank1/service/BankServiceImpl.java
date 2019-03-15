package com.cg.bank1.service;

import com.cg.bank1.menudao.IMenuDAO;
import com.cg.bank1.menudao.MenuDAOImpl;
import com.cg.bank1.transactiondao.ITransactionDAO;
import com.cg.bank1.transactiondao.TransactionDAOImpl;
import com.cg.bank1.beans.Customer;
import com.cg.bank1.beans.Transaction;

public class BankServiceImpl implements IBankService ,ITransactionDAO{
	boolean a=true;
	Customer customer=new Customer();
	IMenuDAO iMenuDAO = new MenuDAOImpl();
	ITransactionDAO iTransactionDAO=new TransactionDAOImpl();
	boolean i=true;

	public boolean emailValidation(String s) {
		if (s.contains("@")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean aadharValidation(String a) {

		if (a.length() == 12)
			return true;
		else
			return false;
	}

	public Customer setCustomerDetails(Customer customer) {
		 customer= iMenuDAO.setCustomerDetails(customer);
		return customer;
	}

	public  Customer login(int account,String password) {
		customer=iMenuDAO.login(account,password);
		return customer;

	}

	public boolean withdraw(String adar, int bal) {
		a=iTransactionDAO.withdraw(adar, bal);
		return a;

	}

	public boolean deposit(String adar, int bal) {
		a=iTransactionDAO.deposit(adar, bal);
		return a;

	}

	public boolean balance(String adar, int bal) {
		a=iTransactionDAO.balance(adar, bal);
		return a;

	}

	

	public Transaction fundTransfer(Transaction transaction) {

			transaction=iTransactionDAO.fundTransfer(transaction);
			return transaction;
		
	}

	
	
}