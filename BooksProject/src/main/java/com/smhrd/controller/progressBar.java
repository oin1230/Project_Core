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
		
		SeatVO vo = new SeatVO(0, 0, 0, null, event_id, 0);

		DAO dao = new DAO();
		
		List<SeatVO> progressBar = dao.progressBar(vo);
		
		request.setAttribute("progressBar",progressBar);
		
		return "concert";
		
	}

}
