/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */



/*
 * @class: CourseCatalogue
 * @param: courseID,courseName,professor,department,prerequisites
 * setters and getters for the CourseCatalogue attributes.
 * 
 */

public class Catalougue {
	
	
	
	private int course_Id;
	private String course_Name;
	private String professor;
	private String department;
	private String prerequisites;
	
	
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
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	
	@Override
	public String toString() {
		return "Course_Catalougue [course_Id=" + course_Id + ", course_Name=" + course_Name + ", professor=" + professor
				+ ", department=" + department + ", prerequisites=" + prerequisites + "]";
	}
	

}
