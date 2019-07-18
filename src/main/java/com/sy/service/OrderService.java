package com.sy.service;

import java.util.List;

import com.sy.entity.NewOrder;
import com.sy.entity.SelectOrder;

public interface OrderService {
	// 发送存库里
	boolean insertOrder(NewOrder order);

	// 获取查询
	List<NewOrder> select(String phone);

	List<NewOrder> selectorder(String phone);

	List<SelectOrder> selectuserorder(String agencyIndex);

	List<NewOrder> selectAll();

	boolean update(NewOrder order);

}
