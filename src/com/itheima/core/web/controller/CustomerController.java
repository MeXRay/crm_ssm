package com.itheima.core.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itheima.common.utils.Page;
import com.itheima.core.dao.BaseDictDao;
import com.itheima.core.po.Customer;
import com.itheima.core.service.BaseDictService;
import com.itheima.core.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService service;
	@Autowired
	private BaseDictService baseService;
//springmvc已加载resource。properties
	@Value("${customer.from.type}")
	private String FROM_TYPE;
	@Value("${customer.industry.type}")
	private String INDUSTRY_TYPE;
	@Value("${customer.level.type}")
	private String LEVEL_TYPE;
	@RequestMapping("/customer/list.action")
	public String selectCustomerlist(@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer row,String custName,String custSource,String custIndustry,String custLevel,Model model,HttpSession session) {
		
		Page<Customer> result = service.findCustomerlist(page, row, custName, custSource, custIndustry, custLevel);
		//"page" 是根据jsp名字来取的
		model.addAttribute("page",result);
		List<BaseDictDao> fromType = baseService.findBaseDictlist(FROM_TYPE);
		List<BaseDictDao> industryType = baseService.findBaseDictlist(INDUSTRY_TYPE);
		List<BaseDictDao> levelType = baseService.findBaseDictlist(LEVEL_TYPE);
		model.addAttribute("fromType",fromType);
		model.addAttribute("industryType",industryType);
		model.addAttribute("levelType",levelType);
		model.addAttribute("custName",custName);
		model.addAttribute("custSource",custSource);
		model.addAttribute("custIndustry",custIndustry);
		model.addAttribute("custLevel",custLevel);
		return "customer";
	}
}
