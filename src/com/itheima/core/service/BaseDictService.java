package com.itheima.core.service;

import java.util.List;

import com.itheima.core.dao.BaseDictDao;

public interface BaseDictService {
	public List<BaseDictDao> findBaseDictlist(String dict_type_code);
}
