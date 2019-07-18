package com.sy.entity;

import java.io.Serializable;
import java.util.Date;

public class SelectOrder implements Serializable {
	private String ordernum; // 订单编号
	private String type; // 订单种类
	private String status; // 订单状态 1 未定义 2 审核中 3 审核通过
	private String totalpay; //
	private String num; // 订单数量
	private Date date; // 下单日期
	private int product;
	private String productName; // 商品名字
	private String productPic;// 商品图片
	private String price; // 单价
	private String productIndex; // 产品编号
	private String phone; // 用户手机号码
	private double feedback;
	private String agencyIndex;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPic() {
		return productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductIndex() {
		return productIndex;
	}

	public void setProductIndex(String productIndex) {
		this.productIndex = productIndex;
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

	public String getAgencyIndex() {
		return agencyIndex;
	}

	public void setAgencyIndex(String agencyIndex) {
		this.agencyIndex = agencyIndex;
	}

}
