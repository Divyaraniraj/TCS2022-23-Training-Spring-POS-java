/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */

/*
 * @class: SemRegistration
 * @param: studentId,studentName,semester,regulation
 * setters and getters for the sem registration attributes.
 * 
 */

public class Sem_Registration {
	
	private int student_Id;
	private String student_Name;
	private int semester;
	private String regulation;
	
	
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
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getRegulation() {
		return regulation;
	}
	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}
	
	
	
	

}
