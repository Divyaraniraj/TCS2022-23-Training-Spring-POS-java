/**
 * 
 */
package com.tcs.service;
import com.tcs.exception.StudentIdNotFound;
/**
 * @author Administrator
 *
 */
public interface Admin_Service_Interface {

	public void ToApproveStudentRegistration();

	public void ToAddCourse();

	public void ToRemoveCourse() throws StudentIdNotFound;

	public void ToGenerateReportCard();

	public void ToAddProfessor();

	public void ToListProfessor();

	public void ToListCourses();

}
