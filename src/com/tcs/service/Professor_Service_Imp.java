/**
 * 
 */
package com.tcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tcs.bean.*;
import com.tcs.dao.*;
import com.tcs.exception.CourseIdNotFound;
import com.tcs.exception.*;
/**
 * @author Administrator
 *
 */
public class Professor_Service_Imp implements Professor_Service_Interface {

	Scanner sc = new Scanner(System.in);
	static List<Grade> grade = new ArrayList<>();
	static List<Course_Registration> clist = new ArrayList<>();

	Professor_DaoInterface pd = new Professor_DaoImp();

	/*
	 * @method: viewEnrolledStudent Professor can view the students who enrolled for
	 * particular course.
	 * 
	 * @param: Course ID Using the courseID professor can list the students who
	 * enrolled for that course.
	 * 
	 * @param: cclist Search is performed on cclist.
	 */

	@Override
	public void ToViewEnrolledStudent() throws CourseIdNotFound{
		// TODO Auto-generated method stub
		//try {
			System.out.println("Enter course ID");
			int cid = sc.nextInt();
			sc.nextLine();
			int count = 0;
			System.out.println("Enrolled Students list");
			boolean f=false;
			for(Course cr :Student_Service_Imp.clist) {
				if(cr.getCourseId1()==cid ||
				cr.getCourseId2()==cid ||
				 cr.getCourseId3()==cid
				 ||cr.getCourseId4()==cid ) 
				{
					f=true;
					}
			}
			if(f==false)
			{
				throw new CourseIdNotFound(cid);
			}
			
				
	
			
			/***
			 * for(int i=0;i<StudentServiceImp.clist.size();i++) {
			 * if(StudentServiceImp.clist.get(i).getCourseId1()==cid ||
			 * StudentServiceImp.clist.get(i).getCourseId2()==cid ||
			 * StudentServiceImp.clist.get(i).getCourseId3()==cid
			 * ||StudentServiceImp.clist.get(i).getCourseId4()==cid ) { int
			 * sid=StudentServiceImp.clist.get(i).getStudentId(); for(int
			 * j=0;j<UserServiceImp.slist.size();j++) {
			 * if(UserServiceImp.slist.get(i).getStudentId()==sid) {
			 * System.out.println(UserServiceImp.slist.get(i).getStudentName()); count++;
			 * 
			 * } } } } if(count<=0) { System.out.println("No enrolled students for this
			 * course"); }
			 ***/
			pd.viewEnrolledStudent(cid);
//		} catch (Exception e) {
//			System.out.println("Enter correct input");
//		}

	}

	/*
	 * @method: addGrades Professor can add grades to a course of a particular
	 * student.
	 * 
	 * @param: student id,course id,grade
	 */

	@Override
	public void ToAddGrades() {
		// TODO Auto-generated method stub
		try {
			/***
			 * Grade gr=new Grade(); boolean sfound=false;
			 ***/
			System.out.println("Enter Student Id");
			int sid = sc.nextInt();
			sc.nextLine();
			/***
			 * for(int i=0;i<StudentServiceImp.clist.size();i++) {
			 * if(StudentServiceImp.clist.get(i).getStudentId()==sid) { sfound=true; } }
			 * if(sfound==true) { gr.setStuId(sid); System.out.println("Enter Student
			 * Name"); gr.setStuName(sc.nextLine()); System.out.println("Enter Course ID");
			 * gr.setCourseID(sc.nextInt());sc.nextLine(); System.out.println("Enter
			 * Grade"); gr.setGrade(sc.nextLine()); grade.add(gr); System.out.println("Grade
			 * added"); } else { System.out.println("Student ID not found"); }
			 ***/
			pd.addGrades(sid);
		} catch (Exception e) {
			System.out.println("Enter correct input");
		}
	}
}
