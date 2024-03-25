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
		
		String pw = request.getParameter("pw");
		String newPw = request.getParameter("pw_check");

		
		
		UserVO sessionVo = (UserVO) session.getAttribute("member");
		String userPw = sessionVo.getPw();
		String email = sessionVo.getEmail();
		
		System.out.println(pw);
		System.out.println(userPw);
		
		UserVO vo = new UserVO();
		
		if(pw.equals(userPw)) {
			System.out.println("성공");
			vo.setPw(pw);
			vo.setEmail(email);
			vo.setNewPw(newPw);
		}
	
		
		DAO dao = new DAO();
		int row = dao.pwUpdate(vo);		
		
		session.setAttribute("row", row);
		
		return "check";
		
		
		
	}
}
