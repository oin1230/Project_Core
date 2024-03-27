package com.smhrd.model;

public class myPageVO {
	
	private int book_id;
	
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	private String email;
	
	private String event_name;
	
	private String shtl_state;
	
	private int price;
	
	private String pay_time;
	

	public myPageVO(int book_id, String email, String event_name, String shtl_state, int price, String pay_time) {
		
		this.book_id = book_id;
		this.email = email;
		this.event_name = event_name;
		this.shtl_state = shtl_state;
		this.price = price;
		this.pay_time = pay_time;
	}

	public myPageVO() {
		 
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getShtl_state() {
		return shtl_state;
	}

	public void setShtl_state(String shtl_state) {
		this.shtl_state = shtl_state;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPay_time() {
		return pay_time;
	}

	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}
	
	
}
