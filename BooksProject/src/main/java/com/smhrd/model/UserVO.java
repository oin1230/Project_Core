package com.smhrd.model;

public class UserVO {

	// user 이메일
	private String email;
	// user 비밀번호
	private String pw;
	// user 닉네임
	private String nick;
	// user 주소
	private String address;
	// user 핸드폰번호
	private String phone;
	// 새로운 비밀번호
	private String newPw;

	public UserVO(String email, String pw, String nick, String address, String phone, String newPw) {
		super();
		this.email = email;
		this.pw = pw;
		this.nick = nick;
		this.address = address;
		this.phone = phone;
		this.newPw = newPw;
	}

	public String getNewPw() {
		return newPw;
	}

	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}

	public UserVO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
