package com.sy.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.UserDao;
import com.sy.entity.NewOrder;
import com.sy.entity.User;
import com.sy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User checkLogin(String phone, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", phone);
		map.put("password", password);
		User user = userDao.findByUsernameAndPassword(map);
		return user;
	}

	/**
	 * 返回true 表示已注册 返回 false 表示未注册
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public boolean Regist(User user) {
		// 判断用户是否重复注册
		if (userDao.findByUsername(user.getPhone()) == null) {
			userDao.registerByUsernameAndPassword(user);
			return false;
		}
		return true;
	}

	@Override
	public User selectlevel(String phone) {
		// TODO Auto-generated method stub
		User u = userDao.selectLevel(phone);
		return u;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

}
