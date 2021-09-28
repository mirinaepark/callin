package com.callin.domain;

public class UserDto {

	private String userId;
	private String userPw;
	private String userName;
	private String userLevel;
	private String userEmail;
	private String userAddr;
	private String userRegDate;
	private String userClass;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserRegDate() {
		return userRegDate;
	}
	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}
	public String getUserClass() {
		return userClass;
	}
	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}
	
	
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userLevel=" + userLevel + ", userEmail=" + userEmail + ", userAddr=" + userAddr + ", userRegDate="
				+ userRegDate + ", userClass=" + userClass + "]";
	}
}
