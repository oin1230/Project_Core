package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;
import com.smhrd.model.BoardLikeVO;
import com.smhrd.model.UserVO;

public class boardLikeUpdate implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		
		
		
		// 로그인 한 사용자 이메일, b_id 받아오기
		UserVO sessionVo = (UserVO) session.getAttribute("member");
		BoardLikeVO sessionVo2 = (BoardLikeVO) session.getAttribute("b_id");
		String email = sessionVo.getEmail();
		int b_id = sessionVo2.getB_id();
		
		
		
		// vo에 email, b_id 넣어주기
		BoardLikeVO vo = new BoardLikeVO();
		vo.setEmail(email);
		vo.setB_id(b_id);
		
		// 로그인 한 사용자가 좋아요 누르면 row가 1
		DAO dao = new DAO();
		int row =  dao.boardLike(vo);
		
		session.setAttribute("row", row);
			
		
		if(row>0) {
			return "like";
			
		}else {
			
			// vo에 담겨있는 사용자 이메일 값 DAO의 boardLikeInsert로 보내주기
			DAO dao2 = new DAO();
			dao2.boardLikeInsert(vo);
			
			// b_like 값 +1
			DAO dao3 = new DAO();
			dao3.boardLikePlus(vo);
			
			return "like";
		}
		
		
	}

}
