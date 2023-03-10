package com.application.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.Customer;
import com.application.utility.HibernateUtil;

public class Retrive {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer id = 1;
		Boolean flag = false;

		try {

			session = HibernateUtil.getSession();

			if (session != null) {
				Customer customer = session.get(Customer.class, id);

				transaction = session.beginTransaction();
				if (customer != null) {
					System.out.println("before :: " + customer);
					customer.setLocation("Portugal");
					customer.setMobileNO(1111111);
					customer.setCname("Cristiano Ronaldo Dos Santos");
					System.out.println("after :: " + customer);
					flag = true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (flag) {
				transaction.commit();
			} else {
				transaction.rollback();
			}

		}
	}
}
