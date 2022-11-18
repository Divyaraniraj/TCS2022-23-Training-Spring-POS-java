/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */

/*
 * @class: Login for student,professor,admin
 * @param: loginId,loginPassword
 * setters and getters for the login attributes.
 * 
 */
public class Login {
	
	private int login_Id;
	private String login_Password;
	
	
	public int getLogin_Id() {
		return login_Id;
	}
	public void setLogin_Id(int login_Id) {
		this.login_Id = login_Id;
	}
	public String getLogin_Password() {
		return login_Password;
	}
	public void setLogin_Password(String login_Password) {
		this.login_Password = login_Password;
	}
	
	
	
	
}
