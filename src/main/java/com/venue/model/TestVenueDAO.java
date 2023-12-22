package com.venue.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import util.HibernateUtil;

public class TestVenueDAO {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
//			List<VenueVO> list = session.createQuery("from VenueVO where venId > ?0 and venName like :venName", VenueVO.class)
//					.setParameter(0, 5)
//					.setParameter("venName", "%K%")
//					.list();
			
			List<VenueVO> list = session.createQuery("from VenueVO", VenueVO.class).list();
			
			System.out.println(list);
			

			VenueVO venVO = new VenueVO();
			venVO.setVenTypeId(2);
			venVO.setVenName("test hibernate");
			venVO.setVenDescr("ven 1 descr");
			venVO.setVenPic("picture".getBytes());
			venVO.setVenLoc("ven 1 loc");
			venVO.setVenPrice(new BigDecimal(100.34));
			venVO.setVenStatus((byte)2);
			venVO.setVenUptime(Timestamp.valueOf(LocalDateTime.now()));
			venVO.setVenDowntime(Timestamp.valueOf(LocalDateTime.now()));
			venVO.setVenModTime(Timestamp.valueOf(LocalDateTime.now()));
			venVO.setVenTotRating(0.0);
			venVO.setVenRateCount(0);

			session.save(venVO);

			session.getTransaction().commit();
			
			session.close();
		
			
//			List<VenueVO> list = session.createQuery("from VenueVO where venId > :venId", VenueVO.class)
//					.setParameter("venId", 10)
//					.list();
			
//			Query<Emp> query1 = session.createQuery("from Emp where empno > :empno and ename like :ename", Emp.class);
//			
//			Emp emp = new Emp();
//			emp.setEmpno(7001);
//			emp.setEname("%K%");
//			query1.setProperties(emp);
//			
//			List<Emp> list2 = query1.list();
//			System.out.println(list2);
//			
//			Query<Emp> query2 = session.createQuery("from Emp", Emp.class);
//			query2.setFirstResult(0);
//			query2.setMaxResults(3);
//			List<Emp> list3 = query2.list();
//			System.out.println(list3);
////			
//			List<Emp> list4 = session.getNamedQuery("getAllEmps")
//					.setParameter("empno", 7010)
//					.list();
//			System.out.println(list4);
//			
//			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
	
	
	public VenueVO addVenue(Integer venTypeId, String venName, String venDescr, byte[] venPic, String venLoc, BigDecimal venPrice,
			Byte venStatus) {

		VenueVO venueVO = new VenueVO();
		
		venueVO.setVenTypeId(venTypeId);
		venueVO.setVenName(venName);
		venueVO.setVenDescr(venDescr);
		venueVO.setVenPic(venPic);
		venueVO.setVenLoc(venLoc);
		venueVO.setVenPrice(venPrice);
		venueVO.setVenStatus(venStatus);




//		int key = dao.insert(venueVO);
//		venueVO.setVenId(key);

		return venueVO;
	}

}
