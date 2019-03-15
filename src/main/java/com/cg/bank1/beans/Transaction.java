package com.cg.bank1.beans;

public class Transaction {
 private int transactionId;
 private int fromAccountNo;
 public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public int getFromAccountNo() {
	return fromAccountNo;
}
public void setFromAccountNo(int fromAccountNo) {
	this.fromAccountNo = fromAccountNo;
}
public int getToAccountNo() {
	return toAccountNo;
}
public void setToAccountNo(int toAccountNo) {
	this.toAccountNo = toAccountNo;
}
public int getAmountTransfered() {
	return AmountTransfered;
}
public void setAmountTransfered(int amountTransfered) {
	AmountTransfered = amountTransfered;
}
private int toAccountNo;
 private int AmountTransfered;

}
