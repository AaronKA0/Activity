package com.notify.model;

import java.sql.Timestamp;

public class NotifyVO implements java.io.Serializable {
	
	private	Integer	notifyId;
	private	Integer	memId;
	private	String	notifyTitle;
	private	String	notifyContent;
	private	Byte	notifyStatus;
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
