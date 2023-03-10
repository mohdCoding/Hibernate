package in.ineuron.main;

import java.io.Serializable;

import org.hibernate.*;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class SavaAndPersist {

	public static void main(String... args) {
		Session session = HibernateUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpId(6);
		employee.setEmpName("samuel");
		employee.setEmpSal(453.23);
		session.persist(employee);

		transaction.commit();
	}

}
