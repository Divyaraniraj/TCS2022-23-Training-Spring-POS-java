/**
 * 
 */
package com.tcs.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.utils.DBUtils;
/**
 * @author Administrator
 *
 */
public class User_DaoImp implements User_DaoInterface {
	PreparedStatement stmt = null;
    DBUtils cc=new DBUtils();
    Connection conn=cc.connect();
    /**
     * Students enters their details for registration
     * The registration will be approved by admination
     */
    
	@Override
	public void studentRegistration(int sid, String sname,  String sdept,String spassword) {
		// TODO Auto-generated method stub
		String sql="insert into registration values(?,?,?,?,?)";
		//String sql1="insert into student values(?,?,?,?,?)";
   	 
	   	 try {
	   	 stmt = conn.prepareStatement(sql);
	   	 stmt.setInt(1,sid);
	   	 stmt.setString(2, sname);
	   	 stmt.setString(3,sdept);
	   	 stmt.setString(4,spassword);
	   	 stmt.setInt(5, 0);
	   	 stmt.executeUpdate();
	     System.out.println("Registration request sent to admin for approval! Login after sometime.");

	   	 
	        }
		     catch(SQLException se2){
		    	 System.out.println("UserID already exists");
		      }// nothing we can do
			
	   /*	try {
		   	 stmt = conn.prepareStatement(sql1);
		   	 stmt.setInt(1,sid);
		   	 stmt.setString(2, sname);
		   	 stmt.setString(3,sdept);
		   	 stmt.setString(4,spassword);
		   	 stmt.setInt(5, 0);
		   	 stmt.executeUpdate();
		   	 
		        }
			     catch(SQLException se2){
			      }// nothing we can do*/
			
	   	 
	   	 
	   	 
		}

	@Override
	public boolean adminLogin(String inp1, String inp2) {
		// TODO Auto-generated method stub
		
		ResultSet rs;
		try {
			String s1="select Admin_name,Admin_password from admin";
			stmt=conn.prepareStatement(s1);
			rs = stmt.executeQuery();
			while(rs.next()){
		        //Retrieve by column name
		        String adminName = rs.getString("Admin_name");
		        String adminpswd = rs.getString("Admin_password");
		        if(adminName.equals(inp1)&& adminpswd.equals(inp2)) {
		        	return true;
		        }
		        
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		}
	
	
	
	@Override
	public boolean studentLogin(String inp1, String inp2) {
		// TODO Auto-generated method stub
		
		ResultSet rs;
		try {
			String s1="select User_name,password from login";
			stmt=conn.prepareStatement(s1);
			rs = stmt.executeQuery();
			while(rs.next()){
		        //Retrieve by column name
		        String sname = rs.getString("User_name");
		        String spswd = rs.getString("password");
		        if(sname.equals(inp1)&& spswd.equals(inp2)) {
		        	return true;
		        }
		        
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		}
	
	
	
	@Override
	public boolean professorLogin(String inp1, String inp2) {
		// TODO Auto-generated method stub
		
		ResultSet rs;
		try {
			String s1="select User_name,password from login";
			stmt=conn.prepareStatement(s1);
			rs = stmt.executeQuery();
			while(rs.next()){
		        //Retrieve by column name
		        String sname = rs.getString("User_name");
		        String spswd = rs.getString("password");
		        if(sname.equals(inp1)&& spswd.equals(inp2)) {
		        	return true;
		        }
		        
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		}
	
	
	@Override
	public void updatePassword(int id,String oldpswd, String newpswd) {
		
		//int userid=id;
		//String sql2="select * from login,professor";
		//String sql3="select * from login,Admin";
		/**
 		 * Password updation 
       */
		
		try
		{
			String sql1="select  login_id,role_id,password from login";

			stmt=conn.prepareStatement(sql1);

		    ResultSet rs = stmt.executeQuery(sql1);
		    while(rs.next()){
		     
		        	 int roleid  = rs.getInt("role_id");
		        	 int loginId=rs.getInt("login_id");
		        	 String old1=rs.getString("password");
		        	 
			     	 if(loginId==id && old1.equals(oldpswd) && roleid==1)
					{   
					 String sql7="update login as l ,admin as a set l.password='"+newpswd+"', a.Admin_Password='"+newpswd+"' where login_id='"+loginId+"' AND role_id='"+roleid+"'";
					 stmt=conn.prepareStatement(sql7);
					 stmt.executeUpdate(sql7);
					}
					else if(loginId==id && old1.equals(oldpswd) && roleid==2)
					{
						String sql8="update login as l ,professor as p set l.password='"+newpswd+"', p.Professor_password='"+newpswd+"' where login_id='"+loginId+"' AND role_id='"+roleid+"'";
						 stmt=conn.prepareStatement(sql8);
						 stmt.executeUpdate(sql8);
					}
					else if(loginId==id && old1.equals(oldpswd) && roleid==3)
					{
						String sql9="update login as l ,student as s set l.password='"+newpswd+"', s.Password='"+newpswd+"' where login_id='"+loginId+"' AND roleid='"+roleid+"'";
						 stmt=conn.prepareStatement(sql9);
						 stmt.executeUpdate(sql9);
					}
		
		
		}
		
	
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
	
