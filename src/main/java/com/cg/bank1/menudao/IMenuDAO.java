package com.cg.bank1.menudao;

import com.cg.bank1.beans.Customer;

public interface IMenuDAO {

	Customer setCustomerDetails(Customer customer);

	Customer  login(int account,String password);



}