package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Assigned_Mars;
import model.MarReport;
import model.Users;
import util.SQLConnection;

public class MarReportDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static ArrayList<MarReport> ReturnMatchingReportsList(String queryString) {
		ArrayList<MarReport> reportListInDB = new ArrayList<MarReport>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet reportsList = stmt.executeQuery(queryString);
			while (reportsList.next()) {
				MarReport report = new MarReport();
				report.setFacilityName(reportsList.getString("facilityName"));
				report.setUrgency(reportsList.getString("urgency"));
				report.setDescription(reportsList.getString("description"));
				report.setReportedBy(reportsList.getString("reportedBy"));
				report.setReportedDate(reportsList.getString("reportedDate"));
				report.setMarNumber(reportsList.getString("marNumber"));
				report.setAssigned(reportsList.getString("assigned"));
				report.setRequested(reportsList.getString("requested"));
				report.setAssignedDate(reportsList.getString("assignedDate"));
				report.setAssignedTime(reportsList.getString("assignedTime"));
				report.setAssignedTo(reportsList.getString("assignedTo"));
				report.setEstimateOfRepairs(reportsList.getString("estimateOfRepairs"));

				reportListInDB.add(report);

			}
		} catch (SQLException e) {
		}
		return reportListInDB;
	}

	public static ArrayList<MarReport> searchAllReports() {
		String query = "SELECT * from mar_reports";
		ArrayList<MarReport> reportListInDB = new ArrayList<MarReport>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet reportsList = stmt.executeQuery(query);
			while (reportsList.next()) {
				MarReport report = new MarReport();
				report.setMarNumber(reportsList.getString("marNumber"));
				report.setFacilityName(reportsList.getString("facilityName"));
				report.setUrgency(reportsList.getString("urgency"));
				report.setDescription(reportsList.getString("description"));
				report.setReportedBy(reportsList.getString("reportedBy"));
				report.setReportedDate(reportsList.getString("reportedDate"));
				report.setRequested(reportsList.getString("requested"));
				report.setAssigned(reportsList.getString("assigned"));

				reportListInDB.add(report);
			}
		} catch (SQLException e) {
		}
		return reportListInDB;
	}
	public static ArrayList<MarReport> searchAllReports2(String name) {
		String query = "SELECT * from mar_reports WHERE reportedBy='"+ name +"'";
		ArrayList<MarReport> reportListInDB = new ArrayList<MarReport>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet reportsList = stmt.executeQuery(query);
			while (reportsList.next()) {
				MarReport report = new MarReport();
				report.setMarNumber(reportsList.getString("marNumber"));
				report.setFacilityName(reportsList.getString("facilityName"));
				report.setUrgency(reportsList.getString("urgency"));
				report.setDescription(reportsList.getString("description"));
				report.setReportedBy(reportsList.getString("reportedBy"));
				report.setReportedDate(reportsList.getString("reportedDate"));
				report.setRequested(reportsList.getString("requested"));
				report.setAssigned(reportsList.getString("assigned"));

				reportListInDB.add(report);
			}
		} catch (SQLException e) {
		}
		return reportListInDB;
	}


	public static ArrayList<MarReport> searchAllReports1() {
		String query = "SELECT * from mar_reports  WHERE  assigned ='NO' ";
		ArrayList<MarReport> reportListInDB = new ArrayList<MarReport>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet reportsList = stmt.executeQuery(query);
			while (reportsList.next()) {
				MarReport report = new MarReport();
				report.setMarNumber(reportsList.getString("marNumber"));
				report.setFacilityName(reportsList.getString("facilityName"));
				report.setUrgency(reportsList.getString("urgency"));
				report.setDescription(reportsList.getString("description"));
				report.setReportedBy(reportsList.getString("reportedBy"));
				report.setReportedDate(reportsList.getString("reportedDate"));
				report.setRequested(reportsList.getString("requested"));
				report.setAssigned(reportsList.getString("assigned"));

				reportListInDB.add(report);
			}
		} catch (SQLException e) {
		}
		return reportListInDB;
	}

	
	
	public static ArrayList<MarReport> searchSpecificReport(String reportID) {
		String query =" SELECT * from mar_reports WHERE marNumber LIKE '" + reportID + "'; ";
		ArrayList<MarReport> reportsListInDB = new ArrayList<MarReport>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet usersList = stmt.executeQuery(query);
			while (usersList.next()) {
				MarReport report = new MarReport();

				report.setMarNumber(usersList.getString("marNumber"));
				report.setFacilityName(usersList.getString("facilityName"));
				report.setUrgency(usersList.getString("urgency"));
				report.setDescription(usersList.getString("description"));
				report.setReportedBy(usersList.getString("reportedBy"));
				report.setReportedDate(usersList.getString("reportedDate"));
				report.setAssigned(usersList.getString("assigned"));
				report.setRequested(usersList.getString("requested"));

				reportsListInDB.add(report);
			}
		} catch (SQLException e) {
		}
		return reportsListInDB;

	}
	
	public static ArrayList<MarReport> listRequests(String reportID)
	{
		String query =" SELECT * FROM requested_mars WHERE marNumber LIKE '" + reportID + "'; ";
		ArrayList<MarReport> reportsListInDB = new ArrayList<MarReport>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet reportsList = stmt.executeQuery(query);
			while (reportsList.next()) {
				MarReport report = new MarReport();

				report.setRequestID(reportsList.getString("requestID"));
				report.setMarNumber(reportsList.getString("marNumber"));
				report.setRequestedBy(reportsList.getString("requestedBy"));
				report.setRequestedDate(reportsList.getString("requestedDate"));
				report.setRequestedTime(reportsList.getString("requestedTime"));
				report.setEstimateOfRepairs(reportsList.getString("estimateOfRepairs"));

				reportsListInDB.add(report);
			}
		} catch (SQLException e) {
		}
		return reportsListInDB;
	}

	public static ArrayList<MarReport> searchReports(String condition)
	{
		String query;
		if(!condition.equalsIgnoreCase("")) {
			query = "SELECT * from mar_reports WHERE " + condition;
		}
		else
		{
			query =  "SELECT * from mar_reports";
		}
		ArrayList<MarReport> reportListInDB = new ArrayList<MarReport>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet reportsList = stmt.executeQuery(query);
			while (reportsList.next()) {
				MarReport report = new MarReport();
				report.setFacilityName(reportsList.getString("facilityName"));
				report.setUrgency(reportsList.getString("urgency"));
				report.setDescription(reportsList.getString("description"));
				report.setReportedBy(reportsList.getString("reportedBy"));
				report.setReportedDate(reportsList.getString("reportedDate"));
				report.setMarNumber(reportsList.getString("marNumber"));
				report.setAssigned(reportsList.getString("assigned"));
				report.setRequested(reportsList.getString("requested"));
				
				reportListInDB.add(report);
			}
		} catch (SQLException e) {
		}
		return reportListInDB;
	}
	
	public static void createMAR(MarReport report) {
		String query = "INSERT INTO mar_reports(marNumber, facilityName, urgency, description, reportedBy, reportedDate, requested, assigned) VALUES ('"
				+ report.getMarNumber() + "', '" + report.getFacilityName() + "', '" + report.getUrgency() + "', '"
				+ report.getDescription() + "', '" + report.getReportedBy() + "', '" + report.getReportedDate()
				+ "', 'NO', 'NO')";
		String q = "INSERT INTO mar_reports(marNumber, facilityName, urgency) VALUES '" + report.getMarNumber() + "', '"
				+ report.getFacilityName() + "', '" + report.getUrgency() + ")";
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			conn.setAutoCommit(false);
			System.out.print("hi 1");
			stmt = conn.createStatement();
			System.out.print("hi 2");
			stmt.executeUpdate(query);
			System.out.print("hi 3");
			conn.commit();
			System.out.print("success");
		} catch (SQLException e) {
			System.out.print("something wrong");
		}
	}
	
	
	
	public static void assignRepairman(String marNumber, String requestedBy, String requestedDate, String requestedTime, String estimateOfRepairs)
	{
		String query = "INSERT INTO assigned_mars(marNumber, assignedTo, assignedDate, assignedTime, estimateOfRepairs)" + 
				"VALUES('" + marNumber + "', '" + requestedBy + "', '" + requestedDate + "', '" + requestedTime + "', '" + estimateOfRepairs + "');";
		
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
	
	public static void assignRepairmanReport(String marNumber)
	{
		String query = ("UPDATE mar_reports SET assigned = 'YES' WHERE marNumber = '" + marNumber + "'");
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
	
	
	public static void assignRepairmanNO(String marNumber)
	{
		String query = ("UPDATE mar_reports SET assigned = 'NO' WHERE marNumber = '" + marNumber + "'");
			
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
	
	public static ArrayList<Assigned_Mars> searchSpecificRepair(String id)
	{
		String query = "SELECT * FROM assigned_mars WHERE assignedID='" + id + "';";
		ArrayList<Assigned_Mars> reportListInDB = new ArrayList<Assigned_Mars>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet reportsList = stmt.executeQuery(query);
			while (reportsList.next()) {
				Assigned_Mars report = new Assigned_Mars();
				report.setAssignedID(Integer.parseInt(reportsList.getString("assignedID")));
				report.setAssignedDate(reportsList.getString("assignedDate"));
				report.setAssignedTime(reportsList.getString("assignedTime"));
				report.setAssignedTo(reportsList.getString("reportedBy"));
				report.setEstimateOfRepairs(reportsList.getString("reportedDate"));
				
				reportListInDB.add(report);
			}
		} catch (SQLException e) {
		}
		return reportListInDB;
	}

	public static void assignRepairmanNO1(String mar) {
		// TODO Auto-generated method stub
		String query = ("UPDATE mar_reports SET assigned = 'NO' WHERE marNumber = '" + mar + "'");
		
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
	
	public static ArrayList<MarReport> searchAssignedReportByDate(String assignedDate) {
		String query =" SELECT * from mar_reports, assigned_mars WHERE assigned_mars.assignedDate LIKE '" + assignedDate 
				+ "' AND mar_reports.marNumber LIKE assigned_mars.marNumber; ";
		ArrayList<MarReport> reportsListInDB = new ArrayList<MarReport>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet amarsList = stmt.executeQuery(query);
			while (amarsList.next()) {
				MarReport report = new MarReport();
				report.setFacilityName(amarsList.getString("facilityName"));
				report.setUrgency(amarsList.getString("urgency"));
				report.setDescription(amarsList.getString("description"));
				report.setReportedBy(amarsList.getString("reportedBy"));
				report.setReportedDate(amarsList.getString("reportedDate"));
				report.setMarNumber(amarsList.getString("marNumber"));
				report.setAssigned(amarsList.getString("assigned"));
				report.setRequested(amarsList.getString("requested"));

				reportsListInDB.add(report);
			}
		} catch (SQLException e) {
		}
		return reportsListInDB;

	}
	
	public static ArrayList<MarReport> listSpecificAssignedMar(String marNumber){
		String query =" SELECT * from mar_reports, assigned_mars WHERE mar_reports.marNumber LIKE '" + marNumber + "'"
				+ "AND mar_reports.marNumber LIKE assigned_mars.marNumber;";
		ArrayList<MarReport> reportsListInDB = new ArrayList<MarReport>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet amarsList = stmt.executeQuery(query);
			while (amarsList.next()) {
				MarReport report = new MarReport();
				report.setFacilityName(amarsList.getString("facilityName"));
				report.setUrgency(amarsList.getString("urgency"));
				report.setDescription(amarsList.getString("description"));
				report.setReportedBy(amarsList.getString("reportedBy"));
				report.setReportedDate(amarsList.getString("reportedDate"));
				report.setMarNumber(amarsList.getString("marNumber"));
				report.setAssigned(amarsList.getString("assigned"));
				report.setRequested(amarsList.getString("requested"));
				report.setAssignedDate(amarsList.getString("assignedDate"));
				report.setAssignedTime(amarsList.getString("assignedTime"));
				report.setAssignedTo(amarsList.getString("assignedTo"));
				report.setEstimateOfRepairs(amarsList.getString("estimateOfRepairs"));
				report.setAssignedID(amarsList.getString("assignedID"));

				reportsListInDB.add(report);
			}
		} catch (SQLException e) {
		}
		return reportsListInDB;
	}
	
	public static ArrayList<MarReport> searchAssignedReports() {
		String query =" SELECT * from mar_reports WHERE assigned LIKE 'YES';";
		ArrayList<MarReport> reportsListInDB = new ArrayList<MarReport>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet amarsList = stmt.executeQuery(query);
			while (amarsList.next()) {
				MarReport report = new MarReport();
				report.setFacilityName(amarsList.getString("facilityName"));
				report.setUrgency(amarsList.getString("urgency"));
				report.setDescription(amarsList.getString("description"));
				report.setReportedBy(amarsList.getString("reportedBy"));
				report.setReportedDate(amarsList.getString("reportedDate"));
				report.setMarNumber(amarsList.getString("marNumber"));
				report.setAssigned(amarsList.getString("assigned"));
				report.setRequested(amarsList.getString("requested"));

				reportsListInDB.add(report);
			}
		} catch (SQLException e) {
		}
		return reportsListInDB;

	}
	
	public static void fillinReport(String marNumber, String urgency)
	{
		String query = "UPDATE mar_reports SET urgency = '" + urgency +"' WHERE marNumber = '" + marNumber + "'; ";
		
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
	
	
	}

	
	