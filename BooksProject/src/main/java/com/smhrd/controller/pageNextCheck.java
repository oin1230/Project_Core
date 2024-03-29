package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;
import com.smhrd.model.pageVO;

public class pageNextCheck implements command {
	
public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String b_category = request.getParameter("value");
		int page = Integer.parseInt(request.getParameter("page"));

		
		request.setAttribute("value", b_category);
		request.setAttribute("page", page);
		
		
		/////////////마지막페이지 판별//////////////////////
		int NextJulPage = page;

		
		DAO dao = new DAO();
		int startPageNum2 = (NextJulPage-1)*5;
		pageVO vo2 = new pageVO();
		vo2.setB_category(b_category);
		vo2.setStartPageNum(startPageNum2);
		List<BoardVO> boardList = dao.boardList2(vo2);

		
		if(boardList.isEmpty()) {
			session.setAttribute("pageNextChecking", "Y");
			int newPage = page-1;
			request.setAttribute("page", newPage);
			
			String nextPageURL = "boardList.do?value=" + b_category + "&page=" + newPage; // 새로운 페이지 URL 생성
			try {
				response.sendRedirect(nextPageURL);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			String nextPageURL = "boardList.do?value=" + b_category + "&page=" + page; // 새로운 페이지 URL 생성
			try {
				response.sendRedirect(nextPageURL);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		return null;

		
	}

}
