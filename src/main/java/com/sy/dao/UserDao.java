package com.sy.dao;

import java.util.List;
import java.util.Map;

import com.sy.entity.NewOrder;
import com.sy.entity.User;

public interface UserDao {

	/**
	 * 查找用户名和密码
	 * 
	 * @param username
	 *            登录用户名
	 * @return
	 */
	User findByUsernameAndPassword(Map<String, String> map);

	/**
	 * 根据用户名查询用户
	 */
	User findByUsername(String phone);

	/*
	 * jasonzhang
	 * 
	 * 根据用户名查询等级
	 */
	User selectLevel(String phone);

	/**
	 * 注册用户和密码
	 */
	/*
	 * void registerByUsernameAndPassword(@Param("username")String username,
	 * 
	 * @Param("password")String password);
	 */
	void registerByUsernameAndPassword(User user);

	boolean update(User user);
}
