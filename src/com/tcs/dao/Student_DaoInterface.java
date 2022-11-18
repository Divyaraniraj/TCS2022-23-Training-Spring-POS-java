/**
 * 
 */
package com.tcs.dao;

/**
 * @author Administrator
 *
 */
public interface Student_DaoInterface {
	public void courseRegister(int student_id,int course_id1,int course_id2,int course_id3,int course_id4);
	public void addCourse(int student_id);
	public void dropCourse(int student_id);
	public void viewCourses(int g);
	public void viewReportCard(int student_id);
	public void payment(int sid);
	
	
}
