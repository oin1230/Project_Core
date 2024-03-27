package com.smhrd.model;

public class BoardLikeVO {

	// like 식별자
	private int like_id;
	// like 상태
	private String b_like_state;
	// 게시물 식별자
	private int b_id;
	// 유저 이메일
	private String email;

	private int b_likes;

	public BoardLikeVO(int like_id, String b_like_state, int b_id, String email, int b_likes) {
		this.like_id = like_id;
		this.b_like_state = b_like_state;
		this.b_id = b_id;
		this.email = email;
	}

	public BoardLikeVO() {

	}

	public int getLike_id() {
		return like_id;
	}

	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}

	public String getB_like_state() {
		return b_like_state;
	}

	public void setB_like_state(String b_like_state) {
		this.b_like_state = b_like_state;
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
