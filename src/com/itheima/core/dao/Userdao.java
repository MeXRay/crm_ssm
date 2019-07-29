package com.itheima.core.dao;

import org.apache.ibatis.annotations.Param;

import com.itheima.core.po.User;

public interface Userdao {
	//@Param接收数据库传过来的给name
	public User findUser(@Param("usercode")String usercode,@Param("password")String password);
}
