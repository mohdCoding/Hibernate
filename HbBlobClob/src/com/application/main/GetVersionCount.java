package com.application.main;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.User;
import com.application.utility.HibernateUtil;

public class GetVersionCount {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
        Integer id = 3;
        FileOutputStream fos = null;
        FileWriter writer = null;
		try {
			
			session = HibernateUtil.getSession();
			
			if(session != null)
			{
				
				User user = session.get(User.class, id);
				
				if(user != null) {
					
					fos = new FileOutputStream("store/add.png");
					fos.write(user.getPhoto());
					
					writer = new FileWriter("store/note.txt");
					writer.write(user.getResume());
					
					writer.close();
					fos.close();
					
					
				} else {
					System.out.println("not found");
				}
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
}
