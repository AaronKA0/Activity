package com.report.service;

import java.util.List;

import com.report.model.ActivityReport;

public interface ActivityReportService {

	List<ActivityReport> getAll();

	ActivityReport findByPrimaryKey(Integer repId);

	void insert(ActivityReport activityReportVO);

	void update(ActivityReport activityReportVO);

	void delete(Integer repId);
}
