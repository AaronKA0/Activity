package com.venorder.model;

import java.util.List;

public interface VenOrderDAOInterface {

//	public Integer insert(VenOrderVO venOrderVO);
//
//	public void update(VenOrderVO venOrderVO);
//	
//	public void delete(Integer venOrderId);
//
//	public VenOrderVO findByPrimaryKey(Integer venOrderId);

//	public List<VenOrderVO> getAll();
	
	List<VenOrderVO> getAll(int currentPage);
	
	long getTotal();

	
}
