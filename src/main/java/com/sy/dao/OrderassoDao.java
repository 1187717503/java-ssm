package com.sy.dao;

import java.util.List;

import com.sy.entity.NewOrder;
import com.sy.entity.Orderassociation;

public interface OrderassoDao {
	void insertOrderass(Orderassociation oc);

	List<NewOrder> select();

	boolean update(Orderassociation oc);
}
