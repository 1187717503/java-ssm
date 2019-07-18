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

import com.sy.entity.BindBank;
import com.sy.response.TaotaoResult;
import com.sy.service.BindService;

@Controller
@RequestMapping("/bindbank")
@SessionAttributes("bindbank")
public class BindBankController {

	@Autowired
	private BindService bs;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/insertBind", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult insertBind(@RequestBody BindBank bb) {
		TaotaoResult result = new TaotaoResult();
		if (bs.select(bb.getPhone()).isEmpty()) {
			bs.insertBind(bb);
			result.setMsg("绑定银行卡成功");
			result.setStatus(1);
		} else {
			result.setMsg("绑定银行卡失败或者该用户已经绑定");
			result.setStatus(0);
		}
		result.setData(bb);
		return result;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectBind", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectBind(@RequestBody BindBank bb) {
		TaotaoResult result = new TaotaoResult();
		List<BindBank> b = bs.select(bb.getPhone());
		if (b == null) {
			result.setMsg("没有绑定银行卡");
			result.setStatus(0);
		} else {
			result.setMsg("绑定银行卡");
			result.setStatus(1);
		}
		result.setData(b);
		return result;

	}
}
