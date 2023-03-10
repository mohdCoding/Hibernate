package com.app.service;

import com.app.dao.PersonDao;
import com.app.entity.Person;
import com.app.factory.Factory;

public class ServiceImpl implements Service {

	private PersonDao personDao = null;
	
	public String save(Person person) {
		personDao = Factory.getPersonDao();
		return personDao.save(person);
	}
	
	public Person search(Integer id) {
		personDao = Factory.getPersonDao();
		return personDao.search(id);
	}
	
	public String delete(Integer id) {
		personDao = Factory.getPersonDao();
		return personDao.delete(id);
	}
	
	public String update(Person person) {
		personDao = Factory.getPersonDao();
		return personDao.update(person);
	}
}


