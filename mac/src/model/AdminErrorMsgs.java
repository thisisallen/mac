package model;

public class AdminErrorMsgs {
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg() {
		if (!nameError.equals("") )
			this.errorMsg = "Please correct the following errors";
	}

	public String getNameError() {
		return nameError;
	}

	public void setNameError(String nameError) {
		this.nameError = nameError;
	}

	private String errorMsg;
	private String nameError;

	public AdminErrorMsgs() {
		this.errorMsg = "";
		this.nameError = "";
		
	}


}
