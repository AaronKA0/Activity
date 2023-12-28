package com.notify.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification_message")
public class NotifyVO implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notify_id", updatable = false)
	private	Integer	notifyId;
	
	@Column(name = "mem_id")
	private	Integer	memId;
	
	@Column(name = "notify_title")
	private	String	notifyTitle;
	
	@Column(name = "notify_content")
	private	String	notifyContent;
	
	@Column(name = "notify_status")
	private	Byte	notifyStatus;
	
	@Column(name = "notify_time", insertable = false)
	private	Timestamp notifyTime;	
	
	public NotifyVO() {
		super();
	}

	public NotifyVO(Integer notifyId, Integer memId, String notifyTitle, String notifyContent, Byte notifyStatus,
			Timestamp notifyTime) {
		super();
		this.notifyId = notifyId;
		this.memId = memId;
		this.notifyTitle = notifyTitle;
		this.notifyContent = notifyContent;
		this.notifyStatus = notifyStatus;
		this.notifyTime = notifyTime;
	}

	public Integer getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(Integer notifyId) {
		this.notifyId = notifyId;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getNotifyTitle() {
		return notifyTitle;
	}

	public void setNotifyTitle(String notifyTitle) {
		this.notifyTitle = notifyTitle;
	}

	public String getNotifyContent() {
		return notifyContent;
	}

	public void setNotifyContent(String notifyContent) {
		this.notifyContent = notifyContent;
	}

	public Byte getNotifyStatus() {
		return notifyStatus;
	}

	public void setNotifyStatus(Byte notifyStatus) {
		this.notifyStatus = notifyStatus;
	}

	public Timestamp getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(Timestamp notifyTime) {
		this.notifyTime = notifyTime;
	}
	
	
}
