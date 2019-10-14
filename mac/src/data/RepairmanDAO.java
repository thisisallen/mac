package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;

import model.Assigned_Mars;
import model.MarReport;
import model.RequestedMAR;
import model.Users;
import util.SQLConnection;
import java.util.Calendar;
import java.util.Date;

public class RepairmanDAO{
	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static ArrayList<Assigned_Mars> ReturnMatchingReportsList(String queryString) {
		ArrayList<Assigned_Mars> reportsListInDB = new ArrayList<Assigned_Mars>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		try {
			stmt = conn.createStatement();
			ResultSet reportsList = stmt.executeQuery(queryString);
			while (reportsList.next()) {
				Assigned_Mars assigned_mars = new Assigned_Mars();

				assigned_mars.setAssignedID(reportsList.getInt("assignedID"));
				assigned_mars.setMarNumber(reportsList.getString("marNumber"));
				assigned_mars.setAssignedTo(reportsList.getString("assignedTo"));
				assigned_mars.setAssignedDate(reportsList.getString("assignedDate"));
				assigned_mars.setAssignedTime(reportsList.getString("assignedTime"));
				assigned_mars.setEstimateOfRepairs(reportsList.getString("estimateOfRepairs"));
				
				reportsListInDB.add(assigned_mars);
			}
		} catch (SQLException e) {
		}
		return reportsListInDB;
	}
	
	
	
	public static void createRequest(String marNumber,String user,String date, String time, String estimate) {
//		LocalTime time=java.time.LocalTime.now();  
		Statement stmt = null;   
		Connection conn = SQLConnection.getDBConnection();  
		
		String query = "INSERT INTO requested_mars (marNumber, requestedBy, requestedDate,requestedTime,estimateofRepairs) "
				+ "VALUES ('" + marNumber + "','" + user + "', '" + date + "','" + time + "', '" 
				+ estimate + "')";				
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
	
	
	private static ArrayList<RequestedMAR> ReturnMatchingReportList(String queryString) {
		ArrayList<RequestedMAR> reportsListInDB = new ArrayList<RequestedMAR>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		try {
			stmt = conn.createStatement();
			ResultSet reportsList = stmt.executeQuery(queryString);
			while (reportsList.next()) {
				RequestedMAR request_mars = new RequestedMAR();

				request_mars.setMarNumber(reportsList.getString("marNumber"));
				request_mars.setFacilityName(reportsList.getString("facilityName"));
				request_mars.setRequestedBy(reportsList.getString("requestedBy"));
				request_mars.setAssignedDate(reportsList.getString("requestedDate"));
				request_mars.setAssignedTime(reportsList.getString("requestedTime"));
				request_mars.setEstimateOfRepairs(reportsList.getString("estimateOfRepairs"));
				
				reportsListInDB.add(request_mars);
			}
		} catch (SQLException e) {
		}
		return reportsListInDB;
	}
	
 
	public static ArrayList<Assigned_Mars> searchAssignedMars(String assignedTo ) {
		return ReturnMatchingReportsList(" SELECT * from assigned_mars, mar_reports where assigned_mars.assignedTo = '" + assignedTo + "' AND  mar_reports.marNumber = assigned_mars.marNumber;");
	}
	public static ArrayList<RequestedMAR> searchRequestedMars(String requestedBy ) {
		return ReturnMatchingReportList(" SELECT * from requested_mars, mar_reports where requested_mars.requestedBy = '" + requestedBy + "' AND  mar_reports.marNumber = requested_mars.marNumber;");
	}
	
	public static ArrayList<Assigned_Mars> searchSpecificRepair(String id ) {
		String query = "SELECT * from assigned_mars, mar_reports where assigned_mars.assignedID = '" + id + "' AND  mar_reports.marNumber LIKE assigned_mars.marNumber;";
		
		ArrayList<Assigned_Mars> reportsListInDB = new ArrayList<Assigned_Mars>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		try {
			stmt = conn.createStatement();
			ResultSet reportsList = stmt.executeQuery(query);
			while (reportsList.next()) {
				Assigned_Mars assignedMAR = new Assigned_Mars();

				assignedMAR.setAssignedID(Integer.parseInt(reportsList.getString("assignedID")));
				assignedMAR.setMarNumber(reportsList.getString("marNumber"));
				assignedMAR.setFacilityName(reportsList.getString("facilityName"));
				assignedMAR.setUrgency(reportsList.getString("urgency"));
				assignedMAR.setDescription(reportsList.getString("description"));
				assignedMAR.setAssignedDate(reportsList.getString("assignedDate"));
				assignedMAR.setAssignedTime(reportsList.getString("assignedTime"));
				assignedMAR.setEstimateOfRepairs(reportsList.getString("estimateOfRepairs"));
				
				reportsListInDB.add(assignedMAR);
			}
		} catch (SQLException e) {
		}
		return reportsListInDB;
	}
	
	public static void changeMAR(String marNumber)
	{
		String query = ("UPDATE mar_reports SET requested = 'YES' WHERE marNumber = '" + marNumber + "'");
			
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		try
		{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.commit();	
		}
		catch(SQLException e){}
	}
	
	
	
	
	public static void deleteSpecificRepair(String id ) {
		Statement stmt = null;   
		Connection conn = SQLConnection.getDBConnection();  
		 String query = (" DELETE from assigned_mars where assignedID = '" + id + "' ");
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
	
	public static void editSpecificRepair(String estimate,String id) {
		// TODO Auto-generated method stub
		
		String query = ("UPDATE assigned_mars SET estimateOfRepairs='" + estimate + "' WHERE assignedID LIKE '" + id + "';");
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		try
		{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.commit();	
		}
		catch(SQLException e){}
	}

	
	
	
	public static void requestedMar(String number, String name) {
		Statement stmt = null;   
		Connection conn = SQLConnection.getDBConnection();  
		String number1 = number;
		String name1 = name;
		
		System.out.print(name1);
		String query = "INSERT INTO requested_mars (requestID,marNumber, requestedBy,requestedDate) "
				+ "VALUES ('5','number1','name1','2019-02-02')";				
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
	
}

