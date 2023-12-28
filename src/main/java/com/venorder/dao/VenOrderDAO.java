package com.venorder.dao;

import java.util.List;

import org.hibernate.Session;

import com.venorder.model.VenOrderVO;

import util.HibernateUtil;

public class VenOrderDAO implements IVenOrderDAO {
	
	//新增 insert
		@Override
		public Integer insert(VenOrderVO venOrderVO) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				Integer id = (Integer) session.save(venOrderVO);
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
		public Integer update(VenOrderVO venOrderVO) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				session.update(venOrderVO);
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
		public VenOrderVO getById(Integer venOrderId) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				VenOrderVO venOrderVO = session.get(VenOrderVO.class, venOrderId);
				session.getTransaction().commit();
				return venOrderVO;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			return null;
		}
			

	//查詢 getAll
		@Override
		public List<VenOrderVO> getAll(){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				List<VenOrderVO> list = session.createQuery("from VenOrderVO", VenOrderVO.class).list();
				session.getTransaction().commit();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			return null;
		}
	
	
}
