/**
 * 
 */
package com.tcs.exception;

/**
 * @author Administrator
 *
 */
public class CourseIdNotFound extends Exception {
	private int c_id;
	public CourseIdNotFound(int c_id)
	{
		this.c_id=c_id;
	}
	public int getC_Id()
	{
		return c_id;
	}

}
