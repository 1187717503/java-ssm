package com.sy.dao;

import com.sy.entity.Submit;

public interface SubmitDao {
	void insertSub(Submit sb);

	boolean updateSub(Submit sb);

	Submit selectSub(String phone);
}
