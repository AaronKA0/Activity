package com.report.service.impl;

import java.util.List;

import com.report.dao.ActivityReportDao;
import com.report.dao.impl.ActivityReportDaoImpl;
import com.report.model.ActivityReport;
import com.report.service.ActivityReportService;

public class ActivityReportServiceImpl implements ActivityReportService {

	private ActivityReportDao activityReportDAO;

	public ActivityReportServiceImpl() {
		activityReportDAO = new ActivityReportDaoImpl();
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