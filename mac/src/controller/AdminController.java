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
import model.Admin;
import model.AdminErrorMsgs;
import model.Users;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
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
		Admin admin;
		String action = request.getParameter("action"), url = "";
		HttpSession session = request.getSession();

		if (action.equalsIgnoreCase("listUsers")) {
			ArrayList<Users> usersInDB = new ArrayList<Users>();
			usersInDB = AdminDAO.listUsers();
			request.setAttribute("USER", usersInDB);
			System.out.println("right code");

			getServletContext().getRequestDispatcher("/ViewOtherUsersAdmin.jsp").forward(request, response);
		} 
		else if (action.equalsIgnoreCase("listSpecificUser")) {
			ArrayList<Users> userInDB = new ArrayList<Users>();
			Users selectedUser = new Users();
			userInDB = AdminDAO.searchUser(request.getParameter("id"));

			selectedUser.setUser(userInDB.get(0).getUsername(), userInDB.get(0).getPassword(),
					userInDB.get(0).getFirstName(), userInDB.get(0).getLastName(), userInDB.get(0).getUtaID(),
					userInDB.get(0).getRole(), userInDB.get(0).getEmail(), userInDB.get(0).getPhone(),
					userInDB.get(0).getAddress(), userInDB.get(0).getCity(), userInDB.get(0).getState(),
					userInDB.get(0).getZipCode());
			
			String roleName = "";
			
			switch(userInDB.get(0).getRole())
			{
			case 1:
				request.setAttribute("ROLE", "User");
				break;
			case 2:
				request.setAttribute("ROLE", "Repairman");
				break;
			case 3:
				request.setAttribute("ROLE", "Facility Manager");
				break;
			case 4:
				request.setAttribute("ROLE", "Admin");
				break;
			default:
				request.setAttribute("ROLE", "Undefined");
			}
			
			request.setAttribute("USERS", selectedUser);
			getServletContext().getRequestDispatcher("/ListSpecificUserAdmin.jsp").forward(request, response);
		} 
		else if (action.equalsIgnoreCase("listSpecificUser2")) {
			ArrayList<Users> userInDB = new ArrayList<Users>();
			Users selectedUser = new Users();
			userInDB = AdminDAO.searchUser(request.getParameter("id"));

			selectedUser.setUser(userInDB.get(0).getUsername(), userInDB.get(0).getPassword(),
					userInDB.get(0).getFirstName(), userInDB.get(0).getLastName(), userInDB.get(0).getUtaID(),
					userInDB.get(0).getRole(), userInDB.get(0).getEmail(), userInDB.get(0).getPhone(),
					userInDB.get(0).getAddress(), userInDB.get(0).getCity(), userInDB.get(0).getState(),
					userInDB.get(0).getZipCode());
			
			String roleName = "";
			
			switch(userInDB.get(0).getRole())
			{
			case 1:
				roleName = "User";
				break;
			case 2:
				roleName = "Repairman";
				break;
			case 3:
				roleName = "Facility Manager";
				break;
			case 4:
				roleName = "Admin";
				break;
				default:
					roleName = "Undefined";
			}
			request.setAttribute("USERS", selectedUser);
			request.setAttribute("ROLE", roleName);
			getServletContext().getRequestDispatcher("/ListSpecificUser2Admin.jsp").forward(request, response);
		} else {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		Users user;
		AdminErrorMsgs CerrorMsgs = new AdminErrorMsgs();
		HttpSession session= request.getSession();
		session.removeAttribute("errorMsgs");
		String action = request.getParameter("action"), url = "";
		
		if (action.equalsIgnoreCase("searchSpecificUser")) {
			ArrayList<Users> usersInDB = new ArrayList<Users>();
			String name = request.getParameter("last");
			session.removeAttribute("errorMsgs");
			admin.setUser(name);
			admin.validateUser(action,admin, CerrorMsgs);
			if (CerrorMsgs.getErrorMsg().equals("")) {
				usersInDB = AdminDAO.searchSpecificUser(name);
				request.setAttribute("USER", usersInDB);
				getServletContext().getRequestDispatcher("/ViewOtherUsersAdmin.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMsgs", CerrorMsgs);
				getServletContext().getRequestDispatcher("/ViewOtherUsersAdmin.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("editSpecificUser")) 
		{
			String username = request.getParameter("id");
			int role = Integer.parseInt(request.getParameter("role"));
//			user = new Users(username, password, firstName, lastName, utaID, role, email, phone, address, city, state, zipCode);
	
			AdminDAO.editUser(username, role);
			ArrayList<Users> userInDB = new ArrayList<Users>();
			Users selectedUser = new Users();
			userInDB=AdminDAO.searchUser(username);
				
			selectedUser.setUser(userInDB.get(0).getUsername(), userInDB.get(0).getPassword(), 
					userInDB.get(0).getFirstName(), userInDB.get(0).getLastName(), userInDB.get(0).getUtaID(),
					userInDB.get(0).getRole(),userInDB.get(0).getEmail(),
					userInDB.get(0).getPhone(),userInDB.get(0).getAddress(),userInDB.get(0).getCity(),
					userInDB.get(0).getState(),userInDB.get(0).getZipCode());
			
			String roleName = "";
			
			switch(selectedUser.getRole())
			{
			case 1:
				roleName = "User";
				break;
			case 2:
				roleName = "Repairman";
				break;
			case 3:
				roleName = "Facility Manager";
				break;
			case 4:
				roleName = "Admin";
				break;
				default:
					roleName = "Undefined";
			}
			request.setAttribute("USERS", selectedUser);
			request.setAttribute("ROLE", roleName);
			
			request.setAttribute("USERS", selectedUser);
			getServletContext().getRequestDispatcher("/ListSpecificUserAdmin.jsp").forward(request, response);
		}

	}

}
