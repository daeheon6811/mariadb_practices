package com.douzone.bookmall.vo;

public class BookVo {

	
	private int no;
	private String title;
	private int price;
	private int categoryNo;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	@Override
	public String toString() {
		return "책이름 [넘버=" + no + ", 제목=" + title + ", 가격=" + price + ", 카테고리 번호=" + categoryNo + "]";
	}

	

	
	
	
	
}
