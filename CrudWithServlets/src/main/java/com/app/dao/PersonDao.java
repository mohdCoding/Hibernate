package com.app.dao;

import javax.persistence.OptimisticLockException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Person;
import com.app.util.HibernateUtil;

public class PersonDao {

	private Session session = null;
	private Transaction transaction = null;

	public String save(Person person) {
		String status = "failure";

		try {

			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				session.save(person);
				status = "success";
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (status.equals("success"))
				transaction.commit();
			else
				transaction.rollback();
		}

		return status;
	}

	public Person search(Integer id) {
		Person person = null;

		try {

			session = HibernateUtil.getSession();

			if (session != null)
				person = session.get(Person.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return person;
	}

	public String delete(Integer id) {
		String status = "failure";
		Person person = null;
		try {

			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null)
				person = session.get(Person.class, id);

			if (person != null) {
				session.delete(person);
				status = "success";
			} else
				status = "failure";

		} catch (HibernateException e) {
			status = "failure";
			e.printStackTrace();
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		} finally {

			if (status.equals("success"))
				transaction.commit();
			else
				transaction.rollback();
		}

		return status;
	}

	public String update(Person person) {
		String status = "failure";
        Person person1 = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
                person1 = search(person.getId());
                System.out.println("before :: " + person1);
                if(person1 != null) {
                	person1.setId(person.getId());
                	person1.setName(person.getName());
                	person1.setDob(person.getDob());
                	person1.setCity(person.getCity());
                	session.update(person1);
    				status = "success";
                }
			

                
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

			if (status.equals("success"))
				transaction.commit();
			else
				transaction.rollback();

		}

		return status;
	}
}
