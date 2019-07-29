package com.itheima.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.core.dao.BaseDictDao;

@Service("baseDictService")
@Transactional
public class BaseDictServiceImpl implements BaseDictService{
	@Autowired
	private BaseDictDao dao;
	@Override
	public List<BaseDictDao> findBaseDictlist(String dict_type_code) {
		return dao.selectBaseDictByTypeCode(dict_type_code);
	
	}

}
