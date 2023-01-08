package net.sccc.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trip_requests")
public class TripReq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String travellerName;
	private String dateFrom;
	private String dateTo;
	private String interestBy;
	private String location;
	public String getTravellerName() {
		return travellerName;
	}
	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getInterestBy() {
		return interestBy;
	}
	public void setInterestBy(String interestBy) {
		this.interestBy = interestBy;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public TripReq(String dateFrom, String dateTo, String interestBy, String location, String travellerName) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.interestBy = interestBy;
		this.location = location;
		this.travellerName = travellerName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TripReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
