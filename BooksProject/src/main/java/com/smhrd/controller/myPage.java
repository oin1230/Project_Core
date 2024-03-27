package com.smhrd.controller;

import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;
import com.smhrd.model.myPageVO;

public class myPage implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		// 로그인한 사용자의 id 받아오기
		UserVO member = (UserVO) session.getAttribute("member");

		// id를 자료형에 넣어주기
		myPageVO vo = new myPageVO();
		vo.setEmail(member.getEmail());

		DAO dao = new DAO();

		// DAO에서 id값과 결제상태가 Y인 데이터 3개만 불러오기
		List<myPageVO> myPageApply = dao.myPageApply(vo);
		// DAO에서 id값과 결제상태가 R인 데이터 3개만 불러오기
		List<myPageVO> myPageRefund = dao.myPageRefund(vo);
		// DAO에서 id값과 셔틀의 상태가 N인 데이터 3개만 불러오기
		List<myPageVO> myPageEnd = dao.myPageEnd(vo);

		// 데이터 세션에 담아주기
		session.setAttribute("myPageApply", myPageApply);
		//System.out.println("myPageApply 확인 : " + myPageApply);

		session.setAttribute("myPageRefund", myPageRefund);
		//System.out.println("myPageRefund 확인 : " + myPageRefund);

		session.setAttribute("myPageEnd", myPageEnd);
		//System.out.println("myPageReEnd 확인 : " + myPageEnd);

		return "myPage";
	}

}
