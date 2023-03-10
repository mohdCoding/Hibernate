package com.application.main;

import org.hibernate.*;

import com.application.entity.InsurancePolicy;
import com.application.utility.HibernateUtil;

public class LockApp1 {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
        InsurancePolicy policy = null;
        
		try {

			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			policy = session.get(InsurancePolicy.class, 1, LockMode.UPGRADE_NOWAIT);
			
			Thread.sleep(30000); // (meantime go and run the lockapp2)
			if(policy != null) {
				policy.setTenure(20);
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("Object updated");
			} else {
				transaction.rollback();
				System.out.println("object not updated");
			}
		}
	}

}
