package com.sy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

	private String id;
	private String phone;
	// private String username;
	private String verifycode;
	private String password;
	private String agencyIndex;// 邀请码
	private String level;// 等级
	private List<NewOrder> orderList = new ArrayList<NewOrder>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*
	 * public String getUsername() { return username; }
	 * 
	 * public void setUsername(String username) { this.username = username; }
	 */

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<NewOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<NewOrder> orderList) {
		this.orderList = orderList;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public String getAgencyIndex() {
		return agencyIndex;
	}

	public void setAgencyIndex(String agencyIndex) {
		this.agencyIndex = agencyIndex;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
