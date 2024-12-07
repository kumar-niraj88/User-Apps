package com;

import java.util.List;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) throws Exception {
		
		UserDao dao = new UserDao();
		
		Scanner s = new Scanner(System.in);
		System.out.println("\t\t***WelCome to User Application***");
		boolean b = true;
		while(b) {// while start here
			System.out.println("1) press for Signup\n2) press for login\n3) press for logout\n");
			int choice = s.nextInt();
			
			switch(choice) {//starting the while loop
			case 1:{
			System.out.println("\t\t***WelCome to Sign up Page***");
			System.out.print("Enter id :");
			int id = s.nextInt();
			System.out.print("Enter First Name : ");
			String fname= s.next();
			System.out.print("Enter Last Name : ");
			String lname = s.next();
			System.out.print("Enter email : ");
			String email = s.next();
			System.out.print("Enter passwords : ");
			String passwords = s.next();
			System.out.print("Enter Gender : ");
			String gender = s.next();
			System.out.print("Enter moible number : ");
			long phone = s.nextLong();
			
			User u = new User();
			u.setId(id);
			u.setfName(fname);
			u.setlName(lname);
			u.setEmail(email);
			u.setPassword(passwords);
			u.setGender(gender);
			u.setPhone(phone);
			dao.saveData(u);
			break;
			
			}//Sign up Page end here
						
			case 2:{
			System.out.println("\t\t***WelCome to Login Page***");
			System.out.print("Enter Email: ");
			String email = s.next();
			System.out.print("Enter Passwords : ");
			String passwords = s.next();
			User u = dao.getByEmail(email);
			
			if(u != null) {
				if(passwords.equals(u.getPassword())) {
					System.out.println("\t\t**Login successfully**");
					
//					1)view All data --> based on user want see all data 
//					2)view based on id  --> 
//					3)delete based on id
				
					boolean user = true;
					while(user) {
						System.out.println("1)press for All Data\n2) view based on id\n3)delete based on id\n4)Update");
						int userData= s.nextInt();
						switch(userData) {
						case 1: {
							List<User> user1 =dao.fetchAll();
							for (User li : user1) {
								System.out.println(li);	
							}
							
							break;}
						case 2: {
							System.out.println("Enter id : ");
							int id = s.nextInt();
							User user2  = dao.getById(id);
							System.out.println(user2);
							break;}
						case 3: {
							System.out.println("Enter id : ");
							int id = s.nextInt();
							dao.deleteData(id);
							System.out.println(" successfully");
							user =false;
							break;}
						case 4:{
							System.out.println("Enter Id : ");
							int id = s.nextInt();
							User u1 =dao.getById(id);
							System.out.println("1)Enter for fName\n2)Enter for lName");
							int update=s.nextInt();
							
							switch(update) {
							case 1:{
								System.out.println("Enter fName : ");
								String fname= s.next();
								u1.setfName(fname);// for setting the data
								dao.UpdateUser(u1);//for updating the data
								System.out.println("Data Updated");
							break;}
							case 2:{
								System.out.println("Enter fName : ");
								String lname= s.next();
								u1.setlName(lname);// for setting the data
								dao.UpdateUser(u1);//for updating the data
								System.out.println("Data Updated");
								
							break;}
							default:{
								   System.out.println("invalid input");
								}
							
							}//
							
							
							
							break;}
						default:{
							   System.out.println("invalid input");
							}
						}
						
					}
					
					
					
				}else {
					System.out.println("Incorrect Passwords\n");
				}
				
			}else {
				System.out.println("Email not found\n");
			}	
			break;
			}
			
			
			case 3:{
			System.out.println("\t\t***Logout Successfully***");
			b=false;
			
			return;
			}
			default :{
				System.out.println("Enter valid input\n");
			}
		}
			
		}//ending the while loop

	}//main end here
	
}//class block end here
