package com.callin.domain;

public class UserDto {

	private String userId;			// 아이디
	private String userPw;			// 패스워드
	private String userName;		// 이름
	private String userLevel;		// 권한
	private String userEmail;		// 이메일
	
	private String userPostCode;	// 우편번호
	private String userAddr;		// 주소
	private String userAddrDetail;	// 상세주소
	private String userAddrExtra;	// 참고항목
	
	private String userRegDate;		// 가입일자
	private String userNickName;	// 닉네임
	private String userBirth;		// 생일
	private String userGender;		// 성별
	private String userPhone;		// 휴대폰번호

	
	public String getUserPostCode() {
		return userPostCode;
	}
	public void setUserPostCode(String userPostCode) {
		this.userPostCode = userPostCode;
	}
	public String getUserAddrDetail() {
		return userAddrDetail;
	}
	public void setUserAddrDetail(String userAddrDetail) {
		this.userAddrDetail = userAddrDetail;
	}
	public String getUserAddrExtra() {
		return userAddrExtra;
	}
	public void setUserAddrExtra(String userAddrExtra) {
		this.userAddrExtra = userAddrExtra;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
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
	
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userLevel="
				+ userLevel + ", userEmail=" + userEmail + ", userPostCode=" + userPostCode + ", userAddrDetail="
				+ userAddrDetail + ", userAddrExtra=" + userAddrExtra + ", userAddr=" + userAddr + ", userRegDate="
				+ userRegDate + ", userNickName=" + userNickName + ", userBirth=" + userBirth + ", userGender="
				+ userGender + ", userPhone=" + userPhone + "]";
	}
	
}
