/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */




/*
 * @class: ApproveStudentRegistration
 * @param: studentId,studentName,department,password.
 * setters and getters for the student registration attributes.
 * 
 * 
 */

public class Registration {
	
	
	private int student_Id;
	private String student_Name;
	private String student_Department;
	private String student_Password;
	private int Completion_status=0;
	
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
	public String getStudent_Department() {
		return student_Department;
	}
	public void setStudent_Department(String student_Department) {
		this.student_Department = student_Department;
	}
	public String getStudent_Password() {
		return student_Password;
	}
	public void setStudent_Password(String student_Password) {
		this.student_Password = student_Password;
	}
	public int getCompletion_status() {
		return Completion_status;
	}
	public void setCompletion_status(int completion_status) {
		Completion_status = completion_status;
	}
	@Override
	public String toString() {
		return "Registration [student_Id=" + student_Id + ", student_Name=" + student_Name + ", student_Department="
				+ student_Department + ", student_Password=" + student_Password + ", Completion_status="
				+ Completion_status + "]";
	}

}
