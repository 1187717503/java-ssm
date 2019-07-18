package com.sy.controller;

import java.util.List;

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
import com.sy.response.TaotaoResult;
import com.sy.service.OrderassoService;

@Controller
@RequestMapping("/orderasso")
@SessionAttributes("orderasso")
public class OrderassoController {
	@Autowired
	private OrderassoService os;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectAll", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult select() {
		TaotaoResult result = new TaotaoResult();
		List<NewOrder> no = os.select();
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
	public TaotaoResult update(@RequestBody Orderassociation oc) {
		TaotaoResult result = new TaotaoResult();
		if (os.update(oc)) {
			result.setMsg("修改成功");
			result.setStatus(1);
		} else {
			result.setMsg("修改失败");
			result.setStatus(0);
		}
		return result;

	}
}
