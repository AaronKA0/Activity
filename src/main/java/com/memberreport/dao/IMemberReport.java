package com.memberreport.dao;

import java.util.List;

import com.memberreport.model.MemberReportVO;

public interface IMemberReport {

	int insert(MemberReportVO entity);

	int update(MemberReportVO entity);

//	int delete(Integer repId);

	MemberReportVO getById(Integer repId);

	List<MemberReportVO> getAll();

}
