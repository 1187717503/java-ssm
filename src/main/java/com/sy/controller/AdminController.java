package com.sy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sy.entity.Admin;
import com.sy.response.TaotaoResult;
import com.sy.service.AdminService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class AdminController {
	@Autowired
	private AdminService as;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult adminLogin(@RequestBody Admin a) {
		TaotaoResult tr = new TaotaoResult();
		Admin ad = as.select(a.getAdminname(), a.getPassword());
		if (ad == null) {
			tr.setMsg("登录失败");
			tr.setStatus(0);
		} else {
			tr.setMsg("登录成功");
			tr.setStatus(1);
		}
		tr.setData(a);
		return tr;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult regist(@RequestBody Admin a) {
		TaotaoResult tr = new TaotaoResult();
		if (as.regist(a)) {
			tr.setMsg("用户已存在");
			tr.setData(0);
		} else {
			tr.setMsg("注册成功");
			tr.setStatus(1);
		}
		tr.setData(a);
		return tr;
	}

}
