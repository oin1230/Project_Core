package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.protobuf.TextFormat.Printer;
import com.smhrd.database.DAO;
import com.smhrd.model.UserVO;

public class AFindInfo implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// ajax 요청 데이터 꺼내오기
		String AInfo = null;
		// ajax에서 꺼내온 값 객체로 만들기
		UserVO vo = new UserVO();
		if(request.getParameter("AInfoID") != null) {
			AInfo = request.getParameter("AInfoID");
			vo.setPhone(AInfo);
		} else if(request.getParameter("AInfoPW") != null) {
			AInfo = request.getParameter("AInfoPW");
			vo.setEmail(AInfo);
			
		}		

		// dao에 AFindID 메소드 사용
		DAO dao = new DAO();
		UserVO resultID = dao.AFindInfo(vo);
		
		// json 파일로의 변경을 위한, Gson 가져오기
		Gson gson = new Gson();
		String json = gson.toJson(resultID);
		response.setContentType("text/html;charser=UTF-8");

		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
