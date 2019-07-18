package com.sy.service;

import java.util.List;

import com.sy.entity.NewOrder;
import com.sy.entity.Orderassociation;

public interface OrderassoService {
	boolean insert(Orderassociation oc);

	List<NewOrder> select();

	boolean update(Orderassociation oc);
}
