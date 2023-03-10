package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class DeleteRecord {

	public static void main(String[] args) {
		
		Session session  = null;
        Transaction transaction = null;
		Boolean flag = false;
		try {
			
			session = HibernateUtil.getSession();
			
			if(session != null)
				transaction  = session.beginTransaction();
			
			
			Integer id = 4;
			Employee employee = session.load(Employee.class, id);
			
			if(employee != null) {
			  session.delete(employee);
			  flag = true;
			} else {
				System.out.println("No record found for this id :: " + id);
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			
			if(flag == true) {
				transaction.commit();
				System.out.println("Object Deleted Succesfully");
			} else {
				System.out.println("Failed to delete Object");
			}
			
			HibernateUtil.close(session);
		}
	}

}
