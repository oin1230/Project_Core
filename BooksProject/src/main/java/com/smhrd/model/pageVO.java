package com.smhrd.model;

public class pageVO {
	
	private String b_category;
	private int startPageNum;
	private int boardNum;
	
	public pageVO(String b_category, int startPageNum, int boardNum) {
		super();
		this.b_category = b_category;
		this.startPageNum = startPageNum;
		this.boardNum = boardNum;
	}

	public pageVO() {
		// TODO Auto-generated constructor stub
	}

	public String getB_category() {
		return b_category;
	}

	public void setB_category(String b_category) {
		this.b_category = b_category;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
}
