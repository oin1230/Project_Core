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

		System.out.println(email);
		System.out.println(pw);

		UserVO vo = new UserVO();
		vo.setEmail(email);
		vo.setPw(pw);

		DAO dao = new DAO();

		UserVO resultVo = dao.Login(vo);

		HttpSession session = request.getSession();
		if (resultVo != null) {
			session.setAttribute("member", resultVo);
			return "redirect:/gomain.do";
			
			// 테스트용
			//UserVO sessionVo = (UserVO) session.getAttribute("member");
			//String email2 = sessionVo.getEmail();

		} else {
			System.out.println("실패");
			session.setAttribute("loginChecking", "Y");
			return "login";
		}

	}

}
