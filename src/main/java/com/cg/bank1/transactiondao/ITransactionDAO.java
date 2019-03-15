package com.cg.bank1.transactiondao;

import com.cg.bank1.beans.Transaction;

public interface ITransactionDAO {

	boolean withdraw(String adar, int bal);

	boolean deposit(String adar, int bal);

	boolean balance(String adar, int bal);

	

	Transaction fundTransfer(Transaction transaction);

}