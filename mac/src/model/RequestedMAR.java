package model;

import java.sql.Date;
import java.sql.Time;

public class RequestedMAR {

	
	private String marNumber;
	private String facilityName;
	private String requestedBy;
	private String estimateOfRepairs;
	private String date;
	private String assignedDate;
	private String assignedTime;
	
	public RequestedMAR(String marNumber, String requestedBy, String estimateOfRepairs, String date) {
		super();
		this.marNumber = marNumber;
		this.requestedBy = requestedBy;
		this.estimateOfRepairs = estimateOfRepairs;
		this.date = date;
	}

	public void setFacilityName(String name)
	{
		this.facilityName = name;
	}
	public String getFacilityName()
	{
		return this.facilityName;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMarNumber() {
		return marNumber;
	}

	public void setMarNumber(String marNumber) {
		this.marNumber = marNumber;
	}

	public String getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

	public String getAssignedTime() {
		return assignedTime;
	}

	public void setAssignedTime(String assignedTime) {
		this.assignedTime = assignedTime;
	}

	public String getEstimateOfRepairs() {
		return estimateOfRepairs;
	}

	public void setEstimateOfRepairs(String estimateOfRepairs) {
		this.estimateOfRepairs = estimateOfRepairs;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}



	public RequestedMAR( String marNumber, String requestedBy, 
			String estimateOfRepairs) {
		super();
		
		this.marNumber = marNumber;
		this.requestedBy = requestedBy;
		this.assignedDate = assignedDate;
		this.assignedTime = assignedTime;
		this.estimateOfRepairs = estimateOfRepairs;
	}
	
	
	public RequestedMAR() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "RequestMAR [marNumber=" + marNumber + ", requestedBy=" + requestedBy
				+ ", assignedDate=" + assignedDate + ", assignedTime=" + assignedTime + ", estimateOfRepairs="
				+ estimateOfRepairs + "]";
	}
	
}
