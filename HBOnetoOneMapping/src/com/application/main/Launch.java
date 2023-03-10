package com.application.main;
import org.hibernate.*;
import com.application.entity.*;
import com.application.utility.HibernateUtil;
public class Launch {

	public static void main(String[] args) {
		
		Session session = null;
        Transaction transaction = null;
        Boolean flag = false;
        
        try {
        	
        	session = HibernateUtil.getSession();
        	
        	if(!session.getTransaction().isActive())
        		transaction = session.beginTransaction();
        	
        	Account account = new Account();
        	account.setAccNo("122333");
        	account.setAccName("First");
        	account.setAccType("something");
        	
        	Employee employee = new Employee();
        	employee.setEname("My name");
        	employee.setEaddress("myaddress");
        	employee.setEsal(2332.321f);
        	employee.setAccount(account);
        	
        	
        	session.save(employee);
        	
        	flag = true;
        	
        	
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	
        	if(flag) {
        		transaction.commit();
        		System.out.println("success...");
        	} else {
        		transaction.rollback();
        		System.out.println("failure....");
        	}
        }
	}

}
