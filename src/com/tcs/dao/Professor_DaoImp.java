/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tcs.utils.DBUtils;

/**
 * @author Administrator
 *
 */
public class Professor_DaoImp implements Professor_DaoInterface {
	/**
     * Professor viewing the list of 
     * students enrolled for the courses
     */
	
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	
    DBUtils cc=new DBUtils();
    Connection conn=cc.connect();
    Scanner sc=new Scanner(System.in);
    

	@Override
	public void viewEnrolledStudent(int cid) {
		// TODO Auto-generated method stub
		int c=0;
		try
		{
			String sql="select * from courseregistration";
			
			stmt=conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		    	 int sid  = rs.getInt("Student_id");
		    	 
		         int cid1 = rs.getInt("course_id1");
		         int cid2  = rs.getInt("course_id2");
		         int cid3  = rs.getInt("course_id3");
		         int cid4 = rs.getInt("course_id4");
				if(cid1==cid)
				{
							System.out.println("Student Id: "+sid);
							c++;
				}
				else if(cid2==cid)
				{
					System.out.println("Student Id: "+sid);
					c++;
				}
				else if(cid3==cid)
				{
					System.out.println("Student Id: "+sid);
					c++;
				}
				else if(cid4==cid)
				{
					System.out.println("Student Id: "+sid);
					c++;
				}
				if(c==0) {
							System.out.println("NO One Registered for Course Id:"+cid);
				}
		      }
		   }
		catch(SQLException se2){
      }// nothing we can do
		
	}

	@Override
	public void addGrades(int sid) {
		// TODO Auto-generated method stub
		try {
			boolean f=false;
		String sql="select * from courseregistration";
        stmt=conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
	         //Retrieve by column name
	    	 int sid1  = rs.getInt("Student_id");
	    	 String sname=rs.getString("Student_name");
	         int cid1 = rs.getInt("course_id1");
	         int cid2  = rs.getInt("course_id2");
	         int cid3  = rs.getInt("course_id3");
	         int cid4 = rs.getInt("course_id4");
	         if(sid1==sid) {
	        	 System.out.println("Student Course Ids Are:");
	        	 System.out.print("Course ID1: " + cid1);
		         System.out.print("Course ID2: " + cid2);
		         System.out.print("Course ID3: " + cid3);
		         System.out.print("Course ID4: " + cid4);
		         System.out.println();
		         System.out.println("Enter Grades For CourseId1 , CourseId2, CourseId3, CourseId4");
		         String cg1=sc.next();
		         String cg2=sc.next();
		         String cg3=sc.next();
		         String cg4=sc.next();
		         
		         String sql2="insert into grade(Student_id,Student_name,course_id,grade) values(?,?,?,?)";
		         
		         stmt1 = conn.prepareStatement(sql2);
		         
		          stmt1.setInt(1,sid1);
		          stmt1.setString(2, sname);
		         stmt1.setInt(3,cid1);
		         stmt1.setString(4, cg1);
		         stmt1.executeUpdate();
		         
		      
		         String sql3="insert into grade values(?,?,?,?)";
		         stmt1 = conn.prepareStatement(sql3);
		         stmt1.setInt(1, sid1);
		          stmt1.setString(2, sname);
		         stmt1.setInt(3,cid2);
		         stmt1.setString(4, cg2);
		         stmt1.executeUpdate();
		         
		         String sql4="insert into grade values(?,?,?,?)";
		         stmt1 = conn.prepareStatement(sql4);
		         stmt1.setInt(1, sid1);
		          stmt1.setString(2, sname);
		         stmt1.setInt(3,cid3);
		         stmt1.setString(4, cg3);
		         stmt1.executeUpdate();
		         
		         String sql5="insert into grade values(?,?,?,?)";
		         stmt1 = conn.prepareStatement(sql5);
		         stmt1.setInt(1, sid1);
		          stmt1.setString(2, sname);
		         stmt1.setInt(3,cid4);
		         stmt1.setString(4, cg4);
		         stmt1.executeUpdate();
		         f=true;
		         
		         System.out.println("Grades Are Added to The Course Ids");
		        }
		 
		}
		if(f==false) {
			System.out.println("Student Id Not Found");
		}
	  }
		catch(SQLException se2){
			//se2.printStackTrace();
			
        }
	      // nothing we can do

}
}
