/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */


/*
 * @class: Payment
 * @param: studentId,studentName,coursesRegistered,amount
 * setters and getters for the payment attributes.
 * 
 */

public class Payment {
	private int student_Id;
	private String student_Name;
	private int courses_Registered;
	private int amount;
	
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
	public int getCourses_Registered() {
		return courses_Registered;
	}
	public void setCourses_Registered(int courses_Registered) {
		this.courses_Registered = courses_Registered;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
	

}
