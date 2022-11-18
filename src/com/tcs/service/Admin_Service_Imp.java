/**
 * 
 */
package com.tcs.service;

import com.tcs.bean.Course;
import com.tcs.bean.*;

import com.tcs.dao.*;
import com.tcs.exception.StudentIdNotFound;

import java.util.*;
import com.tcs.service.*;


/**
 * @author Administrator
 *
 */
public class Admin_Service_Imp implements Admin_Service_Interface{
	User_Service_Imp usimp=new User_Service_Imp();
	static List<Catalougue> cclist=new ArrayList<Catalougue>();
	Admin_DaoInterface ad = new Admin_DaoImp();
	
  static List<Grade_Card> gcard=new ArrayList<Grade_Card>();
	 Scanner sc=new Scanner(System.in);
	 
	 
	 /*
	  * @method: ToApproveStudentRegistration
	  * Admin has to approve the student registration by using student ID
	  * 
	  * @param: sid  Student ID
	  * @param: status Admin set the status value to 1 to approve the student.
	  *
	  */
	 
	@Override
	public void ToApproveStudentRegistration() {
		// TODO Auto-generated method stub
		/*try {
		boolean found=false;
        if(UserServiceImp.asr.size()>0)
        {
        	UserServiceImp.asr.forEach(System.out::println);
        	
        	System.out.println("Enter Student id");
        	int sid=sc.nextInt();sc.nextLine();
        	for(int i=0;i<UserServiceImp.slist.size();i++)
        	{
        		if(UserServiceImp.slist.get(i).getStudentId()==sid)
        		{
        		UserServiceImp.slist.get(i).setStatus(1);
        		System.out.println("Student Approved");
        		found=true;
        		}
        	}
        	if(found==true)
        	{
        	for(int i=0;i<UserServiceImp.asr.size();i++)
        	{
        		if(UserServiceImp.asr.get(i).getStudentId()==sid)
        		{
        			UserServiceImp.asr.remove(i);
        		}
        	}
        	}
        }
        else
        {
        	System.out.println("No Registrations to approve");
        }
		}
        catch(Exception e)
		{
			System.out.println("Enter correct input");
		}*/
		
        ad.approveRegistration();
		
	}

	 /*
	  * @method: addCourse
	  * Admin can add course to course catalogue
	  * 
	  * @param: course id,course name,professor name,department,prerequisites
	  */
	
	@Override
	public void ToAddCourse() {
		// TODO Auto-generated method stub
		try {
        //Catalogue course=new Catalogue();
		
		System.out.println("Enter Course ID");
	    int cid=sc.nextInt();
	    sc.nextLine();
	    System.out.println("Enter Course Name");
	    String cname=sc.nextLine();
	    System.out.println("Enter Professor Name");
	    String pname=sc.nextLine();
	    System.out.println("Enter Department");
	    String dept=sc.nextLine();
	    System.out.println("Enter Prerequisites");
	    String pre=sc.nextLine();
	  	//cclist.add(course);
	    ad.addCourse(cid,cname,pname,dept,pre);
		}
		catch(Exception e)
		{
			System.out.println("Enter correct input");
		}
		
	}
	
	
	 /*
	  * @method: removeCourse
	  * Admin can remove course from course catalogue by using the course ID.
	  * 
	  * @param: Course ID The course Id is used to search whether the course exists or not.If exists then remove the course
	  *          else print course id not found.
	  */

	@Override
	public void ToRemoveCourse() throws StudentIdNotFound{
		// TODO Auto-generated method stub
		//try {
	//	boolean f=false;
		System.out.println("Enter Course ID");
		int inp=sc.nextInt();
		ad.removeCourse(inp);
		
		
		boolean found=false;

		for(int i=0;i<cclist.size();i++)
		{
			if(cclist.get(i).getCourse_Id()==inp)
			{
				found=true;
				cclist.remove(i);
				System.out.println("Course Removed");

			}
			
		}
       if(found==false)
       {
    	   //System.out.println("Course ID not found");
    	   throw new StudentIdNotFound(inp);
       }
		}
//		catch(Exception e)
//		{
//			System.out.println("Enter correct input");
//		}
//		
	

	
	
	
	 /*
	  * @method: generateReportCard
	  * Admin can generate report card of a particular student using student Id.
	  * 
	  * @param: Student ID The student Id is used to search whether the student exists or not.
	  *         If exists the report card is generated and printed else prints student not found.
	  */
	
	@Override
	public void ToGenerateReportCard() {
		// TODO Auto-generated method stub
		try
		{
		//int count=0;
		System.out.println("Enter Student Id");
		int sid=sc.nextInt();sc.nextLine();
		System.out.println("Enter Student Name");
		String sname=sc.nextLine();
	
		/***int gA=0,gB=0,gC=0,gD=0,gF=0;
		int courseId;
		String stuGrade;
		String result;
		System.out.println("Report Card");
		System.out.println("Course ID         Grade");

		for(int i=0;i< ProfessorServiceImp.grade.size();i++)
		{
			if(ProfessorServiceImp.grade.get(i).getStuId()==sid)
			{    count++;
			      courseId=ProfessorServiceImp.grade.get(i).getCourseID();
			      stuGrade=ProfessorServiceImp.grade.get(i).getGrade();
			      if(stuGrade.equalsIgnoreCase("A"))
					{
						gA=gA+1;
					}
			      else if(stuGrade.equalsIgnoreCase("B"))
			      {
			    	  gB=gB+1;
			      }
			      else if(stuGrade.equalsIgnoreCase("C"))
			      {
			    	 gC=gC+1;
			      }
			      else if(stuGrade.equalsIgnoreCase("D"))
			      {
			    	  gD=gD+1;
			      }
			      else
			      {
			    	  gF=gF+1;
			      }
			      
				System.out.println(courseId+"                   "+stuGrade);
			}
		}
		GradeCard gc=new GradeCard();
		System.out.println("---------------------------------------");
		if(gF>=1)
		{   result="Failed";
			gc.setStudentId(sid);
			gc.setStudentName(sname);
			gc.setResult(result);
			gcard.add(gc);
			System.out.println("Result    *****  Failed  *****");
		}
		else if(gA>3)
		{
			result="Distinction with 80%";
			gc.setStudentId(sid);
			gc.setStudentName(sname);
			gc.setResult(result);
			gcard.add(gc);
			System.out.println("Result    ***** Distinction with 80% *****");
		}
		else if(gB>3)
		{
			result="Pass with 70%";
			gc.setStudentId(sid);
			gc.setStudentName(sname);
			gc.setResult(result);
			gcard.add(gc);
			System.out.println("Result    ***** Pass with 70% *****");
		}
		else if(gC>3)
		{
			result="Pass with 60%";
			gc.setStudentId(sid);
			gc.setStudentName(sname);
			gc.setResult(result);
			gcard.add(gc);
			System.out.println("Result    ***** Pass with 60% *****");
		}
		else
		{
			result="Pass with 55%";
			gc.setStudentId(sid);
			gc.setStudentName(sname);
			gc.setResult(result);
			gcard.add(gc);
			System.out.println("Result    ***** Pass with 55% *****");

		}
		
		
		if(count<=0)
		{
			System.out.println("Student ID not found");
		}***/
		ad.gradeCard(sid,sname);
		}
		catch(Exception e)
		{
			//System.out.println("Enter correct input");
			e.printStackTrace();
		}
	}

	
	

	 /*
	  * @method: addProfessor
	  * Admin can add professor details
	  * 
	  * @param: Professor ID,professor Name,Department,Professor Password(default password- which can be updated by professor).
	  */
	
	
	@Override
	public void ToAddProfessor() {
		// TODO Auto-generated method stub
		try {
		//Professor pro=new Professor();
		
		System.out.println("Enter Professor Id");
	    int pid=sc.nextInt();
	    sc.nextLine();
	    System.out.println("Enter Professor Name");
	    String pname=sc.nextLine();
	    System.out.println("Enter Department");
	    String dept=sc.nextLine();
	    
	    System.out.println("Enter Professor Password");
	    String ppswd=sc.nextLine();
	    //UserServiceImp.plist.add(pro);
	    ad.addProfessor(pid,pname,ppswd,dept);
		}
		catch(Exception e)
		{
			System.out.println("Enter correct input");
		}
	}
 
	 

	 /*
	  * @method: listProfessor
	  * This method prints all the professors details.
	  * 
	  * @param: plist plist is the professor list.
	  */
	  
	@Override
	public void ToListProfessor() {
		// TODO Auto-generated method stub
		
		System.out.println("----Professors List-----");
		
		ad.listProfessor();
		
		//UserServiceImp.plist.forEach(System.out::println);
		
	}
	
	
	 /*
	  * @method: listCourses
	  * This method prints all the student enrolled courses details.
	  * 
	  * @param: cclist cclist is the list of students enrolled for courses.
	  */
	
	public void ToListCourses() {
		// TODO Auto-generated method stub
		
		System.out.println("----Courses List-----");
		ad.listCourses();

		//cclist.forEach(System.out::println);
		
	}

	
}
