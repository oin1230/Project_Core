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
		
		if (request.getParameter("AInfoID") != null) {
			// id찾기 버튼을 클릭한 경우
			AInfo = request.getParameter("AInfoID");
			vo.setPhone(AInfo);
		} else if (request.getParameter("AInfoPW") != null) {
			// pw찾기 버튼을 클릭한 경우
			AInfo = request.getParameter("AInfoPW");
			vo.setEmail(AInfo);
		}

		// dao에 AFindID 메소드 사용
		DAO dao = new DAO();
		// id찾기와 pw찾기 둘 다 보내줘야하는 값이 email이라 메소드 한개로 만듦
		// 추후에 기능이 추가 될 경우 수정될 여지가 있음
		UserVO resultID = dao.AFindInfo(vo);

		// json 파일로의 변경을 위한, Gson 가져오기
		Gson gson = new Gson();
		
		// 찾아온 email json으로 보내주기
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
