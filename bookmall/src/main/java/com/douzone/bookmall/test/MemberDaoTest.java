package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.MemberDao;
import com.douzone.bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
	//	insertTest();
		findAllTest();
		updateTest();	
		System.out.println("업데이트 완료----");
		findAllTest();
		System.out.println("삭제 완료 ----");
		deleteTest();
	}

	private static void findAllTest() {

		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		MemberVo vo = null;

		vo = new MemberVo();
		// vo.setNo(1);
		vo.setName("test");
		vo.setEmail("wwww@n");
		vo.setPhone("01000");
		vo.setPassword("1223");
		new MemberDao().insert(vo);
	}

	private static void updateTest() {
		new MemberDao().updateEmail(1,"test@naver.com");
	}

	private static void deleteTest() {
		new MemberDao().allDelete();
	}

}
