package com.notify.dao;

import java.util.List;

import org.hibernate.Session;

import com.notify.model.NotifyVO;

import util.HibernateUtil;

public class NotifyDAO implements INotifyDAO{

	//新增 insert
		@Override
		public int insert(NotifyVO notifyVO) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				Integer id = (Integer) session.save(notifyVO);
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
		public int update(NotifyVO notifyVO) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				session.update(notifyVO);
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
		public NotifyVO getById(Integer notifyId) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				NotifyVO notifyVO = session.get(NotifyVO.class, notifyId);
				session.getTransaction().commit();
				return notifyVO;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			return null;
		}

	//查詢 getAll
		@Override
		public List<NotifyVO> getAll(){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				List<NotifyVO> list = session.createQuery("from NotifyVO", NotifyVO.class).list();
				session.getTransaction().commit();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			return null;
		}
	
	
}
