package model;

public class FacilityManager {
	private String facilityType = "";
	private String facilityName = "";
	private String duration = "";
	private String timeInterval = "";
	private String venue = "";

	public FacilityManager(String facilityName, String facilityType, String duration, String timeInterval, String venue) {
		super();
		this.facilityName = facilityName;
		this.facilityType = facilityType;
		this.duration = duration;
		this.timeInterval = timeInterval;
		this.venue = venue;
	}

	public FacilityManager() {
		// TODO Auto-generated constructor stub
	}

	public void setFacility(String facilityName, String facilityType, String duration, String timeInterval, String venue) {

		setFacilityName(facilityName);
		setFacilityType(facilityType);
		setDuration(duration);
		setTimeInterval(timeInterval);
		setVenue(venue);

	}


	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}
}