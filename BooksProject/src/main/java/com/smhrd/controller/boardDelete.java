package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;
import com.smhrd.model.UserVO;

public class boardDelete implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int b_id = Integer.parseInt(request.getParameter("ValueCategory"));
		
		String b_category = request.getParameter("value");
		String page = request.getParameter("page");
		
		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		
		UserVO userVo = (UserVO) session.getAttribute("member");
		String email = userVo.getEmail();
		
		BoardVO vo = new BoardVO();
		vo.setEmail(email);
		vo.setB_id(b_id);
		
		DAO dao = new DAO();
		
		dao.boardDelete(vo);
		
		request.setAttribute("value", b_category);
		
		String nextPageURL = "boardList.do?value=" + b_category + "&page=" + page; 
		try {
			response.sendRedirect(nextPageURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
		

}
