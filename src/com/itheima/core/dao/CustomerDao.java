package com.itheima.core.dao;

import java.util.List;

import com.itheima.core.po.Customer;

public interface CustomerDao {
	public List<Customer> selectCustomerlist(Customer customer);
	public Integer countCustomer(Customer customer);
}
