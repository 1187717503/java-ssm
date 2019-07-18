package com.sy.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.WithdbDao;
import com.sy.entity.WithdrawBank;
import com.sy.service.WithdrawBankService;

@Service
public class WithdrawBankServiceImpl implements WithdrawBankService {

	@Autowired
	private WithdbDao wd;

	@Override
	public boolean insertWithdb(WithdrawBank wb) {
		// TODO Auto-generated method stub
		wd.insertWithdrawBank(wb);
		return true;
	}

	@Override
	public List<WithdrawBank> selectWithdb(String phone) {
		// TODO Auto-generated method stub
		List<WithdrawBank> wb = wd.selectWithdrawBank(phone);
		return wb;
	}

}
