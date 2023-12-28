package com.announcement.dao;

import java.util.List;

import org.hibernate.Session;

import com.announcement.model.AnnouncementVO;
import com.notify.dao.INotifyDAO;
import com.notify.model.NotifyVO;

import util.HibernateUtil;

public class AnnouncementDAO implements IAnnouncementDAO{
	
	//新增 insert
		@Override
		public int insert(AnnouncementVO announcementVO) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				Integer id = (Integer) session.save(announcementVO);
				session.getTransaction().commit();
				return id;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			return -1;
		}
		
			
	//修改 update	
		@Override
		public int update(AnnouncementVO announcementVO) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				session.update(announcementVO);
				session.getTransaction().commit();
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			return -1;
		}
			

	//查詢 getById	
		@Override
		public AnnouncementVO getById(Integer annId) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				AnnouncementVO announcementVO = session.get(AnnouncementVO.class, annId);
				session.getTransaction().commit();
				return announcementVO;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			return null;
		}
		

	//查詢 getAll
		@Override
		public List<AnnouncementVO> getAll(){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				List<AnnouncementVO> list = session.createQuery("from AnnouncementVO", AnnouncementVO.class).list();
				session.getTransaction().commit();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			return null;
		}
		
		
}
