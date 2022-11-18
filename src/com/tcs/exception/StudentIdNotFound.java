/**
 * 
 */
package com.tcs.exception;

/**
 * @author Administrator
 *
 */
public class StudentIdNotFound extends Exception{
	private int s_id;
	public StudentIdNotFound(int s_id)
	{
		this.s_id=s_id;
	}
	public int getS_Id()
	{
		return s_id;
	}

}
