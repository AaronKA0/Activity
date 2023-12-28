package com.venclosed.dao;

import java.util.List;

import com.venclosed.model.VenClosedVO;

public interface IVenClosedDAO {
	
	int insert(VenClosedVO entity);

	int update(VenClosedVO entity);
	
//	int delete(Integer closedDateId);
	 
	VenClosedVO getById(Integer closedDateId);
	
	List<VenClosedVO> getAll();
	
//	List<VenClosedVO> getByCompositeQuery(Map<String, String> map);
	
//	List<VenClosedVO> getAll(int currentPage);
	
//	long getTotal();
	
}
