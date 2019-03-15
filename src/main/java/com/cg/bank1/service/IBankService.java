package com.cg.bank1.service;

import com.cg.bank1.beans.Customer;
import com.cg.bank1.beans.Transaction;

public interface IBankService {
	Customer customer =new Customer();
Transaction transaction=new Transaction();


	 Customer setCustomerDetails(Customer customer);

	Customer login(int account,String password);

	boolean withdraw(String adar, int bal);

	boolean deposit(String adar, int bal);

	boolean balance(String adar, int bal);

	Transaction fundTransfer(Transaction transaction); 


} 