package com.announcement.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.announcement.model.AnnouncementVO;
import com.announcement.dao.IAnnouncementDAO;
import com.announcement.dao.AnnouncementDAO;

public class TestAnnouncement {
	
	public static void main(String[] args) {
		IAnnouncementDAO dao = new AnnouncementDAO();
		
		// 新增 insert
//		AnnouncementVO announcementVO1 = new AnnouncementVO();
//		
//		announcementVO1.setEmpId(3);
//		announcementVO1.setAnnName("測試新增");
//		announcementVO1.setAnnDescr("新增,新增,新增,新增,新增,新增.");
//		
//		dao.insert(announcementVO1);
		
		System.out.println("============================");
		
		// 修改 update
//		AnnouncementVO announcementVO2 = new AnnouncementVO();
//		
//		announcementVO2.setAnnId(8);
//		announcementVO2.setEmpId(3);
//		announcementVO2.setAnnName("測試修改");
//		announcementVO2.setAnnDescr("修改,修改,修改,修改,修改,修改.");
//		announcementVO2.setAnnTime(Timestamp.valueOf(LocalDateTime.now()));
//
//		dao.update(announcementVO2);
		
		System.out.println("============================");
		
		// 查詢 getById
		AnnouncementVO announcementVO = dao.getById(3);
		System.out.print(announcementVO.getAnnId() + ",");
		System.out.print(announcementVO.getEmpId() + ",");
		System.out.print(announcementVO.getAnnName() + ",");
		System.out.print(announcementVO.getAnnDescr() + ",");
		System.out.print(announcementVO.getAnnTime());
		System.out.println();
		
		System.out.println("============================");
		
		// 查詢 getAll
		List<AnnouncementVO> list = dao.getAll();
		for (AnnouncementVO aAnnouncementVO : list) {
			System.out.print(aAnnouncementVO.getAnnId() + ",");
			System.out.print(aAnnouncementVO.getEmpId() + ",");
			System.out.print(aAnnouncementVO.getAnnName() + ",");
			System.out.print(aAnnouncementVO.getAnnDescr() + ",");
			System.out.print(aAnnouncementVO.getAnnTime());
			System.out.println();
		}
	}
	
}
