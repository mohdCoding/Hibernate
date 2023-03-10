package in.ineuron.main;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class StandardApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
        Boolean flag = false;
		try {

			   session = HibernateUtil.getSession();
				
			   if (session != null) 
				   transaction = session.beginTransaction();
			   
			   if (transaction != null) {
				   Employee employee = new Employee();
				   employee.setEmpId(4);
				   employee.setEmpName("Sergio Ramos");
				   employee.setEmpSal(345.45);
				   
				   session.save(employee);
				   flag = true;
			   }
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag == true)
				transaction.commit();
			
			
			HibernateUtil.close(session);
		}
		 
		   
	}

}
