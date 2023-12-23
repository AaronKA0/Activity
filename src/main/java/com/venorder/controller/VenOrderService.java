package com.venorder.controller;

import static util.Constants.PAGE_MAX_RESULT;

import java.util.List;

import com.venorder.model.VenOrderDAO;
import com.venorder.model.VenOrderVO;

public class VenOrderService implements VenOrderServiceInterface{
	
	private VenOrderDAO dao;
	
	public VenOrderService() {
		dao = new VenOrderDAO();
	}
	
	@Override
	public List<VenOrderVO> getAllVenOrder(int currentPage) {
		return dao.getAll(currentPage);
	}
	
	@Override
	public int getPageTotal() {
		long total = dao.getTotal();
		int pageQty = (int)(total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;
	}
}
