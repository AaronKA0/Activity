package com.cha104g3.activity.emp.model;
import java.sql.Date;

public class EmpVO implements java.io.Serializable{
	
	private Integer empId;
	private String empAcc;
	private String empEmail;
	private String empPwd;
	private String empName;
	private String empPhone; 
	private Date empBirthdate;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpAcc() {
		return empAcc;
	}
	public void setEmpAcc(String empAcc) {
		this.empAcc = empAcc;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPwd() {
		return empPwd;
	}
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public Date getEmpBirthdate() {
		return empBirthdate;
	}
	public void setEmpBirthdate(Date empBirthdate) {
		this.empBirthdate = empBirthdate;
	}
	
	
}
