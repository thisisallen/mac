package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	private static String DB_DRIVER;
	private static String DB_CONNECTION;
	private static String DB_USER;
	private static String DB_PASSWORD; 
	private static SQLConnection single_instance = null;
	
	private SQLConnection() {
		DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		DB_CONNECTION  = "jdbc:mysql://localhost:3306/mac_maintenance?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		DB_USER  = "root";
		DB_PASSWORD = "pvdor>gXV3s%";
	}
	
	public static synchronized SQLConnection getInstance() {
        if (single_instance == null)
        	single_instance = new SQLConnection();
        return single_instance;
	}

	public static Connection getDBConnection() {	
		System.out.println(456789);
		Connection dbConnection = null;	 

		try {	 
			Class.forName(DB_DRIVER);	
			System.out.println(Class.forName(DB_DRIVER));
		} catch (ClassNotFoundException e) {	
			System.out.println(e);
		}

		try {	 
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			dbConnection.setAutoCommit(false);
			System.out.println(dbConnection);
		} catch (SQLException e) {
			System.out.println(e);
		}	 
		return dbConnection;	 
	}
}