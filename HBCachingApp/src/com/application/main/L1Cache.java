package com.application.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.Customer;
import com.application.utility.HibernateUtil;

public class L1Cache {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer id = 1;
		Boolean flag = false;

		try {

			session = HibernateUtil.getSession();

			if (session != null) {
				Customer customer = session.get(Customer.class, id);
				System.out.println("1 :: " + customer);
				System.in.read();
				Customer customer1 = session.get(Customer.class, id);
				System.out.println("2 :: " + customer1);
				System.in.read();
				
				session.evict(customer);
				Customer customer3 = session.get(Customer.class, id);
				System.out.println("3 :: " + customer3);
				System.in.read();
				session.clear();
				Customer customer4 = session.get(Customer.class, id);
				System.out.println("4 :: " + customer4);
				System.out.println(customer.hashCode() + " :: " + customer1.hashCode() + " :: " + customer3.hashCode()
						+ " :: " + customer4.hashCode());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
}
