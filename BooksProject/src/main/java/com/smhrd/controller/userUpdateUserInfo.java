package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;

public class userUpdateUserInfo implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		UserVO sessionVo = (UserVO) (request.getSession().getAttribute("member"));
		String email = sessionVo.getEmail();
		
		UserVO vo2 = new UserVO();
		vo2.setEmail(email);

		// dao.userInfo 기능 사용(기존에 저장돼어있는 사용자 정보 담기)
		DAO dao = new DAO();
		UserVO userInfo = dao.userInfo(vo2);
		
		String userNick = userInfo.getNick();
		String userAddress = userInfo.getAddress();
		String userPhone = userInfo.getPhone();
		
		UserVO vo = new UserVO();
		vo.setNick(userNick);
		vo.setAddress(userAddress);
		vo.setPhone(userPhone);
		
		
		session.setAttribute("userUpdateUserInfo", vo);
		
		return "userInfoEdit";
	}
}
