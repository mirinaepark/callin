package com.callin.domain;

public class ClassProgressDto {

	private String courseName;
	private String teacherName;
	private String classStartDate;
	private String classEndDate;
	private String classProgressDay;
	private String classStartTime;
	private String classEndTime;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
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
	public String getClassProgressDay() {
		return classProgressDay;
	}
	public void setClassProgressDay(String classProgressDay) {
		this.classProgressDay = classProgressDay;
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
	
	@Override
	public String toString() {
		return "ClassProgressDto [courseName=" + courseName + ", teacherName=" + teacherName + ", classStartDate="
				+ classStartDate + ", classEndDate=" + classEndDate + ", classProgressDay=" + classProgressDay
				+ ", classStartTime=" + classStartTime + ", classEndTime=" + classEndTime + "]";
	}

	
	
}
