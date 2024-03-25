package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;

public class userUpdate implements command {

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// 1. 요청 데이터 수집
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		UserVO sessionVo = (UserVO)(request.getSession().getAttribute("member"));
		String email = sessionVo.getEmail();
		
		// 2. 데이터 하나로 묶기
		UserVO vo = new UserVO(email, pw, nick, address, phone, null);
		
		// 3. DAO생성
		DAO dao = new DAO();
		
		// 4. dao.update 기능 사용
		dao.userUpdate(vo);
		
		// * session 안에 있는 데이터를 수정한 데이터로 변경
		request.getSession().setAttribute("member", vo);

		
		// 5. main.jsp로 redirect 방식으로 이동
		
		return "redirect:/gomain.do";
	}

	
}
