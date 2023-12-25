package com.membership.model;

import java.sql.Date;
import java.sql.Timestamp;

public class MembershipVO implements java.io.Serializable {
	private Integer memId;
	private String memAcc;
	private String memEmail;
	private String memPwd;
	private String memName;
	private Byte memGender;
	private Date memBirthdate;
	private String memUsername;
	private byte[] memPic;
	private String memIntro;
	private String memPhone;
	private Timestamp blockStartTime;
	private Timestamp blockEndTime;
	private Byte isAccEna;
	private Byte isPartEna;
	private Byte isHostEna;
	private Byte isRentEna;
	private Byte isMsgEna;
	private Timestamp memCrTime;
	private Timestamp memLoginTime;

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getMemAcc() {
		return memAcc;
	}

	public void setMemAcc(String memAcc) {
		this.memAcc = memAcc;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public Byte getMemGender() {
		return memGender;
	}

	public void setMemGender(Byte memGender) {
		this.memGender = memGender;
	}

	public Date getMemBirthdate() {
		return memBirthdate;
	}

	public void setMemBirthdate(Date memBirthdate) {
		this.memBirthdate = memBirthdate;
	}

	public String getMemUsername() {
		return memUsername;
	}

	public void setMemUsername(String memUsername) {
		this.memUsername = memUsername;
	}

	public byte[] getMemPic() {
		return memPic;
	}

	public void setMemPic(byte[] memPic) {
		this.memPic = memPic;
	}

	public String getMemIntro() {
		return memIntro;
	}

	public void setMemIntro(String memIntro) {
		this.memIntro = memIntro;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public Timestamp getBlockStartTime() {
		return blockStartTime;
	}

	public void setBlockStartTime(Timestamp blockStartTime) {
		this.blockStartTime = blockStartTime;
	}

	public Timestamp getBlockEndTime() {
		return blockEndTime;
	}

	public void setBlockEndTime(Timestamp blockEndTime) {
		this.blockEndTime = blockEndTime;
	}

	public Byte getIsAccEna() {
		return isAccEna;
	}

	public void setIsAccEna(Byte isAccEna) {
		this.isAccEna = isAccEna;
	}

	public Byte getIsPartEna() {
		return isPartEna;
	}

	public void setIsPartEna(Byte isPartEna) {
		this.isPartEna = isPartEna;
	}

	public Byte getIsHostEna() {
		return isHostEna;
	}

	public void setIsHostEna(Byte isHostEna) {
		this.isHostEna = isHostEna;
	}

	public Byte getIsRentEna() {
		return isRentEna;
	}

	public void setIsRentEna(Byte isRentEna) {
		this.isRentEna = isRentEna;
	}

	public Byte getIsMsgEna() {
		return isMsgEna;
	}

	public void setIsMsgEna(Byte isMsgEna) {
		this.isMsgEna = isMsgEna;
	}

	public Timestamp getMemCrTime() {
		return memCrTime;
	}

	public void setMemCrTime(Timestamp memCrTime) {
		this.memCrTime = memCrTime;
	}

	public Timestamp getMemLoginTime() {
		return memLoginTime;
	}

	public void setMemLoginTime(Timestamp memLoginTime) {
		this.memLoginTime = memLoginTime;
	}

}
