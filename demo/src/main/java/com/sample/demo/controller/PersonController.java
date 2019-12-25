package com.sample.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.beans.Person;
import com.sample.demo.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	
	@GetMapping("/entity/all")
	public List<Person> findAll() {
		return service.listAll();
	}

}
