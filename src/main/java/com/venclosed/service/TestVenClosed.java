package com.venclosed.service;

import java.util.List;

import com.venclosed.dao.IVenClosedDAO;
import com.venclosed.dao.VenClosedDAO;
import com.venclosed.model.VenClosedVO;

import java.sql.Date;

public class TestVenClosed {

	public static void main(String[] args) {
		
		IVenClosedDAO dao = new VenClosedDAO();
		
		// 新增 insert
//		VenClosedVO venClosedVO1 = new VenClosedVO();
//		long longtime = System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000L;
//		Date closedDate = new Date(longtime);
//		venClosedVO1.setVenId(1);
//		venClosedVO1.setClosedDate(closedDate);
//		venClosedVO1.setClosedReason("測試,測試,測試,測試,測試,測試,測試,測試");
//		dao.insert(venClosedVO1);
		
		System.out.println("============================");
		
		// 修改 update
//		VenClosedVO venClosedVO2 = new VenClosedVO();
//		long longtime2 = System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000L;
//		Date closedDate2 = new Date(longtime2);
//		venClosedVO2.setClosedDateId(1);
//		venClosedVO2.setVenId(1);
//		venClosedVO2.setClosedDate(closedDate2);
//		venClosedVO2.setClosedReason("測試,測試,測試,測試,測試,測試,測試,測試");
//		dao.update(venClosedVO2);
		
		System.out.println("============================");
		
		// 查詢 getById
		VenClosedVO venClosedVO = dao.getById(3);
		System.out.print(venClosedVO.getClosedDateId() + ",");
		System.out.print(venClosedVO.getVenId() + ",");
		System.out.print(venClosedVO.getClosedDate() + ",");
		System.out.print(venClosedVO.getClosedReason());
		System.out.println();
		
		System.out.println("============================");
		
		// 查詢 getAll
		List<VenClosedVO> list = dao.getAll();
		for (VenClosedVO aVenClosedVO : list) {
			System.out.print(aVenClosedVO.getClosedDateId() + ",");
			System.out.print(aVenClosedVO.getVenId() + ",");
			System.out.print(aVenClosedVO.getClosedDate() + ",");
			System.out.print(aVenClosedVO.getClosedReason());
			System.out.println();
		}
	}

}
