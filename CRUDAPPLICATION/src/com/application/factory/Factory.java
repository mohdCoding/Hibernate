package com.application.factory;

import com.application.dao.StudentDao;

public class Factory {

	private static StudentDao studentDao = null;
	
	private Factory() {
		
	}
	
	public static StudentDao getStudentDao() {
		
		if(studentDao == null)
			studentDao = new StudentDao();
		
		return studentDao;
	}
}
