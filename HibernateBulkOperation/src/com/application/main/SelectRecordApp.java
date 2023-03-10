package com.application.main;

import org.hibernate.*;

import com.application.entity.Footballer;
import com.application.utility.HibernateUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectRecordApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

//		Query<Footballer> query = session.createQuery("FROM com.application.entity.Footballer");
//		
//		List<Footballer> footballers = query.list();
//		
//		footballers.forEach(footballer -> System.out.println(footballer));

//		Query<Footballer> query1 = session
//				.createQuery("FROM com.application.entity.Footballer WHERE fno>=?1 AND fno<=?2");
//
//		query1.setParameter(1, 7);
//		query1.setParameter(2, 9);
//		
//
//		
//
//		List<Footballer> footballers1 = query1.getResultList();
//
//		footballers1.forEach(System.out::println);
		
		
		Query<Footballer> query3 = session.createQuery("FROM com.application.entity.Footballer");
		
		Iterator<Footballer> itr = query3.iterate();
		
		
		while(itr.hasNext())
		{
		
		}

	}

}
