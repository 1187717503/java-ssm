package com.sy.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	private String adminname;
	private String password;

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
