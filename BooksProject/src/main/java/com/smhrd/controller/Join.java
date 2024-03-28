package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;

public class Join implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// joinPwCheck.java에서 보내준 값 받아오기
		UserVO vo2 = (UserVO) request.getAttribute("vo");

		String email = vo2.getEmail();
		String pw = vo2.getPw();
		String nick = vo2.getNick();
		String address = vo2.getAddress();
		String phone = vo2.getPhone();
		//------------------------------------

		UserVO vo = new UserVO(email, pw, nick, address, phone, null);

		DAO dao = new DAO();

		int row = dao.Join(vo);

		return "redirect:/gomain.do";

	}

}
