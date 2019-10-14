package model;

public class MarReport {
	private String facilityName;
	private String urgency;
	private String description;
	private String reportedBy;
	private String reportedDate;
	private String marNumber;
	private String assigned;
	private String requested;
	private String assignedID;
	private String assignedDate;
	private String assignedTime;
	private String assignedTo;
	private String estimateOfRepairs;
	private String requestID;
	private String requestedBy;
	private String requestedDate;
	private String requestedTime;
	
	public MarReport()
	{
		this.facilityName="";
		this.urgency="";
		this.description="";
		this.reportedBy="";
		this.reportedDate="";
		this.marNumber="";
		this.assigned="";
		this.requested="";
		this.assignedID="";
		this.assignedDate="";
		this.assignedTime="";
		this.assignedTo="";
		this.estimateOfRepairs="";
		this.requestID="";
		this.requestedBy="";
		this.requestedDate="";
		this.requestedTime="";

	}
	
	public MarReport(String facilityName, String urgency, String description, String reportedBy, String reportedDate)
	{
		long random1 = Math.round(Math.random()*(999-100)+100);
		long random2 = Math.round(Math.random()*(999-100)+100);
		
		this.facilityName=facilityName;
		this.urgency=urgency;
		this.description=description;
		this.reportedBy=reportedBy;
		this.reportedDate=reportedDate;
		this.marNumber="MAR " + random1 + "-" + random2;
		this.assigned="NO";
		this.requested="NO";
		this.assignedID="TBD";
		this.assignedDate="TBD";
		this.assignedTime="TBD";
		this.assignedTo="TBD";
		this.estimateOfRepairs="TBD";
		this.requestID="TBD";
		this.requestedBy="TBD";
		this.requestedDate="TBD";
		this.requestedTime="TBD";
	}
	
	public void setAssignedReport(String facilityName, String urgency, String description, String reportedBy, String reportedDate, String marNumber, String assigned, String requested, String assignedTo, String assignedDate, String assignedTime, String estimateOfRepairs)
	{
		this.facilityName=facilityName;
		this.urgency=urgency;
		this.description=description;
		this.reportedBy=reportedBy;
		this.reportedDate=reportedDate;
		this.marNumber=marNumber;
		this.assigned=assigned;
		this.requested=requested;
		this.assignedDate=assignedDate;
		this.assignedTime=assignedTime;
		this.assignedTo=assignedTo;
		this.estimateOfRepairs=estimateOfRepairs;
	}
	
	public void setRequestedFacility(String facilityName, String urgency, String description, String reportedBy, String reportedDate, String marNumber, String assigned, String requested, String assignedTo, String assignedDate, String assignedTime, String estimateOfRepairs)
	{
		long random1 = Math.round(Math.random()*(999-100)+100);
		long random2 = Math.round(Math.random()*(999-100)+100);
		
		this.facilityName=facilityName;
		this.urgency=urgency;
		this.description=description;
		this.reportedBy=reportedBy;
		this.reportedDate=reportedDate;
		this.marNumber=marNumber;
		this.assigned=assigned;
		this.requested=requested;
		this.assignedDate=assignedDate;
		this.assignedTime=assignedTime;
		this.assignedTo=assignedTo;
		this.estimateOfRepairs=estimateOfRepairs;
	}
	public void setReport(String marNumber, String facilityName, String urgency, String description,
			String reportedBy, String reportedDate, String assigned, String requested, String assignedDate,
			String assignedTime, String assignedTo, String estimateOfRepairs) {
		this.marNumber = marNumber;
		this.facilityName = facilityName;
		this.urgency = urgency;
		this.description = description;
		this.reportedBy = reportedBy;
		this.reportedDate = reportedDate;
		this.assigned = assigned;
		this.requested =requested;
		this.assignedDate = assignedDate;
		this.assignedTime = assignedTime;
		this.assignedTo = assignedTo;
		this.estimateOfRepairs = estimateOfRepairs;		
	}
	
	public void setFacilityName(String facilityName)
	{
		this.facilityName = facilityName;
	}
	
	public String getFacilityName()
	{
		return this.facilityName;
	}
	
	public void setUrgency(String urgency)
	{
		this.urgency = urgency;
	}
	
	public String getUrgency()
	{
		return this.urgency;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setReportedBy(String reportedBy)
	{
		this.reportedBy = reportedBy;
	}
	
	public String getReportedBy()
	{
		return this.reportedBy;
	}
	
	public void setReportedDate(String reportedDate)
	{
		this.reportedDate = reportedDate;
	}
	
	public String getReportedDate()
	{
		return this.reportedDate;
	}
	
	public void setMarNumber(String marNumber)
	{
		this.marNumber = marNumber;
	}
	
	public String getMarNumber()
	{
		return this.marNumber;
	}
	
	public void setAssigned(String assigned)
	{
		this.assigned = assigned;
	}
	
	public String getAssigned()
	{
		return this.assigned;
	}
	
	public void setRequested(String requested)
	{
		this.requested = requested;
	}
	
	public String getRequested()
	{
		return this.requested;
	}
	
	public void setAssignedID(String assignedID)
	{
		this.assignedID = assignedID;
	}
	public String getAssignedID()
	{
		return this.assignedID;
	}
	
	public void setAssignedDate(String assignedDate)
	{
		this.assignedDate = assignedDate;
	}
	
	public String getAssignedDate()
	{
		return this.assignedDate;
	}
	
	public void setAssignedTime(String assignedTime)
	{
		this.assignedTime = assignedTime;
	}
	
	public String getAssignedTime()
	{
		return this.assignedTime;
	}
	
	public void setAssignedTo(String assignedTo)
	{
		this.assignedTo = assignedTo;
	}
	
	public String getAssignedTo()
	{
		return this.assignedTo;
	}
	
	public void setEstimateOfRepairs(String estimateOfRepairs)
	{
		this.estimateOfRepairs = estimateOfRepairs;
	}
	
	public String getEstimateOfRepairs()
	{
		return this.estimateOfRepairs;
	}
	
	public void setRequestID(String requestID)
	{
		this.requestID = requestID;
	}
	
	public String getRequestID()
	{
		return this.requestID;
	}
	public void setRequestedBy(String requestedBy)
	{
		this.requestedBy = requestedBy;
	}
	
	public String getRequestedBy()
	{
		return this.requestedBy;
	}
	public void setRequestedDate(String requestedDate)
	{
		this.requestedDate = requestedDate;
	}
	
	public String getRequestedDate()
	{
		return this.requestedDate;
	}
	
	public void setRequestedTime(String requestedTime)
	{
		this.requestedTime = requestedTime;
	}
	
	public String getRequestedTime()
	{
		return this.requestedTime;
	}
}
