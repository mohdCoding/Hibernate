package com.application.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.BankAccount;
import com.application.utility.HibernateUtil;

public class Insert {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		BankAccount account = null;
		Boolean flag = false;
		try {
			
			session = HibernateUtil.getSession();
			
			if(session != null) 
				transaction = session.beginTransaction();
			
			if(transaction != null) {
				account = new BankAccount();
				account.setAccountHolderName("Sachin Tendulkar");
				account.setBalance(4000 + 3000);
				session.save(account);
				flag = true;
			}
			
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			
			if(flag) 
				transaction.commit();
			else
				transaction.rollback();
			
		}
		
	}
	
}
