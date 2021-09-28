package com.callin.domain;

public class ClassProgressDto {

	private String classStartDate;
	private String classEndDate;
	private String classStartTime;
	private String classEndTime;
	private String classProgressDay;
	private String courseName;
	private String teacherId;
	
	public String getClassStartDate() {
		return classStartDate;
	}
	public void setClassStartDate(String classStartDate) {
		this.classStartDate = classStartDate;
	}
	public String getClassEndDate() {
		return classEndDate;
	}
	public void setClassEndDate(String classEndDate) {
		this.classEndDate = classEndDate;
	}
	public String getClassStartTime() {
		return classStartTime;
	}
	public void setClassStartTime(String classStartTime) {
		this.classStartTime = classStartTime;
	}
	public String getClassEndTime() {
		return classEndTime;
	}
	public void setClassEndTime(String classEndTime) {
		this.classEndTime = classEndTime;
	}
	public String getClassProgressDay() {
		return classProgressDay;
	}
	public void setClassProgressDay(String classProgressDay) {
		this.classProgressDay = classProgressDay;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	@Override
	public String toString() {
		return "ClassProgressDto [classStartDate=" + classStartDate + ", classEndDate=" + classEndDate
				+ ", classStartTime=" + classStartTime + ", classEndTime=" + classEndTime + ", classProgressDay="
				+ classProgressDay + ", courseName=" + courseName + ", teacherId=" + teacherId + "]";
	}
	
	
	
}
