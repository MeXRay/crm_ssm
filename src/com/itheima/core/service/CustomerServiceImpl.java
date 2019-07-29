package com.itheima.core.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.common.utils.Page;
import com.itheima.core.dao.CustomerDao;
import com.itheima.core.po.Customer;

@Service("customerService") 
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;

	@Override
	public Page<Customer> findCustomerlist(Integer page, Integer row, String custName, String custSource,
			String custIndustry, String custLevel) {
		Customer customer = new Customer();
		if(StringUtils.isNotBlank(custName)) {
			customer.setCust_name(custName);
		}
		if(StringUtils.isNotBlank(custSource)) {
			customer.setCust_source(custSource);
		}	
		if(StringUtils.isNotBlank(custIndustry)) {
			customer.setCust_industry(custIndustry);
		}
		if(StringUtils.isNotBlank(custLevel)) {
			customer.setCust_level(custLevel);
		}
		customer.setStart((page-1)*row);
		customer.setRows(row);
		Page<Customer> page2 = new Page<Customer>();
		page2.setTotal(dao.countCustomer(customer));
		List<Customer> rows = dao.selectCustomerlist(customer);
		page2.setRows(rows);
		page2.setPage(page);
		page2.setSize(row);
		return page2;
	}


}
