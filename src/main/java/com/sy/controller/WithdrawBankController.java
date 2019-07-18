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

import com.sy.entity.WithdrawBank;
import com.sy.response.TaotaoResult;
import com.sy.service.WithdrawBankService;

@Controller
@RequestMapping("/withdrawbank")
@SessionAttributes("withdrawbank")
public class WithdrawBankController {
	@Autowired
	private WithdrawBankService wbs;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/insertWithdrawBank", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult insertWithdrawBank(@RequestBody WithdrawBank wb) {
		TaotaoResult tr = new TaotaoResult();
		if (wbs.selectWithdb(wb.getPhone()).isEmpty()) {
			wbs.insertWithdb(wb);
			tr.setMsg("保存成功");
			tr.setStatus(1);
		} else {
			tr.setMsg("保存失败");
			tr.setStatus(0);
		}
		tr.setData(wb);
		return tr;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectWithdrawBank", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectWithdrawBank(@RequestBody WithdrawBank wb) {
		TaotaoResult tr = new TaotaoResult();
		List<WithdrawBank> wdb = wbs.selectWithdb(wb.getPhone());
		if (wdb == null) {
			tr.setMsg("查询失败");
			tr.setStatus(0);
		} else {
			tr.setMsg("查询成功");
			tr.setStatus(1);
		}
		tr.setData(wdb);
		return tr;

	}

}
