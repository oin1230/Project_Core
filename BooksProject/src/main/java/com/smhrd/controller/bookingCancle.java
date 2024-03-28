package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;
import com.smhrd.model.myPageVO;

public class bookingCancle implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		UserVO memberVO = (UserVO) session.getAttribute("member");
		String email = memberVO.getEmail();
		
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		
		myPageVO vo = new myPageVO();
		vo.setBook_id(book_id);
		vo.setEmail(email);
		
		DAO dao = new DAO();
		
		int result = dao.bookingCancle(vo);
		
		myPage command = new myPage();
		
		return command.execute(request, response);
		
	}

}
