package com.application.main;

import org.hibernate.Session;

import com.application.entity.Customer;
import com.application.utility.HibernateUtil;

public class L2Cache {

	public static void main(String[] args) {
	
		Session session = null;
		Customer customer = null;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) 
			{
				
				customer = session.get(Customer.class, 1);
				System.out.println("OBJECT COMING FROM DB AND GIVING TO L2 AND L1 CACHE");
				System.out.println("=====================================================");
				System.out.println(customer);
				
				System.out.println();
				
				System.out.println("OBJECT COMING FROM L1 CACHE");
				System.out.println("=====================================================");
			    customer = session.get(Customer.class, 1);
			    System.out.println(customer);
			    // Removing the object from l1 cache
			    session.evict(customer);
			    
			    System.out.println();
			    
			    System.out.println("OBJECT COMING FROM L2 CACHE");
				System.out.println("=====================================================");
			    customer = session.get(Customer.class, 1);
			    System.out.println(customer);
			    
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
