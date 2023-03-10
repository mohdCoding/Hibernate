package in.ineuron.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Employee;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestApp {
 
	public static void main(String... args) {
		
		
		// step-1 create a configuration object
		Configuration cfg = new Configuration();
	
		// step-2 configure the hibernate.cfg.xml file
		cfg.configure();
		
		// step-3 build a session factory
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// step-4 get the session object using session factory
		Session session = sessionFactory.openSession();
		
		// step-5 begin the transaction within a session
	    Transaction transaction = session.beginTransaction();
	   
	   Employee emp1 = new Employee();
	   emp1.setEmpId(8);
	   emp1.setEmpName("Cristiano Ronaldo");
	   emp1.setEmpSal(270.34);
	   
	   // step-6 perform operation
	   session.save(emp1);
	   
	   // step-7 perform transaction
	    transaction.commit();
	   
	   // step-8 close the session
	    session.close();
		
	
	}
	
	
}
