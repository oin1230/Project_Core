package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.EventVO;
import com.smhrd.model.ShuttleVO;

public class bookingList implements command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String go = request.getParameter("go");
		int shtl_id = Integer.parseInt(request.getParameter("SEAT_ID"));
		
		ShuttleVO vo = new ShuttleVO();
		vo.setShtl_id(shtl_id);
		
		DAO dao = new DAO();
		List<ShuttleVO> bookingList = dao.bookingList();
		
		request.setAttribute("bookingList",bookingList);
		
		return "booking";
	}
}
