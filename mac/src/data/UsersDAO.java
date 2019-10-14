package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Users;
import util.SQLConnection;

public class UsersDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	//function used to insert a new user into the database (registration)
	public static void registerUser(Users user) {
		Statement stmt = null;   
		Connection conn = SQLConnection.getDBConnection();  
		
		String query = "INSERT INTO users (username, password, firstName, lastName, utaID, role, phone, email, streetAddress, city, state, zipCode) "
				+ "VALUES ('" + user.getUsername() + "','" + user.getPassword() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', '" 
				+ user.getUtaID() + "', '" + user.getRole() + "', '" + user.getPhone() + "', '" + user.getEmail() + "', '" + user.getAddress() + "', '" 
				+ user.getCity() + "', '" + user.getState() + "', '" + user.getZipCode() + "')";				
//				+ " SYSDATE()  //to get date  
		try 
		{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.commit();					 
		} 
		catch (SQLException e) 
		{
			System.out.print(e);
		}
	}
	
	public static ArrayList<Users> loginUser(Users user)
	{
		System.out.println(112233);
		Statement stmt = null;
		Connection conn = SQLConnection.getInstance().getDBConnection();
		Users selectedUser = new Users();
		ArrayList<Users> userInDB = new ArrayList<Users>();
		
		String query = "SELECT * FROM users WHERE username = '" + user.getUsername() + "' AND password = '" + user.getPassword() + "';";

		try 
		{	
			System.out.println(conn);
			stmt = conn.createStatement();
			ResultSet userList = stmt.executeQuery(query);
			while (userList.next()) 
			{ 
				selectedUser.setUsername(userList.getString("username"));	
				selectedUser.setPassword(userList.getString("password"));	
				selectedUser.setFirstName(userList.getString("firstName"));	
				selectedUser.setLastName(userList.getString("lastName"));	
				selectedUser.setUtaID(userList.getString("utaID"));	
				selectedUser.setRole(Integer.parseInt(userList.getString("role")));	
				selectedUser.setPhone(userList.getString("phone"));	
				selectedUser.setEmail(userList.getString("email"));	
				selectedUser.setAddress(userList.getString("streetAddress"));	
				selectedUser.setCity(userList.getString("city"));	
				selectedUser.setState(userList.getString("state"));	
				selectedUser.setZipCode(userList.getString("zipCode"));
				
				userInDB.add(selectedUser);
			}
		} 
		catch (SQLException e) 
		{
			System.out.print(e);
		}
		
		return userInDB;
	}
	 public static ArrayList<Users> getProfile(String uName)
	 {
		 ArrayList<Users> userDataInDB = new ArrayList<Users>();
		 
		 Statement stmt = null;
		 Connection conn = SQLConnection.getDBConnection();
		 
		 String query = "SELECT * FROM users WHERE username = '" + uName + "';"; 
		 
		 try
		 {
			 stmt = conn.createStatement();
			 ResultSet userList = stmt.executeQuery(query);
			 
			 while (userList.next()) 
			 { 
				 Users user = new Users();
				 user.setUsername(userList.getString("username"));
				 user.setPassword(userList.getString("password"));	
				 user.setFirstName(userList.getString("firstName"));	
				 user.setLastName(userList.getString("lastName"));	
				 user.setUtaID(userList.getString("utaID"));
				 user.setRole(Integer.parseInt(userList.getString("role")));	
				 user.setPhone(userList.getString("phone"));	
				 user.setEmail(userList.getString("email"));	
				 user.setAddress(userList.getString("streetAddress"));	
				 user.setCity(userList.getString("city"));	
				 user.setState(userList.getString("state"));	
				 user.setZipCode(userList.getString("zipCode"));
				 userDataInDB.add(user);
			 }
		 }
		 catch(SQLException e)
		 {
			 System.out.print(e);
		 }
		 
		 return userDataInDB; 
	 }
	 
	 public static ArrayList<Users> updateProfile(String loggedUsername, String query)
	 {
		 Statement stmt = null;
		 Connection conn = SQLConnection.getDBConnection();
		
		 try 
		 {
			 conn.setAutoCommit(false);
			 stmt = conn.createStatement();
			 stmt.executeUpdate(query);
			 conn.commit();		
		 } 
		 catch (SQLException e) 
		 {
			 System.out.print(e);
		 }
			
		 return getProfile(loggedUsername);
	 }
	 
	 public static Boolean UsernameUnique(String username)
	 {
		 ArrayList<Users> usersInDB = new ArrayList<Users>();
		 Statement stmt = null;
		 Connection conn = SQLConnection.getDBConnection();
		 ResultSet res = null;
		 String query = "SELECT * FROM users WHERE username LIKE '" + username +"';";
		 
		 try 
		 {
			 stmt = conn.createStatement();
			 res = stmt.executeQuery(query);
			 
			 while (res.next()) {
					Users user = new Users(); 
					user.setUsername(res.getString("username"));
					user.setPassword(res.getString("password"));
					user.setFirstName(res.getString("firstName"));
					user.setLastName(res.getString("lastName"));
					user.setUtaID(res.getString("utaID"));
					user.setRole(Integer.parseInt(res.getString("role")));
					user.setPhone(res.getString("phone"));
					user.setEmail("email");
					user.setAddress("streetAddress");
					user.setCity("city");
					user.setState("state");
					user.setZipCode("zipCode");
					
					usersInDB.add(user);	
				}
		 } 
		 catch (SQLException e) 
		 {
			 System.out.print(e);
		 }
		 return usersInDB.isEmpty();
	 }
}