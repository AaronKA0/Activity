package com.postreport.model;

import java.util.*;

public interface PostReportDAOInterface {

	public void insert(PostReportVO rostReportVO);

	public void update(PostReportVO rostReportVO);

	public void delete(Integer repId);

	public PostReportVO findByPrimaryKey(Integer repId);

	public List<PostReportVO> getAll();

}
