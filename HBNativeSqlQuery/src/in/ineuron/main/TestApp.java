package in.ineuron.main;


import in.ineuron.dao.InsurancePolicyDaoImpl;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {

		InsurancePolicyDaoImpl dao = null;
		dao = new InsurancePolicyDaoImpl();
		dao.transferPremiumPolicies("life");
		HibernateUtil.closeSessionFactory();
	}

}
