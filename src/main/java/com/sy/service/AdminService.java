package com.sy.service;

import com.sy.entity.Admin;

public interface AdminService {
	Admin select(String adminname, String password);

	boolean regist(Admin a);
}
