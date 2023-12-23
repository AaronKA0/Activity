package com.venorder.controller;

import java.util.List;

import com.venorder.model.VenOrderVO;

public interface VenOrderServiceInterface {
	
	List<VenOrderVO> getAllVenOrder(int currentPage);

	int getPageTotal();
}
