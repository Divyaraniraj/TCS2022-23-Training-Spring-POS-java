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
public class Student_DaoImp implements Student_DaoInterface {
	PreparedStatement stmt = null;
    DBUtils cc=new DBUtils();
    Connection conn=cc.connect();
    Scanner sc=new Scanner(System.in);
    
    
    
	@Override
	public void courseRegister(int sid, int cid1, int cid2, int cid3, int cid4) {
		/**
		 * Student course registration
		 */
		// TODO Auto-generated method stub
		
		String sql="select *  from courseregistration";
		ResultSet rs;
//		String sql2="select *  from catalogue";
//		ResultSet rs1;
		try {
			stmt=conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
		        //Retrieve by column name
				int stuid=rs.getInt("Student_id");
				String sname=rs.getString("Student_name");
				int scid1 = rs.getInt("course_id1");
				int scid2= rs.getInt("course_id2");
				int scid3 = rs.getInt("course_id3");
				int scid4 = rs.getInt("course_id4");
				if(stuid==sid)
		        {
		        	System.out.println("You are already registered");
		        	break;
		        }
				else
				{
				String sql1="insert into courseregistration values(?,?,?,?,?,?)";
    			
			   	 stmt = conn.prepareStatement(sql1);
			   	 stmt.setInt(1,sid);
			   	 stmt.setString(2, sname);
			   	 stmt.setInt(3, cid1);
			   	 stmt.setInt(4,cid2);
			   	 stmt.setInt(5,cid3);
			   	 stmt.setInt(6,cid4);
			   	 stmt.executeUpdate();
			   	 System.out.println("Courses registerd successfully");
			   	 break;
			}
			}
			

	    
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("You are already registered");
	}

}
	
	public void addCourse(int sid) {
		/**
 		 * Students adding courses
 		 */
	
		String sql="select *  from courseregistration";
		ResultSet rs;
		boolean g=false;
		try {
			stmt=conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
		        //Retrieve by column name
				int stuid=rs.getInt("Student_id");
				String sname=rs.getString("Student_name");
				int scid1 = rs.getInt("course_id1");
				int scid2= rs.getInt("course_id2");
				int scid3 = rs.getInt("course_id3");
				int scid4 = rs.getInt("course_id4");
				if(stuid==sid) {
				if(scid1==0)
				{
					System.out.println("Enter course Id to add");
					int s=sc.nextInt();
					String sql1="update courseregistration as c set c.course_id1='"+s+"' where Student_id='"+sid+"'";
					stmt = conn.prepareStatement(sql1);
					stmt.executeUpdate();
					g=true;
					System.out.println("Your Course Got Added Successfully!");
				}
				else if(scid2==0)
				{
					System.out.println("Enter course Id to add");
					int s=sc.nextInt();
					String sql2="update courseregistration as c set c.course_id2='"+s+"' where Student_id='"+sid+"'";
					stmt = conn.prepareStatement(sql2);
					stmt.executeUpdate();
					g=true;
					System.out.println("Your Course Got Added Successfully!");
				}
				else if(scid3==0)
				{
					System.out.println("Enter course Id to add");
					int s=sc.nextInt();
					String sql3="update courseregistration as c set c.course_id3='"+s+"' where Student_id='"+sid+"'";
					stmt = conn.prepareStatement(sql3);
					stmt.executeUpdate();
					g=true;
					System.out.println("Your Course Got Added Successfully!");
				}
				else if(scid4==0)
				{
					System.out.println("Enter course Id to add");
					int s=sc.nextInt();
					String sql4="update courseregistration as c set c.course_id4='"+s+"' where student_id='"+sid+"'";
					stmt = conn.prepareStatement(sql4);
					stmt.executeUpdate();
					g=true;
					System.out.println("Your Course Got Added Successfully!");
					
				}
				else {
					System.out.println("You Had Already registered To The 4 Courses !,Drop Any Course ");
				}
			}
              }
			if(g==false) {
				System.out.println("Student Id Not Found");
			}
		}
		catch (SQLException e) {
          		// TODO Auto-generated catch block
          		e.printStackTrace();
          		System.out.println("You are already registered");
		
	}
}
	public void dropCourse(int sid) {
		String sql="select *  from courseregistration";
		ResultSet rs;
		try {
			stmt=conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("Enter course Id to drop:");
			int s=sc.nextInt();
			while(rs.next()){
		        //Retrieve by column name
				int stuid=rs.getInt("Student_id");
				String sname=rs.getString("Student_name");
				int scid1 = rs.getInt("course_id1");
				int scid2= rs.getInt("course_id2");
				int scid3 = rs.getInt("course_id3");
				int scid4 = rs.getInt("course_id4");
				
				if(stuid==sid) {
					if(scid1==s)
					{
					String sql1="update courseregistration as c set c.course_id1='"+0+"' where Student_id='"+sid+"'";
						stmt = conn.prepareStatement(sql1);
						stmt.executeUpdate();
						System.out.println("Your Course Got Removed Successfully!");
					}
					else if(scid2==s)
					{
					String sql1="update courseregistration as c set c.course_id2='"+0+"' where Student_id='"+sid+"'";
						stmt = conn.prepareStatement(sql1);
						stmt.executeUpdate();
						System.out.println("Your Course Got Removed Successfully!");
					}
					else if(scid3==s)
						{
						String sql1="update courseregistration as c set c.course_id3='"+0+"' where Student_id='"+sid+"'";
							stmt = conn.prepareStatement(sql1);
							stmt.executeUpdate();
							System.out.println("Your Course Got Removed Successfully!");
						}
					else if(scid4==s)
					{
					String sql1="update courseregistration as c set c.course_id4='"+0+"' where Student_id='"+sid+"'";
						stmt = conn.prepareStatement(sql1);
						stmt.executeUpdate();
						System.out.println("Your Course Got Removed Successfully!");
					}
					else {
						System.out.println("No Course Id Found !");
					}
					
				}
					
				}
	}catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		System.out.println("You Had Already Removed That CourseId");
	}

}
	@Override
	public void viewCourses(int g)
	{
		try
		{
			String sql="select * from courseregistration";
			
			stmt=conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		    	 int sid  = rs.getInt("Student_id");
		    	 String sname=rs.getString("Student_name");
		         int cid1 = rs.getInt("course_id1");
		         int cid2  = rs.getInt("course_id2");
		         int cid3  = rs.getInt("course_id3");
		         int cid4 = rs.getInt("course_id4");
		         

		         //Display values
		         if(sid==g) {
		        System.out.println("Student Id:"+sid);
		        System.out.println("Student Name:"+sname);
		        System.out.print("Course ID1: " + cid1);
		         System.out.print("Course ID2: " + cid2);
		         System.out.print("Course ID3: " + cid3);
		         System.out.print("Course ID4: " + cid4);
		         System.out.println();
		      }
		   }
		}
		catch(SQLException se2){
      }// nothing we can do
		
	}
	public void viewReportCard(int sid) {
		boolean f1=false;
		
		try
		{
			String sql="select * from grade";
			stmt=conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Course Id:                Grade:");
		      while(rs.next()){
		         //Retrieve by column name
		         int sid1  = rs.getInt("Student_id");
		         String sname1 = rs.getString("Student_name");
		         int cid = rs.getInt("course_id");
		         String g = rs.getString("grade");
		       
		         if(sid1==sid) {
		        	 f1=true;
		        	 System.out.println(cid+"                      "+g);
		         }
		      }
		      if(f1==false) {
		    	  System.out.println("Student Id Not Found");
		      }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		  




		public void payment(int sid) {
			
			int count=0;
			
			try {
			String sql1="select * from courseregistration where student_id='"+sid+"'";
			stmt=conn.prepareStatement(sql1);
			ResultSet rs = stmt.executeQuery(sql1);
		      while(rs.next()){
		         //Retrieve by column name
		         int sid1  = rs.getInt("Student_id");
		         System.out.println(sid1);
		        // String sname1 = rs.getString("Student_name");
		         int cid1 = rs.getInt("course_id1");
		         int cid2 = rs.getInt("course_id2");
		         int cid3 = rs.getInt("course_id3");
		         int cid4 = rs.getInt("course_id4");

		         
			if(sid1==sid)
			{
				if(cid1!=0 && cid2!=0 && cid3!=0 && cid4!=0)
				{
					System.out.println("you have to pay 2000");
					//System.out.println("Enter payment Mode");
				
					System.out.println("1.online mode");
					System.out.println("2.offline mode");
					//System.out.println("Enter payment Mode");
					System.out.println("enter your choice");
					int ch=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter mode name:");
					String mode=sc.nextLine();
					switch(ch)
					{
					case 1: ;
					        System.out.println("Enter card number");
					        int cardnum=sc.nextInt();sc.nextLine();
					        System.out.println("Enter cvv");
					        int cvv=sc.nextInt();sc.nextLine();
					        String sql2="insert into payment values(?,?,?,?,?)";
					        stmt=conn.prepareStatement(sql2);
					        stmt.setInt(1, sid1);
					  //      stmt.setString(2,sname1);
					        stmt.setInt(2, 2000);
					        stmt.setString(3, mode);
					        stmt.setInt(4, cardnum);
					     //   stmt.setInt(6,0);
					        stmt.executeUpdate();
					        
					        System.out.println("Payment Successfull");
					        break;
					case 2: 
					        System.out.println("enter your phone number");
					        String phonenum=sc.nextLine();
					        String sql21="insert into payment values(?,?,?,?,?)";
					        stmt=conn.prepareStatement(sql21);
					        stmt.setInt(1, sid1);
					  //      stmt.setString(2,sname1);
					        stmt.setInt(2, 2000);
					        stmt.setString(3, mode);
					        stmt.setString(4, phonenum);
					     //   stmt.setInt(6,0);
					        stmt.executeUpdate();
					        break;
					}
					
				}
				else
				{
					
					System.out.println("You did not registered four courses!");
					
				}
			}
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			}
		
	         
	
}
