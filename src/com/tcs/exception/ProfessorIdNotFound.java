/**
 * 
 */
package com.tcs.exception;

/**
 * @author Administrator
 *
 */
public class ProfessorIdNotFound extends Exception{
	private int p_id;
	public ProfessorIdNotFound(int p_id)
	{
		this.p_id=p_id;
	}
	public int getP_Id()
	{
		return p_id;
	}

}
