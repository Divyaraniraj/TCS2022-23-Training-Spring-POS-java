/**
 * 
 */
package com.tcs.service;

import com.tcs.exception.CourseIdNotFound;

/**
 * @author Administrator
 *
 */
public interface Professor_Service_Interface {

	public void ToViewEnrolledStudent() throws CourseIdNotFound;

	public void ToAddGrades();
}
