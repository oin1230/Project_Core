package com.smhrd.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.smhrd.database.DAO;
import com.smhrd.model.SeatVO;

public class bookingSeat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");

        int shtl_id = Integer.parseInt(request.getParameter("SHTL_ID"));
		SeatVO vo = new SeatVO();
		vo.setSHTL_ID(shtl_id);
		
		
		DAO dao = new DAO();
		List<SeatVO> bookingSeat = dao.bookingSeat(vo);
		
		request.setAttribute("bookingSeat", bookingSeat);
		
		  Gson gson = new Gson();
	         String json = gson.toJson(bookingSeat);
	         PrintWriter out = response.getWriter();
	         out.print(json);
	         return;
		
	}

}
