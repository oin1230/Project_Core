package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;

public class userUpdate implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String nick = request.getParameter("nickname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		UserVO sessionVo = (UserVO) (request.getSession().getAttribute("member"));
		String email = sessionVo.getEmail();

		UserVO vo2 = new UserVO();
		vo2.setEmail(email);

		DAO dao = new DAO();
		UserVO userInfo = dao.userInfo(vo2);
		String userNick = userInfo.getNick();
		String userAddress = userInfo.getAddress();
		String userPhone = userInfo.getPhone();
		
		UserVO vo = new UserVO();
		
		vo.setNick(nick);
		vo.setAddress(address);
		vo.setPhone(phone);
		vo.setEmail(email);
		
		dao.userUpdate(vo);

		return "redirect:/gomyPage.do";
	}

}
