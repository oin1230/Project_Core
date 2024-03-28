package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.UserVO;

public class userDeletePwCheck implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String pw = request.getParameter("PW");
		
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("member");
		String userPw = userVo.getPw();
		
		request.setAttribute("PW", pw);
		
		
		if(pw.equals(userPw)) {
			userDelete userDeleteCommand = new userDelete();
	        return userDeleteCommand.execute(request, response);
		}else {
			session.setAttribute("userDeletePwChecking", "Y");
			return "userDelete";
		}

	}

}
