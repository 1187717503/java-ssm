package com.sy.dao;

import java.util.List;

import com.sy.entity.WithdrawMoney;

public interface WithdrawDao {
	// 增加
	void insertWithdraw(WithdrawMoney wm);

	// 查询
	List<WithdrawMoney> findByPhone(String phone);

	List<WithdrawMoney> selectall();

	List<WithdrawMoney> select();

	boolean update(WithdrawMoney wm);
}
