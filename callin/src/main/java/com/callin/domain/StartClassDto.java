package com.callin.domain;

public class StartClassDto {

	private String courseName;
	private String classFare;
	private String registrationDate;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getClassFare() {
		return classFare;
	}
	public void setClassFare(String classFare) {
		this.classFare = classFare;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	@Override
	public String toString() {
		return "StartClassDto [courseName=" + courseName + ", classFare=" + classFare + ", registrationDate="
				+ registrationDate + "]";
	}
	
}
