package com.notify.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.notify.dao.INotifyDAO;
import com.notify.dao.NotifyDAO;
import com.notify.model.NotifyVO;

public class TestNotify {

	public static void main(String[] args) {
		
		INotifyDAO dao = new NotifyDAO();
		
		// 新增 insert
//		NotifyVO notifyVO1 = new NotifyVO();
//		
//		notifyVO1.setMemId(3);
//		notifyVO1.setNotifyTitle("測試新增");
//		notifyVO1.setNotifyContent("測試內容,測試內容,測試內容,測試內容,測試內容,測試內容.");
//		notifyVO1.setNotifyStatus((byte)2);
//		// notifyVO1.setNotifyTime(Timestamp.valueOf(LocalDateTime.now()));
//		
//		dao.insert(notifyVO1);
		
		System.out.println("============================");
		
		// 修改 update
//		NotifyVO notifyVO2 = new NotifyVO();
//		
//		notifyVO2.setNotifyId(1);
//		notifyVO2.setMemId(3);
//		notifyVO2.setNotifyTitle("測試修改");
//		notifyVO2.setNotifyContent("測試內容,測試內容,測試內容,測試內容,測試內容,測試內容.");
//		notifyVO2.setNotifyStatus((byte)2);
//		notifyVO2.setNotifyTime(Timestamp.valueOf(LocalDateTime.now()));
//
//		dao.update(notifyVO2);
		
		System.out.println("============================");
		
		// 查詢 getById
		NotifyVO notifyVO = dao.getById(3);
		System.out.print(notifyVO.getNotifyId() + ",");
		System.out.print(notifyVO.getMemId() + ",");
		System.out.print(notifyVO.getNotifyTitle() + ",");
		System.out.print(notifyVO.getNotifyContent() + ",");
		System.out.print(notifyVO.getNotifyStatus() + ",");
		System.out.print(notifyVO.getNotifyTime());
		System.out.println();
		
		System.out.println("============================");
		
		// 查詢 getAll
		List<NotifyVO> list = dao.getAll();
		for (NotifyVO aNotifyVO : list) {
			System.out.print(aNotifyVO.getNotifyId() + ",");
			System.out.print(aNotifyVO.getMemId() + ",");
			System.out.print(aNotifyVO.getNotifyTitle() + ",");
			System.out.print(aNotifyVO.getNotifyContent() + ",");
			System.out.print(aNotifyVO.getNotifyStatus() + ",");
			System.out.print(aNotifyVO.getNotifyTime());
			System.out.println();
		}
	}

}
