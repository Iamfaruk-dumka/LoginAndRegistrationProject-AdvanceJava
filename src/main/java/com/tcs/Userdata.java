package com.tcs;

public class Userdata {

	private String username;
	private String password;
	private String cpassword;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Userdata(String username, String password, String cpassword, String email) {
		super();
		this.username = username;
		this.password = password;
		this.cpassword = cpassword;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Userdata [username=" + username + ", password=" + password + ", cpassword=" + cpassword + ", email="
				+ email + "]";
	}
	
	
	
	}


