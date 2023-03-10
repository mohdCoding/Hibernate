package com.app.service;

import com.app.entity.Person;

public interface Service {

	public String save(Person person);
	
	public Person search(Integer id);
	
	public String delete(Integer id);
	
	public String update(Person person);
}
