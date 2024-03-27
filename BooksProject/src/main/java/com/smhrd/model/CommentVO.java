package com.smhrd.model;

public class CommentVO {
	
	private int cmt_id;
	private int b_id;
	private String cmt_content;
	private String cmt_date;
	private String email;
	
	public CommentVO(int cmt_id, int b_id, String cmt_content, String cmt_date, String email) {
		super();
		this.cmt_id = cmt_id;
		this.b_id = b_id;
		this.cmt_content = cmt_content;
		this.cmt_date = cmt_date;
		this.email = email;
	}

	public CommentVO() {
		// TODO Auto-generated constructor stub
	}

	public int getCmt_id() {
		return cmt_id;
	}

	public void setCmt_id(int cmt_id) {
		this.cmt_id = cmt_id;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getCmt_content() {
		return cmt_content;
	}

	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}

	public String getCmt_date() {
		return cmt_date;
	}

	public void setCmt_date(String cmt_date) {
		this.cmt_date = cmt_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
