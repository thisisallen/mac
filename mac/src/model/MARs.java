package model;

//dhruv's code
public class MARs {
	private String facility = "";
	private String name = "";
	private String urgency = "";
	private String description = "";
	private String reportedby = "";
	private String date = "";
	private String req = "";
	private String marNumber = "";

	// default constructor, everything is null
	public MARs() {
		this.facility = "";
		this.name = "";
		this.urgency = "";
		this.description = "";
		this.reportedby = "";
		this.date = "";
		this.req = "";
		this.marNumber = "";
	}

	// overloaded constructor, takes values entered, usually for report problem
	public MARs(String facility, String name, String urgency, String description, String reportedby, String date,
			String req, String MARnumber) {
		this.facility = facility;
		this.name = name;
		this.urgency = urgency;
		this.description = description;
		this.reportedby = reportedby;
		this.date = date;
		this.req = req;
		this.marNumber = MARnumber;
	}

	// used to update MAR
	public void setMARs(String facility, String name, String urgency, String description, String reportedby,
			String date, String req, String MARnumber) {
		this.facility = facility;
		this.name = name;
		this.urgency = urgency;
		this.description = description;
		this.reportedby = reportedby;
		this.date = date;
		this.req = req;
		this.marNumber = MARnumber;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getFacility() {
		return facility;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setUrgency(String uegency) {
		this.urgency = uegency;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setReportedby(String reportedby) {
		this.reportedby = reportedby;
	}

	public String getReportedby() {
		return reportedby;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public String getReq() {
		return req;
	}

	public void setMARnumber(String MARnumber) {
		this.marNumber = MARnumber;
	}

	public String getMARnumber() {
		return marNumber;
	}
}
