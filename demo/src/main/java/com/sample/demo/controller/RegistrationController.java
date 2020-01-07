package com.sample.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.sample.demo.beans.Registration;
import com.sample.demo.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/findAll")
	public List<Registration> findAll() {
		return registrationService.findAll();
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<HttpStatus> create(@RequestBody Registration resource) {
		Preconditions.checkNotNull(resource);
		registrationService.create(resource);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	// http://127.0.0.1:8080/newRegistration1?userName=abcd123&id=1&mobileNo=1234567890&password=abcd
	// @PostMapping(value = "/newRegistration1",consumes = "application/json")
	@PostMapping("/create1")
	@ResponseStatus(HttpStatus.CREATED)
	public Registration create1(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "registrationId") int registrationId, @RequestParam(name = "mobileNo") String mobileNo,
			@RequestParam(name = "password") String password) {
		Registration resource = new Registration(userName, registrationId, mobileNo, password);
		Preconditions.checkNotNull(resource);
		return registrationService.create(resource);
	}

	@GetMapping(value = "find/{registrationId}")
	public Registration findById(@PathVariable("registrationId") int registrationId) {
		return registrationService.findById(registrationId);
	}

	@GetMapping(value = "findByUserName/{userName}")
	public Registration findByUserName(@PathVariable("userName") String userName) {
		return registrationService.findByUserName(userName);
	}

	@PutMapping(value = "updateByRegId/{registrationId}")
	@ResponseStatus(HttpStatus.OK)
	public void updateByRegId(@PathVariable("registrationId") int registrationId, @RequestBody Registration resource) {
		Preconditions.checkNotNull(resource);
		registrationService.updateByRegId(registrationId, resource);
	}

	@PutMapping(value = "updateByUserName/{userName}")
	@ResponseStatus(HttpStatus.OK)
	public void updateByUserName(@PathVariable("userName") String userName, @RequestBody Registration resource) {
		Preconditions.checkNotNull(resource);
		registrationService.updateByUserName(userName, resource);
	}

}
