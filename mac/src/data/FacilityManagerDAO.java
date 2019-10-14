package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.FacilityManagerController;
import model.Users;
import model.FacilityManager;
import util.SQLConnection;
import model.FacilityManager;

public class FacilityManagerDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static ArrayList<FacilityManager> ReturnMatchingFacilitiesList(String queryString) {
		ArrayList<FacilityManager> facilityListInDB = new ArrayList<FacilityManager>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet facilityList = stmt.executeQuery(queryString);
			while (facilityList.next()) {
				FacilityManager fm = new FacilityManager();
				fm.setFacilityType(facilityList.getString("facilityType"));
				fm.setFacilityName(facilityList.getString("facilityName"));
				fm.setTimeInterval(facilityList.getString("timeInterval"));
				fm.setDuration(facilityList.getString("duration"));
				fm.setVenue(facilityList.getString("venue"));

				facilityListInDB.add(fm);

			}
		} catch (SQLException e) {
		}
		return facilityListInDB;
	}

	public static ArrayList<FacilityManager> listFacility() {
		return ReturnMatchingFacilitiesList("SELECT * from facilities ");
	}

	public static void addFacility(FacilityManager fm) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();

		String query = "INSERT INTO facilities (facilityName, facilityType, timeInterval, duration, venue) " + "VALUES ('"
				+ fm.getFacilityName() + "', '" + fm.getFacilityType() + "', '" + fm.getTimeInterval() + "', '" + fm.getDuration() + "', '" + fm.getVenue() + "')";
//				+ " SYSDATE()  //to get date  
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.commit();
		} catch (SQLException e) {
			System.out.print(e);
		}
	}


	public static void editFacility(String name, String type, String duration, String timeInterval, String venue ) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		String query = "UPDATE facilities SET facilityName = '" + name + "', facilityType='"+type+"', duration='"+duration+"', timeInterval='" + timeInterval + "', venue='"+venue+"'  WHERE facilityName = '" + name + "'";
//				+ " SYSDATE()  //to get date  
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.commit();
		} catch (SQLException e) {
			System.out.print(e);
		}
	}

	
	public static ArrayList<FacilityManager> searchFacility(String idfacility) {
		return ReturnMatchingFacilitiesList(" SELECT * from facilities WHERE facilityName = '" + idfacility + "' ");
	}
}
