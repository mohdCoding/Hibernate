package com.application.main;

import org.hibernate.*;

import com.application.utility.HibernateUtil;

public class DeleteRecord {
	
	
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
			
				Query query = session.createQuery("DELETE FROM com.application.entity.Employee where eno<=:id");
				query.setParameter("id", 9);
				
				rowCount = query.executeUpdate();
				flag = true;
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("no of records deleted  is :: " + rowCount);
			}
			else {
				transaction.rollback();
				System.out.println("No record found for this id");
			}
		}
	}
}
