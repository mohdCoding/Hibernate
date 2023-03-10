package com.app.factory;

import com.app.dao.PersonDao;
import com.app.service.ServiceImpl;

public class Factory {

	private Factory() {

	}

	private static PersonDao personDao = null;
	private static ServiceImpl serviceImpl = null;

	public static PersonDao getPersonDao() {

		if (personDao == null)
			personDao = new PersonDao();
		return personDao;
	}

	public static ServiceImpl getServiceImpl() {

		if (serviceImpl == null)
			serviceImpl = new ServiceImpl();
		return serviceImpl;
	}

}
