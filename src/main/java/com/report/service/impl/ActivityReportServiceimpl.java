package com.report.service.impl;

import java.util.List;

import com.report.dao.ActivityReportDAO;
import com.report.dao.impl.ActivityReportDAOimpl;
import com.report.model.ActivityReport;
import com.report.service.ActivityReportService;

public class ActivityReportServiceimpl implements ActivityReportService {

	private ActivityReportDAO activityReportDAO;

	public ActivityReportServiceimpl() {
		activityReportDAO = new ActivityReportDAOimpl();
	}

	public List<ActivityReport> getAll() {
		return activityReportDAO.getAll();
	}

	public ActivityReport findByPrimaryKey(Integer repId) {
		return activityReportDAO.findByPrimaryKey(repId);
	}

	public void insert(ActivityReport activityReportVO) {
		activityReportDAO.insert(activityReportVO);
	}

	public void update(ActivityReport activityReportVO) {
		activityReportDAO.update(activityReportVO);
	}

	public void delete(Integer repId) {
		activityReportDAO.delete(repId);
	}

}