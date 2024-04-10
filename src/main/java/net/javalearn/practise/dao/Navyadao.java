package net.javalearn.practise.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.javalearn.practise.model.Navya;
//This DAo class provides CRUD database operation for the table users in the database.

public class Navyadao{
private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
private String jdbcUsername="root";
private String jdbcPassword="Vedaannoji@07";
	static String insert="insert into db.employee values(?,?,?)";
	static String printall = "select * from db.employee";
	static String deleteemploy = "DELETE from employee where emp_id=?";
	static String selectemployee="select emp_id,emp_name,emp_password from employee where emp_id=?";
	static String updateemploy = "UPDATE employee Set emp_name=?, emp_password=? WHERE emp_id=?";

	public Connection getConnection() {
		Connection con = null;
		// load
		try {
	          Class.forName("com.mysql.jdbc.Driver");// load driver             // connection
		      con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		     } catch (Exception e) 
	         {
		       e.printStackTrace();
		      }
	           return con;
	           }
	
	// insert user
	public void insert(Navya navya)throws SQLException {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			
		 e1.printStackTrace();
         }
		try (Connection con = getConnection();// checking
		 PreparedStatement ps = con.prepareStatement(insert);) {
		 ps.setInt(1, navya. getEmp_id());
	    ps.setString(2, navya.getEmp_name());
	    ps.setString(3, navya.getEmp_password() );
		 ps.executeUpdate();
		} catch (Exception e)
		{
		  e.printStackTrace();
		 }
	}

	//Delete user
	public void deleteemployee(int id)throws SQLException {
		try {
		 Class.forName("com.mysql.jdbc.Driver");
		 } catch (ClassNotFoundException e1) {

		 e1.printStackTrace();
		}
		 try(Connection con=getConnection();
		 PreparedStatement ps=con.prepareStatement(deleteemploy);) {
			 
		 ps.setInt(1,id);
		 ps.executeUpdate();
		 }
	 }

	
	//Update User
	public void updateemployee(Navya navya)throws SQLException {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 } catch (ClassNotFoundException e1) {

		 e1.printStackTrace();
		}
		 try (Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement(updateemploy);) {
		  // ps.setInt(1, navya.getEmp_id()));
              ps.setString(1, navya.getEmp_name());
		         ps.setString(2, navya.getEmp_password());
		 ps.setInt(3, navya.getEmp_id());
		           ps.executeUpdate();
		       } catch (Exception e) {

		 e.printStackTrace();
		 }
	}
	
	 //Print all details of users
	public List printdetailsemployee() {
		 List<Navya>  obj =new ArrayList<>();
	          try {
		 Class.forName("com.mysql.jdbc.Driver");
		 } catch (ClassNotFoundException e1) {

		 e1.printStackTrace();
		}
		 try(Connection con=getConnection();
		 PreparedStatement ps=con.prepareStatement(printall);) {
		 ResultSet rs=ps.executeQuery();
		 while(rs.next())
		 {
		 int id=rs.getInt("emp_id");
		 String name=rs.getString("emp_name");
		 String pass=rs.getString("emp_password");
	     obj.add(new Navya(id,name,pass));
	     }
		 } catch (Exception e) 
		 {

			 e.printStackTrace();
         }
		return obj;
	}
	
	
}

