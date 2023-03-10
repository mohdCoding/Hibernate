package com.application.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.BankAccount;
import com.application.utility.HibernateUtil;

public class Retieve {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		BankAccount account = null;
		Boolean flag = false;
		try {

			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			account = session.get(BankAccount.class, 1);

			account.setAccountHolderName("SpringBoot + Microservices");
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

			if (flag) {

			} else {
				transaction.rollback();
			}

		}

	}

}
