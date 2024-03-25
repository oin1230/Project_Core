package com.smhrd.model;

public class LikeVO {

	// like 식별자
	private int like_id;
	// like 상태
	private String like_state;
	// 게시물 식별자
	private int b_id;
	// 유저 이메일
	private String email;
	
	
	public LikeVO(int like_id, String like_state, int b_id, String email) {
		super();
		this.like_id = like_id;
		this.like_state = like_state;
		this.b_id = b_id;
		this.email = email;
	}


	public LikeVO() {
		// TODO Auto-generated constructor stub
	}


	public int getLike_id() {
		return like_id;
	}


	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}


	public String getLike_state() {
		return like_state;
	}


	public void setLike_state(String like_state) {
		this.like_state = like_state;
	}


	public int getB_id() {
		return b_id;
	}


	public void setB_id(int b_id) {
		this.b_id = b_id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
