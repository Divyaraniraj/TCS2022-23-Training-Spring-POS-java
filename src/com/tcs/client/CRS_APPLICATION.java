/**
 * 
 */
package com.tcs.client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import com.tcs.service.*;
import com.tcs.bean.*;
import com.tcs.exception.CourseIdNotFound;
import com.tcs.exception.StudentIdNotFound;

/**
 * @author Administrator
 *
 */
public class CRS_APPLICATION {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		User_Service_Interface usi = new User_Service_Imp();
		Admin_Service_Interface asi = new Admin_Service_Imp();
		Professor_Service_Interface psi = new Professor_Service_Imp();
		Student_Service_Interface ssi = new Student_Service_Imp();

		int ch1;

		do {
			LocalDate localDate = LocalDate.now();
			LocalTime localTime = LocalTime.now();
			LocalDateTime localDateTime = LocalDateTime.now();

			/*
			 * Main menu for login,student registration,update password
			 */

			System.out.println("\nWelcome to the CRS Application" + " " + localDate + " " + localTime);
			System.out.println("-----Main Menu-----");
			System.out.println("\n1.Login");
			System.out.println("2.Student Registration");
			System.out.println("3.Update Password");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			ch1 = sc.nextInt();
			sc.nextLine();

			switch (ch1) {
			case 1:
				System.out.println("Enter role to login");
				String role = sc.nextLine();
				if (role.equals("Admin")) {
					boolean res1 = usi.AdminLogin();
					int ch5;
					if (res1 == true) {
						do {
							System.out.println("-----Admin Menu-----");
							System.out.println("1.Add Professor");
							System.out.println("2.Add Course");
							System.out.println("3.Remove Course");
							System.out.println("4.Approve Student Registration");
							System.out.println("5.Generate Report Card");
							System.out.println("6.List Professors");
							System.out.println("7.List Courses");
							System.out.println("8.Exit");
							System.out.println("Enter your choice");
							ch5 = sc.nextInt();
							sc.nextLine();
							switch (ch5) {
							case 1:
								asi.ToAddProfessor();
								System.out.println("Professor Added");
								break;
							case 2:
								asi.ToAddCourse();
								System.out.println("Course Added");
								break;
							case 3:
								try {
								asi.ToRemoveCourse();
								}catch (StudentIdNotFound ex){
									System.out.println("invalid student id :"+ex.getS_Id());
								}
								break;
							case 4:
								asi.ToApproveStudentRegistration();
								break;
							case 5:
								asi.ToGenerateReportCard();
								break;
							case 6:
								asi.ToListProfessor();
								break;
							case 7:
								asi.ToListCourses();
								break;
							case 8:
								System.out.println("Exit");
								break;
							default:
								System.out.println("Wrong option selected! Choose options from 1 to 8");
								break;

							}
						} while (ch5 != 8);
					} else {
						System.out.println("Login Failed! Enter Correct Credentials");
					}

				} else if (role.equals("Professor")) {
					boolean res2 = usi.ProfessorLogin();
					int ch4;
					if (res2 == true) {
						do {
							System.out.println("-----Professor Menu-----");
							System.out.println("1.Add Grades");
							System.out.println("2.View Enrolled Students");
							System.out.println("3.Exit");
							System.out.println("Enter your choice");
							ch4 = sc.nextInt();
							sc.nextLine();
							switch (ch4) {
							case 1:
								psi.ToAddGrades();
								break;
							case 2:
								try {
								psi.ToViewEnrolledStudent() ;
								}
								catch(CourseIdNotFound ex)
								{
									System.out.println("Invalid Id: "+ex.getMessage());
								}
								break;
							case 3:
								System.out.println("Exit");
								break;
							default:
								System.out.println("Wrong option selected! Choose options from 1 to 3");
								break;

							}
						} while (ch4 != 3);
					}

					else {
						System.out.println("Login Failed! Enter Correct Credentials");
					}

				} else if (role.equals("Student")) {
					int ch3;
					boolean res3 = usi.StudentLogin();
					if (res3 == true) {
						do {

							System.out.println("-----Student Menu-----");
							System.out.println("1.Register for Course");
							System.out.println("2.Add Course");
							System.out.println("3.Drop Course");
							System.out.println("4.View Grades");
							System.out.println("5.Fee pay");
							System.out.println("6.View Courses");
							System.out.println("7.Exit");
							System.out.println("Enter your choice");
							ch3 = sc.nextInt();
							sc.nextLine();
							switch (ch3) {
							case 1:
								ssi.CourseRegister();
								break;
							case 2:
								ssi.ToAddCourse();
								break;
							case 3:
								ssi.ToDropCourse();
								break;
							case 4:
								ssi.ToViewReportCard();
								break;
							case 5:
								ssi.MakePayment();
								break;
							case 6:
								ssi.ToViewCourses();
								break;
							case 7:
								System.out.println("Exit");
								break;
							default:
								System.out.println("Wrong option selected! Choose options from 1 to 7");
								break;

							}
						} while (ch3 != 7);
					} else {
						System.out.println("Login Failed! Enter Correct Credentials");
					}

				}
				break;
			case 2:
				usi.StudentRegistration();
				break;
			case 3:
				usi.UpdatePassword();
				System.out.println("Password Updated");
				break;
			case 4:
				System.out.println("Exit");
				break;

			default:
				System.out.println("Wrong option selected! Choose options from 1 to 4");
				break;
			}

		} while (ch1 != 4);

	}

}
