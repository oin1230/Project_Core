package com.smhrd.model;

public class SeatVO {

	private int SEAT_ID;
	private int SHTL_ID;
	private int SEAT_NUM;
	private String SEAT_STATUS;
	private int EVENT_ID;
	private int RESERVED_SEAT_COUNT;
	private String EVENT_LOC;

	public SeatVO() {}


	public SeatVO(int SEAT_ID, int SHTL_ID, int SEAT_NUM, String SEAT_STATUS, int EVENT_ID, int RESERVED_SEAT_COUNT, String EVENT_LOC) {
		this.SEAT_ID = SEAT_ID;
		this.SHTL_ID = SHTL_ID;
		this.SEAT_NUM = SEAT_NUM;
		this.SEAT_STATUS = SEAT_STATUS;
		this.EVENT_ID = EVENT_ID;
		this.RESERVED_SEAT_COUNT = RESERVED_SEAT_COUNT;
		this.EVENT_LOC = EVENT_LOC;
	}

	public SeatVO(int SEAT_ID, int SHTL_ID, int SEAT_NUM, String SEAT_STATUS) {
		this.SEAT_ID = SEAT_ID;
		this.SHTL_ID = SHTL_ID;
		this.SEAT_NUM = SEAT_NUM;
		this.SEAT_STATUS = SEAT_STATUS;
	}

	public int getEVENT_ID() {
		return EVENT_ID;
	}

	public void setEVENT_ID(int eVENT_ID) {
		EVENT_ID = eVENT_ID;
	}

	public int getRESERVED_SEAT_COUNT() {
		return RESERVED_SEAT_COUNT;
	}

	public void setRESERVED_SEAT_COUNT(int rESERVED_SEAT_COUNT) {
		RESERVED_SEAT_COUNT = rESERVED_SEAT_COUNT;
	}

	public int getSEAT_ID() {
		return SEAT_ID;
	}

	public void setSEAT_ID(int sEAT_ID) {
		SEAT_ID = sEAT_ID;
	}

	public int getSHTL_ID() {
		return SHTL_ID;
	}

	public void setSHTL_ID(int sHTL_ID) {
		SHTL_ID = sHTL_ID;
	}

	public int getSEAT_NUM() {
		return SEAT_NUM;
	}

	public void setSEAT_NUM(int sEAT_NUM) {
		SEAT_NUM = sEAT_NUM;
	}

	public String getSEAT_STATUS() {
		return SEAT_STATUS;
	}

	public void setSEAT_STATUS(String sEAT_STATUS) {
		SEAT_STATUS = sEAT_STATUS;
	}

	public String getEVENT_LOC() {
		return EVENT_LOC;
	}
	
	public void setEVENT_LOC(String eVENT_LOC) {
		EVENT_LOC = eVENT_LOC;
	}
}
