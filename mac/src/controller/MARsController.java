package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.AdminDAO;
import data.FacilityManagerDAO;
import data.MARsDAO;
import data.MarReportDAO;
import model.FacilityManager;
import model.MARs;
import model.MarReport;
import model.Users;

/**
 * Servlet implementation class MARsController
 */
@WebServlet("/MARsController")
public class MARsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MARsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session;
		String action = request.getParameter("action"), url = "";
		session = request.getSession();
		String loggedInUsername = (String) session.getAttribute("loggedInUser");

		if (action.equalsIgnoreCase("getUnassignedMARs")) {
			ArrayList<MARs> uMARs = new ArrayList<MARs>();
			uMARs = MARsDAO.getUnassignedMARs();
			request.setAttribute("unassignedMARs", uMARs);
			getServletContext().getRequestDispatcher("/UnassignedMARs.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("listSpecificMarReport")) 
		{			
			ArrayList<MarReport> reportsInDB = new ArrayList<MarReport>();
			MarReport selectedReport = new MarReport();
			reportsInDB = MarReportDAO.searchSpecificReport(request.getParameter("id"));

			selectedReport.setReport(reportsInDB.get(0).getMarNumber(), reportsInDB.get(0).getFacilityName(),
					reportsInDB.get(0).getUrgency(), reportsInDB.get(0).getDescription(), reportsInDB.get(0).getReportedBy(),
					reportsInDB.get(0).getReportedDate(), reportsInDB.get(0).getAssigned(), reportsInDB.get(0).getRequested(),
					reportsInDB.get(0).getAssignedDate(), reportsInDB.get(0).getAssignedTime(), reportsInDB.get(0).getAssignedTo(),
					reportsInDB.get(0).getEstimateOfRepairs());
			request.setAttribute("REPORT", selectedReport);
			getServletContext().getRequestDispatcher("/ViewMarReportFM.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("listSpecificMarReport3")) 
		{			
			ArrayList<MarReport> reportsInDB = new ArrayList<MarReport>();
			MarReport selectedReport = new MarReport();
			reportsInDB = MarReportDAO.searchSpecificReport(request.getParameter("id"));

			selectedReport.setReport(reportsInDB.get(0).getMarNumber(), reportsInDB.get(0).getFacilityName(),
					reportsInDB.get(0).getUrgency(), reportsInDB.get(0).getDescription(), reportsInDB.get(0).getReportedBy(),
					reportsInDB.get(0).getReportedDate(), reportsInDB.get(0).getAssigned(), reportsInDB.get(0).getRequested(),
					reportsInDB.get(0).getAssignedDate(), reportsInDB.get(0).getAssignedTime(), reportsInDB.get(0).getAssignedTo(),
					reportsInDB.get(0).getEstimateOfRepairs());
			request.setAttribute("REPORT", selectedReport);
			getServletContext().getRequestDispatcher("/ViewMarReportUser.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("listSpecificMarReport1")) 
		{			
			ArrayList<MarReport> reportsInDB = new ArrayList<MarReport>();
			MarReport selectedReport = new MarReport();
			reportsInDB = MarReportDAO.searchSpecificReport(request.getParameter("id"));

			selectedReport.setReport(reportsInDB.get(0).getMarNumber(), reportsInDB.get(0).getFacilityName(),
					reportsInDB.get(0).getUrgency(), reportsInDB.get(0).getDescription(), reportsInDB.get(0).getReportedBy(),
					reportsInDB.get(0).getReportedDate(), reportsInDB.get(0).getAssigned(), reportsInDB.get(0).getRequested(),
					reportsInDB.get(0).getAssignedDate(), reportsInDB.get(0).getAssignedTime(), reportsInDB.get(0).getAssignedTo(),
					reportsInDB.get(0).getEstimateOfRepairs());
			request.setAttribute("REPORT", selectedReport);
			getServletContext().getRequestDispatcher("/RequestMAR.jsp").forward(request, response);
		}		
		else if(action.equalsIgnoreCase("listRequests"))
		{		
			ArrayList<MarReport> requestsInDB = new ArrayList<MarReport>();
			requestsInDB = MarReportDAO.listRequests(request.getParameter("id"));
			request.setAttribute("ALL_REQUESTS", requestsInDB);
			getServletContext().getRequestDispatcher("/ViewRequestsFM.jsp").forward(request, response);
		}
		

		else if (action.equalsIgnoreCase("searchAllMARs"))
		{
			ArrayList<MarReport> reportsInDB = new ArrayList<MarReport>();
			reportsInDB = MarReportDAO.searchAllReports();
			request.setAttribute("ALL_REPORTS", reportsInDB);
			getServletContext().getRequestDispatcher("/allMARsFM.jsp").forward(request, response);
		}
		
		
		else if(action.equalsIgnoreCase("listSpecificAssignedMar"))
		{
			ArrayList<MarReport> reportsInDB = new ArrayList<MarReport>();
			reportsInDB = MarReportDAO.listSpecificAssignedMar(request.getParameter("id"));
			MarReport selectedReport = new MarReport();

			selectedReport.setReport(reportsInDB.get(0).getMarNumber(), reportsInDB.get(0).getFacilityName(),
					reportsInDB.get(0).getUrgency(), reportsInDB.get(0).getDescription(), reportsInDB.get(0).getReportedBy(),
					reportsInDB.get(0).getReportedDate(), reportsInDB.get(0).getAssigned(), reportsInDB.get(0).getRequested(),
					reportsInDB.get(0).getAssignedDate(), reportsInDB.get(0).getAssignedTime(), reportsInDB.get(0).getAssignedTo(),
					reportsInDB.get(0).getEstimateOfRepairs());
			
			request.setAttribute("REPORT", selectedReport);
			getServletContext().getRequestDispatcher("/ViewAssignedMarReportFM.jsp").forward(request, response);
		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
