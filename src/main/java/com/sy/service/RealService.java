package com.sy.service;

import com.sy.entity.RealName;
import com.sy.entity.SelectPhone;

public interface RealService {
	boolean insert(RealName realname);

	boolean update(RealName realname);

	RealName select(String phone);

	SelectPhone selectPhone(String phone);
}
