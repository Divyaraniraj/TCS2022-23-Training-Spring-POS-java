/**
 * 
 */
package com.tcs.service;

/**
 * @author Administrator
 *
 */
public interface User_Service_Interface {
	public boolean AdminLogin();

	public boolean StudentLogin();

	public boolean ProfessorLogin();

	public void StudentRegistration();

	public void UpdatePassword();

}
