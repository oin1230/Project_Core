package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;

public class pwUpdate implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");

		String pw = request.getParameter("nPw");
		String newPw = request.getParameter("ePw");

		UserVO sessionVo = (UserVO) session.getAttribute("member");
		String userPw = sessionVo.getPw();
		String email = sessionVo.getEmail();

		UserVO vo = new UserVO();

		if (pw.equals(userPw)) {
			System.out.println("성공");
			vo.setPw(pw);
			vo.setEmail(email);
			vo.setNewPw(newPw);
		}

		DAO dao = new DAO();
		dao.pwUpdate(vo);
		
		UserVO vo2 = new UserVO();
		vo2.setEmail(email);
		vo2.setPw(newPw);
		
		UserVO resultVo = dao.Login(vo2);
		
		session.setAttribute("member", resultVo);
		
		

		return "redirect:/gomyPage.do";

	}
}
