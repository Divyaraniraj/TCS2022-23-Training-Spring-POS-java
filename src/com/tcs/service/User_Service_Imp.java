/**
 * 
 */
package com.tcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tcs.bean.Admin;
import com.tcs.bean.Professor;
import com.tcs.bean.Registration;
import com.tcs.bean.Student;
import com.tcs.dao.*;
/**
 * @author Administrator
 *
 */
public class User_Service_Imp implements User_Service_Interface {
	Scanner sc = new Scanner(System.in);
	static List<Student> slist = new ArrayList<Student>();

	static List<Professor> plist = new ArrayList<Professor>();
	static List<Admin> alist = new ArrayList<Admin>();
	static List<Registration> asr = new ArrayList<Registration>();

	User_DaoInterface udi = new User_DaoImp();

	/*
	 * @method: adminLogin
	 * 
	 * 
	 * @param: Admin ID
	 * 
	 * @param: Admin Password
	 * 
	 * The Admin can login if the given credentials are correct. The method return
	 * true if the credentials are correct else return false.
	 * 
	 */

	@Override
	public boolean AdminLogin() {
		// TODO Auto-generated method stub
		/*
		 * Admin adm=new Admin(); adm.setAdminID(123); adm.setAdminName("Admin");
		 * adm.setAdminpswd("Admin123"); alist.add(adm);
		 */

		System.out.println("Enter UserName");
		String inp1 = sc.nextLine();

		System.out.println("Enter Password");
		String inp2 = sc.nextLine();

		/*
		 * if(adm.getAdminName().equals(inp1) && adm.getAdminpswd().equals(inp2)) {
		 * return true; } return false;
		 */
		boolean al = udi.adminLogin(inp1, inp2);

		return al;
	}

	/*
	 * @method: studentLogin
	 * 
	 * 
	 * @param: Student UserName
	 * 
	 * @param: Student Password
	 * 
	 * The student can login if the given credentials are correct. The method return
	 * true if the credentials are correct else return false.
	 * 
	 */

	@Override
	public boolean StudentLogin() {
		// TODO Auto-generated method stub
		System.out.println("Enter UserName");
		String inp1 = sc.nextLine();

		System.out.println("Enter Password");
		String inp2 = sc.nextLine();

		/*
		 * for(int i=0;i<slist.size();i++) {
		 * if((slist.get(i).getStudentName().equals(inp1)) &&
		 * (slist.get(i).getStudentPassword().equals(inp2)) &&
		 * (slist.get(i).getStatus()==1)) { return true;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * return false;
		 */
		boolean sl = udi.studentLogin(inp1, inp2);

		return sl;

	}

	/*
	 * @method: studentRegistration
	 * 
	 * @param: Student ID
	 * 
	 * @param: Student Name
	 * 
	 * @param: Student Password
	 * 
	 * @param: Department
	 * 
	 * The student enters all the required details. The registration request is sent
	 * to admin. If admin approves the student, then the student can login.
	 * 
	 */

	@Override
	public void StudentRegistration() {
		// TODO Auto-generated method stub
		Registration astu = new Registration();
		Student stu = new Student();

		System.out.println("Enter Student ID");
		int sid = sc.nextInt();
		sc.nextLine();

		// astu.setStudentId(sid);
		// stu.setStudentId(sid);

		System.out.println("Enter Student Name");
		String sname = sc.nextLine();

		// astu.setStudentName(sname);
		// stu.setStudentName(sname);

		System.out.println("Enter Password");
		String spassword = sc.nextLine();

		// astu.setStudentPassword(spassword);
		// stu.setStudentPassword(spassword);

		System.out.println("Enter Department");
		String sdept = sc.nextLine();

		// astu.setStudentDepartment(sdept);
		// stu.setStudentDepartment(sdept);
		// slist.add(stu);
		// asr.add(astu);

		udi.studentRegistration(sid, sname, sdept, spassword);
	}

	/*
	 * @method: professorLogin
	 * 
	 * 
	 * @param: Professor UserName
	 * 
	 * @param: Professor Password
	 * 
	 * The Professor can login if the given credentials are correct. The method
	 * return true if the credentials are correct else return false.
	 * 
	 */

	@Override
	public boolean ProfessorLogin() {
		// TODO Auto-generated method stub
		System.out.println("Enter UserName");
		String inp1 = sc.nextLine();
		System.out.println("Enter Password");
		String inp2 = sc.nextLine();
		/*
		 * for(int i=0;i<plist.size();i++) {
		 * if((plist.get(i).getProfessorName().equals(inp1)) &&
		 * (plist.get(i).getProfessorPassword().equals(inp2))) { return true; }
		 * 
		 * } return false;
		 */
		boolean s2 = udi.professorLogin(inp1, inp2);

		return s2;
	}

	/*
	 * @method: updatePassword
	 * 
	 * Student, Professor and Admin can change their password by giving their
	 * ID's,old password and new password.
	 * 
	 * @param: Student/Professor/Admin ID
	 * 
	 * @param: old password
	 * 
	 * @param: new password
	 * 
	 * The password is updated with the new password.
	 * 
	 */

	@Override
	public void UpdatePassword() {
		// TODO Auto-generated method stub
		// System.out.println("Update Password Menu");

		/*
		 * System.out.println("1.Student"); System.out.println("2.Professor");
		 * System.out.println("3.Admin"); System.out.println("Enter your choice"); int
		 * opt=sc.nextInt();sc.nextLine(); switch(opt) { case 1:
		 */

		System.out.println("Enter login Id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Old Password");
		String oldpswd = sc.nextLine();
		System.out.println("Enter new Password");
		String newpswd = sc.nextLine();
		/*
		 * for(int i=0;i<UserServiceImp.slist.size();i++) {
		 * if(UserServiceImp.slist.get(i).getStudentId()==sid &&
		 * UserServiceImp.slist.get(i).getStudentPassword().equals(soldpswd)) {
		 * UserServiceImp.slist.get(i).setStudentPassword(snewpswd); } }
		 */
		udi.updatePassword(id, oldpswd, newpswd);

		/*
		 * break;
		 * 
		 * case 2:
		 */

		/*
		 * System.out.println("Enter Professor Id"); int pid=sc.nextInt();sc.nextLine();
		 * System.out.println("Enter Old Password"); String poldpswd=sc.nextLine();
		 * System.out.println("Enter new Password"); String pnewpswd=sc.nextLine();
		 * for(int i=0;i<UserServiceImp.plist.size();i++) {
		 * if(UserServiceImp.plist.get(i).getProfessorId()==pid &&
		 * UserServiceImp.plist.get(i).getProfessorPassword().equals(poldpswd)) {
		 * UserServiceImp.plist.get(i).setProfessorPassword(pnewpswd); } } /*break;
		 * 
		 * case 3: System.out.println("Enter Admin Id"); int
		 * aid=sc.nextInt();sc.nextLine(); System.out.println("Enter Old Password");
		 * String aoldpswd=sc.nextLine(); System.out.println("Enter new Password");
		 * String anewpswd=sc.nextLine(); for(int i=0;i<UserServiceImp.alist.size();i++)
		 * { if(UserServiceImp.alist.get(i).getAdminID()==aid &&
		 * UserServiceImp.alist.get(i).getAdminpswd().equals(aoldpswd)) {
		 * UserServiceImp.alist.get(i).setAdminpswd(anewpswd); } } // break;
		 * 
		 * }
		 */
	}
}
