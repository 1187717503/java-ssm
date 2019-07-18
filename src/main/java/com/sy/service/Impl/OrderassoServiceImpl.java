package com.sy.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.OrderassoDao;
import com.sy.entity.NewOrder;
import com.sy.entity.Orderassociation;
import com.sy.service.OrderassoService;

@Service
public class OrderassoServiceImpl implements OrderassoService {
	@Autowired
	private OrderassoDao od;

	@Override
	public boolean insert(Orderassociation oc) {
		// TODO Auto-generated method stub
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); String
		 * s = "h1"; Date d2 = new Date(); String s2 = sdf.format(d2); String s3
		 * = s + s2; oc.setOrdernum(s3); oc.setStatus("1");
		 */
		od.insertOrderass(oc);
		return true;
	}

	@Override
	public List<NewOrder> select() {
		// TODO Auto-generated method stub
		List<NewOrder> o = od.select();
		return o;
	}

	@Override
	public boolean update(Orderassociation oc) {
		// TODO Auto-generated method stub
		return od.update(oc);
	}

}
