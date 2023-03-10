package com.application.service;

import com.application.entity.Student;

public interface Service {

	public String save(Student student);
	
	public Student get(Integer id);
	
	public String saveOrUpdate(Student student);
	
	public String delete(Integer id);
	
}
