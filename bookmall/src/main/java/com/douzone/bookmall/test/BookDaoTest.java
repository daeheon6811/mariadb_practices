package com.douzone.bookmall.test;

import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.dao.MemberDao;
import com.douzone.bookmall.dao.OrderDao;
import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.CartVo;
import com.douzone.bookmall.vo.CategoryVo;
import com.douzone.bookmall.vo.MemberVo;
import com.douzone.bookmall.vo.OrderVo;

public class BookDaoTest {

	public static void main(String[] args) {

		
		/*테이블명 : order -> orders 로 수정 했습니다.*/
		
		

		MemberDao memberDao = new MemberDao();
		CategoryDao categoryDao = new CategoryDao();
		BookDao bookDao = new BookDao();
		CartDao cartDao = new CartDao();
		OrderDao orderDao = new OrderDao();
		
		/*
		MemberVo membervo = new MemberVo();
		membervo.setEmail("wow1186@naver.com");
		membervo.setName("박대헌");
		membervo.setPassword("123123");
		membervo.setPhone("01025281186");
		memberDao.insert(membervo);
		
		
		membervo = new MemberVo();
		membervo.setEmail("test1186@naver.com");
		membervo.setName("홍길동");
		membervo.setPassword("123123");
		membervo.setPhone("0101111111");
		memberDao.insert(membervo);
		
		
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setName("공포");
		categoryDao.insert(categoryVo);
		
		categoryVo = new CategoryVo();
		categoryVo.setName("코믹");
		categoryDao.insert(categoryVo);
		
		categoryVo = new CategoryVo();
		categoryVo.setName("추리");
		categoryDao.insert(categoryVo);
		
		BookVo bookVo = new BookVo();
		bookVo.setCategoryNo(1);
		bookVo.setTitle("무서운 이야기");
		bookVo.setPrice(50000);
		bookDao.insert(bookVo);
		
		bookVo = new BookVo();
		bookVo.setCategoryNo(2);
		bookVo.setTitle("재밌는 이야기");
		bookVo.setPrice(60000);
		bookDao.insert(bookVo);
		
		bookVo = new BookVo();
		bookVo.setCategoryNo(3);
		bookVo.setTitle("어려운 이야기");
		bookVo.setPrice(40000);
		bookDao.insert(bookVo);
		
		CartVo cartVo = new CartVo();
		cartVo.setBookNo(1);
		cartVo.setMemberNo(1);
		cartVo.setUnit(3000);
		cartDao.insert(cartVo);
		
		 cartVo = new CartVo();
		cartVo.setBookNo(2);
		cartVo.setMemberNo(2);
		cartVo.setUnit(6000);
		cartDao.insert(cartVo);
		
		 cartVo = new CartVo();
		cartVo.setBookNo(1);
		cartVo.setMemberNo(1);
		cartVo.setUnit(4000);
		cartDao.insert(cartVo);
		

		OrderVo orderVo = new OrderVo();
		orderVo.setPrice(50000);
		orderVo.setLocation("김해");
		orderVo.setMemberNo(1);
		orderVo.setOrderNo(10001);
		orderDao.insertorders(orderVo);
		
		orderVo = new OrderVo();
		orderVo.setNo(1);
		orderVo.setUnit(5);
		orderVo.setPrice(8500);		
		orderVo.setBookNo(1);
		orderDao.insertorders(orderVo);
		
		orderVo = new OrderVo();
		orderVo.setNo(1);
		orderVo.setUnit(5);
		orderVo.setPrice(7000);		
		orderVo.setBookNo(2);
		orderDao.insertorders(orderVo);
		*/

		
		System.out.println("================== 유저 ================");
		
		List<MemberVo> memberlist = new ArrayList<>();
		memberlist = memberDao.findAll();

		for (MemberVo vo : memberlist) {
			System.out.println(vo.toString());
		}

		System.out.println("================== 유저 ================");
		System.out.println("");
		System.out.println("==================카테고리===================");
		// CategoryDao categoryDao = new CategoryDao();
		// categoryDao.insert();
		
		List<CategoryVo> categorylist = new ArrayList<CategoryVo>();
		categorylist = categoryDao.findAll();

		for (CategoryVo vo : categorylist) {
			System.out.println(vo.toString());
		}
		System.out.println("==================카테고리====================");
		System.out.println("");

		System.out.println("==================상품===================");

	
		List<BookVo> Booklist = new ArrayList<BookVo>();
		Booklist = bookDao.findAll();

		for (BookVo vo : Booklist) {
			System.out.println(vo.toString());
		}

		System.out.println("==================상품===================");
		System.out.println("");

		System.out.println("==================카트===================");

		
		List<CartVo> cartlist = new ArrayList<>();
		cartlist = cartDao.findAll();

		for (CartVo vo : cartlist) {
			System.out.println(vo.toString());
		}

		System.out.println("==================카트===================");
		System.out.println("");

		System.out.println("================주문목록===================");


		List<OrderVo> orderlist = new ArrayList<OrderVo>();
		orderlist = orderDao.findAllOrders();
		for (OrderVo vo : orderlist) {
			System.out.println(vo.toString());
		}

		System.out.println("================주문목록===================");
		System.out.println("");
		System.out.println("================주문 상품 목록===================");

		orderlist = new ArrayList<OrderVo>();
		orderlist = orderDao.findAllOrderBook();
		for (OrderVo vo : orderlist) {
			System.out.println(vo.toString());
		}

		System.out.println("================주문 상품 목록===================");

	}

}
