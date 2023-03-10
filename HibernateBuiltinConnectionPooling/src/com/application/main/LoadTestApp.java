package com.application.main;

import org.hibernate.*;

import com.application.entity.InsurancePolicy;
import com.application.utility.HibernateUtil;

public class LoadTestApp {

	
	public static void main(String[] args) {
		
		Session session = null;
		InsurancePolicy policy = null;
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) 
				policy = session.get(InsurancePolicy.class, 1);
			
			if(policy != null)
				System.out.println(policy);
			else
				System.out.println("no data found fot this id");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
