/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */



/*
 * @class: ReportCard
 * @param: studentId,studentName,courseId,courseName,grade
 * setters and getters for the ReportCard attributes.
 * 
 */

public class Grade_Card {
	
	
	private int student_Id;
	private String student_Name;
    private String Student_result;
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
	public String getStudent_result() {
		return Student_result;
	}
	public void setStudent_result(String student_result) {
		Student_result = student_result;
	}
	
    @Override
	public String toString() {
		return "Grade_Card [student_Id=" + student_Id + ", student_Name=" + student_Name + ", Student_result="
				+ Student_result + "]";
	
    }
}
