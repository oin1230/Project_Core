package com.smhrd.model;

public class BoardVO {
	
	private int b_id;
	private String b_category;
	private String b_title;
	private String b_content;
	private String b_date;
	private int b_views;
	private int b_likes;
	private String email;
	private String nick;
	
	
	public BoardVO(int b_id, String b_category, String b_title, String b_content, String b_date, int b_views, String email, String nick, int b_likes) {
		super();
		this.b_id = b_id;
		this.b_category = b_category;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_date = b_date;
		this.b_views = b_views;
		this.email = email;
		this.nick = nick;
		this.b_likes = b_likes;
	}
	
	public int getB_likes() {
		return b_likes;
	}

	public void setB_likes(int b_likes) {
		this.b_likes = b_likes;
	}

	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_category() {
		return b_category;
	}

	public void setB_category(String b_category) {
		this.b_category = b_category;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public int getB_views() {
		return b_views;
	}

	public void setB_views(int b_views) {
		this.b_views = b_views;
	}
	
	
	
	

}
