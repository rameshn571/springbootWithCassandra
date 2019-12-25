package com.sample.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.sample.demo.beans.Person;
import com.sample.demo.repository.PersonRepository;

@Configuration
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository; 

	@Override
	public List<Person> listAll() {
		List<Person> persons = new ArrayList<>();
		personRepository.findAll().forEach(persons::add);
		return persons;
	}

}
