package com.sy.entity;

import java.io.Serializable;
import java.util.Date;

public class NewOrder implements Serializable {
	private String ordernum; // 订单编号
	private String type; // 订单种类
	private String status; // 订单状态 1 未定义 2 审核中 3 审核通过
	private String totalpay; //
	private String num; // 订单数量
	private String date; // 下单日期
	private int product;
	private String productname; // 商品名字
	private String productpic;// 商品图片
	private String price; // 单价
	private String productindex; // 产品编号
	private String phone; // 用户手机号码
	private double feedback;

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalpay() {
		return totalpay;
	}

	public void setTotalpay(String totalpay) {
		this.totalpay = totalpay;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductpic() {
		return productpic;
	}

	public void setProductpic(String productpic) {
		this.productpic = productpic;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductindex() {
		return productindex;
	}

	public void setProductindex(String productindex) {
		this.productindex = productindex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getFeedback() {
		return feedback;
	}

	public void setFeedback(double feedback) {
		this.feedback = feedback;
	}

}