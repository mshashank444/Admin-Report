package com.capgemini.go.dto;

public class UserDTO {




	private String userId;
	private String userPassword;
	private String userRole; // role are productmaster, retailer, admin
	String email;
	String phoneNo;
	


	public UserDTO(String userId, String userPassword, String userRole, String email, String phoneNo) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.email = email;
		this.phoneNo = phoneNo;
		
	}


	public UserDTO() {
		// TODO Auto-generated constructor stub
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userPassword="+ userPassword + ", userRole=" + userRole + ", "
				+ "email="+ email +", phoneNo=" + phoneNo + "]";
	}
}

