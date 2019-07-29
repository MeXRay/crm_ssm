package com.itheima.core.service;

import com.itheima.common.utils.Page;
import com.itheima.core.po.Customer;

public interface CustomerService {
	public Page<Customer> findCustomerlist(Integer page,Integer row,
			String custName,String custSource,String custIndustry,String custLevel);
}
