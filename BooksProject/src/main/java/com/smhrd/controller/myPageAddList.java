package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;
import com.smhrd.model.myPageVO;

public class myPageAddList implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// 세션에서 회원정보 가져오기
		HttpSession session = request.getSession();
		UserVO member = (UserVO) session.getAttribute("member");

		// 요청으로부터 url의 값 가져오기
		String req = request.getParameter("value");

		// 회왼정보 vo에 담기
		myPageVO vo = new myPageVO();
		vo.setEmail(member.getEmail());

		DAO dao = new DAO();

		List<myPageVO> addList = null;

		if (req.equals("myApply")) {
			addList = dao.myPageApply(vo);
		} else if (req.equals("myEnd")) {
			addList = dao.myPageEnd(vo);
		} else if (req.equals("myRefund")) {
			addList = dao.myPageRefund(vo);
		}
		
		session.setAttribute("addList", addList);
		session.setAttribute("addReq", req);

		return "myPageAddList";
	}

}
