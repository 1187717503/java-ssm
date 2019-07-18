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

import com.sy.entity.WithdrawMoney;
import com.sy.response.TaotaoResult;
import com.sy.service.WithdrawMoneyService;

@Controller
@RequestMapping("/withdraw")
@SessionAttributes("withdraw")
public class WithdrawMoneyController {
	@Autowired
	private WithdrawMoneyService wms;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/insertWithdrawMoney", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult insertWithdrawMoney(@RequestBody WithdrawMoney wm) {
		TaotaoResult tr = new TaotaoResult();
		if (wms.insertWithdraw(wm)) {
			tr.setMsg("保存提币记录成功");
			tr.setStatus(1);
		} else {
			tr.setMsg("保存提币记录失败");
			tr.setStatus(0);
		}
		tr.setData(wm);
		return tr;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectWithdrawMoney", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectWithdrawMoney(@RequestBody WithdrawMoney wm) {
		TaotaoResult tr = new TaotaoResult();
		List<WithdrawMoney> wdm = wms.selectWithdraw(wm.getPhone());
		if (wdm == null) {
			tr.setMsg("查询记录失败");
			tr.setStatus(0);
		} else {
			tr.setMsg("查询记录成功");
			tr.setStatus(1);
		}
		tr.setData(wdm);

		return tr;
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectAll", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectAll() {
		TaotaoResult result = new TaotaoResult();
		List<WithdrawMoney> wm = wms.selectall();
		if (wm.size() == 0) {
			result.setMsg("没有记录");
			result.setStatus(0);
		} else {
			result.setMsg("有记录");
			result.setStatus(1);
		}
		result.setData(wm);
		return result;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult update(@RequestBody WithdrawMoney wm) {
		TaotaoResult result = new TaotaoResult();
		if (wms.update(wm)) {
			result.setMsg("修改成功");
			result.setStatus(1);
		} else {
			result.setMsg("修改失败");
			result.setStatus(0);
		}
		return result;
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult select() {
		TaotaoResult result = new TaotaoResult();
		List<WithdrawMoney> wm = wms.select();
		if (wm.size() == 0) {
			result.setMsg("没有记录");
			result.setStatus(0);
		} else {
			result.setMsg("有记录");
			result.setStatus(1);
		}
		result.setData(wm);
		return result;
	}

}
