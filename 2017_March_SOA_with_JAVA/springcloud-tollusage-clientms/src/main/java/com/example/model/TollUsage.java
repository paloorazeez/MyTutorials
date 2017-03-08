package com.example.model;


public class TollUsage {

	private String id;
	
	private String stationId;
	
	private String licensePlate;
	
	private String timeStamp;
	
	public TollUsage() {

	}

	public TollUsage(String id, String stationId, String licensePlate, String timeStamp) {
		super();
		this.id = id;
		this.stationId = stationId;
		this.licensePlate = licensePlate;
		this.timeStamp = timeStamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	
	
}
