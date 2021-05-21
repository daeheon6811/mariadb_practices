package com.douzone.bookmall.vo;

public class OrderVo {
	
	private int no;
	private int price;
	private String location;
	
	private int unit;
	private int orderNo;
	private int memberNo;
	private int bookNo;


	
	
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", price=" + price + ", location=" + location + ", unit=" + unit + ", orderNo="
				+ orderNo + ", memberNo=" + memberNo + ", bookNo=" + bookNo + "]";
	}

	
	

}
