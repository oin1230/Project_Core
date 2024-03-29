package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.ShuttleVO;

// 등록 클래스
public class shuttRegister implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String start_rg = request.getParameter("start_rg");
		String riding_data = request.getParameter("riding_data");
		String event_name = request.getParameter("event_name");
		int price = Integer.parseInt(request.getParameter("price"));
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");
	
		ShuttleVO vo = new ShuttleVO();

		DAO dao = new DAO();
		vo.setStart_rg(start_rg);
		vo.setRiding_date(riding_data);
		vo.setEvent_name(event_name);
		vo.setStart_date(start_date);
		vo.setEnd_date(end_date);
		
		
		int row = dao.shuttRegister(vo);
		
		
		return null;
	}
	
}
