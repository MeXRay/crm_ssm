package com.itheima.core.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itheima.core.po.User;
import com.itheima.core.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	@RequestMapping(value="/toCustomer.action")
	public String test() {
		return "customer";
	}
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String usercode,String password,Model model,HttpSession session) {
		User findUser = service.findUser(usercode, password);
		System.out.println("haha");
		if(findUser!=null) {
			session.setAttribute("USER_SESSION",findUser);
			System.out.println("hehe");
			return "redirect:/customer/list.action";
		}
		model.addAttribute("msg","重新输入");
		return "login";
	}
	
	@RequestMapping("/logout.action")
	public String Logout(HttpSession session){
		session.invalidate();
		return "redirect:login.action";
	}
	@RequestMapping("/login.action")
	public String Login() {
		return "login";
	}
}
