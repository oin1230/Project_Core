package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;

public class Login implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("EMAIL");
		String pw = request.getParameter("PW");

		UserVO vo = new UserVO();
		vo.setEmail(email);
		vo.setPw(pw);

		DAO dao = new DAO();

		UserVO resultVo = dao.Login(vo);

		HttpSession session = request.getSession();
		if (resultVo != null) {
			session.setAttribute("member", resultVo);
			return "redirect:/gomain.do";
		} else {
			session.setAttribute("loginChecking", "Y");
			session.setAttribute("loginCheckingInfo", vo);
			return "login";
		}

	}

}
