package com.sy.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.RewardDao;
import com.sy.entity.RewardCash;
import com.sy.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService {
	@Autowired
	private RewardDao rd;

	@Override
	public boolean insertReward(RewardCash rc) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date d2 = new Date();
		String s = sdf.format(d2);
		rc.setDate(s);
		rc.setStatus("1");
		rd.insertReward(rc);
		return true;
	}

	@Override
	public List<RewardCash> selectReward(String phone) {
		// TODO Auto-generated method stub
		List<RewardCash> rc = rd.selectReward(phone);
		return rc;
	}

}
