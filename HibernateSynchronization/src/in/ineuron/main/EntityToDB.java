package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Bike;
import in.ineuron.util.HibernateUtil;

public class EntityToDB {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		Bike bike = null;
		try {
			
			session = HibernateUtil.getSession();
			int id = 10;
		
			if(session != null) {
				transaction = session.beginTransaction();
				
				
				bike = session.get(Bike.class, id);
				
				if(bike != null) {
					System.out.println(bike);
					bike.setName("rc");
					flag = true;
				} else {
					System.out.println("RECORD NOT AVAILABLE FOR THE GIVEN ID :: " + id);
					flag = false;
				}
			}
		} catch(HibernateException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			
			if(transaction != null) {
				transaction.commit();
				System.out.println(bike);
			} 
		}

	}

}
