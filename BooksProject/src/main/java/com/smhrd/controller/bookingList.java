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
		int shtl_id = Integer.parseInt(request.getParameter("SHTL_ID"));
		
		ShuttleVO vo = new ShuttleVO();
		vo.setShtl_id(shtl_id);
		
		DAO dao = new DAO();
		List<ShuttleVO> bookingList = dao.bookingList();

		// bookingList 객체가 준비되는 곳에 로깅 추가
		if (bookingList == null) {
		    System.out.println("bookingList is null");
		} else {
		    System.out.println("bookingList size: " + bookingList.size());
		    // bookingList의 내용을 로깅으로 확인하고 싶다면, 추가적인 로깅 코드를 작성
		}
		
		request.setAttribute("bookingList",bookingList);
		
		return "booking";
	}
}
