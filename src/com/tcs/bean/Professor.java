/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */




/*
 * @class: Professor
 * @param: professorId,professorName,password,department
 * setters and getters for the professor attributes.
 * 
 */

public class Professor {
	
	
	
	private int professor_Id;
	private String professor_Name;
	private String professor_Password;
	private int Professor_Course_Count;
	private String Professor_department;
	
	public int getProfessor_Id() {
		return professor_Id;
	}
	public void setProfessor_Id(int professor_Id) {
		this.professor_Id = professor_Id;
	}
	public String getProfessor_Name() {
		return professor_Name;
	}
	public void setProfessor_Name(String professor_Name) {
		this.professor_Name = professor_Name;
	}
	public String getProfessor_Password() {
		return professor_Password;
	}
	public void setProfessor_Password(String professor_Password) {
		this.professor_Password = professor_Password;
	}
	public int getProfessor_Course_Count() {
		return Professor_Course_Count;
	}
	public void setProfessor_Course_Count(int professor_Course_Count) {
		Professor_Course_Count = professor_Course_Count;
	}
	public String getProfessor_department() {
		return Professor_department;
	}
	public void setProfessor_department(String professor_department) {
		Professor_department = professor_department;
	}
	
	@Override
	public String toString() {
		return "Professor [professor_Id=" + professor_Id + ", professor_Name=" + professor_Name
				+ ", professor_Password=" + professor_Password + ", Professor_Course_Count=" + Professor_Course_Count
				+ ", Professor_department=" + Professor_department + "]";
	}
	
	
	

}
