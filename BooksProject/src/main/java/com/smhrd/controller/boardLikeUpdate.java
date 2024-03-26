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
		response.setCharacterEncoding("UTF-8");

		// 로그인 한 사용자 이메일, b_id 받아오기
		UserVO sessionVo = (UserVO) session.getAttribute("member");
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		System.out.println("sessionVO :" + sessionVo);
		System.out.println("b_id값" + b_id);
		String email = sessionVo.getEmail();

		// vo에 email, b_id 넣어주기
		BoardLikeVO vo = new BoardLikeVO();
		vo.setEmail(email);
		vo.setB_id(b_id);
		BoardVO vo2 = new BoardVO();
		vo2.setB_id(b_id);
		
		BoardVO like = null;
		

		// 로그인 한 사용자가 좋아요 누르면 row가 1
		DAO dao = new DAO();
		BoardLikeVO resultVo = dao.boardLike(vo);
		System.out.println("성공했나?" + resultVo);

		response.setContentType("text/html;charser=UTF-8");

		if (resultVo == null) {
			// vo에 담겨있는 사용자 이메일 값 DAO의 boardLikeInsert로 보내주기
			dao.boardLikeInsert(vo);
			System.out.println(dao.boardLikeInsert(vo));

			// b_like 값 +1
			dao.boardLikePlus(vo);
			
			like = dao.boardDetail(vo2);
			System.out.println(vo);

		}
		
		
		try {
			response.getWriter().print(resultVo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

}
