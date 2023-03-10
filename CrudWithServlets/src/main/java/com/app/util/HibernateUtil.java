package com.app.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private HibernateUtil() {

	}

	private static Configuration cfg = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {

		try {
			cfg = new Configuration();

			cfg.configure();

			sessionFactory = cfg.buildSessionFactory();

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Session getSession() {

		if(sessionFactory != null) 
			session = sessionFactory.openSession();
		
		return session;
	}
	
}
