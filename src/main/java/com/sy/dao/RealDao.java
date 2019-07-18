package com.sy.dao;

import com.sy.entity.RealName;
import com.sy.entity.SelectPhone;

public interface RealDao {

	void insertReal(RealName realname);

	boolean updateReal(RealName realname);

	RealName selectReal(String phone);

	SelectPhone selectPhone(String phone);

}
