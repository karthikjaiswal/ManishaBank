package com.cg.bank1;

import java.util.Scanner;

import com.cg.bank1.service.BankServiceImpl;
import com.cg.bank1.service.IBankService;
import com.cg.bank1.transactiondao.ITransactionDAO;
import com.cg.bank1.transactiondao.TransactionDAOImpl;
import com.cg.bank1.beans.Customer;
import com.cg.bank1.beans.Transaction;

public class App 
{
	static Scanner sc = new Scanner(System.in);

	 static IBankService iBankService = new BankServiceImpl();
	 static BankServiceImpl bankServiceImpl= new BankServiceImpl();
	 static ITransactionDAO iTransactionDAO= new  TransactionDAOImpl();
	static  Customer customer=new Customer();
	static Transaction transaction =new Transaction();


    public static void main( String[] args )
    {

		 boolean i=true;
		 int ch1=0;
		 do {
       System.out.println("enter 1.Registration \n2.login \n 3.Exit");
       int ch= sc.nextInt();
       switch(ch)
       {
       case 1:
    	   System.out.println("enter firstname");
    	   customer.setFirstName(sc.next());
    	   System.out.println("enter last name");
    	   customer.setLastName(sc.next());
    	   System.out.println("enter email address");
    	   String s= sc.next();
    	   i=bankServiceImpl.emailValidation(s);
    	   if(i==true)
    	   {
    		   customer.setEmailId(s);
    	   }
    	   else {
    		   System.out.println("invalid email");
    	   }
    	   System.out.println("enter password");
    	   customer.setPassword(sc.next());
    	   System.out.println("enter pancard_no");
    	   customer.setPancardNo(sc.next());
    	   System.out.println("enter aadhar_no");
    	   String a=sc.next();
           i=bankServiceImpl.aadharValidation(a);
    	   if(i==true) {
    	   customer.setAadharNo(a);
    	   }
    	   else {
    		   System.out.println("invalid aadhar no");
    	   }

    	   System.out.println("enter address");
    	   customer.setAddress(sc.next());
    	   System.out.println("enter mobile no");
    	   customer.setMobileNo(sc.nextInt());
    	   customer.setBalance(0);

  customer=iBankService.setCustomerDetails(customer);
    	   break;
       case 2:
    	   System.out.println("enter account number");
    	   int account=sc.nextInt();
		
		System.out.println("enter password");
		String password=sc.next();
		
    	 customer= iBankService.login(account,password);
    	 
    	  if(i==true) {
    	   String adar=customer.getAadharNo();
    	   System.out.println(adar);
    	   int bal=customer.getBalance();
    	   do {
    			System.out.println("1.withdraw 2.deposit 3.balance 4.fund transfer");
    			int b=sc.nextInt();
    			switch(b)
    			{
    			case 1:
    			iBankService.withdraw(adar,bal);
			break;
    			case 2:
    			iBankService.deposit(adar,bal);
			break;
    			case 3:
    				iBankService.balance(adar,bal);
		break;
    			case 4:
    				System.out.println("enter from account number");
    				transaction.setFromAccountNo(sc.nextInt());
    				System.out.println("enter to account number");
    				transaction.setToAccountNo(sc.nextInt());
    				System.out.println("enter amount to be transfered");
    				
    				transaction.setAmountTransfered(sc.nextInt());
    				transaction=iBankService.fundTransfer(transaction);
    				System.out.println("-----printing transaction----");
    				System.out.println("transaction id:"+transaction.getTransactionId());
    				System.out.println("from_account_no:"+transaction.getFromAccountNo());
    				System.out.println("to_account_no:"+transaction.getToAccountNo());
    				System.out.println("amount transfered:"+transaction.getAmountTransfered());
    				System.out.println("enter 1 to exit 0 to continue");
    				ch1=sc.nextInt();
    				break;
    			}
    			}while(ch1==0);
    		}break;
    	  case 3:System.exit(0);
    		break;
    	  }
		 }while(true);
    }

}