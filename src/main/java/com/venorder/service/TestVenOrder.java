package com.venorder.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.venorder.dao.IVenOrderDAO;
import com.venorder.dao.VenOrderDAO;
import com.venorder.model.VenOrderVO;

public class TestVenOrder {

	public static void main(String[] args) {
		IVenOrderDAO dao = new VenOrderDAO();
		
		// 新增 insert
//		VenOrderVO venOrderVO1 = new VenOrderVO();
//		
//		long longtime1 = System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000L;
//		Date date1 = new Date(longtime1);
//		BigDecimal fee1 = new BigDecimal("2000.00");
//		
//		venOrderVO1.setVenId(3);
//		venOrderVO1.setMemId(8);
//		venOrderVO1.setEmpId(10);
//		venOrderVO1.setOrderDate(date1);
//		venOrderVO1.setMemPhone("0912345678");
//		venOrderVO1.setActDescr("新增,新增,新增,新增,新增,新增,新增,新增,新增");
//		venOrderVO1.setUserCount(100);
//		venOrderVO1.setMemTaxid("88888888");
//		venOrderVO1.setOrderPayType((byte)2);
//		//venOrderVO1.setMemTransferNum("");
//		venOrderVO1.setMemCreditNum("1234567890123456");
//		venOrderVO1.setOrderStatus((byte)3);
//		venOrderVO1.setVenRentStatus((byte)3);
//		venOrderVO1.setVenRating(5.5);
//		venOrderVO1.setVenCom("新增, 新增, 新增, 新增, 新增");
//		venOrderVO1.setVenComStatus((byte)3);
//		venOrderVO1.setVenResFee(fee1);
//		
//		dao.insert(venOrderVO1);
		
		System.out.println("============================");
		
		// 修改 update
//		VenOrderVO venOrderVO2 = new VenOrderVO();
//		
//		long longtime2 = System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000L;
//		Date date2 = new Date(longtime2);
//		BigDecimal fee2 = new BigDecimal("2000.00");
//		
//		venOrderVO2.setVenOrderId(3);
//		venOrderVO2.setVenId(3);
//		venOrderVO2.setMemId(8);
//		venOrderVO2.setEmpId(10);
//		venOrderVO2.setOrderDate(date2);
//		venOrderVO2.setMemPhone("0912345678");
//		venOrderVO2.setActDescr("新增,新增,新增,新增,新增,新增,新增,新增,新增");
//		venOrderVO2.setUserCount(100);
//		venOrderVO2.setMemTaxid("88888888");
//		venOrderVO2.setOrderTime(Timestamp.valueOf(LocalDateTime.now()));
//		venOrderVO2.setOrderPayType((byte)2);
//		//venOrderVO2.setMemTransferNum("");
//		venOrderVO2.setMemCreditNum("1234567890123456");
//		venOrderVO2.setOrderStatus((byte)3);
//		venOrderVO2.setVenRentStatus((byte)3);
//		venOrderVO2.setVenRating(5.5);
//		venOrderVO2.setVenCom("新增, 新增, 新增, 新增, 新增");
//		venOrderVO2.setVenComStatus((byte)3);
//		venOrderVO2.setVenResFee(fee2);
//
//		dao.update(venOrderVO2);
		
		System.out.println("============================");
		
		// 查詢 getById
		VenOrderVO venOrderVO = dao.getById(3);
		System.out.print(venOrderVO.getVenOrderId() + ",");
		System.out.print(venOrderVO.getVenId() + ",");
		System.out.print(venOrderVO.getMemId() + ",");
		System.out.print(venOrderVO.getEmpId() + ",");
		System.out.print(venOrderVO.getOrderDate() + ",");
		System.out.print(venOrderVO.getMemPhone() + ",");
		System.out.print(venOrderVO.getActDescr() + ",");
		System.out.print(venOrderVO.getUserCount() + ",");
		System.out.print(venOrderVO.getMemTaxid() + ",");
		System.out.print(venOrderVO.getOrderTime() + ",");
		System.out.print(venOrderVO.getOrderPayType() + ",");
		System.out.print(venOrderVO.getMemTransferNum() + ",");
		System.out.print(venOrderVO.getMemCreditNum() + ",");
		System.out.print(venOrderVO.getOrderStatus() + ",");
		System.out.print(venOrderVO.getVenRentStatus() + ",");
		System.out.print(venOrderVO.getVenRating() + ",");
		System.out.print(venOrderVO.getVenCom() + ",");
		System.out.print(venOrderVO.getVenComStatus() + ",");
		System.out.print(venOrderVO.getVenComTime() + ",");
		System.out.print(venOrderVO.getVenResFee());
		System.out.println();
		
		System.out.println("============================");
		
		// 查詢 getAll
		List<VenOrderVO> list = dao.getAll();
		for (VenOrderVO aVenOrderVO : list) {
			System.out.print(aVenOrderVO.getVenOrderId() + ",");
			System.out.print(aVenOrderVO.getVenId() + ",");
			System.out.print(aVenOrderVO.getMemId() + ",");
			System.out.print(aVenOrderVO.getEmpId() + ",");
			System.out.print(aVenOrderVO.getOrderDate() + ",");
			System.out.print(aVenOrderVO.getMemPhone() + ",");
			System.out.print(aVenOrderVO.getActDescr() + ",");
			System.out.print(aVenOrderVO.getUserCount() + ",");
			System.out.print(aVenOrderVO.getMemTaxid() + ",");
			System.out.print(aVenOrderVO.getOrderTime() + ",");
			System.out.print(aVenOrderVO.getOrderPayType() + ",");
			System.out.print(aVenOrderVO.getMemTransferNum() + ",");
			System.out.print(aVenOrderVO.getMemCreditNum() + ",");
			System.out.print(aVenOrderVO.getOrderStatus() + ",");
			System.out.print(aVenOrderVO.getVenRentStatus() + ",");
			System.out.print(aVenOrderVO.getVenRating() + ",");
			System.out.print(aVenOrderVO.getVenCom() + ",");
			System.out.print(aVenOrderVO.getVenComStatus() + ",");
			System.out.print(aVenOrderVO.getVenComTime() + ",");
			System.out.print(aVenOrderVO.getVenResFee());
			System.out.println();
		}
	}
	
}
