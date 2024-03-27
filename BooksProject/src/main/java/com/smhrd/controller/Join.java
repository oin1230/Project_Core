package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;

public class Join implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nickname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phonenumber");

		UserVO vo = new UserVO(email, pw, nick, address, phone, null);

		DAO dao = new DAO();

		int row = dao.Join(vo);

		return "redirect:/gomain.do";

	}

}
