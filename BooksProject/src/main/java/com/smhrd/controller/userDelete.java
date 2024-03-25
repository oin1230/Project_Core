package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;

public class userDelete implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		String pw = request.getParameter("PW");
		
		UserVO userVo = (UserVO) session.getAttribute("member");
		String email = userVo.getEmail();
		String userPw = userVo.getPw();
		
		UserVO vo = new UserVO();
		
		if(pw.equals(userPw)) {
			System.out.println("성공");
			vo.setEmail(email);
			vo.setPw(pw);
		}
		
		DAO dao = new DAO();
		int row = dao.userDelete(vo);
		
		System.out.println(row);
		
		session.setAttribute("row", row);
		
		
		
		return "check";
	}

}
