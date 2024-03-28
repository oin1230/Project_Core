package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.EventVO;
import com.smhrd.model.ShuttleVO;

public class bookingList implements command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int shtl_id = Integer.parseInt(request.getParameter("SHTL_ID"));
		int event_id = Integer.parseInt(request.getParameter("event_id"));
		String start_rg = request.getParameter("go");
		ShuttleVO vo = new ShuttleVO();
		vo.setStart_rg(start_rg);
		vo.setShtl_id(shtl_id);
		vo.setEvent_id(event_id);
		
		DAO dao = new DAO();
		
		List<ShuttleVO> bookingList = dao.bookingList(vo);

		request.setAttribute("bookingList",bookingList);
		
		return "booking";
	}
}
