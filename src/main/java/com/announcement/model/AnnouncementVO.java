package com.announcement.model;

import java.sql.Timestamp;

public class AnnouncementVO implements java.io.Serializable {
	private Integer annId;
	private Integer empId;
	private String annName;
	private String annDescr;
	private Timestamp annTime;

	public Integer getAnnId() {
		return annId;
	}

	public void setAnnId(Integer annId) {
		this.annId = annId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getAnnName() {
		return annName;
	}

	public void setAnnName(String annName) {
		this.annName = annName;
	}

	public String getAnnDescr() {
		return annDescr;
	}

	public void setAnnDescr(String annDescr) {
		this.annDescr = annDescr;
	}

	public Timestamp getAnnTime() {
		return annTime;
	}

	public void setAnnTime(Timestamp annTime) {
		this.annTime = annTime;
	}
}
