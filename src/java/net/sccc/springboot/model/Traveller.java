package net.sccc.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trips")
public class Traveller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String location;
	private String dateFrom;
	private String dateTo;
	private String uuid;
	private String travellerName;
	private int interest;

	//private Date travelDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getUUID() {
		return uuid;
	}
	public void setUUID(String uUID) {
		uuid = uUID;
	}
	public Traveller(String location, String dateFrom, String dateTo, String uUID, String travellerName) {
		super();
		this.location = location;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.uuid = uUID;
		this.travellerName = travellerName;
	}
	public Traveller() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTravellerName() {
		return travellerName;
	}
	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	
	
}
