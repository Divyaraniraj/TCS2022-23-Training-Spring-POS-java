/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.tcs.utils.DBUtils;
/**
 * @author Administrator
 *
 */
public class Admin_DaoImp implements Admin_DaoInterface {
	PreparedStatement stmt = null;
    DBUtils cc=new DBUtils();
    Connection conn=cc.connect();
    Scanner sc=new Scanner(System.in);
    /*
	  * @method: ToApproveStudentRegistration
	  * Admin has to approve the student registration by using student ID
	  * 
	  * @param: sid  Student ID
	  * @param: status Admin set the status value to 1 to approve the student.
	  */
	
	@Override
	public void approveRegistration()
	{
		
		try {
			String sql="select * from registration where status=0";
		    stmt=conn.prepareStatement(sql);

		    ResultSet rs = stmt.executeQuery(sql);


		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         if(rs.getInt("status")==0)
		         {
		        	 int sid  = rs.getInt("Student_id");
			         String sname = rs.getString("Student_name");
			         String sdept = rs.getString("Student_department");
			         String spswd=rs.getString("Student_password");
			         
		        	 //System.out.println("This student needs to be approved");
		        	 System.out.println(rs.getInt("Student_Id") +" " +rs.getString("Student_name"));
		        	 System.out.println("Approve Registration");
		        	 int approve=sc.nextInt(); 
		        	 if(approve==1)
		        		 {
		        		 String sql2="update registration set status=1 where Student_Id= '"+rs.getInt("Student_Id")+"'";
		        		 stmt=conn.prepareStatement(sql2);
		        		 stmt.executeUpdate(sql2);
		        		 System.out.println("Student Approved By You.");
		        		 
		        		 
		        		 //For student table
		        		 String sql1="insert into student values(?,?,?,?)";
		        			try {
		        			   	 stmt = conn.prepareStatement(sql1);
		        			   	 stmt.setInt(1,sid);
		        			   	 stmt.setString(2, sname);
		        			   	 stmt.setString(3,sdept);
		        			   	 stmt.setString(4,spswd);
		        			   	 stmt.executeUpdate();
		        			   	 
		        			        }
		        				     catch(SQLException se2){
		        				      }// nothing we can do
		        			
		        			
		        			
		        			
		        			
		        			//For login table
		        			 String sql3="insert into login values(?,?)";
			        			try {
			        			   	 stmt = conn.prepareStatement(sql3);
			        			   	 stmt.setString(1,sname);
			        			   	 stmt.setString(2, spswd);
			        			//   	 stmt.setInt(3, 3);
			        			 //  	 stmt.setInt(4, sid);
			        			   	 stmt.executeUpdate();
			        			   	 
			        			        }
			        				     catch(SQLException se2){
			        				    	 se2.printStackTrace();
			        				      }// nothing we can do
		        				
		        		 }
		         }
		         
				
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
		
		
		
	}
	
	@Override
	public void addCourse(int course_Id,String course_name,String professor_name,String Department,String prerequies)
	{
		
   	 
	   	 try {
	 		String sql="insert into catalogue values(?,?,?,?,?)";

	   	 
	   	 stmt = conn.prepareStatement(sql);
	   	 stmt.setInt(1,course_Id);
	   	 stmt.setString(2, course_name);
	   	 stmt.setString(3,professor_name);
	   	 stmt.setString(4,Department);
	   	 stmt.setString(5,prerequies);
	   	 stmt.executeUpdate();
	   	 
	        }
		     catch(SQLException se2){
		      }// nothing we can do
		
		
	}
	
	
	@Override
	public void addProfessor(int pid,String pname,String ppswd,String dept)
	{
		
	   	 
	   	 try {
	 		String sql="insert into professor values(?,?,?,?)";

	   	 stmt = conn.prepareStatement(sql);
	   	 stmt.setInt(1,pid);
	   	 stmt.setString(2, pname);
	   	 stmt.setString(3,ppswd);
	   	 stmt.setString(4,dept);
	   	 stmt.executeUpdate();
	   	 
	        }
		     catch(SQLException se2){
		      }// nothing we can do
		
	   	String sql4="insert into login values(?,?,?)";
		try {
		   	 stmt = conn.prepareStatement(sql4);
		   	 stmt.setString(1,pname);
		   	 stmt.setString(2, ppswd);
		   	 stmt.setInt(3, 2);
		   	 stmt.executeUpdate();
		   	 
		        }
			     catch(SQLException se2){
			      }// nothing we can do
		
	}

	@Override
	public void listProfessor()
	{

		try
		{
			String sql="select * from professor";
			ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int pid  = rs.getInt("Professor_id");
		         String pname = rs.getString("Professor_name");
		         String pdept = rs.getString("Department");

		         //Display values
		         System.out.println("Professor Details are:");
		         System.out.print("Professor ID: " + pid);
		         System.out.print(", Professor Name: " + pname);
		         System.out.println(", Department: " + pdept);
		}

		
		
	  }
		catch(SQLException se2){
      }// nothing we can do
		
	}
	
	
	@Override
	public void listCourses()
	{
		try
		{
			String sql="select * from catalogue";
			ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int cid  = rs.getInt("course_Id");
		         String cname = rs.getString("course_name");
		         String pname = rs.getString("professor_name");
		         String pdept = rs.getString("Department");
		         String pre = rs.getString("prerequies");

		         //Display values
		        
		         System.out.print("Course ID: " + cid);
		         System.out.print(", Course Name: " + cname);
		         System.out.print(", Professor Name: " + pname);
		         System.out.print(", Professor Department: " + pdept);
		         System.out.println(", Prerequisites for this course Id is: " + pre);
		}

		
		
	  }
		catch(SQLException se2){
      }// nothing we can do
		
	}
	

	
	
	@Override
	public void removeCourse(int inp)
	{
	
		
		
		try {
			String sql="select course_Id,course_name from catalogue";
		    stmt=conn.prepareStatement(sql);

		    ResultSet rs = stmt.executeQuery(sql);


		      //STEP 5: Extract data from result set
		      while(rs.next()){
		    	 
		         if(rs.getInt("course_Id")==inp)
		         {
		        	 
		        	// System.out.println(rs.getInt("studentId") +" " +rs.getString("studentName"));
		        	
		        		 String sql2="delete from  catalogue where course_Id= '"+rs.getInt("course_Id")+"'";
		        		 stmt=conn.prepareStatement(sql2);
		        		 stmt.executeUpdate(sql2);
		        		 System.out.println(rs.getInt("course_Id") +" " +rs.getString("course_name")+" is  Removed Successfully");
		        		 
		         }
		         
		         
				
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	public void gradeCard(int sid,String sname)
	{
		boolean f1=false;
		System.out.println("Student Id:"+sid+"   "+"StudentName:"+"  "+sname);
		try
		{
			//int a=0,b=0,c=0,d=0,f=0;
			String sql="select * from grade";
			stmt=conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
	         int a=0,b=0,c=0,d=0,f=0;

			System.out.println("Course Id:                         Grade:");
		      while(rs.next()){
		         //Retrieve by column name
		         int sid1  = rs.getInt("Student_id");
		         String sname1 = rs.getString("Student_name");
		         int cid = rs.getInt("course_id");
		         String g = rs.getString("grade");
		         
		         if(sid1==sid)
		         {
		        	 f1=true;
		        	 System.out.println(cid+"                        "+g);
		         }
		        
		         
		         if(g.equals("A"))
		         {

		        	 a=a+1;
		        	 
		         }
		         else if(g.equals("B"))
		         {
		        	 b=b+1;
		        
		        	 
		         }
		         else if(g.equals("c"))
		         {
		        	 c=c+1;
		        	
		        	 
		         }
		         else if(g.equals("D"))
		         {
		        	 d=d+1;
		        	
		        	 
		         }
		         else
		         {
		        	 f=f+1;
		         }
		        
		      }
		      
		      if(a>3)
	        	 {
	        		 String sql4="insert into grade_card values(?,?,?)";
	        		 stmt=conn.prepareStatement(sql4);
	        		 stmt.setInt(1, sid);
	        		 stmt.setString(2, sname);
	        		 stmt.setString(3,"Distinction");
	        		 stmt.executeUpdate();
	        		 
	        		 
	        	 }
		      
		      else if(b>3)
	        	 {
	        		 
	        		 String sql4="insert into grade_card values(?,?,?)";
	        		 stmt=conn.prepareStatement(sql4);
	        		 stmt.setInt(1, sid);
	        		 stmt.setString(2, sname);
	        		 stmt.setString(3,"Passed With 70%");
	        		 stmt.executeUpdate();
	        		 
	        		 
	        	 }
		      
		      else  if(c>3)
	        	 {
	        		 
	        		 String sql4="insert into grade_card values(?,?,?)";
	        		 stmt=conn.prepareStatement(sql4);
	        		 stmt.setInt(1, sid);
	        		 stmt.setString(2, sname);
	        		 stmt.setString(3,"Passed with 60%");
	        		 stmt.executeUpdate();
	        		 
	        		 
	        	 }
		      else  if(d>3)
	        	 {
	        		 
	        		 String sql4="insert into grade_card values(?,?,?)";
	        		 stmt=conn.prepareStatement(sql4);
	        		 stmt.setInt(1, sid);
	        		 stmt.setString(2, sname);
	        		 stmt.setString(3,"Passed with 55%");
	        		 stmt.executeUpdate();
	        		 
	        		 
	        	 }
		      else if(f==1)
		    	  {
		    	  String sql4="insert into grade_card values(?,?,?)";
		    	  
	        	 stmt=conn.prepareStatement(sql4);
	        	 stmt.setInt(1, sid);
	        	 stmt.setString(2, sname);
	        	 stmt.setString(3,"Failed");
	        	 stmt.executeUpdate();
		    	  }
		      
		      
		      
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Student ID not found or card already generated ");
		}
		         
		
	}


	
	

		
	}
	
	

	
