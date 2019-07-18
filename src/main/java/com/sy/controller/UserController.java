package com.sy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sy.entity.User;
import com.sy.response.TaotaoResult;
import com.sy.service.UserService;
import com.sy.until.SmsUtil;
import com.sy.until.Storage;

//@SessionAttributes(value={"verifycode"},types={Integer.class})
@Controller
@RequestMapping("/user")

// 这里用了@SessionAttributes，可以直接把model中的user(也就key)放入其中
// 这样保证了session中存在user这个对象
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userServivce;

	// 正常访问login页面
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// 表单提交过来的路径
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult checkLogin(@RequestBody User user) {
		// 调用service方法
		User user1 = userServivce.checkLogin(user.getPhone(), user.getPassword());
		TaotaoResult tr = new TaotaoResult();
		tr.setData(user);
		if (user1 == null) {
			tr.setStatus(0);
			tr.setMsg("用户名或密码不正确");
		} else {
			tr.setStatus(1);
			tr.setMsg("登陆成功");
		}
		return tr;
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/doRegist", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult doRegist(@RequestBody User user) {
		TaotaoResult result = new TaotaoResult();
		// 1 先校验验证码
		// 1.1验证码正确 ,校验用户信息
		// 1.1.1注册成功
		// 1.1.2注册失败
		// 1.2验证码错误, 返回错误信息

		// 也可以先校验用户, 再校验验证码

		// if(user.getVerifycode().equals(session.getAttribute("verifycode"))){
		if (userServivce.Regist(user)) {
			result.setMsg("用户已存在");
			result.setStatus(0);
		} else {// 验证码正确 并且 用户信息不存在
			result.setMsg("用户注册成功");
			result.setStatus(1);
		}
		/*
		 * }else { result.setMsg("验证码不正确"); result.setStatus(0); }
		 */

		result.setData(user);
		return result;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/registerVerifyPost", method = RequestMethod.POST)
	@ResponseBody
	public String registerVerifyPost(@RequestBody String userInfo, HttpSession httpSession) {
		User u = new User();
		GsonBuilder builder = new GsonBuilder();
		System.out.println(userInfo);
		Gson gson = builder.create();
		u = gson.fromJson(userInfo, User.class);
		if ((u.getPhone() != null)) {
			int verifyCode = SmsUtil.getRandom();
			SmsUtil.sendSms(u.getPhone(), verifyCode);// 这个是短信那个那人写好的
			httpSession.setAttribute("verifyCode", String.valueOf(verifyCode));
			Storage.getVerifyMap().put(u.getPhone(), verifyCode);
		}
		return gson.toJson(u);
		// 前端页面 总共两个按钮 一个是点击发送验证码
		// 一个是注册按钮
		/* 点击发送验证码执行下面的操作 */
		// 调用一个随机数工具类,生成一个验证码
		// 将验证码放在Session中
		// 调用阿里云接口, 将验证码作为短信内容发送给手机用户

		/* 点击注册执行下面的操作 */
		// 从表单中取出用户输入的验证码
		// 从session中取出 验证码
		// 进行比较

		// 写一个短信接口, 让前端调用
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/sendMsg/{phone}", method = RequestMethod.GET)
	@ResponseBody
	public TaotaoResult sendMsg(@PathVariable String phone, HttpSession session) {
		int verifycode = SmsUtil.getRandom();
		SmsUtil.sendSms(phone, verifycode);
		session.setAttribute("verifycode", String.valueOf(verifycode));
		String data = "{phone:" + phone + ",verifycode:" + verifycode + "}";// 这不是好的嘛

		return new TaotaoResult().ok(data);
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/selectlevel", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult selectlevel(@RequestBody User user) {
		TaotaoResult result = new TaotaoResult();
		User u = userServivce.selectlevel(user.getPhone());
		if (u == null) {
			result.setMsg("没有等级");
			result.setStatus(0);
		} else {
			result.setMsg("有等级");
			result.setStatus(1);
		}
		result.setData(u);
		return result;

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult update(@RequestBody User user) {
		TaotaoResult result = new TaotaoResult();
		if (userServivce.update(user)) {
			result.setMsg("修改成功");
			result.setStatus(1);
		} else {
			result.setMsg("修改失败");
			result.setStatus(0);
		}
		return result;
	}

	/*
	 * @CrossOrigin(origins = "*", maxAge = 3600)
	 * 
	 * @RequestMapping(value = "/join", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public TaotaoResult join() throws IOException {
	 * TaotaoResult result = new TaotaoResult(); String url =
	 * "https://www.walian.cn/";
	 * 
	 * Document doc = Jsoup.connect(url).get(); // System.out.println(doc);
	 * Elements list = doc.select(".mint-swipe-item"); for (int
	 * i=0;i<list.size();i++){ Element item = list.get(i);
	 * System.out.println(item); } result.setData(list); return result;
	 * 
	 * }
	 */

}
