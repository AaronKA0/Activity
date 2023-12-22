package com.report.dao;

import java.util.List;

import com.report.model.ActivityReport;

public interface ActivityReportDAO {
	public void insert(ActivityReport activityReportVO);

	public void update(ActivityReport activityReportVO);

	public void delete(Integer repId);

	public ActivityReport findByPrimaryKey(Integer repId);

	public List<ActivityReport> getAll();
}
