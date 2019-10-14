package data;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Users;
import util.SQLConnection;

public class AdminDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static ArrayList<Users> ReturnMatchingUsersList(String queryString) {
		ArrayList<Users> usersListInDB = new ArrayList<Users>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet usersList = stmt.executeQuery(queryString);
			while (usersList.next()) {
				Users users = new Users();

				users.setUsername(usersList.getString("username"));
				users.setFirstName(usersList.getString("firstName"));
				users.setLastName(usersList.getString("lastName"));
				users.setUtaID(usersList.getString("utaID"));
				users.setRole(usersList.getInt("role"));
				users.setEmail(usersList.getString("email"));
				users.setPhone(usersList.getString("phone"));
				users.setAddress(usersList.getString("streetAddress"));
				users.setCity(usersList.getString("City"));
				users.setState(usersList.getString("state"));
				users.setZipCode(usersList.getString("zipCode"));

				usersListInDB.add(users);
			}
		} catch (SQLException e) {
		}
		return usersListInDB;
	}

	public static ArrayList<Users> listUsers() {
		return ReturnMatchingUsersList("SELECT * from users");
	}

	public static ArrayList<Users>   searchUser(String idUser)  {  
		return ReturnMatchingUsersList(" SELECT * from users WHERE username = '"+idUser+"' ");
	}

	public static ArrayList<Users>   searchSpecificUser(String nameUser)  {  
		return ReturnMatchingUsersList(" SELECT * from users WHERE lastName = '"+nameUser+"' ");
	}
	
	public static void editUser(String username, int role)
	{
		Statement stmt = null;   
		Connection conn = SQLConnection.getDBConnection();  

     	String query = "UPDATE users SET role='" + role + "' WHERE username LIKE'"+ username +"';";
		
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
}