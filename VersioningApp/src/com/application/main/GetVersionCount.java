package com.application.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.Customer;
import com.application.utility.HibernateUtil;

public class GetVersionCount {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
        Integer id = 2;
        
        
		try {
			
			session = HibernateUtil.getSession();
			
			if(session != null)
			{
				Customer customer = session.get(Customer.class, id);
				
				transaction = session.beginTransaction();
				if(customer != null) {
					customer.setLocation("Portugal");
					customer.setMobileNO(1111111);
					customer.setCname("Cristiano Ronaldo");
				}
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}  finally {
			
			if(transaction != null)
				transaction.commit();
		}
	}
}
