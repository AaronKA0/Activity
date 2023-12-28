package com.postreport.dao;

import java.util.List;

import com.postreport.model.PostReportVO;

public interface IPostReport {

	int insert(PostReportVO entity);

	int update(PostReportVO entity);

//	int delete(Integer repId);

	PostReportVO getById(Integer repId);

	List<PostReportVO> getAll();

}
