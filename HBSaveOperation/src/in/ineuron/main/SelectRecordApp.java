package in.ineuron.main;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {
		
		Session session = null;
		Serializable id = null;
		
	
		try {
			 
			id = 9;
			session = HibernateUtil.getSession();
			
			if(session != null) {
				Employee employee = session.load(Employee.class, id);
				
				System.out.println(employee);
			}
			
		} catch(HibernateException e) {
			e.printStackTrace();
		}

	}

}
