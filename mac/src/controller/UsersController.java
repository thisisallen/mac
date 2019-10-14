package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import data.MarReportDAO;
import data.UsersDAO;
import model.MarReport;
import model.UserErrorMsgs;
import model.Users;

/**
 * Servlet implementation class UsersController
 */
@WebServlet("/UsersController")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session = null;
	
	private void getUserParam(HttpServletRequest request, Users user) {
		user.setUser(request.getParameter("username"), request.getParameter("password"), request.getParameter("firstName"), request.getParameter("lastName"),
				request.getParameter("utaID"), Integer.parseInt(request.getParameter("role")), request.getParameter("email"), request.getParameter("phone"),
				request.getParameter("address"), request.getParameter("city"), request.getParameter("state"), request.getParameter("zipCode"));  
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersController() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getParameter("action"), url = "";
		session = request.getSession();
		String loggedInUsername = (String) session.getAttribute("loggedInUser");

		if (action.equalsIgnoreCase("logout")) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}

		if (action.equalsIgnoreCase("viewProfile")) {
			ArrayList<Users> userDataInDB = new ArrayList<Users>();
			Users selectedUser;

			userDataInDB = UsersDAO.getProfile(loggedInUsername);

			int roleNumber = userDataInDB.get(0).getRole();
			String roleName = "";

			switch (roleNumber) {
			case 1:
				roleName = "User";
				url = "/userProfile.jsp";
				break;
			case 2:
				roleName = "Repairman";
				url = "/repairmanProfile.jsp";
				break;
			case 3:
				roleName = "Facility Manager";
				url = "/facilityManagerProfile.jsp";
				break;
			case 4:
				roleName = "Admin";
				url = "/adminProfile.jsp";
				break;
			default:
				roleName = "Undefined";
			}

			selectedUser = new Users(userDataInDB.get(0).getUsername(), userDataInDB.get(0).getPassword(),
					userDataInDB.get(0).getFirstName(), userDataInDB.get(0).getLastName(),
					userDataInDB.get(0).getUtaID(), userDataInDB.get(0).getRole(), userDataInDB.get(0).getEmail(),
					userDataInDB.get(0).getPhone(), userDataInDB.get(0).getAddress(), userDataInDB.get(0).getCity(),
					userDataInDB.get(0).getState(), userDataInDB.get(0).getZipCode());

			session.setAttribute("USERINFO", selectedUser);
			session.setAttribute("ROLE", roleName);
			session.setAttribute("UTAID", userDataInDB.get(0).getUtaID());
			session.setAttribute("ADDRESS", userDataInDB.get(0).getAddress());

			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		

		else if (action.equalsIgnoreCase("searchAllMARs"))
		{
			ArrayList<MarReport> reportsInDB = new ArrayList<MarReport>();
			reportsInDB = MarReportDAO.searchAllReports2(loggedInUsername);
			request.setAttribute("ALL_REPORTS", reportsInDB);
			getServletContext().getRequestDispatcher("/MARReported.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users user = new Users();
		String action = request.getParameter("action"), url = "";
		HttpSession session = request.getSession();

		UserErrorMsgs CerrorMsgs = new UserErrorMsgs();
		session.removeAttribute("errorMsgs");
		
		if (action.equalsIgnoreCase("register")) {
			getUserParam(request, user);
			user.validateUser(action, user, CerrorMsgs);
			session.setAttribute("user", user);
			session.setAttribute("errorMsgs", CerrorMsgs);
			
			if (!CerrorMsgs.getErrorMsg().equals("")) {  //there are errors
				getUserParam(request, user);
				session.setAttribute("errorMsgs", CerrorMsgs);
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			} else {  //no errors
				UsersDAO.registerUser(user);
				request.setAttribute("MESSAGE", "Registration successful!");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("login")) {
			// when we hit the login button in the jsp file, it will send the username and
			// password in the request object
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int role = 0;

			user = new Users(username, password);
			user.setUser(username, password);
			session.removeAttribute("errorMsgs");

			ArrayList<Users> selectedUser = UsersDAO.loginUser(user);
			if (!selectedUser.isEmpty()) {  //username and password are correct
				role = selectedUser.get(0).getRole();

				if (role != 0) {  //user and password are correct and the role was read correctly
					// create the user session
					session = request.getSession();
					session.setAttribute("loggedInUser", username);

					switch (role) {
					case 1:
						url = "/userHome.jsp";
						break;
					case 2:
						url = "/repairmanHome.jsp";
						break;
					case 3:
						url = "/facilityManagerHome.jsp";
						break;
					case 4:
						url = "/adminHome.jsp";
						break;
					default:
						System.out.print("default");
						url = "/login.jsp";
					}
				} 
				else 
				{		//something went role, the system didnt read the role correctly
					System.out.print("error");
					url = "/login.jsp";
					request.setAttribute("LOGIN_ERROR", "Something went wrong! Try again!");
				}
				getServletContext().getRequestDispatcher(url).forward(request, response);
			} 
			else 
			{     //username and/ or password are incorrect
				request.setAttribute("LOGIN_ERROR", "Incorrect username and/or password! Try again!");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("updateProfile")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String confirm = request.getParameter("confirm_password");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String utaID = request.getParameter("utaID");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zipCode = request.getParameter("zipCode");

			String loggedUsername = (String) session.getAttribute("loggedInUser");

			String query = "";
			String updates = "";

			if (username != "")
				updates += " username = '" + username + "'";
			if (password != "")
				updates += " password = '" + password + "'";
			if (firstName != "")
				updates += " firstName = '" + firstName + "'";
			if (lastName != "")
				updates += " lastName = '" + lastName + "'";
			if (utaID != "")
				updates += " utaID = '" + utaID + "'";
			if (phone != "")
				updates += " phone = '" + phone + "'";
			if (email != "")
				updates += " email = '" + email + "'";
			if (address != "")
				updates += " streetAddress = '" + address + "'";
			if (city != "")
				updates += " City = '" + city + "'";
//			if(state!="") updates += " state = '" + state + "'";
			if (zipCode != "")
				updates += " zipCode = '" + zipCode + "'";

			query = "UPDATE users SET" + updates + " WHERE username LIKE '" + loggedUsername + "';";

			ArrayList<Users> userInSession = new ArrayList<Users>();
			userInSession = UsersDAO.updateProfile(loggedUsername, query);

			Users userData = new Users();

			userData.setUser(userInSession.get(0).getUsername(), userInSession.get(0).getPassword(),
					userInSession.get(0).getFirstName(), userInSession.get(0).getLastName(),
					userInSession.get(0).getUtaID(), userInSession.get(0).getRole(), userInSession.get(0).getEmail(),
					userInSession.get(0).getPhone(), userInSession.get(0).getAddress(), userInSession.get(0).getCity(),
					userInSession.get(0).getState(), userInSession.get(0).getZipCode());

			session.setAttribute("USERINFO", userData);

			response.sendRedirect("/mac/UsersController?action=viewProfile");
//			getServletContext().getRequestDispatcher(url).forward(request, response);
		} else if (action.equalsIgnoreCase("createMAR")) {
			String facilityName = request.getParameter("facilityName");
			String urgency = request.getParameter("urgency");
			String description = request.getParameter("description");
			String reportedBy = (String) session.getAttribute("loggedInUser");
			String reportedDate = request.getParameter("date");

			MarReport report = new MarReport(facilityName, urgency, description, reportedBy, reportedDate);

			MarReportDAO.createMAR(report);

			url = "/createMARUser.jsp?status=Success&msg=MAR created successfully!";

			request.setAttribute("MSG",
					"Mar was created successfully!!");

			getServletContext().getRequestDispatcher(url).forward(request, response);

		}
	}

}
