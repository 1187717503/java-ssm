package com.sy.service;

import java.util.List;

import com.sy.entity.NewOrder;
import com.sy.entity.User;

//Service层接口
public interface UserService {

	// 检验用户登录
	User checkLogin(String phone, String password);

	boolean Regist(User user);

	User selectlevel(String phone);

	boolean update(User user);
}
