	package com.smhrd.controller;
	
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import com.smhrd.database.DAO;
	import com.smhrd.model.CommentVO;
	
	public class commentDelete implements command {
		
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			
			int cmt_id = Integer.parseInt(request.getParameter("cmt_id")); 
			int b_id = Integer.parseInt(request.getParameter("value"));
			
			CommentVO vo = new CommentVO();
			vo.setCmt_id(cmt_id);
			
			DAO dao = new DAO();
			dao.commentDelete(vo);
			
			boardDetail boardDetailCommand = new boardDetail();
	        return boardDetailCommand.execute(request, response);
		}
	
	}
