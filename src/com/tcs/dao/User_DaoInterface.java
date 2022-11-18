/**
 * 
 */
package com.tcs.dao;

/**
 * @author Administrator
 *
 */
public interface User_DaoInterface {

//	public void studentRegistration();

	public boolean adminLogin(String input1,String input2);
	public boolean studentLogin(String input1,String input2);

	//public boolean professorLogin();
	//public void updatePassword();

	public void studentRegistration(int sid, String sname, String sdept, String spassword);
	public boolean professorLogin(String inp1, String inp2);
	public void updatePassword(int id, String oldpswd, String newpswd);

}
