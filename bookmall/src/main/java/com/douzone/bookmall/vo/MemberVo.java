package com.douzone.bookmall.vo;

public class MemberVo {
	
	private int no;
	private String name;
	private String email;
	private String phone;
	private String password;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "고객 [번호=" + no + ", 이름=" + name + ", 이메일=" + email + ", 폰번호=" + phone + ", 비밀번호="
				+ password + "]";
	}
	
	
	
	

}
