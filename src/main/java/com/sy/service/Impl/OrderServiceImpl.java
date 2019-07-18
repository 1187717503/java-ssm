package com.sy.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.OrderDao;
import com.sy.dao.OrderassoDao;
import com.sy.entity.NewOrder;
import com.sy.entity.Orderassociation;
import com.sy.entity.SelectOrder;
import com.sy.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderdao;
	@Autowired
	private OrderassoDao od;

	/*
	 * true 表示创建订单陈宫 false 表示失败
	 * 
	 */
	@Override
	public boolean insertOrder(NewOrder order) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = "h1";
		Date d2 = new Date();
		String s2 = sdf.format(d2);
		String s3 = s + s2;
		order.setOrdernum(s3);

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		Date d3 = new Date();
		String s1 = sdf1.format(d3);
		order.setDate(s1);
		order.setStatus("1");

		// 关联订单
		Orderassociation oc = new Orderassociation();
		oc.setOrdernum(order.getOrdernum());
		oc.setPhone(order.getPhone());
		oc.setStatus(order.getStatus());// 这个状态不需要一致
		orderdao.insertorder(order);
		od.insertOrderass(oc);
		return true;

	}

	@Override
	public List<NewOrder> select(String phone) {
		// TODO Auto-generated method stub
		List<NewOrder> order = orderdao.findByphone(phone);
		return order;
	}

	@Override
	public List<NewOrder> selectorder(String phone) {
		// TODO Auto-generated method stub
		List<NewOrder> order = orderdao.selectorder(phone);
		return order;
	}

	@Override
	public List<SelectOrder> selectuserorder(String agencyIndex) {
		// TODO Auto-generated method stub
		List<SelectOrder> order = orderdao.selectuserorder(agencyIndex);
		return order;
	}

	@Override
	public List<NewOrder> selectAll() {
		// TODO Auto-generated method stub
		List<NewOrder> order = orderdao.selectall();
		return order;
	}

	@Override
	public boolean update(NewOrder order) {
		// TODO Auto-generated method stub
		return orderdao.update(order);
	}

}
