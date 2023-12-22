package com.venClosed.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "venue_closed_date")
public class VenClosedVO implements java.io.Serializable {
	
	@Id
	@Column(name = "closed_date_id")
	private	Integer	closedDateId;
	
	@Column(name = "ven_id")
	private	Integer	venId;
	
	@Column(name = "closed_date")
	private	Date	closedDate;
	
	@Column(name = "closed_reason")
	private	String	closedReason;
	
	public VenClosedVO() {
		super();
	}

	public VenClosedVO(Integer closedDateId, Integer venId, Date closedDate, String closedReason) {
		super();
		this.closedDateId = closedDateId;
		this.venId = venId;
		this.closedDate = closedDate;
		this.closedReason = closedReason;
	}

	public Integer getClosedDateId() {
		return closedDateId;
	}

	public void setClosedDateId(Integer closedDateId) {
		this.closedDateId = closedDateId;
	}

	public Integer getVenId() {
		return venId;
	}

	public void setVenId(Integer venId) {
		this.venId = venId;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getClosedReason() {
		return closedReason;
	}

	public void setClosedReason(String closedReason) {
		this.closedReason = closedReason;
	}
	
	
}
