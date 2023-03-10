package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.Bike;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) {
		
		Session session = null;
		Integer id = 3;
		
		try {
			session = HibernateUtil.getSession();
			
			Bike bike = session.load(Bike.class, id);
	       
			System.out.println(bike);
		
			
		} catch(HibernateException e) {
		   System.out.println("NO RECORD AVAILABLE FOR THIS GIVEN ID :: " + id);
		}
		
	}

}
