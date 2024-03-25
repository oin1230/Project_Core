package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;

public class boardList implements command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 목록의 해당 태그의 value값(b_id) 받아오기
		// <a href="a.jsp?value=aaa">
		int b_id = Integer.parseInt(request.getParameter("value"));
		
		BoardVO vo = new BoardVO();
		vo.setB_id(b_id);
		
		
		DAO dao = new DAO();
		List<BoardVO> boardlist = dao.boardList(vo);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("b_id", b_id);
		
		
		
		return "";
	
	}

}
