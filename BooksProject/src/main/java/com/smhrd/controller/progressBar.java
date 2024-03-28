package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.SeatVO;
import com.smhrd.model.UserVO;

public class progressBar implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int event_id =Integer.parseInt(request.getParameter("event_id"));
		String event_loc = request.getParameter("event_loc");
		SeatVO vo = new SeatVO();
		vo.setEVENT_ID(event_id);
		vo.setEVENT_LOC(event_loc);

		DAO dao = new DAO();
		
		List<SeatVO> progressBar = dao.progressBar(vo);
		
		request.setAttribute("progressBar",progressBar);
		
		// redirect: 데이터 보낼 수 있는 방법
		return "concert";
		
	}

}
