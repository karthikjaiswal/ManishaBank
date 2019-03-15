package com.cg.bank1.menudao;

import com.cg.bank1.beans.Customer;

import junit.framework.TestCase;

public class MenuDAOImplTest extends TestCase {
	static  Customer customer=new Customer();
	MenuDAOImpl m= new MenuDAOImpl();
@Test
public void testCustomerDetails() {
	customer.setFirstName("manisha");
	customer.setLastName("bukka");
	customer.setEmailId("manisha@gmail.com");
	customer.setPassword("123");
	customer.setPancardNo("1234567");
	customer.setAadharNo("123456789098");
	customer.setAddress("hudacolony");
	customer.setMobileNo(779494672);
	customer.setBalance(2000);
	customer=m.setCustomerDetails(customer);
	assertEquals(customer, customer);
}
@Test
public void testLogin()
{
	customer=m.login(1002,"456");
	assertEquals(customer, customer);
}
}
