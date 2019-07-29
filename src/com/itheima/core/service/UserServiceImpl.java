package com.itheima.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.core.dao.Userdao;
import com.itheima.core.po.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private Userdao dao;
	@Override
	public User findUser(String usercode, String password) {
		return dao.findUser(usercode, password);
	}

}
