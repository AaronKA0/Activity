package com.venorder.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venue_order")
public class VenOrderVO implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ven_order_id", updatable = false)
	private Integer venOrderId;
	
	@Column(name = "ven_id")
	private Integer venId;
	
	@Column(name = "mem_id")
	private Integer memId;
	
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "mem_phone", columnDefinition = "char")
	private String memPhone;
	
	@Column(name = "act_descr")
	private String actDescr;
	
	@Column(name = "user_count")
	private Integer userCount;
	
	@Column(name = "mem_taxid", columnDefinition = "char")
	private String memTaxid;
	
	@Column(name = "order_time", insertable = false)
	private Timestamp orderTime;
	
	@Column(name = "order_pay_type")
	private Byte orderPayType;
	
	@Column(name = "mem_transfer_num")
	private String memTransferNum;
	
	@Column(name = "mem_credit_num", columnDefinition = "char")
	private String memCreditNum;
	
	@Column(name = "order_status")
	private Byte orderStatus;
	
	@Column(name = "ven_rent_status")
	private Byte venRentStatus;
	
	@Column(name = "ven_rating")
	private Double venRating;
	
	@Column(name = "ven_com")
	private String venCom;
	
	@Column(name = "ven_com_status")
	private Byte venComStatus;
	
	@Column(name = "ven_com_time")
	private Timestamp venComTime;
	
	@Column(name = "ven_res_fee")
	private BigDecimal venResFee;

	public VenOrderVO() {
		super();
	}
	
	public VenOrderVO(Integer venOrderId, Integer venId, Integer memId, Integer empId, Date orderDate, String memPhone,
			String actDescr, Integer userCount, String memTaxid, Timestamp orderTime, Byte orderPayType,
			String memTransferNum, String memCreditNum, Byte orderStatus, Byte venRentStatus, Double venRating,
			String venCom, Byte venComStatus, Timestamp venComTime, BigDecimal venResFee) {
		super();
		this.venOrderId = venOrderId;
		this.venId = venId;
		this.memId = memId;
		this.empId = empId;
		this.orderDate = orderDate;
		this.memPhone = memPhone;
		this.actDescr = actDescr;
		this.userCount = userCount;
		this.memTaxid = memTaxid;
		this.orderTime = orderTime;
		this.orderPayType = orderPayType;
		this.memTransferNum = memTransferNum;
		this.memCreditNum = memCreditNum;
		this.orderStatus = orderStatus;
		this.venRentStatus = venRentStatus;
		this.venRating = venRating;
		this.venCom = venCom;
		this.venComStatus = venComStatus;
		this.venComTime = venComTime;
		this.venResFee = venResFee;
	}

	public Integer getVenOrderId() {
		return venOrderId;
	}

	public void setVenOrderId(Integer venOrderId) {
		this.venOrderId = venOrderId;
	}

	public Integer getVenId() {
		return venId;
	}

	public void setVenId(Integer venId) {
		this.venId = venId;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getActDescr() {
		return actDescr;
	}

	public void setActDescr(String actDescr) {
		this.actDescr = actDescr;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public String getMemTaxid() {
		return memTaxid;
	}

	public void setMemTaxid(String memTaxid) {
		this.memTaxid = memTaxid;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Byte getOrderPayType() {
		return orderPayType;
	}

	public void setOrderPayType(Byte orderPayType) {
		this.orderPayType = orderPayType;
	}

	public String getMemTransferNum() {
		return memTransferNum;
	}

	public void setMemTransferNum(String memTransferNum) {
		this.memTransferNum = memTransferNum;
	}

	public String getMemCreditNum() {
		return memCreditNum;
	}

	public void setMemCreditNum(String memCreditNum) {
		this.memCreditNum = memCreditNum;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Byte getVenRentStatus() {
		return venRentStatus;
	}

	public void setVenRentStatus(Byte venRentStatus) {
		this.venRentStatus = venRentStatus;
	}

	public Double getVenRating() {
		return venRating;
	}

	public void setVenRating(Double venRating) {
		this.venRating = venRating;
	}

	public String getVenCom() {
		return venCom;
	}

	public void setVenCom(String venCom) {
		this.venCom = venCom;
	}

	public Byte getVenComStatus() {
		return venComStatus;
	}

	public void setVenComStatus(Byte venComStatus) {
		this.venComStatus = venComStatus;
	}

	public Timestamp getVenComTime() {
		return venComTime;
	}

	public void setVenComTime(Timestamp venComTime) {
		this.venComTime = venComTime;
	}

	public BigDecimal getVenResFee() {
		return venResFee;
	}

	public void setVenResFee(BigDecimal venResFee) {
		this.venResFee = venResFee;
	}
	

}
