package com.application.main;

import org.hibernate.*;

import com.application.entity.Employee;
import com.application.entity.Footballer;
import com.application.utility.HibernateUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Select {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		Query<Employee> query = session.createQuery("FROM com.application.entity.Employee where eno=:id");
		query.setParameter("id", 1);
		
//		Employee employee = query.uniqueResult();
//		
//		if(employee != null)
//			System.out.println(employee);
//		else
//			System.out.println("record not found");
		
	

	}

}
