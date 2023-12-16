package com.cha104g3.activity.report.service;

import java.util.List;

import com.cha104g3.activity.report.dao.ActivityReportDAO;
import com.cha104g3.activity.report.dao.ActivityReportDAO_interface;
import com.cha104g3.activity.report.model.ActivityReportVO;

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