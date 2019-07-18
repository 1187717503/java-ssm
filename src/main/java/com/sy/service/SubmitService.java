package com.sy.service;

import com.sy.entity.Submit;

public interface SubmitService {
	boolean insertSub(Submit sb);

	boolean updateSub(Submit sb);

	Submit selectSub(String phone);
}
