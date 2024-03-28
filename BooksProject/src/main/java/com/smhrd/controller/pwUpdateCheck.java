package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.UserVO;

public class pwUpdateCheck implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 기존 비밀번호
		String nPw = request.getParameter("nPw");
		// 새로운 비밀번호
		String ePw = request.getParameter("ePw");
		// 비밀번호 확인
		String ePwC = request.getParameter("ePwC");
		
		// 현재 사용자 비밀번호 가져오기
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("member");
		String userPw = userVo.getPw();
		
		request.setAttribute("nPw", nPw);
		request.setAttribute("ePw", ePw);
		request.setAttribute("ePwC", ePwC);
		
		// 현재사용자pw 와 입력한pw 비교, epw와 epwC 비교
		if(userPw.equals(nPw)&&ePw.equals(ePwC)) {
			pwUpdate pwUpdateCommand = new pwUpdate();
	        return pwUpdateCommand.execute(request, response);
		}else {
			session.setAttribute("pwUpdateChecking", "Y");
			return "userPwEdit";
		}
	}
}
