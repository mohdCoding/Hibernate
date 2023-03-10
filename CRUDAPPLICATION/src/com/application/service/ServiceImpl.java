package com.application.service;

import com.application.dao.StudentDao;
import com.application.entity.Student;
import com.application.factory.Factory;

public class ServiceImpl implements Service {

	private StudentDao studentDao = null;

	public String save(Student student) {
		studentDao = Factory.getStudentDao();
		return studentDao.save(student);
	}

	public Student get(Integer id) {
		studentDao = Factory.getStudentDao();
		return studentDao.get(id);
	}

	public String saveOrUpdate(Student student) {
		studentDao = Factory.getStudentDao();
		return studentDao.saveOrUpdate(student);
	}

	public String delete(Integer id) {
		studentDao = Factory.getStudentDao();
		return studentDao.delete(id);
	}

}
