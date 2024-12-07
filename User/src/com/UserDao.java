package com;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDao {
    static String Driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/User_db";
    static String userName ="root";
    static String password ="root";
    
    
    
    // for inserting the data
    public void saveData(User u) throws Exception {
    	//load the driver
    	Class.forName(Driver);
    	//establish connection
    	Connection  con = DriverManager.getConnection(url,userName, password);
    	//create statement 
    	PreparedStatement ps = con.prepareStatement("insert into User values(?,?,?,?,?,?,?); ");
    	ps.setInt(1, u.getId());
    	ps.setString(2, u.getfName());
    	ps.setString(3, u.getlName());
    	ps.setString(4, u.getEmail());
    	ps.setString(5, u.getPassword());
    	ps.setString(6, u.getGender());
    	ps.setLong(7, u.getPhone());
    	
    	//Execute query;
    	ps.executeUpdate();
    	//close connection
    	con.close();
    	
    	System.out.println("data saved");
    	
    	
    }
    
    
    // method for deleting the data
    public void deleteData(int id)throws Exception {
    	//load the driver
    	Class.forName(Driver);
    	//establish connection
    	Connection  con = DriverManager.getConnection(url,userName, password);
    	//create statement 
    	PreparedStatement ps = con.prepareStatement("delete from user where id=?; ");
    	ps.setInt(1, id);
    	//Execute query
    	ps.executeUpdate();
    	//close the statement 
    	con.close();
    	System.out.println("data Deteted");
    	
    }
    
    
    public User getById(int id)throws Exception {
    	//load the driver
    	Class.forName(Driver);
    	//establish connection
    	Connection  con = DriverManager.getConnection(url,userName, password);
    	//create statement 
    	PreparedStatement ps = con.prepareStatement("select * from User where id=?; ");
    	ps.setInt(1, id);
    	//Execute query
    	ResultSet rs = ps.executeQuery();
    	
    	while(rs.next()) {
    		int id1 = rs.getInt("id");
    		String fname = rs.getString("fname");
    		String lname = rs.getString("lname");
    		String email = rs.getString("email");
    		String password = rs.getString("password");
    		String gender = rs.getString("gender");
    		long phone = rs.getLong("phone");
    		
    		User u = new User();
    		u.setId(id1);
    		u.setfName(fname);
    		u.setlName(lname);
    		u.setEmail(email);
    		u.setPassword(password);
    		u.setGender(gender);
    		u.setPhone(phone);
    		
    		return u;
    	}
    	
    	return null;
    }
    
    
    
    
    
    
    public User getByEmail(String email)throws Exception {
    	//load the driver
    	Class.forName(Driver);
    	//establish connection
    	Connection  con = DriverManager.getConnection(url,userName, password);
    	//create statement 
    	PreparedStatement ps = con.prepareStatement("select * from User where email=?");
    	ps.setString(1, email);
    	//Execute query
    	ResultSet rs = ps.executeQuery();
    	
    	while(rs.next()) {
    		int id = rs.getInt("id");
    		String fname = rs.getString("fname");
    		String lname = rs.getString("lname");
    		String email1 = rs.getString("email");
    		String password = rs.getString("password");
    		String gender = rs.getString("gender");
    		long phone = rs.getLong("phone");
    		
    		User u = new User();
    		
    		u.setId(id);
    		u.setfName(fname);
    		u.setlName(lname);
    		u.setEmail(email1);
    		u.setPassword(password);
    		u.setGender(gender);
    		u.setPhone(phone);
    		
    		return u;
    	}
    	
    	return null;
    	
    }
    
    public List<User> fetchAll()throws Exception {
    	//load the driver
    	Class.forName(Driver);
    	//establish connection
    	Connection  con = DriverManager.getConnection(url,userName, password);
    	//create statement 
        Statement s = con.createStatement();
        
        //Execute query
         ResultSet rs = s.executeQuery("select * from user");
         
         ArrayList<User> al = new ArrayList<User>();
         
    	
    	
    	
    	while(rs.next()) {
    		int id1 = rs.getInt("id");
    		String fname = rs.getString("fname");
    		String lname = rs.getString("lname");
    		String email = rs.getString("email");
    		String password = rs.getString("password");
    		String gender = rs.getString("gender");
    		long phone = rs.getLong("phone");
    		
    		User u = new User();
    		u.setId(id1);
    		u.setfName(fname);
    		u.setlName(lname);
    		u.setEmail(email);
    		u.setPassword(password);
    		u.setGender(gender);
    		u.setPhone(phone);
    		
    		al.add(u);
    	}
    	
    	return al;
    	
    }
    
    
    public void UpdateUser(User u) throws Exception{
    	//load the driver
    	Class.forName(Driver);
    	//establish connection
    	Connection  con = DriverManager.getConnection(url,userName, password);
    	//create statement 
    	PreparedStatement ps = con.prepareStatement("update user set fname=?,lname=?,gender=?,email=?,password=?,phone=? where id = ?");
    	
    	ps.setString(1, u.getfName());
    	ps.setString(2, u.getlName());
    	ps.setString(3, u.getGender());
    	ps.setString(4, u.getEmail());
    	ps.setString(5, u.getPassword());
    	ps.setLong(6, u.getPhone());
    	ps.setInt(7, u.getId());
    	//execute query
    	ps.executeUpdate();
    	//close the connection
    	con.close();
    }
    
    
    
}
