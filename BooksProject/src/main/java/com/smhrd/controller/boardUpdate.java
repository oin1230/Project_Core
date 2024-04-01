package com.smhrd.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;
import com.smhrd.model.UserVO;

public class boardUpdate implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");

		// member 세션에 저장된 사용자 이메일 받아오기
		UserVO sessionVo = (UserVO) session.getAttribute("member");
		String email = sessionVo.getEmail();
		String page = request.getParameter("page");

		// 목록의 해당 태그의 value값(b_id) 받아오기
		int b_id = Integer.parseInt(request.getParameter("valueId"));
		// value값 int형태로 바꿔주기
		String b_category = request.getParameter("value");
		int b_likes = Integer.parseInt(request.getParameter("valueLike"));

		// 수정된 제목, 내용 받아오기
		String b_title = request.getParameter("title");
		String b_content = request.getParameter("text");
		// 현재 시간 
		Timestamp b_date = new Timestamp(System.currentTimeMillis());
		String b_date2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(b_date);
		
		BoardVO vo = new BoardVO();
		vo.setEmail(email);
		vo.setB_title(b_title);
		vo.setB_content(b_content);
		vo.setB_category(b_category);
		vo.setB_date(b_date2);
		vo.setB_id(b_id);
		vo.setB_likes(b_likes);
		
		
		DAO dao = new DAO();
		dao.boardUpdate(vo);
		
		
		request.setAttribute("b_category", b_category);
		
		
		String nextPageURL = "boardList.do?value=" + b_category + "&page=" + page; // 새로운 페이지 URL 생성
		try {
			response.sendRedirect(nextPageURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;

	}

}
