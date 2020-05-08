package com.capgemini.go.dto;

import java.io.Serializable;

@Entity
@Table(name = "USER")
public class UserDTO implements Serializable {

	
	private static final long serialVersionUID = -8450180103620249767L;

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, length = 30)
	private int userId;

	@Column(name = "USER_PASSWORD", unique = false, nullable = false, length = 30)
	private String userPassword;

	@Column(name = "USER_ROLE", unique = false, nullable = false, length = 20)
	private String userRole;//	Role Can be ADMIN, Retailer, Product Master
	
	@column(name = "USER_EMAIL", unique = false, nullable = false, length = 20)
	private String userEmail;
	
	@column(name = "USER_PHONENO", unique = false, nullable = false, length = 20)
	private String userPhoneNo;




	public UserDTO(int userId, String userPassword, String userRole) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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
	
	public String getUserEmail() {
		return userRole;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	
	
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userPassword="+ userPassword + ", userRole=" + userRole + "]";
	}
}

