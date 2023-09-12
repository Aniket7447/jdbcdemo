package demo5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoPractice {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo5","root","root");
	/*	Statement st=con.createStatement();
         st.execute("create database demo5");
         System.out.println("done");
		 st.addBatch("create table demo51(id int ,age int,name varchar(20))");
		 System.out.println("Table Created !");
		 st.addBatch("insert into demo51 values(1,21,'Aniket')");
		 st.addBatch("insert into demo51 values(2,22,'Manoj')");
		 st.addBatch("insert into demo51 values(3,23,'Rahul')");
		 System.out.println("values inserted !");
		 st.executeBatch();
		 System.out.println("Batch executed !");
		 */
		
		 PreparedStatement st=con.prepareStatement("insert into demo51 (id,age,name) values (?,?,?)");
		 for(int i=0;i<3;i++)
		 {
			 Scanner sc=new Scanner(System.in);
			 System.out.println("Enter id : ");
			 int id=sc.nextInt();
			 System.out.println("Enter age : ");
			 int age=sc.nextInt();
			 System.out.println("Enter name : ");
			 String name=sc.next();
			st.setInt(1, id);
			st.setInt(2, age);
			st.setString(3, name);
			st.addBatch();
		 }
		 st.executeBatch();
		 System.out.println("Batch executed !!!!!!!!!!!!!");
		 
		
 		
		
		
		
		
		
	}
	   

}
