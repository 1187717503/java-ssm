package com.sy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sy.entity.NewOrder;
import com.sy.entity.Orderassociation;
import com.sy.entity.SelectOrder;
import com.sy.entity.User;
import com.sy.response.TaotaoResult;
import com.sy.service.OrderService;
import com.sy.service.OrderassoService;

@Controller
@RequestMapping("/order")
@SessionAttributes("order")
public class OrderController {

	@Autowired
	private OrderService orderservice;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createOrder(@RequestBody NewOrder order) {

		TaotaoResult result = new TaotaoResult();
		if (orderservice.insertOrder(order)) {
			result.setMsg("创建订单成功");
			result.setStatus(1);
		} else {
			result.setMsg("创建订单失败");
			result.setStatus(0);
		}
		result.setData(order);
		return result;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectOrder", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectOrder(@RequestBody NewOrder order) {
		TaotaoResult result = new TaotaoResult();
		List<NewOrder> order1 = orderservice.select(order.getPhone());
		result.setData(order1);
		if (order1 == null) {
			result.setStatus(0);
			result.setMsg("订单不存在");
		} else {
			result.setStatus(1);
			result.setMsg("订单存在");
		}
		return result;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectOrderj", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectOrderj(@RequestBody NewOrder order) {
		TaotaoResult result = new TaotaoResult();
		// 查询出来的是当前用户状态为0的所有订单
		// 需要把这写订单的num累加如果>=180就是经销商
		List<NewOrder> no = orderservice.selectorder(order.getPhone());
		int total = 0;
		for (NewOrder newOrder : no) {
			String num = newOrder.getNum();// 当前的数量2

			int a = Integer.parseInt(num);
			total += a;
		}
		if (total >= 180) {
			result.setStatus(1);
			result.setMsg("该用户是经销商");

		} else {
			result.setStatus(0);
			result.setMsg("该用户不是经销商");
		}

		result.setData(no);
		return result;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectuserorder", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectuserorder(@RequestBody SelectOrder so) {
		TaotaoResult result = new TaotaoResult();
		List<SelectOrder> no = orderservice.selectuserorder(so.getAgencyIndex());

		if (no == null) {
			result.setMsg("代理商没有提成");
			result.setStatus(0);
		} else {
			result.setMsg("代理商有提成");
			result.setStatus(1);
		}
		result.setData(no);
		return result;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectAll", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectAll() {
		TaotaoResult result = new TaotaoResult();
		List<NewOrder> no = orderservice.selectAll();
		if (no.size() == 0) {
			result.setMsg("没有订单");
			result.setStatus(0);
		} else {
			result.setMsg("有订单");
			result.setStatus(1);
		}
		result.setData(no);
		return result;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult update(@RequestBody NewOrder order) {
		TaotaoResult result = new TaotaoResult();
		if (orderservice.update(order)) {
			result.setMsg("修改成功");
			result.setStatus(1);
		} else {
			result.setMsg("修改失败");
			result.setStatus(0);
		}
		return result;

	}

}
