package com.venclosed.dao;

import static util.Constants.PAGE_MAX_RESULT;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.venclosed.model.VenClosedVO;

import util.HibernateUtil;

public class VenClosedDAO implements IVenClosedDAO{

	//新增 insert
		@Override
		public int insert(VenClosedVO venClosedVO) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				Integer id = (Integer) session.save(venClosedVO);
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
		public int update(VenClosedVO venClosedVO) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				session.update(venClosedVO);
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
		public VenClosedVO getById(Integer closedDateId) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				VenClosedVO venClosedVO = session.get(VenClosedVO.class, closedDateId);
				session.getTransaction().commit();
				return venClosedVO;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			return null;
		}
	
	//查詢 getAll
		@Override
		public List<VenClosedVO> getAll(){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				List<VenClosedVO> list = session.createQuery("from VenClosedVO", VenClosedVO.class).list();
				session.getTransaction().commit();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			return null;
		}
	
	
	
	
//	private SessionFactory factory;
//
//	public VenClosedDAO() {
//		factory = HibernateUtil.getSessionFactory();
//	}
//		
//	private Session getSession() {
//		return factory.getCurrentSession();
//	}
//	
//	public int insert(VenClosedVO venClosedVO) {
//		return (Integer) getSession().save(venClosedVO);
//	}
//	
//	@Override
//	public List<VenClosedVO> getAll() {
//		return getSession().createQuery("from VenClosedVO", VenClosedVO.class).list();
//	}
//	
//	@Override
//	public List<VenClosedVO> getAll(int currentPage) {
//		int first = (currentPage - 1) * PAGE_MAX_RESULT;
//		return getSession().createQuery("from VenClosedVO", VenClosedVO.class)
//				.setFirstResult(first)
//				.setMaxResults(PAGE_MAX_RESULT)
//				.list();
//	}
//	
//	@Override
//	public long getTotal() {
//		return getSession().createQuery("select count(*) from VenClosedVO", Long.class).uniqueResult();
//	}
}
