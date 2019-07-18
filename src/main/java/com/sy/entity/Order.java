package com.sy.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Order implements Serializable {
	private String ordernum;// 订单号
	private String type = "";
	private String status = "";// 交易状态
	private String totalpay = "";// 总价
	private String num = "";// 数量
	private String date;// 日期
	private int product = 0;
	private String productName = "";// 商品名字
	private String productPic = "";// 商品图片
	private String price = "";// 价格
	private String productIndex = "";
	private String phone = "";// 用户

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

	public NewOrder getNewOrder() {
		NewOrder order = new NewOrder();
		// order.setIndex(this.index);
		order.setOrdernum(ordernum);
		order.setNum(num);
		order.setPrice(price);
		order.setProduct(product);
		order.setProductindex(productIndex);
		order.setProductname(productName);
		order.setProductpic(productPic);
		order.setStatus(status);
		order.setTotalpay(totalpay);
		order.setType(type);
		order.setPhone(phone);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d2 = null;
		try {
			// d2 = sdf.parse("Sep 29, 2012 1:00:01 AM");
			d2 = sdf.parse(date);
			// NewOrder order = new NewOrder();
			// order.setDate(d2);
			order.setDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return order;
	}
}