package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.smhrd.model.UserVO;

public class boardRegisterCheck implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		

		
		//System.out.println("######################");
		// 로그인 안했다면 email값이 없어 오류발생 -> ajax함수에서 fail유도
		HttpSession session = request.getSession();
		UserVO sessionVo = (UserVO) session.getAttribute("member");
		String email = sessionVo.getEmail();
		//System.out.println("사용자이메일값"+email);
		
		//System.out.println("&&&&&&&&&&&&&&&&&&&");
		


		
		try {
			response.getWriter().print(email);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
		//return "boardWrite";
	}

}
