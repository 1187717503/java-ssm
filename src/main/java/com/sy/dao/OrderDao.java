package com.sy.dao;

import java.util.List;
import java.util.Map;

import com.sy.entity.NewOrder;
import com.sy.entity.Order;
import com.sy.entity.SelectOrder;

public interface OrderDao {
	// 增加
	void insertorder(NewOrder order);

	// 根据手机号查询
	List<NewOrder> findByphone(String phone);

	List<NewOrder> selectorder(String phone);

	List<SelectOrder> selectuserorder(String agencyIndex);

	List<NewOrder> selectall();

	boolean update(NewOrder order);

}
