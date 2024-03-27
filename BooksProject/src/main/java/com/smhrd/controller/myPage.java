package com.smhrd.controller;

import java.lang.reflect.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;
import com.smhrd.model.myPageVO;

public class myPage implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVO member= (UserVO) session.getAttribute("member");
		
		
		DAO dao = new DAO();
		
		
		
		
		
	
		

		return "myPage";
	}

}
