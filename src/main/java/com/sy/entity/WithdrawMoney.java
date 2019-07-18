package com.sy.entity;

import java.io.Serializable;
import java.util.Date;

public class WithdrawMoney implements Serializable {
	private String phone;// 手机号
	private Double num;// 提币数量
	private String address;// 钱包地址
	private String caseorder;// 算例订单
	private Date date;// 提币时间
	private Double realnum;// 实际数量
	private String status;// 状态

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getNum() {
		return num;
	}

	public void setNum(Double num) {
		this.num = num;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCaseorder() {
		return caseorder;
	}

	public void setCaseorder(String caseorder) {
		this.caseorder = caseorder;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getRealnum() {
		return realnum;
	}

	public void setRealnum(Double realnum) {
		this.realnum = realnum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
