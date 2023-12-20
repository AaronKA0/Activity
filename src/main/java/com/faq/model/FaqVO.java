package com.faq.model;
import java.sql.Date;

public class FaqVO implements java.io.Serializable{
	private Integer faqId;
	private String faqQue;
	private String faqAns;
	
	public Integer getFaqId() {
		return faqId;
	}
	public void setFaqId(Integer faqId) {
		this.faqId = faqId;
	}
	public String getFaqQue() {
		return faqQue;
	}
	public void setFaqQue(String faqQue) {
		this.faqQue = faqQue;
	}
	public String getFaqAns() {
		return faqAns;
	}
	public void setFaqAns(String faqAns) {
		this.faqAns = faqAns;
	}
}
