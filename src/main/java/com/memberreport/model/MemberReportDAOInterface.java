package com.memberreport.model;

import java.util.*;

public interface MemberReportDAOInterface {

	public void insert(MemberReportVO memberReportVO);

	public void update(MemberReportVO memberReportVO);

	public void delete(Integer repId);

	public MemberReportVO findByPrimaryKey(Integer repId);

	public List<MemberReportVO> getAll();

}
