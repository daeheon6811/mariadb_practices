package com.douzone.bookmall.vo;

public class CartVo {
	
	private int unit;
	private int memberNo;
	private int bookNo;
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
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
		return "카트 [수량=" + unit + ", 고객번호=" + memberNo + ", 책번호=" + bookNo + "]";
	}
	
	
	
	

}
