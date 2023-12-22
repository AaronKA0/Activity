package com.venclosed.model;

import java.util.List;

public interface VenClosedDAOInterface {

	public Integer insert(VenClosedVO venClosedVO);
	public void update(VenClosedVO venClosedVO);
//	public void delete(Integer closedDateId);
	public VenClosedVO findByPrimaryKey(Integer closedDateId);
	public List<VenClosedVO> getAll();
	
}
