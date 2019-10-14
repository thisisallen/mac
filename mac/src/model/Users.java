package model;

import data.UsersDAO;

public class Users {
	private String username = "";
	private String password = "";
	private String firstName = "";
	private String lastName = "";
	private String utaID = "";
	private int role = 0;
	private String roleName = "";
	private String email = "";
	private String phone = "";
	private String streetAddress = "";
	private String city = "";
	private String state = "";
	private String zipCode = "";

	// default constructor, everything is null
	public Users() {
		this.username = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.utaID = "";
		this.role = 0;
		this.email = "";
		this.phone = "";
		this.streetAddress = "";
		this.city = "";
		this.state = "";
		this.zipCode = "";
	}

	// overloaded constructor, takes values entered, usually for login
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// overloaded constructor, takes values entered, usually for register or
	// retrieving user data
	public Users(String username, String password, String firstName, String lastName, String utaID, int role,
			String email, String phone, String address, String city, String state, String zipCode) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.utaID = utaID;
		this.role = role;
		this.email = email;
		this.phone = phone;
		this.streetAddress = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public Users(String username, String password, String firstName, String lastName, int role, String email, String phone) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.email = email;
		this.phone = phone;
	}

	public void setUser(String username, String password, String firstName, String lastName, String utaID, int role,
			String email, String phone, String address, String city, String state, String zipCode) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.utaID = utaID;
		this.email = email;
		this.phone = phone;
		this.streetAddress = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public void setUser(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getRole() {
		return role;
	}

	public void setUtaID(String utaID) {
		this.utaID = utaID;
	}

	public String getUtaID() {
		return utaID;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setAddress(String address) {
		this.streetAddress = address;
	}

	public String getAddress() {
		return streetAddress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void validateUser(String action, Users user, UserErrorMsgs errorMsgs) {
//		if (action.equals("login")) {
//
//			errorMsgs.setUsernameError(validateUsername(user.getUsername()));
//			errorMsgs.setPasswordError(validatePassword(user.getPassword()));
//			errorMsgs.setErrorMsg();
//		} else 
		if (action.equals("register")) {

			errorMsgs.setUsernameError(validateUsername(user.getUsername()));
			errorMsgs.setPasswordError(validatePassword(user.getPassword()));

			errorMsgs.setFirstNameError(validateFirstName(user.getFirstName()));
			errorMsgs.setLastNameError(validateLastName(user.getLastName()));
			errorMsgs.setEmailError(validateEmail(user.getEmail()));
			errorMsgs.setPhoneError(validatePhone(user.getPhone()));

			errorMsgs.setStreetError(validateStreet(user.getPassword()));
			errorMsgs.setCityError(validateCity(user.getCity()));
			errorMsgs.setZipError(validateZip(user.getZipCode()));
			errorMsgs.setUtaIDError(validateutaID(user.getUtaID()));

			errorMsgs.setErrorMsg();
		}

	}

	private String validateUsername(String username) {
		String result = "";
		if (!stringSize(username, 3, 45))
			result = "Username must between 3 and 45 characters";
		else if (Character.isLowerCase(username.charAt(0)))
			result = "Username must start with a capital letter";
		else
			if (!UsersDAO.UsernameUnique(username))
				result="Username already in database. Choose another username!";
		return result;
	}

	private String validatePassword(String password) {
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#_$%^&+=])(?=\\S+$).{8,32}$";
		String result="";
		
		System.out.print(password.matches(pattern));
		
		if (!password.matches(pattern))
			result = "Length=8-32. Must contain at least one uppercase, one lowercase, one digit and one special character. No spaces allowed.";
		
		return result;
	}
	
	private String validateFirstName(String name) {
		String result = "";
		if (!stringSize(name, 3, 45))
			result = "Username must between 3 and 45 characters";
		else if (Character.isLowerCase(name.charAt(0)))
			result = "Username must start with a capital letter";
		return result;
	}

	private String validateLastName(String name) {
		String result = "";
		if (!stringSize(name, 3, 45))
			result = "Username must between 3 and 45 characters";
		else if (Character.isLowerCase(name.charAt(0)))
			result = "Username must start with a capital letter";
		return result;
	}

	private String validateutaID(String utaid) {
		String result = "";
		if (utaid.length() != 10)
			result = "UTA ID  must be 10 digits in length";
		else if (!isTextAnInteger(utaid))
			result = "UTA ID must be a number";
		return result;
	}

	private String validatePhone(String phone) {
		String result = "";
		if (phone.length() != 10)
			result = "Phone number must be 10 digits in length";
		else if (!isTextAnInteger(phone))
			result = "Phone number must be a number";
		return result;
	}

	private String validateEmail(String email) {
		String result = "", extension = "";
		if (!email.contains("@"))
			result = "Email address needs to contain @";
		else if (!stringSize(email, 7, 45))
			result = "Email address must be between 7 and 45 characters long";
		else {
			extension = email.substring(email.length() - 4, email.length());
			if (!extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com")
					&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil"))
				result = "Invalid domain name";
		}
		return result;
	}
	
	private String validateStreet(String street) {
		String result = "";
		if (!stringSize(street, 3, 65))
			result = "Username must between 3 and 65 characters";
		return result;
	}

	private String validateCity(String city) {
		String result = "";
		if (!stringSize(city, 3, 35))
			result = "Username must between 3 and 35 characters";
		return result;
	}

	private String validateZip(String zip) {
		String result = "";
		if (zip.length() != 5)
			result = "Zip code must be 5 digits in length";
		else if (!isTextAnInteger(zip))
			result = "Zip code  must be a number";
		return result;
	}

	// This section is for general purpose methods used internally in this class

	private boolean stringSize(String string, int min, int max) {
		return string.length() >= min && string.length() <= max;
	}

	private boolean isTextAnInteger(String string) {
		boolean result;
		try {
			Long.parseLong(string);
			result = true;
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}

}