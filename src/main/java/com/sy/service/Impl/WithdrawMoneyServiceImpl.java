package com.sy.service.Impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.WithdrawDao;
import com.sy.entity.WithdrawMoney;
import com.sy.service.WithdrawMoneyService;

@Service
public class WithdrawMoneyServiceImpl implements WithdrawMoneyService {

	@Autowired
	private WithdrawDao wd;

	@Override
	public boolean insertWithdraw(WithdrawMoney wm) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = "h1";
		Date d2 = new Date();
		s = s + sdf.format(d2);
		wm.setCaseorder(s);

		SimpleDateFormat sdf1 = new SimpleDateFormat("MMM d, yyyy, K:m:s a", Locale.ENGLISH);
		DecimalFormat df = new DecimalFormat("#####.0000");
		Date d3 = new Date();
		sdf1.format(d3);
		wm.setDate(d3);
		// double num;
		/*
		 * DecimalFormat df = new DecimalFormat("#####.0000"); Double d =
		 * 1.3482; System.out.println(Double.parseDouble(df.format(d-0.002)));
		 */
		// wm.setNum(Double.parseDouble(df.format(wm.getNum())));
		double realnum = Double.parseDouble(df.format(wm.getNum() - (wm.getNum() * 0.003)));// 0.02-
		wm.setRealnum(realnum);
		wm.setStatus("1");
		wd.insertWithdraw(wm);
		return true;
	}

	@Override
	public List<WithdrawMoney> selectWithdraw(String phone) {
		// TODO Auto-generated method stub
		List<WithdrawMoney> wm = wd.findByPhone(phone);
		return wm;
	}

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#####.0000");
		Double d = 1.3482;
		System.out.println(Double.parseDouble(df.format(d - 0.002)));
	}

	@Override
	public List<WithdrawMoney> selectall() {
		// TODO Auto-generated method stub
		List<WithdrawMoney> wm = wd.selectall();
		return wm;
	}

	@Override
	public boolean update(WithdrawMoney wm) {
		// TODO Auto-generated method stub
		return wd.update(wm);
	}

	@Override
	public List<WithdrawMoney> select() {
		// TODO Auto-generated method stub
		List<WithdrawMoney> wm = wd.select();
		return wm;
	}

}
