package com.sy.service;

import java.util.List;

import com.sy.entity.WithdrawBank;

public interface WithdrawBankService {
	boolean insertWithdb(WithdrawBank wb);

	List<WithdrawBank> selectWithdb(String phone);
}
