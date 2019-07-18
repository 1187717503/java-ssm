package com.sy.dao;

import java.util.Map;

import com.sy.entity.Admin;

public interface AdminDao {
	Admin findByadminname(Map<String, String> map);

	void regist(Admin a);

	Admin find(String adminname);
}
