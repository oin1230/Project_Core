package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.UserVO;

public class boardLoginCheck implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVO sessionVo = (UserVO) session.getAttribute("member");
		
		String b_category = request.getParameter("value");
		
		request.setAttribute("value", b_category);
		
		if(sessionVo==null) {
			session.setAttribute("boardLoginChecking", "Y");
			boardList boardListCommand = new boardList();
	        return boardListCommand.execute(request, response);
		}else {
			return "boardWrite";
		}		
	}

}
