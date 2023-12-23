package com.venorder.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static util.Constants.PAGE_MAX_RESULT;
import util.HibernateUtil;

public class VenOrderDAO implements VenOrderDAOInterface {

	private SessionFactory factory;

	public VenOrderDAO() {
		factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public List<VenOrderVO> getAll(int currentPage) {
		int first = (currentPage - 1) * PAGE_MAX_RESULT;
		return getSession().createQuery("from Emp", VenOrderVO.class)
				.setFirstResult(first)
				.setMaxResults(PAGE_MAX_RESULT)
				.list();
	}
	
	@Override
	public long getTotal() {
		return getSession().createQuery("select count(*) from VenOrderVO", Long.class).uniqueResult();
	}
	
}