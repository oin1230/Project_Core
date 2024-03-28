package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;

public class noticeList implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		String b_category = request.getParameter("value");

		BoardVO vo = new BoardVO();
		vo.setB_category(b_category);

		DAO dao = new DAO();

		List<BoardVO> boardList = dao.boardList(vo);

		request.setAttribute("boardList", boardList);
		
		request.setAttribute("value", b_category);

		return "announcement";
		
		
	}

}
