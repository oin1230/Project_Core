package com.smhrd.model;

public class myPageVO {

	private int book_id;

	private String email;

	private String event_name;

	private String pay_state;

	private int pay;

	private String pay_date;

	private int shtl_id;

	private int seat_num;
	
	

	public myPageVO(int book_id, String email, String event_name, String pay_state, int pay, String pay_date,
			int shtl_id, int seat_num) {
		this.book_id = book_id;
		this.email = email;
		this.event_name = event_name;
		this.pay_state = pay_state;
		this.pay = pay;
		this.pay_date = pay_date;
		this.shtl_id = shtl_id;
		this.seat_num = seat_num;
	}

	public myPageVO() {

	}

	public int getShtl_id() {
		return shtl_id;
	}

	public void setShtl_id(int shtl_id) {
		this.shtl_id = shtl_id;
	}

	public int getSeat_num() {
		return seat_num;
	}

	public void setSeat_num(int seat_num) {
		this.seat_num = seat_num;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
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

	public String getPay_state() {
		return pay_state;
	}

	public void setPay_state(String pay_state) {
		this.pay_state = pay_state;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

}
