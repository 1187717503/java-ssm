package com.sy.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.AdminDao;
import com.sy.entity.Admin;
import com.sy.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao ad;

	@Override
	public Admin select(String adminname, String password) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("adminname", adminname);
		map.put("password", password);
		Admin a = ad.findByadminname(map);
		return a;
	}

	@Override
	public boolean regist(Admin a) {
		// TODO Auto-generated method stub
		if (ad.find(a.getAdminname()) == null) {
			ad.regist(a);
			return false;
		}
		return true;
	}

}
