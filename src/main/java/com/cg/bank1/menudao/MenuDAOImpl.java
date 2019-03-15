package com.cg.bank1.menudao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.bank1.App;
import com.cg.bank1.beans.Customer;

public class MenuDAOImpl implements IMenuDAO {
	Scanner sc = new Scanner(System.in);
	Customer customer=new Customer();

	public Customer setCustomerDetails(Customer customer) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MANISHA", "oracle123");
			PreparedStatement ps = con.prepareStatement("insert into customer_details values(acc_seq.nextval,?,?,?,?,?,?,?,?,?)");
			//ps.setInt(1, cust_seq.nextval);
			ps.setString(1,customer.getFirstName());
			ps.setString(2,customer.getLastName());
			ps.setString(3,customer.getEmailId());
			ps.setString(4,customer.getPassword());
			ps.setString(5,customer.getPancardNo());
			ps.setString(6,customer.getAadharNo());
			ps.setString(7,customer.getAddress());
			ps.setInt(8,customer.getMobileNo());
			ps.setInt(9, customer.getBalance());

			int i = ps.executeUpdate();



			if (i == 1) {
				System.out.println("done");

			} else {
				System.out.println("could not insert data");
			}

			con.close();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	public Customer login(int account,String password) {
		int i=0;
		customer.setAccountNo(account);
		customer.setPassword(password);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MANISHA", "oracle123");
			
			PreparedStatement ps = con.prepareStatement("select * from customer_details where account_no=? and password=?");
			ps.setInt(1, customer.getAccountNo());
			ps.setString(2, customer.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("login successful..."+rs.getString(2));
				customer.setAadharNo(rs.getString(7));
				customer.setBalance(rs.getInt(10));
				i++;



			} else {
				System.out.println("invalid details");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} if(i==0)return null;
		else return customer;

	}

}