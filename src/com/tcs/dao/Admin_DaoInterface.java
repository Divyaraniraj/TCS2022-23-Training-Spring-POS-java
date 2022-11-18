/**
 * 
 */
package com.tcs.dao;

/**
 * @author Administrator
 *
 */
public interface Admin_DaoInterface {
	
	public void approveRegistration();
//	public void addCourse();
	//public void addProfessor();
	public void listProfessor();
	public void listCourses();
	//public void removeCourse();
	public void gradeCard(int student_id,String s_name);
	public void addCourse(int course_Id, String course_name, String professor_name, String Department, String prerequies);
	public void addProfessor(int pid, String pname, String ppswd, String dept);
	void removeCourse(int inp);
	
}
