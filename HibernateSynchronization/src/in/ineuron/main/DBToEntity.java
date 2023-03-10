package in.ineuron.main;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Bike;
import in.ineuron.util.HibernateUtil;

public class DBToEntity {

	public static void main(String[] args) throws IOException {
		
		Session session = null;
		Transaction transaction = null;
		Bike bike = null;
		Integer id = 10;
		Boolean flag = false;
		
		try {
			
			session = HibernateUtil.getSession();
			
			if(session != null) {
				bike = session.get(Bike.class, id);
				
				if(bike != null) {
					System.out.println("Previous Data :: " + bike);
				}
				
				// pause the execution
				System.in.read();//(meanwhile going and modifying the data in the database manually)
				
				session.refresh(bike);
				System.out.println("Modified Data :: " + bike);
				
				
				
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		} 

	}

}
