package com.commentreport.dao;

import java.util.List;

import com.commentreport.model.ActivityCommentReport;

public interface CommentReportDAO {

	List<ActivityCommentReport> getAll();

	ActivityCommentReport getCommentReport();

	Integer insert();

	void update();

	void delete();
}
