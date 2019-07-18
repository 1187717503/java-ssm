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
import com.sy.entity.Submit;
import com.sy.response.TaotaoResult;
import com.sy.service.SubmitService;

@Controller
@RequestMapping("/submit")
@SessionAttributes("submit")
public class SubmitController {
	@Autowired
	private SubmitService sub;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/insertSub", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult insertSub(@RequestBody Submit sb) {
		TaotaoResult tr = new TaotaoResult();

		if (sub.selectSub(sb.getPhone()) == null) {
			sub.insertSub(sb);
			tr.setMsg("提交成功");
			tr.setStatus(1);
		} else {
			tr.setMsg("提交失败");
			tr.setStatus(0);
		}
		tr.setData(sb);
		return tr;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/updateSub", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult updateSub(@RequestBody Submit sb) {
		TaotaoResult tr = new TaotaoResult();
		if (sub.updateSub(sb)) {
			tr.setMsg("修改信息成功");
			tr.setStatus(1);
		} else {
			tr.setMsg("修改信息失败");
			tr.setStatus(0);
		}
		tr.setData(sb);
		return tr;
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectSub", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectSub(@RequestBody Submit sb) {
		TaotaoResult tr = new TaotaoResult();
		Submit s = sub.selectSub(sb.getPhone());
		if (s == null) {
			tr.setMsg("没有查到");
			tr.setStatus(0);
		} else {
			tr.setMsg("查到了");
			tr.setStatus(1);
		}
		tr.setData(s);
		return tr;

	}

}
