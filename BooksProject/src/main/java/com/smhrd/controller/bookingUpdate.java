package com.smhrd.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.SeatVO;
import com.smhrd.model.UserVO;
import com.smhrd.model.myPageVO;

public class bookingUpdate implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		// 세션으로부터 결제정보 가져오기
		UserVO member = (UserVO) session.getAttribute("member");

		// 요청으로부터 셔틀 아이디 가져오기
		int shuttleID = Integer.parseInt(request.getParameter("shuttleID"));
		// 요청으로부터 결제금액 가져오기
		int pay = Integer.parseInt(request.getParameter("pay"));

		// 요청으로부터 선택된 좌석 가져오기
		String seatListString = request.getParameter("seatList");
		String[] arraySeatList = seatListString.split(",");
		// 좌석의 배열을 int 형태로 변경하기
		// 1. 좌석배열의 길이만큼 int형식의 배열 선언
		// 2. 받아온 문자열의 길이만큼 반복하기
		int[] seatList = new int[arraySeatList.length];
		for (int i = 0; i < arraySeatList.length; i++) {
			// 3.seatListString[i]의 값을 seatList[i]로 변환하기
			seatList[i] = Integer.parseInt(arraySeatList[i]);
		}

		// SEAT_INFO 업데이트를 위한 vo 생성
		SeatVO seatVo = new SeatVO();
		// BOOK_INFO 업데이트를 위한 vo 생성
		myPageVO myPagevo = new myPageVO();

		// 작성한 날짜 구해주기
		Timestamp tDate = new Timestamp(System.currentTimeMillis());
		// 시분초 까지나오는 데이터를 날짜까지 나오게 포맷
		String todayDate = new SimpleDateFormat("yyyy/MM/dd").format(tDate);
		System.out.println(todayDate);


		// 데이터베이스 연결을 위한 dao 생성
		DAO dao = new DAO();
		// 로그인한 회원정보 넣기
		myPagevo.setEmail(member.getEmail());
		// 가격 넣기
		myPagevo.setPay(pay / arraySeatList.length);
		// 현재 날짜 넣기
		myPagevo.setPay_date(todayDate);

		for (int i = 0; i < seatList.length; i++) {
			// seatVO의 값을 설정
			seatVo.setSHTL_ID(shuttleID);
			seatVo.setSEAT_NUM(seatList[i]);

			// 설정된 vo의 값으로 업데이틑 구문 실행
			dao.seatUpdate(seatVo);
			// myPagevo의 값을 설정
			
			myPagevo.setShtl_id(shuttleID);
			myPagevo.setSeat_num(seatList[i]);

			dao.bookInsert(myPagevo);
			
		}

		myPage common = new myPage();
		
		return common.execute(request, response); 
	}

}
