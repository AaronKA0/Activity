package com.act.model;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

public class ActVO implements java.io.Serializable{
	private Integer act_id;
	private Integer mem_id;
	private String act_name;
	private LocalDateTime act_start_time;
	private LocalDateTime act_end_time;
	private String act_loc;
	private String act_descr;
	private Integer act_upper;
	private Integer act_count;
	private Byte act_status;
	private LocalDateTime act_cr_time;
	private LocalDateTime reg_start_time;
	private LocalDateTime reg_end_time;
	private byte[] act_pic;
	private Double act_tot_rating;
	private Integer act_rate_count;
	private Integer act_follow_count;
	private BigDecimal lat;
	private BigDecimal lon;
	
	public Integer getAct_id() {
		return act_id;
	}
	public void setAct_id(Integer act_id) {
		this.act_id = act_id;
	}
	public Integer getMem_id() {
		return mem_id;
	}
	public void setMem_id(Integer mem_id) {
		this.mem_id = mem_id;
	}
	public String getAct_name() {
		return act_name;
	}
	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}
	public LocalDateTime getAct_start_time() {
		return act_start_time;
	}
	public void setAct_start_time(LocalDateTime act_start_time) {
		this.act_start_time = act_start_time;
	}
	public LocalDateTime getAct_end_time() {
		return act_end_time;
	}
	public void setAct_end_time(LocalDateTime act_end_time) {
		this.act_end_time = act_end_time;
	}
	public String getAct_loc() {
		return act_loc;
	}
	public void setAct_loc(String act_loc) {
		this.act_loc = act_loc;
	}
	public String getAct_descr() {
		return act_descr;
	}
	public void setAct_descr(String act_descr) {
		this.act_descr = act_descr;
	}
	public Integer getAct_upper() {
		return act_upper;
	}
	public void setAct_upper(Integer act_upper) {
		this.act_upper = act_upper;
	}
	public Integer getAct_count() {
		return act_count;
	}
	public void setAct_count(Integer act_count) {
		this.act_count = act_count;
	}
	public Byte getAct_status() {
		return act_status;
	}
	public void setAct_status(Byte act_status) {
		this.act_status = act_status;
	}
	public LocalDateTime getAct_cr_time() {
		return act_cr_time;
	}
	public void setAct_cr_time(LocalDateTime act_cr_time) {
		this.act_cr_time = act_cr_time;
	}
	public LocalDateTime getReg_start_time() {
		return reg_start_time;
	}
	public void setReg_start_time(LocalDateTime reg_start_time) {
		this.reg_start_time = reg_start_time;
	}
	public LocalDateTime getReg_end_time() {
		return reg_end_time;
	}
	public void setReg_end_time(LocalDateTime reg_end_time) {
		this.reg_end_time = reg_end_time;
	}
	public byte[] getAct_pic() {
		return act_pic;
	}
	public void setAct_pic(byte[] act_pic) {
		this.act_pic = act_pic;
	}
	public double getAct_tot_rating() {
		return act_tot_rating;
	}
	public void setAct_tot_rating(double act_tot_rating) {
		this.act_tot_rating = act_tot_rating;
	}
	public Integer getAct_rate_count() {
		return act_rate_count;
	}
	public void setAct_rate_count(Integer act_rate_count) {
		this.act_rate_count = act_rate_count;
	}
	public Integer getAct_follow_count() {
		return act_follow_count;
	}
	public void setAct_follow_count(Integer act_follow_count) {
		this.act_follow_count = act_follow_count;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getLon() {
		return lon;
	}
	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}
	
	
	
	

	
}
