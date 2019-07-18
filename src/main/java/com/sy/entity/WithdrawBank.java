package com.sy.entity;

import java.io.Serializable;

public class WithdrawBank implements Serializable {
	private String phone;
	private String bankcard;
	private String bankdeposit;

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

	public String getBankdeposit() {
		return bankdeposit;
	}

	public void setBankdeposit(String bankdeposit) {
		this.bankdeposit = bankdeposit;
	}

}
