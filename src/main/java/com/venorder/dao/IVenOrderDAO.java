package com.venorder.dao;

import java.util.List;

import com.venorder.model.VenOrderVO;

public interface IVenOrderDAO {

	Integer insert(VenOrderVO entity);

	Integer update(VenOrderVO entity);
	
//	Integer delete(Integer venOrderId);

	VenOrderVO getById(Integer venOrderId);

	List<VenOrderVO> getAll();
	
//	List<VenOrderVO> getAll(int currentPage);
	
//	long getTotal();

	
}
