package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.MARs;
import util.SQLConnection;

public class MARsDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();

	// function used to insert a new MAR into the database (ReportMARS)
	public static void ReportMARS(MARs mar) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();

		String query = "INSERT INTO mar_reports (facility, name, uegency, description, reportedby, date, req, MARnumber) "
				+ "VALUES ('" + mar.getFacility() + "','" + mar.getName() + "', '" + mar.getUrgency() + "', '"
				+ mar.getDescription() + "', '" + mar.getReportedby() + "', '" + mar.getDate() + "', '" + mar.getReq()
				+ "', '" + mar.getMARnumber() + "')";
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

	public static ArrayList<MARs> getMARs() {

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		ArrayList<MARs> MARs = new ArrayList<MARs>();

		String query = "SELECT * FROM mar_reports";

		try {
			stmt = conn.createStatement();
			ResultSet MARList = stmt.executeQuery(query);

			while (MARList.next()) {
				MARs mar = new MARs();
				mar.setFacility(MARList.getString("facility"));
				mar.setName(MARList.getString("name"));
				mar.setUrgency(MARList.getString("urgency"));
				mar.setDescription(MARList.getString("description"));
				mar.setReportedby(MARList.getString("reportedby"));
				mar.setDate(MARList.getString("date"));
				mar.setReq(MARList.getString("req"));
				mar.setMARnumber(MARList.getString("MARnumber"));
				MARs.add(mar);
			}
		} catch (SQLException e) {
			System.out.print(e);
		}

		return MARs;
	}

	public static ArrayList<MARs> getUnassignedMARs() {

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		ArrayList<MARs> unassignedMAR = new ArrayList<MARs>();

		String query = "SELECT * FROM mar_reports WHERE assigned = 'No'";

		try {
			stmt = conn.createStatement();
			ResultSet MARList = stmt.executeQuery(query);

			while (MARList.next()) {
				MARs mar = new MARs();
				mar.setFacility(MARList.getString("facility"));
				mar.setName(MARList.getString("name"));
				mar.setUrgency(MARList.getString("urgency"));
				mar.setDescription(MARList.getString("description"));
				mar.setReportedby(MARList.getString("reportedby"));
				mar.setDate(MARList.getString("date"));
				mar.setReq(MARList.getString("req"));
				mar.setMARnumber(MARList.getString("MARnumber"));
				unassignedMAR.add(mar);
			}
		} catch (SQLException e) {
			System.out.print(e);
		}

		return unassignedMAR;
	}
}