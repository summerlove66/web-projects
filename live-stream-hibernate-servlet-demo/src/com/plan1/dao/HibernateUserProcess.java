package com.plan1.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.plan1.model.User;

public class HibernateUserProcess {
	static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public static void insertUpdateObj(Object... objArgs) {
		
		Session session = sf.openSession();
	
		
		session.beginTransaction();
		for(int i= 0 ;i <objArgs.length ;i++) {
		session.saveOrUpdate(objArgs[i]);
		}
		session.getTransaction().commit();
		session.close();
		
	}

//	public static void insertObj(Object obj) {
//	
//			Session session = sf.openSession();
//
//			session.beginTransaction();
//
//			session.persist(obj);
//
//			session.getTransaction().commit();
//			session.close();
//		
//	
//	}
	
	
	public static List<User> isOk(String queryName ,String ...queryparams) {
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(queryName);
		
		int i =0;
		for (String qp :queryparams) {
			query.setParameter(i , qp);
			i+=1;
		}
		List<User> users = query.getResultList();
		System.out.println("Result user :" +users);
		session.getTransaction().commit();
		session.close();
		
		return users;
	}
	
	
	
	
	
}
