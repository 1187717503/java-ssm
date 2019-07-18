package com.sy.dao;

import java.util.List;

import com.sy.entity.BindBank;

public interface BindDao {
	// 增加
	void insertBind(BindBank bb);

	// 查询
	List<BindBank> selectBind(String phone);
}
