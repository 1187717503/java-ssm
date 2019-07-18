package com.sy.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.SubmitDao;
import com.sy.entity.Submit;
import com.sy.service.SubmitService;

@Service
public class SubmitServiceImpl implements SubmitService {

	@Autowired
	private SubmitDao sd;

	@Override
	public boolean insertSub(Submit sb) {
		// TODO Auto-generated method stub
		sd.insertSub(sb);
		return true;
	}

	@Override
	public boolean updateSub(Submit sb) {
		// TODO Auto-generated method stub
		sd.updateSub(sb);
		return true;
	}

	@Override
	public Submit selectSub(String phone) {
		// TODO Auto-generated method stub
		Submit s = sd.selectSub(phone);
		return s;
	}

}
