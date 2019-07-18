package com.sy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sy.entity.RealName;
import com.sy.entity.SelectPhone;
import com.sy.response.TaotaoResult;
import com.sy.service.RealService;

@Controller
@RequestMapping("/real")
@SessionAttributes("real")
public class RealController {
	@Autowired
	private RealService realservice;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/insertReal", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult insertReal(@RequestBody RealName realname) {
		TaotaoResult tr = new TaotaoResult();
		if (realservice.select(realname.getPhone()) == null) {
			realservice.insert(realname);
			tr.setMsg("实名认证成功");
			tr.setStatus(1);
		} else {
			tr.setMsg("实名认证失败");
			tr.setStatus(0);
		}
		tr.setData(realname);
		return tr;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/updateReal", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult updateReal(@RequestBody RealName realname) {
		TaotaoResult tr = new TaotaoResult();
		if (realservice.update(realname)) {
			tr.setMsg("修改信息成功");
			tr.setStatus(1);
		} else {
			tr.setMsg("修改信息失败");
			tr.setStatus(0);
		}
		tr.setData(realname);
		return tr;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectReal", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectReal(@RequestBody RealName realname) {
		TaotaoResult tr = new TaotaoResult();
		RealName rn = realservice.select(realname.getPhone());
		if (rn == null) {
			tr.setMsg("没查到");
			tr.setStatus(0);
		} else {
			tr.setMsg("查到了");
			tr.setStatus(1);
		}
		tr.setData(rn);
		return tr;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectPhone", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectPhone(@RequestBody SelectPhone sp) {
		TaotaoResult tr = new TaotaoResult();
		SelectPhone rn = realservice.selectPhone(sp.getPhone());
		if (rn == null) {
			tr.setMsg("没查到");
			tr.setStatus(0);
		} else {
			tr.setMsg("查到了");
			tr.setStatus(1);
		}
		tr.setData(rn);
		return tr;

	}
}
