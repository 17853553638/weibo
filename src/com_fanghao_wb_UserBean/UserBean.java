package com_fanghao_wb_UserBean;

public class UserBean {
	
	/*
	 * 对应User表的字段
	 * */

				 private int userid;
				 private String username;
				 private String password;
				 private String phone;
				 private String role;
				public int getUserid() {
					return userid;
				}
				public void setUserid(int userid) {
					this.userid = userid;
				}
				public String getUsername() {
					return username;
				}
				public void setUsername(String username) {
					this.username = username;
				}
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
				public String getRole() {
					return role;
				}
				public void setRole(String role) {
					this.role = role;
				}
				 
}
