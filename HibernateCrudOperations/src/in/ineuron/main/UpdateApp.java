package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Bike;
import in.ineuron.util.HibernateUtil;

public class UpdateApp {

	public static void main(String[] args) {
		
		
		Session session = null;
		Transaction transaction = null;
		Integer id = 3;
		Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) 
				transaction = session.beginTransaction();
				
			if(transaction != null) {
				Bike bike1 = new Bike();
			   bike1.setNumber(23);
				bike1.setName("Hello");
				bike1.setCost(90000);
				session.saveOrUpdate(bike1);
				flag = true;
			}
			
		} catch(HibernateException e) {
			e.printStackTrace();
		   System.out.println("NO RECORD AVAILABLE FOR THIS GIVEN ID :: " );
		   flag = false;
		} finally {
			
			if(flag) {
				
				transaction.commit();
				System.out.println("update success");
			}
			else {
				transaction.rollback();
				System.out.println("update failure");
			}
			
			session.close();
		}
		
	}

}
