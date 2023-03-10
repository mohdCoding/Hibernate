package in.ineuron.main;

import javax.persistence.EntityNotFoundException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Bike;
import in.ineuron.util.HibernateUtil;

public class DeleteRecord {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		Integer id = 3;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			Bike bike = session.load(Bike.class, id);
			session.delete(bike);
			flag = true;
            
		} catch (EntityNotFoundException e) {
			System.out.println("NO RECORD AVAILABLE FOR THIS GIVEN ID :: " + id);
		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("Deleted Succesfully");
			} else {
				transaction.rollback();
				System.out.println("failed to delete");
			}

			session.close();
		}

	}

}
