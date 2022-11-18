/**
 * 
 */
package com.tcs.bean;

/**
 * @author Administrator
 *
 */

/*
 * @class: Admin
 * 
 * @param: a_Id, a_Name, a_Pswd setters and getters for the Admin attributes.
 * 
 * 
 */

public class Admin {

	private int a_Id;
	private String a_Name;
	private String a_Pswd;

	public int getA_Id() {
		return a_Id;
	}

	public void setA_Id(int a_Id) {
		this.a_Id = a_Id;
	}

	public String getA_Name() {
		return a_Name;
	}

	public void setA_Name(String a_Name) {
		this.a_Name = a_Name;
	}

	public String getA_Pswd() {
		return a_Pswd;
	}

	public void setA_Pswd(String a_Pswd) {
		this.a_Pswd = a_Pswd;
	}

}
