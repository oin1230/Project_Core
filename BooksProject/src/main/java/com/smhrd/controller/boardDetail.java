package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;
import com.smhrd.model.CommentVO;

public class boardDetail implements command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 목록의 해당 태그의 value값(b_id) 받아오기
		String b_id = request.getParameter("value");
		// value값 int형태로 바꿔주기
		int b_id2 = Integer.parseInt(b_id);
		
		
		// 조회수 업데이트--------------------------
		BoardVO vo3 = new BoardVO();
		vo3.setB_id(b_id2);
		DAO dao = new DAO();
		dao.boardView(vo3);
		// -------------------------------------
		
		
		
		HttpSession session = request.getSession();

		// 해당 게시물의 정보 담아주기
		BoardVO vo = new BoardVO();
		vo.setB_id(b_id2);
		

		BoardVO boardDetail = dao.boardDetail(vo);
		
		session.setAttribute("boardDetail", boardDetail);
		
		
		// 해당 게시물의 댓글 리스트 담아주기
		CommentVO vo2 = new CommentVO();
		vo2.setB_id(b_id2);
		

		List<CommentVO> commentList = dao.commentList(vo2);

		session.setAttribute("commentList", commentList);
		
		
		
		request.setAttribute("b_id", b_id2);

		return "boardView";
	
	}

}
