package com.application.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.entity.Student;
import com.application.utility.HibernateUtil;

public class StudentDao {

	Session session = null;
	Transaction transaction = null;

	public String save(Student student) {
		String status = "failure";

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				session.save(student);
				status = "success";
			}

		} catch (HibernateException e) {
			status = "failure";
			e.printStackTrace();
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		} finally {

			if (status.equals("success")) {
				transaction.commit();
			} else {
				transaction.rollback();
			}

		}

		return status;
	}

	public Student get(Integer id) {
		Student student = null;

		try {

			session = HibernateUtil.getSession();

			if (session != null)
				student = session.get(Student.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;
	}

	public String saveOrUpdate(Student student) {
		String status = "failure";

		try {

			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Student student1 = get(student.getId());
			
				if(student1 != null) {
					student1.setId(student.getId());
					student1.setName(student.getName());
					student1.setAge(student.getAge());
					
				}
				
				 session.saveOrUpdate(student1);
	             status = "success";
			
                
			} 
		} catch (HibernateException e) {
			status = "failure";
			e.printStackTrace();
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		} finally {
			
			if(status.equals("success")) 
				transaction.commit();
			else
				transaction.rollback();
			
		}

		return status;
	}
	
	
	public String delete(Integer id) {
		String status = "failure";
		Student student = null;
		try {
			
			session = HibernateUtil.getSession();
			
			if(session != null)
				transaction = session.beginTransaction();
			
			if(transaction != null)
			    student = session.get(Student.class, id);
			
			if(student != null) {
				session.delete(student);
				status = "success";
			} else 
				status = "failure";
				
			
		} catch(HibernateException e) {
			status = "failure";
			e.printStackTrace();
		} catch(Exception e) {
			status = "failure";
			e.printStackTrace();
		} finally {
			
			if(status.equals("success"))
				transaction.commit();
			else 
				transaction.rollback();
		}
		
		return status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
