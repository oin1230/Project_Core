	package com.smhrd.controller;
	
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import com.smhrd.database.DAO;
	import com.smhrd.model.CommentVO;
	
	public class commentDelete implements command {
		
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			
			int cmt_id = Integer.parseInt(request.getParameter("cmt_id")); 
			int b_id = Integer.parseInt(request.getParameter("value"));
			// System.out.println("cmt_id : "+cmt_id+"b_id : "+b_id);
			
			CommentVO vo = new CommentVO();
			vo.setCmt_id(cmt_id);
			
			DAO dao = new DAO();
			dao.commentDelete(vo);
			
			// request.setAttribute("value", b_id);
			
			boardDetail boardDetailCommand = new boardDetail();
	        return boardDetailCommand.execute(request, response);
		}
	
	}
