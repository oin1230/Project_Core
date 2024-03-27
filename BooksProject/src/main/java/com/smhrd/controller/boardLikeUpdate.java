package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.smhrd.database.DAO;
import com.smhrd.model.BoardVO;
import com.smhrd.model.BoardLikeVO;
import com.smhrd.model.UserVO;

public class boardLikeUpdate implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		// 로그인 한 사용자 이메일, b_id 받아오기
		UserVO member = (UserVO) session.getAttribute("member");

		int b_id = Integer.parseInt(request.getParameter("b_id"));

		String email = member.getEmail();

		// vo에 email, b_id 넣어주기
		BoardLikeVO vo = new BoardLikeVO();
		vo.setEmail(email);
		vo.setB_id(b_id);

		// 데이터베이스 연결을 위한 DAO 생성
		DAO dao = new DAO();

		// b_Like 테이블에서 해당 회원의 값이 null 인지 확인
		BoardLikeVO likeState = dao.boardLikeUpdate(vo);

		// null 이라면
		if (likeState == null) {
			// null 이라면, 정보추가
			dao.boardLikeInsert(vo);
			// board 테이블에, 좋아요수 1 올리기
			dao.boardLikePlus(vo);
		} else {
			//System.out.println("null이 아닐떄 :" + likeState.getB_like_state());
		}

		// 좋아요수 가져오기
		BoardLikeVO select = dao.boardLikeSelect(vo);
		
		int result = select.getB_likes();

		//Gson gson = new Gson();
		// 좋아요수 보내기
		//String json = gson.toJson(select);
		
		response.setContentType("text/html;charser=UTF-8");

		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
