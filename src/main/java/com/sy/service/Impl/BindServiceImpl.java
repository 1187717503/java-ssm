package com.sy.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.BindDao;
import com.sy.entity.BindBank;
import com.sy.service.BindService;

@Service
public class BindServiceImpl implements BindService {

	@Autowired
	private BindDao bd;

	@Override
	public boolean insertBind(BindBank bb) {
		// TODO Auto-generated method stub
		bd.insertBind(bb);
		return true;
	}

	@Override
	public List<BindBank> select(String phone) {
		// TODO Auto-generated method stub
		List<BindBank> bindbank = bd.selectBind(phone);
		return bindbank;
	}

}
