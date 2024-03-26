package com.smhrd.model;

public class ShuttleVO {
	
	// 셔틀 식별자
	private int shtl_id;
	// 출발 지역
	private String start_rg;
	// 해당 셔틀 신청한 총 인원수
	private int shtl_num;
	// 셔틀 등록일
	private String start_date;
	// 셔틀 신청 마감일
	private String end_date;
	// 가격
	private int price;
	// 출발 날짜
	private String riding_date;
	// 셔틀 등록 상태
	private String shtl_state;
	// 행사 식별자
	private int event_id;
	// 행사 이미지
	private String event_img;
	// 행사 이름
	private String event_name;
	// 행사 지역
	private String event_loc;
	
	
	public ShuttleVO(int shtl_id, String start_rg, int shtl_num, String start_date, String end_date, int price,
			String riding_date, String shtl_state, int event_id, String event_img, String event_name,
			String event_loc) {
		this.shtl_id = shtl_id;
		this.start_rg = start_rg;
		this.shtl_num = shtl_num;
		this.start_date = start_date;
		this.end_date = end_date;
		this.price = price;
		this.riding_date = riding_date;
		this.shtl_state = shtl_state;
		this.event_id = event_id;
		this.event_img = event_img;
		this.event_name = event_name;
		this.event_loc = event_loc;
	}


	public ShuttleVO() {
	}


	public int getShtl_id() {
		return shtl_id;
	}


	public void setShtl_id(int shtl_id) {
		this.shtl_id = shtl_id;
	}


	public String getStart_rg() {
		return start_rg;
	}


	public void setStart_rg(String start_rg) {
		this.start_rg = start_rg;
	}


	public int getShtl_num() {
		return shtl_num;
	}


	public void setShtl_num(int shtl_num) {
		this.shtl_num = shtl_num;
	}


	public String getStart_date() {
		return start_date;
	}


	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}


	public String getEnd_date() {
		return end_date;
	}


	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getRiding_date() {
		return riding_date;
	}


	public void setRiding_date(String riding_date) {
		this.riding_date = riding_date;
	}


	public String getShtl_state() {
		return shtl_state;
	}


	public void setShtl_state(String shtl_state) {
		this.shtl_state = shtl_state;
	}


	public int getEvent_id() {
		return event_id;
	}


	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}


	public String getEvent_img() {
		return event_img;
	}


	public void setEvent_img(String event_img) {
		this.event_img = event_img;
	}


	public String getEvent_name() {
		return event_name;
	}


	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}


	public String getEvent_loc() {
		return event_loc;
	}


	public void setEvent_loc(String event_loc) {
		this.event_loc = event_loc;
	}
	
	

	
}
