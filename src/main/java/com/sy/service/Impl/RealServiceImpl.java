package com.sy.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.RealDao;
import com.sy.entity.RealName;
import com.sy.entity.SelectPhone;
import com.sy.service.RealService;

@Service
public class RealServiceImpl implements RealService {

	@Autowired
	private RealDao rd;

	@Override
	public boolean insert(RealName realname) {
		// TODO Auto-generated method stub
		rd.insertReal(realname);
		return true;
	}

	@Override
	public boolean update(RealName realname) {
		// TODO Auto-generated method stub
		rd.updateReal(realname);
		return true;
	}

	@Override
	public RealName select(String phone) {
		// TODO Auto-generated method stub
		RealName rn = rd.selectReal(phone);
		return rn;
	}

	@Override
	public SelectPhone selectPhone(String phone) {
		// TODO Auto-generated method stub
		SelectPhone sp = rd.selectPhone(phone);
		return sp;
	}

}
