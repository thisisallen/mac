package model;

import java.sql.Date;
import java.sql.Time;

public class Assigned_Mars {

	private int assignedID;
	private String marNumber;
	private String facilityName;
	private String urgency;
	private String description;
	private String assignedTo;
	private String assignedDate;
	private String assignedTime;
	private String estimateOfRepairs;

	public int getAssignedID() {
		return assignedID;
	}
	public void setAssignedID(int assignedID) {
		this.assignedID = assignedID;
	}

	public String getMarNumber() {
		return marNumber;
	}
	public void setMarNumber(String marNumber) {
		this.marNumber = marNumber;
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
	
	public void setFacilityName(String name)
	{
		this.facilityName = name;
	}
	public String getFacilityName()
	{
		return this.facilityName;
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

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Assigned_Mars(int assignedID, String marNumber, String assignedTo, String assignedDate, String assignedTime,
			String estimateOfRepairs) {
		super();
		this.assignedID = assignedID;
		this.marNumber = marNumber;
		this.assignedTo = assignedTo;
		this.assignedDate = assignedDate;
		this.assignedTime = assignedTime;
		this.estimateOfRepairs = estimateOfRepairs;
	}

	public Assigned_Mars() {
		// TODO Auto-generated constructor stub
	}

	public void setAssigned_Mars(String marNumber, String assignedTo, String assignedDate, String assignedTime,
			String estimateOfRepairs) {
		this.marNumber = marNumber;
		this.assignedTo = assignedTo;
		this.assignedDate = assignedDate;
		this.assignedTime = assignedTime;
		this.estimateOfRepairs = estimateOfRepairs;
	}
	
	public void setAssigned_Mars(int id, String marNumber, String assignedTo, String assignedDate, String assignedTime,
			String estimateOfRepairs) {
		this.assignedID = id;
		this.marNumber = marNumber;
		this.assignedTo = assignedTo;
		this.assignedDate = assignedDate;
		this.assignedTime = assignedTime;
		this.estimateOfRepairs = estimateOfRepairs;
	}
	
	@Override
	public String toString() {
		return "Assigned_Mars [assignedID=" + assignedID + ", marNumber=" + marNumber + ", assignedTo=" + assignedTo
				+ ", assignedDate=" + assignedDate + ", assignedTime=" + assignedTime + ", estimateOfRepairs="
				+ estimateOfRepairs + "]";
	}

}
