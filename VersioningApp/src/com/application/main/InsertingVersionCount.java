package com.application.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.Customer;
import com.application.utility.HibernateUtil;



public class InsertingVersionCount {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
        Boolean flag = false;
        Integer idVal = null;
        
		try {
			
			session = HibernateUtil.getSession();
			
			if(session != null)
				transaction = session.beginTransaction();
			
			if(transaction != null) {
				
			   Customer customer = new Customer();
			   customer.setCname("tendulkar");
			   customer.setMobileNO(99988877);
			   customer.setLocation("MI");
			   
			   idVal =(Integer) session.save(customer);
			   
			   System.out.println("GENERATED ID VAL IS :: " + idVal);
			   flag = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag == true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
		}
	}

}
