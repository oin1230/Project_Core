package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.pageVO;

public class pagePrevCheck implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String b_category = request.getParameter("value");
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("value", b_category);
		request.setAttribute("page", page);
	
		if(page==0) {
			session.setAttribute("pagePrevChecking", "Y");
			int newPage = page+1;
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
