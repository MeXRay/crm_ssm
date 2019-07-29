package com.itheima.core.dao;

import java.util.List;

public interface BaseDictDao {
	public List<BaseDictDao> selectBaseDictByTypeCode(String dict_type_code);
}
