package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;

public class boardDetail implements command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 목록의 해당 태그의 value값(b_id) 받아오기
		String b_id = request.getParameter("value");
		// value값 int형태로 바꿔주기
		int b_id2 = Integer.parseInt(b_id);
		
		
		BoardVO vo = new BoardVO();
		vo.setB_id(b_id2);
		
		
		DAO dao = new DAO();
		BoardVO boardDetail = dao.boardDetail(vo);
		
		
		request.setAttribute("boardDetail", boardDetail);
		System.out.println("ㅋㅋ카테고리 값::"+boardDetail.getB_category());
		
		request.setAttribute("b_id", b_id2);

		return "boardView";
	
	}

}
