package com.postreport.model;

import java.sql.Timestamp;

public class PostReportVO implements java.io.Serializable{
	private Integer repId;
	private Integer postId;
	private Integer memId;
	private Integer empId;
	private String repTitle;
	private String repContent;
	private byte[] repPic;
	private Byte repStatus;
	private Timestamp repTime;
	
	public Integer getRepId() {
		return repId;
	}
	public void setRepId(Integer repId) {
		this.repId = repId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
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
	public String getRepTitle() {
		return repTitle;
	}
	public void setRepTitle(String repTitle) {
		this.repTitle = repTitle;
	}
	public String getRepContent() {
		return repContent;
	}
	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}
	public byte[] getRepPic() {
		return repPic;
	}
	public void setRepPic(byte[] repPic) {
		this.repPic = repPic;
	}
	public Byte getRepStatus() {
		return repStatus;
	}
	public void setRepStatus(Byte repStatus) {
		this.repStatus = repStatus;
	}
	public Timestamp getRepTime() {
		return repTime;
	}
	public void setRepTime(Timestamp repTime) {
		this.repTime = repTime;
	}

	
}
