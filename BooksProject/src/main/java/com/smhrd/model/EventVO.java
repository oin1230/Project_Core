package com.smhrd.model;

public class EventVO {

    // 행사 식별자 
    private int event_id;
    // 행사 명 
    private String event_name;
    // 행사 날짜 
    private String event_date;
    // 행사 장소 
    private String event_loc;
    // 행사 사진경로
    private String event_img;
    
    public EventVO(int event_id, String event_name, String event_date, String event_loc,
			String event_img) {
		super();
		this.event_id = event_id;
		this.event_name = event_name;
		this.event_date = event_date;
		this.event_loc = event_loc;
		this.event_img = event_img;
	}

	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public String getEvent_loc() {
		return event_loc;
	}
	public void setEvent_loc(String event_loc) {
		this.event_loc = event_loc;
	}
	public String getEvent_img() {
		return event_img;
	}
	public void setEvent_img(String event_img) {
		this.event_img = event_img;
	}

}