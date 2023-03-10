package com.application.main;

import org.hibernate.*;

import com.application.utility.HibernateUtil;

public class UpdateRecord {
	
	
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Integer rowCount = 0;
		Boolean flag = false;
		
		
		try {
			
			session = HibernateUtil.getSession();
			
			if(session != null)
				transaction = session.beginTransaction();
			
			if(transaction != null) {
				
				Query query = session.createQuery("UPDATE com.application.entity.Employee SET esalary = esalary + :increment WHERE ename =:name");
				query.setParameter("increment", 99999);
				query.setParameter("name", "Cristiano Ronaldo");
				
				rowCount = query.executeUpdate();
				flag = true;
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Executed update is :: " + rowCount);
			}
			else {
				transaction.rollback();
				System.out.println("No record found for this id");
			}
		}
	}
}
