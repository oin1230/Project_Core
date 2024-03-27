package com.smhrd.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.smhrd.database.DAO;
import com.smhrd.model.CommentVO;
import com.smhrd.model.UserVO;

public class commentRegister implements command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		// System.out.println("11111111111111111111");
		
		String cmt_content = request.getParameter("comment");
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		// System.out.println("??????????"+cmt_content+b_id);
		
		// 현재 시간 b_date변수에 저장(2024-03-26 11:27:42.979 형식)
		Timestamp b_date = new Timestamp(System.currentTimeMillis());
		String b_date2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(b_date);
		
		UserVO sessionVo = (UserVO) session.getAttribute("member");
		String email = sessionVo.getEmail();
		
		
		CommentVO vo = new CommentVO();
		vo.setB_id(b_id);
		vo.setCmt_content(cmt_content);
		vo.setCmt_date(b_date2);
		vo.setEmail(email);
		
		DAO dao = new DAO();
		dao.commentRegister(vo);
		
		
		Gson gson = new Gson();
		
		String json = gson.toJson(vo);
		// System.out.println("?????????"+json);
		
		response.setContentType("text/html;charser=UTF-8");
		
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
