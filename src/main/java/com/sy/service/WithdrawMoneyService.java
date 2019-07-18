package com.sy.service;

import java.util.List;

import com.sy.entity.WithdrawMoney;

public interface WithdrawMoneyService {
	boolean insertWithdraw(WithdrawMoney wm);

	List<WithdrawMoney> selectWithdraw(String phone);

	List<WithdrawMoney> selectall();

	boolean update(WithdrawMoney wm);

	List<WithdrawMoney> select();
}
