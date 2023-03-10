package in.ineuron.main;

import org.hibernate.cfg.Configuration;

import in.ineuron.model.Employee;

import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestApp2 {

	public static void main(String[] args) {
		
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        Boolean flag = false;
        
        try {
        	cfg = new Configuration();
        	cfg.configure();
        	
        	System.out.println(cfg.getProperties());
        	sessionFactory = cfg.buildSessionFactory();
        	
        	session = sessionFactory.openSession();
        	
        	transaction = session.beginTransaction();
        	
        	Employee employee  = new Employee();
        	employee.setEmpId(9);
        	employee.setEmpName("Karim Benzema");
        	employee.setEmpSal(80.782);
        	
        	session.save(employee);
        	flag = true;
        	transaction.commit();
        	
        } catch(HibernateException e) {
        	e.printStackTrace();
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	
        	session.close();
        }
	}

}
