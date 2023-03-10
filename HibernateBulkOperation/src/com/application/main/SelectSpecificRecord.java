package com.application.main;

import com.application.utility.HibernateUtil;
import org.hibernate.*;
import java.util.*;
public class SelectSpecificRecord {

	public static void main(String[] args) {

		Session session = null;
		Query query = null;
		try {

			session = HibernateUtil.getSession();

			if (session != null) {
				query = session.createQuery(
						"SELECT ename, email, esalary FROM com.application.entity.Employee where eno>=:id1 and eno<=:id2");
				query.setParameter("id1", 1);
				query.setParameter("id2", 3);
				List<Object[]> list= query.getResultList();
				
				list.forEach(row -> {
					
					for(Object obj : row) 
						System.out.println(obj);
					System.out.println();
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
