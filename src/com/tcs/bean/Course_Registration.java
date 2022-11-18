/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */


/*
 * @class: CourseRegistration
 * @param: studentId,studnetName,courseId,courseName
 * setters and getters for the course registration attributes.
 * 
 */

public class Course_Registration {
	
	
	private int student_Id;
	private String student_Name;
	private int course_Id;
	private String course_Name;
	public boolean sid;
	
	public int getStudent_Id() {
		return student_Id;
	}
	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}
	public String getStudent_Name() {
		return student_Name;
	}
	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}
	public int getCourse_Id() {
		return course_Id;
	}
	public void setCourse_Id(int course_Id) {
		this.course_Id = course_Id;
	}
	public String getCourse_Name() {
		return course_Name;
	}
	public void setCourse_Name(String course_Name) {
		this.course_Name = course_Name;
	}
	
	
	

}
