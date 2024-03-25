package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface command {
	
	// FrontController --> 자원을 많이 차지하는 / 돈을 많이 받아야하는 매니저
	// Join, Login, SelectAll, Login --> 일반인클래스 /자원을 적게 차지하는 / 아르바이트생
	// Command --> 메뉴얼 / 규격
	
	// abstract만 받을 수 있어서 생략 가능하다
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
