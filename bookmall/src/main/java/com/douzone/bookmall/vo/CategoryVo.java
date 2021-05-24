package com.douzone.bookmall.vo;


// DB 명 genre
public class CategoryVo {
	
	private int no;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "CategoryVo [번호=" + no + ", 이름=" + name + "]";
	}
	
	
	
	
	

}
