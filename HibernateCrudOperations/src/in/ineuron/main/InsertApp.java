package in.ineuron.main;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Bike;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
        Boolean flag = false;
		session = HibernateUtil.getSession();

	
		try {
			if(session != null)
			 transaction = session.beginTransaction();// connection.autoCommit(false)

			
			if(transaction != null) {
				Bike bike1 = new Bike();
				bike1.setName("FZ");
				bike1.setCost(100000);

			    session.persist(bike1); 
			    System.in.read();
	            flag = true;
			}
			
		} catch (HibernateException e) {
			System.out.println("hibernate exception controll is here");
			
		} 
			
			if (flag) {
				System.out.println("im true");
				transaction.commit(); // connection.commit();
			} else  {
				System.out.println("im false");
				transaction.rollback(); // connection.rollback();
			}
            
			session.close();
		

	}

}
