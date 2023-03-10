package com.application.main;

import org.hibernate.*;

import com.application.entity.InsurancePolicy;
import com.application.utility.HibernateUtil;

public class LoadTestApp {

	private static final String HQL_TRANSACTION_QUERY = "INSERT INTO com.application.entity.InsurancePremiumPolicy(policyId,policyName,policyType,company,tenure) SELECT i.policyId,i.policyName,i.policyType,i.company,i.tenure FROM com.application.entity.InsurancePolicy as i WHERE i.tenure>:tenure";

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		int count = 0;
		try {
			session = HibernateUtil.getSession();

			transaction = session.beginTransaction();

			Query query = session.createQuery(HQL_TRANSACTION_QUERY);
			query.setParameter("tenure", 13);

			count = query.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("rows inserted :: " + count);
			} else {
				transaction.rollback();
				System.out.println("failed to insert");

			}
		}

	}

}
