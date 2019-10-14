package model;

public class Admin {
	private String name = "";

	// default constructor, everything is null
	public Admin() {
		this.name = "";
	}

	public Admin(String name) {
		this.name = name;
	}

	public void setUser(String name) {
		this.name = name;
	}

	public void setName(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}
	
	public void validateUser(String action, Admin admin, AdminErrorMsgs errorMsgs) {
		if (action.equals("searchSpecificUser")) {
			
			errorMsgs.setNameError(validateLastName(admin.getName()));
			
			errorMsgs.setErrorMsg();
		}
			}

	
	private String validateLastName(String company_name) {
		String result="";
		if (!stringSize(company_name,3,45))
			result= "Last Name must between 3 and 45 characters";
//		else
//			if (Character.isLowerCase(company_name.charAt(0)))
//				result="Last Name must start with a capital letter";
		return result;		
	}
	
	
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}
	
	
}