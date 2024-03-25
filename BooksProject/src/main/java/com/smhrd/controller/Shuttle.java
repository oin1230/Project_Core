package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.ShuttleVO;

public class Shuttle implements command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		DAO dao = new DAO();
		List<ShuttleVO> shuttlelist = dao.Shuttle();
		request.setAttribute("shuttlelist", shuttlelist);
		
		return "index";
	
	}

}
