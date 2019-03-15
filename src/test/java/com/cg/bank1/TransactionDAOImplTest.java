package com.cg.bank1;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import com.cg.bank1.beans.Customer;
import com.cg.bank1.beans.Transaction;
import com.cg.bank1.transactiondao.TransactionDAOImpl;

class TransactionDAOImplTest {
static Transaction transaction= new Transaction();
static  Customer customer=new Customer();
static TransactionDAOImpl t=new TransactionDAOImpl();
 
	@Test
	void testWithDraw() {
		
		assertEquals(true, t.withdraw("123456789012", 500));
	}
	@Test
	void testDeposit() {
		assertEquals(true, t.deposit("123456789012", 500));
	}

	@Test
	void testBalance() {
		assertEquals(true, t.balance("123456789012", 50));
	}
	@Test
	void testFundTransfer() {
		transaction.setAmountTransfered(10);
		transaction.setFromAccountNo(1004);
		transaction.setToAccountNo(1001);
		assertEquals(transaction, t.fundTransfer(transaction));
	}



}
