package com;

public class User {
	
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String gender;
	private long phone;
	
	
	//helper method start here
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
				+ password + ", gender=" + gender + ", phone=" + phone + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}//class block end here
