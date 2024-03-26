package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;
import com.smhrd.model.UserVO;

public class boardDelete implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 해당 게시물의 b_id 받아오기
		int b_id = Integer.parseInt(request.getParameter("ValueCategory"));
		
		String b_category = request.getParameter("value");
		
		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		
		
		
		UserVO userVo = (UserVO) session.getAttribute("member");
		String email = userVo.getEmail();
		
		BoardVO vo = new BoardVO();
		vo.setEmail(email);
		vo.setB_id(b_id);
		
		DAO dao = new DAO();
		int row = dao.boardDelete(vo);
		
		session.setAttribute("row", row);
		
		request.setAttribute("value", b_category);
		
		
		boardList boardListCommand = new boardList();
        return boardListCommand.execute(request, response);
		
		
		
	}
		

}
