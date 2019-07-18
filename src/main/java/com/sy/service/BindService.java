package com.sy.service;

import java.util.List;

import com.sy.entity.BindBank;

public interface BindService {
	boolean insertBind(BindBank bb);

	List<BindBank> select(String phone);
}
