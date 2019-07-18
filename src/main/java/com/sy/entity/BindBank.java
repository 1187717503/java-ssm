package com.sy.entity;

import java.io.Serializable;

public class BindBank implements Serializable {
	private String phone;
	private String bankcard;
	private String bankaddress;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankcard() {
		return bankcard;
	}

	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}

	public String getBankaddress() {
		return bankaddress;
	}

	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}

}
