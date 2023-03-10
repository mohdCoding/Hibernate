package in.ineuron.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class InsurancePolicyDaoImpl {

	public void transferPremiumPolicies(String type) {
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		Integer count = 0;
		String msg = null;

		try {
			session = HibernateUtil.getSession();

			NativeQuery nativeQuery = session.getNamedNativeQuery("GET_ALL_POLICY_TYPE");
			nativeQuery.setParameter("type", type);
			List<Object[]> list = nativeQuery.getResultList();

			list.forEach(row -> {
				for (Object ele : row)
					System.out.print(ele + ", ");
				System.out.println();
			});
			
			
			for(int i=1; i<=10; i++)
				System.out.println(i);
			
			

			NativeQuery<InsurancePolicy> query1 = session.getNamedNativeQuery("GET_ALL");

			List<InsurancePolicy> list1 = query1.getResultList();
			list1.forEach(obj -> System.out.println(obj));

			if (!session.getTransaction().isActive()) {
				transaction = session.beginTransaction();

				NativeQuery<InsurancePolicy> delete = (NativeQuery<InsurancePolicy>) session
						.getNamedQuery("DELETE_BY_ID");

				delete.setParameter("id", 4);

				count = delete.executeUpdate();
				flag = true;
			}

			if (session.getTransaction().isActive()) {

				NativeQuery<InsurancePolicy> insert = session
						.createSQLQuery("INSERT INTO InsurancePolicy values(?, ?, ?, ?, ?)");

				insert.setParameter(1, 5);
				insert.setParameter(2, "FFF");
				insert.setParameter(3, "five");
				insert.setParameter(4, "life");
				insert.setParameter(5, 19);

				insert.executeUpdate();
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("rows Deleted :: " + count);
			} else {
				transaction.rollback();
			}
			
		
		}

	}

}
