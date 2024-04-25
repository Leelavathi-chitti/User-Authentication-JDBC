package jdbc_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RegistrationPage {
	
	Scanner sc=new Scanner(System.in);
	HomePage hp=new HomePage();
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_project","root","root");
		return con;
	}
	public void register() throws ClassNotFoundException, SQLException
	{
		RegistrationPage rp=new RegistrationPage(); 
		Connection gc=rp.getConnection();
		System.out.println("=====for registration=====");
		PreparedStatement ps=gc.prepareStatement("insert into user values(?,?,?,?,?)");
		System.out.println("enter user id");
		int id=sc.nextInt();
		System.out.println("enter the user name");
		String name=sc.next();
		System.out.println("enter user phone number");
		long phone_number=sc.nextLong();
		System.out.println("enter the user email");
		String email=sc.next();
		System.out.println("enter the password");
		int password=sc.nextInt();
		
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setLong(3,phone_number);
		ps.setString(4,email);
		ps.setInt(5, password);
		
		ps.executeUpdate();
		
		System.out.println("-----------registration successfully done-----------");
		
	}
	public void login() throws ClassNotFoundException, SQLException {
	    RegistrationPage rp = new RegistrationPage();
	    Connection gc = rp.getConnection();
	    System.out.println("======for login=======");
	    PreparedStatement ps = gc.prepareStatement("select * from user where email=? and password=?");

	    System.out.println("Enter the user email");
	    String email = sc.next();
	    System.out.println("Enter the password");
	    int password = sc.nextInt();

	    ps.setString(1, email);
	    ps.setInt(2, password); 

	    ResultSet rs = ps.executeQuery();

	    if (rs.next()) {
	        
	        System.out.println("-----------Login successfully done----------");
	        while (true) {
	            System.out.println("Press 1: Enter your email to view your details");
	            System.out.println("Press 2: Logout");
	            System.out.println("Enter the choice");
	            int choice = sc.nextInt();
	            if (choice == 1) {
	            	
	            	System.out.println("=====for viewing the details======");
	            	
	            	PreparedStatement ps1=gc.prepareStatement("select * from user where email=?");
	            	System.out.println("enter the email");
	            	String email1=sc.next();
	            	ps1.setString(1, email1);
	            	ResultSet rs1 =ps1.executeQuery();
	            	while(rs1.next()) {
	            		System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getLong(3)+" "+rs1.getString(4)+" "+rs1.getInt(5));
	            		
	            	}
	            }  
	            else if (choice == 2) {
	                System.out.println("------Logged out successfully--------");
	                
	                return; 
	            }
	        }
	    } else {
	        System.out.println("invalid email/passward or enter correct email/passward");
	        System.out.println("--------------OR-----------------");
	        System.out.println("Register Again");
	        return;
	
		
		
	}
}
}

	
		
	

