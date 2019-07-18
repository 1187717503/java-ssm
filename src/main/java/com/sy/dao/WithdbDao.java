package com.sy.dao;

import java.util.List;

import com.sy.entity.WithdrawBank;

public interface WithdbDao {
	// 增加
	void insertWithdrawBank(WithdrawBank wb);

	// 查询
	List<WithdrawBank> selectWithdrawBank(String phone);
}
