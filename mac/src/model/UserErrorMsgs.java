package model;

public class UserErrorMsgs {

	private String usernameError;
	private String passwordError;
	private String firstNameError;
	private String lastNameError;
	private String phoneError;
	private String emailError;
	private String utaIDError;
	private String cityError;
	private String zipError;
	private String streetError;
	private String errorMsg;
	
	public UserErrorMsgs() {
		this.errorMsg = "";

		this.usernameError = "";
		this.passwordError = "";
		this.firstNameError= "";
		this.lastNameError = "";
		this.phoneError = "";
		this.emailError = "";
		this.utaIDError = "";
		this.cityError = "";
		this.zipError = "";
		this.streetError = "'";

	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg() {
		if (!usernameError.equals("") || !passwordError.equals("") || !firstNameError.equals("") || !lastNameError.equals("") || 
				!phoneError.equals("") || !emailError.equals("") || !utaIDError.equals("") || !cityError.equals("") || 
				!zipError.equals("") || !streetError.equals(""))
			this.errorMsg = "Please correct the following errors!";
//		this.errorMsg = errorMsg;
	}
	public void setLoginError(String msg)
	{
		this.errorMsg = msg;
	}
	
	public String getFirstNameError() {
		return firstNameError;
	}

	public void setFirstNameError(String firstNameError) {
		this.firstNameError = firstNameError;
	}

	public String getLastNameError() {
		return lastNameError;
	}

	public void setLastNameError(String lastNameError) {
		this.lastNameError = lastNameError;
	}

	public String getPhoneError() {
		return phoneError;
	}

	public void setPhoneError(String phoneError) {
		this.phoneError = phoneError;
	}

	public String getEmailError() {
		return emailError;
	}

	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}

	public String getUtaIDError() {
		return utaIDError;
	}

	public void setUtaIDError(String utaIDError) {
		this.utaIDError = utaIDError;
	}

	public String getCityError() {
		return cityError;
	}

	public void setCityError(String cityError) {
		this.cityError = cityError;
	}

	public String getZipError() {
		return zipError;
	}

	public void setZipError(String zipError) {
		this.zipError = zipError;
	}

	public String getStreetError() {
		return streetError;
	}

	public void setStreetError(String streetError) {
		this.streetError = streetError;
	}

	public String getPasswordError() {
		return passwordError;
	}

	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}

	public String getUsernameError() {
		return usernameError;
	}

	public void setUsernameError(String usernameError) {
		this.usernameError = usernameError;
	}
}