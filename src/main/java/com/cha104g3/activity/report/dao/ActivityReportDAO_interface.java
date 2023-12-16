package com.cha104g3.activity.report.dao;

import java.util.List;

public interface ActivityReportDAO_interface {
	public void insert(ActivityReportVO activityReportVO);

	public void update(ActivityReportVO activityReportVO);

	public void delete(Integer repId);

	public ActivityReportVO findByPrimaryKey(Integer repId);

	public List<ActivityReportVO> getAll();
}
