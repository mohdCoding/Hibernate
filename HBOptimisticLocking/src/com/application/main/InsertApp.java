package com.application.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.InsurancePolicy;
import com.application.utility.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
        InsurancePolicy policy = null;
        
		try {

			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

		
			policy = new InsurancePolicy();
			policy.setPolicyName("better");
			policy.setCompany("SBI");
			policy.setPolicyType("MAXLIFE");
			policy.setTenure(10);
			
			session.save(policy);
			flag = true;
			
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
