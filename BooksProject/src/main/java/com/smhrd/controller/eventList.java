package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.EventVO;

public class eventList implements command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		DAO dao = new DAO();
		List<EventVO> eventlist = dao.eventList();
		request.setAttribute("eventlist", eventlist);
		System.out.println(eventlist.get(0).getEvent_name());
		
		return "index";
	
	}
}
