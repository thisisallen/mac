package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.AdminDAO;
import data.MarReportDAO;
import data.RepairmanDAO;
import data.UsersDAO;
import model.Assigned_Mars;
import model.MarReport;
import model.RequestedMAR;
import model.Users;

/**
 * Servlet implementation class RepairmanController
 */
@WebServlet("/RepairmanController")
public class RepairmanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairmanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String action = request.getParameter("action"), url="";
    	session = request.getSession();
		String loggedInUsername= (String) session.getAttribute("loggedInUser");
		
		if (action.equalsIgnoreCase("viewAssignedRepairs") ) 
		{ 
			ArrayList<Assigned_Mars> assigned_mars = RepairmanDAO.searchAssignedMars(loggedInUsername);
			request.setAttribute("ASSIGNED_MARS", assigned_mars);
	
			url = "/viewAssignedMarsRepairman.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		
		
		else if (action.equalsIgnoreCase("viewRequestedRepairs") ) 
		{
			ArrayList<RequestedMAR> requested_mars = RepairmanDAO.searchRequestedMars(loggedInUsername);
			request.setAttribute("REQUESTED_MARS", requested_mars);
	
			url = "/ViewMyRequests.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		
		else if (action.equalsIgnoreCase("listSpecificRepair")) {
			ArrayList<Assigned_Mars> reportInDB = new ArrayList<Assigned_Mars>();
			Assigned_Mars selectedMAR = new Assigned_Mars();
			reportInDB = RepairmanDAO.searchSpecificRepair(request.getParameter("id"));

			selectedMAR.setAssigned_Mars(reportInDB.get(0).getAssignedID(), reportInDB.get(0).getMarNumber(), reportInDB.get(0).getAssignedTo(), 
					reportInDB.get(0).getAssignedDate(), reportInDB.get(0).getAssignedTime(), reportInDB.get(0).getEstimateOfRepairs());
			selectedMAR.setFacilityName(reportInDB.get(0).getFacilityName());
			selectedMAR.setUrgency(reportInDB.get(0).getUrgency());
			selectedMAR.setDescription(reportInDB.get(0).getDescription());
			
			request.setAttribute("REPORT", selectedMAR);
			session.setAttribute("MARINFO", selectedMAR);
			getServletContext().getRequestDispatcher("/listSpecificRepairRepairman.jsp").forward(request, response);

		}
		else if (action.equalsIgnoreCase("displayMARForUpdate"))
		{
			ArrayList<Assigned_Mars> reportInDB = new ArrayList<Assigned_Mars>();
			Assigned_Mars selectedMAR = new Assigned_Mars();
			reportInDB = RepairmanDAO.searchSpecificRepair(request.getParameter("id"));

			selectedMAR.setAssigned_Mars(reportInDB.get(0).getAssignedID(), reportInDB.get(0).getMarNumber(), reportInDB.get(0).getAssignedTo(), 
					reportInDB.get(0).getAssignedDate(), reportInDB.get(0).getAssignedTime(), reportInDB.get(0).getEstimateOfRepairs());
			request.setAttribute("REPORT", selectedMAR);
			session.setAttribute("MARINFO", selectedMAR);
			getServletContext().getRequestDispatcher("/updateAssignedMar.jsp").forward(request, response);
		}	
		else if (action.equalsIgnoreCase("deleteSpecificRepair")) 
		{
			String mar = request.getParameter("id2");
			String assigned = request.getParameter("id");		       
			RepairmanDAO.deleteSpecificRepair(assigned);
			MarReportDAO.assignRepairmanNO(mar);
			getServletContext().getRequestDispatcher("/repairmanHome.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("searchAllMARs"))
		{ 
			ArrayList<MarReport> reportsInDB = new ArrayList<MarReport>();
			reportsInDB = MarReportDAO.searchAllReports1();
			request.setAttribute("ALL_REPORTS", reportsInDB);
			getServletContext().getRequestDispatcher("/availableMARsRepairman.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("listSpecificMarReport")) 
		{
			String mar = request.getParameter("id");
			RepairmanDAO.requestedMar(mar,loggedInUsername);
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Repairman repairman;
		String action = request.getParameter("action"), url = "";
		HttpSession session = request.getSession();
		String loggedInUsername= (String) session.getAttribute("loggedInUser");
		
		if (action.equalsIgnoreCase("listSpecificMarReport"))
		{            
			String marNumber = request.getParameter("id");
		    RepairmanDAO.requestedMar(marNumber,loggedInUsername);

			response.sendRedirect("login.jsp");
		}
		else if (action.equalsIgnoreCase("editAssignedRepairs")) 
		{
			String estimate = request.getParameter("estimate");
			String id = request.getParameter("id");
			RepairmanDAO.editSpecificRepair(estimate, id);
			 
			response.sendRedirect("/mac/RepairmanController?action=viewAssignedRepairs");
//			getServletContext().getRequestDispatcher("/RepairmanController?action=viewAssignedRepairs").forward(request, response);
		}
		else if (action.equalsIgnoreCase("requestMAR")) 
		{
			String estimate = request.getParameter("estimate");
			String mar = request.getParameter("id");
			String date =  request.getParameter("date");
			RequestedMAR request1 = new RequestedMAR(mar, date,estimate);
			getServletContext().getRequestDispatcher("/repairmanHome.jsp").forward((ServletRequest) request1, response);
		}
		else if (action.equalsIgnoreCase("request1")) 
		{
            String mar = request.getParameter("id");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String estimate = request.getParameter("estimate");
			String a = "Successfully Requested";
			RepairmanDAO.createRequest(mar,loggedInUsername,date, time, estimate);
			RepairmanDAO.changeMAR(mar);
			request.setAttribute("MESSAGE", a);
			response.sendRedirect("/mac/RepairmanController?action=searchAllMARs");
			
		}
	}
}
