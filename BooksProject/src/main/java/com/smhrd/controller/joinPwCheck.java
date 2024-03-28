package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.UserVO;

public class joinPwCheck implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String pw_check = request.getParameter("pw_check");
		String nick = request.getParameter("nickname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phonenumber");

		UserVO vo = new UserVO(email, pw, nick, address, phone, pw_check);
		
		// join.java파일에서 쓰기위해 request로 담아줌
		request.setAttribute("vo", vo);
		
		// signin.jsp파일에서 쓰기위해 세션에 담아줌
		session.setAttribute("loginPwCheckingUserInfo", vo);
		
		
		
		// pw와 pw_check가 일치한지 판별
		if(pw.equals(pw_check)) {
			// 일치한다면 join.java로 이동
			Join JoinCommand = new Join();
	        return JoinCommand.execute(request, response);
		}else {
			// 일치하지 않는다면 다시 signin.jsp파일로 이동
			session.setAttribute("loginPwChecking", "Y");
			return "signin";
		}
		
	}
	

}
