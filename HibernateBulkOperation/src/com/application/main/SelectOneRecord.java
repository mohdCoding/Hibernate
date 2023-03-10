package com.application.main;

import com.application.utility.HibernateUtil;
import org.hibernate.*;
import java.util.*;
public class SelectOneRecord {

	public static void main(String[] args) {

		Session session = null;
		Query query = null;
		try {

			session = HibernateUtil.getSession();

			if (session != null) {
				query = session.createQuery(
						"SELECT ename FROM com.application.entity.Employee where eno =:id");
				query.setParameter("id", 1);
				
				List<String> list= query.getResultList();
				
		        list.forEach(name -> System.out.println(name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
