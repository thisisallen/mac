package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.AdminDAO;
import data.FacilityManagerDAO;
import data.MarReportDAO;
import model.Assigned_Mars;
import model.FacilityManager;
import model.MarReport;
import model.Users;

/**
 * Servlet implementation class FacilityManagerController
 */
@WebServlet("/FacilityManagerController")
public class FacilityManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacilityManagerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FacilityManager facility;
		HttpSession session = null;
		session = request.getSession();
		String loggedInUsername = (String) session.getAttribute("loggedInUser");

		String action = request.getParameter("action"), url = "";

		if (action.equalsIgnoreCase("listFacilities")) {
			ArrayList<FacilityManager> facilityInDB = new ArrayList<FacilityManager>();
			facilityInDB = FacilityManagerDAO.listFacility();
			request.setAttribute("USER", facilityInDB);

			getServletContext().getRequestDispatcher("/ViewFacilityFM.jsp").forward(request, response);

		} else if (action.equalsIgnoreCase("listSpecificFacility")) {
			ArrayList<FacilityManager> facilityInDB = new ArrayList<FacilityManager>();
			FacilityManager selectedFacility = new FacilityManager();
			facilityInDB = FacilityManagerDAO.searchFacility(request.getParameter("id"));

			selectedFacility.setFacility(facilityInDB.get(0).getFacilityName(), facilityInDB.get(0).getFacilityType(),
					facilityInDB.get(0).getDuration(), facilityInDB.get(0).getTimeInterval(), facilityInDB.get(0).getVenue());
			request.setAttribute("USERS", selectedFacility);
			getServletContext().getRequestDispatcher("/ListSpecificFacilityFM.jsp").forward(request, response);

		}
		
		else if (action.equalsIgnoreCase("listSpecificFacility1")) {
			ArrayList<FacilityManager> facilityInDB = new ArrayList<FacilityManager>();
			FacilityManager selectedFacility = new FacilityManager();
			facilityInDB = FacilityManagerDAO.searchFacility(request.getParameter("id"));

			selectedFacility.setFacility(facilityInDB.get(0).getFacilityName(), facilityInDB.get(0).getFacilityType(),
					facilityInDB.get(0).getDuration(), facilityInDB.get(0).getTimeInterval(), facilityInDB.get(0).getVenue());
			request.setAttribute("USERS", selectedFacility);
			getServletContext().getRequestDispatcher("/editSpecificFaility.jsp").forward(request, response);

		}
		
		
		
		else if (action.equalsIgnoreCase("searchAssignedMARs"))
		{
			ArrayList<MarReport> reportsInDB = new ArrayList<MarReport>();
			reportsInDB = MarReportDAO.searchAssignedReports();
			request.setAttribute("ALL_REPORTS", reportsInDB);
			getServletContext().getRequestDispatcher("/assignedMARsFM.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("assignRepairman"))
		{
			 String marNumber = request.getParameter("id1");
			 String requestedBy = request.getParameter("id2");
			 String requestedDate = request.getParameter("id3");
			 String requestedTime = request.getParameter("id4");
			 String estimateOfRepairs = request.getParameter("id5");
			 
			 MarReportDAO.assignRepairman(marNumber, requestedBy, requestedDate, requestedTime, estimateOfRepairs);
			 MarReportDAO.assignRepairmanReport(marNumber);
			
			 response.sendRedirect("/mac/FacilityManagerController?action=searchAllMARs");
		}
		else if (action.equalsIgnoreCase("searchAllMARs"))
		{
			ArrayList<MarReport> reportsInDB = new ArrayList<MarReport>();
			reportsInDB = MarReportDAO.searchAllReports();
			request.setAttribute("ALL_REPORTS", reportsInDB);
			getServletContext().getRequestDispatcher("/allMARsFM.jsp").forward(request, response);
		}

		
		
		else if (action.equalsIgnoreCase("fillinreport")) {
			String marNumber = request.getParameter("id");
			String urgency = request.getParameter("Urgency");
			MarReportDAO.fillinReport(marNumber, urgency);;

			response.sendRedirect("/mac/FacilityManagerController?action=searchAllMARs");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		FacilityManager fm;
		String action = request.getParameter("action"), url = "";
		HttpSession session = null;

		if (action.equalsIgnoreCase("addFacility")) {
			FacilityManager facility;
			String facilityName = request.getParameter("fac_name");
			String facilityType = request.getParameter("fac_type");
			String timeInterval = request.getParameter("timeInterval");
			String duration = request.getParameter("duration");
			String venue = request.getParameter("venue");
			
				facility = new FacilityManager(facilityName, facilityType, duration, timeInterval, venue);
	
				FacilityManagerDAO.addFacility(facility);
				
				response.sendRedirect("/mac/FacilityManagerController?action=listFacilities");
		}
		
		
		else if (action.equalsIgnoreCase("searchAssignedMARsByDate")) {
			ArrayList<MarReport> AssignedMARsInDB = new ArrayList<MarReport>();
			AssignedMARsInDB = MarReportDAO.searchAssignedReportByDate(request.getParameter("assignedDate"));
			request.setAttribute("ALL_REPORTS", AssignedMARsInDB);
			getServletContext().getRequestDispatcher("/assignedMARsFM.jsp").forward(request, response);
		}
		
		else if (action.equalsIgnoreCase("editFacilities")) {
	         String Facility_name=request.getParameter("id");
	         String Facility_type = request.getParameter("type");
	         String duration = request.getParameter("duration");
	         String timeInterval = request.getParameter("timeInterval");
	         String venue = request.getParameter("venue");
	         
	         FacilityManagerDAO.editFacility(Facility_name, Facility_type, duration, timeInterval, venue);
	     	response.sendRedirect("/mac/FacilityManagerController?action=listFacilities");
	    	}
			
		
		
		else if(action.equalsIgnoreCase("searchSpecificMars"))
		{
			String requested = request.getParameter("requested");
			String assigned = request.getParameter("assigned");
			String condition = "", requestedCondition = "", assignedCondition = "";
			ArrayList<MarReport> reportsInDB = new ArrayList<MarReport>();
			
			if(assigned.equalsIgnoreCase("ALL"))
			{
				assignedCondition = "empty";
			}
			else 
			{
				if(assigned.equalsIgnoreCase("YES"))
				{
					assignedCondition = " assigned LIKE 'YES' ";
				}
				else if (assigned.equalsIgnoreCase("NO"))
				{
					assignedCondition = " assigned LIKE 'NO' ";
				}
			}
			
			if(requested.equalsIgnoreCase("ALL"))
			{
				requestedCondition = "empty";
			}
			else 
			{
				if(requested.equalsIgnoreCase("YES"))
				{
					requestedCondition = " requested LIKE 'YES' ";
				}
				else if (requested.equalsIgnoreCase("NO"))
				{
					requestedCondition = " requested LIKE 'NO' ";
				}
			}
			
			if(!requestedCondition.equalsIgnoreCase("empty") && !assignedCondition.equalsIgnoreCase("empty"))
			{
				condition = assignedCondition + "AND" + requestedCondition;
			}
			else if(!requestedCondition.equalsIgnoreCase("empty") && assignedCondition.equalsIgnoreCase("empty"))
			{
				condition = requestedCondition;
			}
			else if(requestedCondition.equalsIgnoreCase("empty") && !assignedCondition.equalsIgnoreCase("empty"))
			{
				condition = assignedCondition;
			}
			else if(!requestedCondition.equalsIgnoreCase("empty") && !assignedCondition.equalsIgnoreCase("empty"))
			{
				condition = "";
			}
			
			reportsInDB = MarReportDAO.searchReports(condition);
			request.setAttribute("ALL_REPORTS", reportsInDB);
			getServletContext().getRequestDispatcher("/allMARsFM.jsp").forward(request, response);
		}
	}
}