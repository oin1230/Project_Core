package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;
import com.smhrd.model.pageVO;

public class noticeList implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		String b_category = request.getParameter("value");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageView = 5;
		int Jul = page/5+1;
		if(page%5==0) {
			Jul = page/5;
		}
		int startPageNum = 25*(Jul-1);
	
		pageVO vo = new pageVO();
		vo.setB_category(b_category);
		vo.setStartPageNum(startPageNum);
		
		DAO dao = new DAO();
		pageVO boardNum2 = dao.boardNum(vo);
		int boardNum = boardNum2.getBoardNum();
		
		if(boardNum<=20) {
			if(boardNum%5 != 0) {
				pageView = boardNum/5+1;
			}else {
				pageView = boardNum/5;
			}
		}else {
			pageView = 5;
		}
		
		int startNum = page/5*5+1;
		if(page%5==0) {
			startNum = page/5;
		}
		int endNum = pageView;
		
		int startPageNum2 = (page-1)*5;
		pageVO vo2 = new pageVO();
		vo2.setB_category(b_category);
		vo2.setStartPageNum(startPageNum2);
		List<BoardVO> boardList = dao.boardList2(vo2);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("startNum", startNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("page", page);
		request.setAttribute("b_category", b_category);
		
		return "announcement";
	}

}
