package in.ineuron.main;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerProjectInfo;
import in.ineuron.model.ProjectInfo;
import in.ineuron.util.HibernateUtil;

public class Inserting {

	public static void main(String[] args) throws IOException {
		
		Session session = null;
		Transaction transaction = null;
		Integer id = 10;
		Boolean flag = false;
		
		try {
			
			session = HibernateUtil.getSession();
			
			if(session != null) {
				
				transaction = session.beginTransaction();
				
				if(transaction != null) {
					
					
					ProjectInfo info = new ProjectInfo(7, 34);
					ProgrammerProjectInfo one = new ProgrammerProjectInfo(info, "CR7", "AL-NASSAR", "no 1 player");
					
					ProjectInfo idInfo =(ProjectInfo) session.save(one);
					System.out.println("number is :: "+ idInfo);
					transaction.commit();
					
				}
				
				
				
				
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		} 

	}

}
