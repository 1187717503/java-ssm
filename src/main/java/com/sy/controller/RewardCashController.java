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

import com.sy.entity.RewardCash;
import com.sy.response.TaotaoResult;
import com.sy.service.RewardService;

@Controller
@RequestMapping("/rewardcash")
@SessionAttributes("rewardcash")
public class RewardCashController {
	@Autowired
	private RewardService rs;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/insertReward", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult insertReward(@RequestBody RewardCash rc) {
		TaotaoResult tr = new TaotaoResult();
		if (rs.selectReward(rc.getPhone()).isEmpty()) {
			rs.insertReward(rc);
			tr.setMsg("保存成功");
			tr.setStatus(1);
		} else {
			tr.setMsg("保存失败");
			tr.setStatus(0);
		}
		tr.setData(rc);
		return tr;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectReward", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectReward(@RequestBody RewardCash rc) {
		TaotaoResult tr = new TaotaoResult();
		List<RewardCash> r = rs.selectReward(rc.getPhone());
		if (r == null) {
			tr.setMsg("查询失败");
			tr.setStatus(0);
		} else {
			tr.setMsg("查询成功");
			tr.setStatus(1);
		}
		tr.setData(r);
		return tr;

	}

}
