package com.venue.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "venue")
public class VenueVO implements java.io.Serializable{
	
//	@Transient
	private static final long serialVersionUID = 7247353469714932743L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // uses auto_increment
	@Column(name = "ven_id", insertable = false, updatable = false)
	private Integer venId;
	@Override
	public String toString() {
		return "VenueVO [venId=" + venId + ", venTypeId=" + venTypeId + ", venName=" + venName + ", venDescr="
				+ venDescr + ", venLoc=" + venLoc + ", venPrice=" + venPrice
				+ ", venStatus=" + venStatus + ", venUptime=" + venUptime + ", venDowntime=" + venDowntime
				+ ", venModTime=" + venModTime + ", venTotRating=" + venTotRating + ", venRateCount=" + venRateCount
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(venId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VenueVO other = (VenueVO) obj;
		return Objects.equals(venId, other.venId);
	}
	
	@Column(name = "ven_type_id")
	private Integer venTypeId;
	
	@Column(name = "ven_name")
	private String venName;
	
	@Column(name = "ven_descr")
	private String venDescr;
	
	@Column(name = "ven_pic", columnDefinition = "longblob")
	private byte[] venPic;
	
	@Column(name = "ven_loc")
	private String venLoc;
	
	@Column(name = "ven_price")
	private BigDecimal venPrice;
	
	@Column(name = "ven_status")
	private Byte venStatus;
	
	@Column(name = "ven_uptime")
	private Timestamp venUptime;
	
	@Column(name = "ven_downtime")
	private Timestamp venDowntime;
	
	@Column(name = "ven_mod_time")
	private Timestamp venModTime;
	
	@Column(name = "ven_tot_rating")
	private Double venTotRating;
	
	@Column(name = "ven_rate_count")
	private Integer venRateCount;
	
	public VenueVO() {}
		
	public Integer getVenId() {
		return venId;
	}
	public void setVenId(Integer venId) {
		this.venId = venId;
	}
	public Integer getVenTypeId() {
		return venTypeId;
	}
	public void setVenTypeId(Integer venTypeId) {
		this.venTypeId = venTypeId;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public String getVenDescr() {
		return venDescr;
	}
	public void setVenDescr(String venDescr) {
		this.venDescr = venDescr;
	}
	public byte[] getVenPic() {
		return venPic;
	}
	public void setVenPic(byte[] venPic) {
		this.venPic = venPic;
	}
	public String getVenLoc() {
		return venLoc;
	}
	public void setVenLoc(String venLoc) {
		this.venLoc = venLoc;
	}
	public BigDecimal getVenPrice() {
		return venPrice;
	}
	public void setVenPrice(BigDecimal venPrice) {
		this.venPrice = venPrice;
	}
	public Byte getVenStatus() {
		return venStatus;
	}
	public void setVenStatus(Byte venStatus) {
		this.venStatus = venStatus;
	}
	public Timestamp getVenUptime() {
		return venUptime;
	}
	public void setVenUptime(Timestamp venUptime) {
		this.venUptime = venUptime;
	}
	public Timestamp getVenDowntime() {
		return venDowntime;
	}
	public void setVenDowntime(Timestamp venDowntime) {
		this.venDowntime = venDowntime;
	}
	public Timestamp getVenModTime() {
		return venModTime;
	}
	public void setVenModTime(Timestamp venModTime) {
		this.venModTime = venModTime;
	}
	public Double getVenTotRating() {
		return venTotRating;
	}
	public void setVenTotRating(Double venTotRating) {
		this.venTotRating = venTotRating;
	}
	public Integer getVenRateCount() {
		return venRateCount;
	}
	public void setVenRateCount(Integer venRateCount) {
		this.venRateCount = venRateCount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
