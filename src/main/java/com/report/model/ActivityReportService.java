package com.report.model;

import java.util.List;

public class ActivityReportService {

	private ActivityReportDAO_interface activityReportDAO;

	public ActivityReportService() {
		activityReportDAO = new ActivityReportDAO();
	}

	public List<ActivityReportVO> getAll() {
		return activityReportDAO.getAll();
	}

	public ActivityReportVO findByPrimaryKey(Integer repId) {
		return activityReportDAO.findByPrimaryKey(repId);
	}

	public void insert(ActivityReportVO activityReportVO) {
		activityReportDAO.insert(activityReportVO);
	}

	public void update(ActivityReportVO activityReportVO) {
		activityReportDAO.update(activityReportVO);
	}

	public void delete(Integer repId) {
		activityReportDAO.delete(repId);
	}

}