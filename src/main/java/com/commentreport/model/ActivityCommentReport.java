package com.commentreport.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "activity_comment_report")
public class ActivityCommentReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rep_id")
	private Integer repId;
	@Column(name = "com_id")
	private Integer comId;
	@Column(name = "mem_id")
	private Integer memId;
	@Column(name = "emp_id")
	private Integer empId;
	@Column(name = "rep_title")
	private String repTitle;
	@Column(name = "rep_content")
	private String repContent;
	@Column(name = "rep_pic", columnDefinition = "longblob")
	private byte[] repPic;
	@Column(name = "rep_status")
	private byte repStatus;
	@Column(name = "rep_time")
	private Timestamp repTime;

	public Integer getRepId() {
		return repId;
	}

	public void setRepId(Integer repId) {
		this.repId = repId;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
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

	public byte getRepStatus() {
		return repStatus;
	}

	public void setRepStatus(byte repStatus) {
		this.repStatus = repStatus;
	}

	public Timestamp getRepTime() {
		return repTime;
	}

	public void setRepTime(Timestamp repTime) {
		this.repTime = repTime;
	}

}
