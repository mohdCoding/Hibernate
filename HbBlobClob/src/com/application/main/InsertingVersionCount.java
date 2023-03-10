package com.application.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.User;
import com.application.utility.HibernateUtil;



public class InsertingVersionCount {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
        Boolean flag = false;
        Integer idVal = null;
        byte[] photo = null;
        char[] resume = null;
        
		try {
			
			session = HibernateUtil.getSession();
			
			if(session != null)
				transaction = session.beginTransaction();
			
			if(transaction != null) {
				User user = new User();
				user.setName("image");
				
				try(FileInputStream fis = new FileInputStream("stu.png")) {
					photo = new byte[fis.available()];
					
					fis.read(photo);
					
					File file = new File("Doubts.txt");
					try(FileReader reader = new FileReader(file)) {
						resume = new char[(int) file.length()];
						reader.read(resume);
					}catch(IOException e) {
						e.printStackTrace();
					}
					
				} catch(IOException e) {
					e.printStackTrace();
				}
				user.setPhoto(photo);
				user.setResume(resume);
				session.save(user);
				flag = true;
				System.out.println(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag == true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
		}
	}

}
