package com.sample.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.beans.Registration;
import com.sample.demo.repository.RegistrationRepository;
import com.sample.demo.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public List<Registration> findAll() {
		return registrationRepository.findAll();
	}

	@Override
	public Registration create(Registration registration) {
		return registrationRepository.save(registration);
	}

	@Override
	public Registration findById(int regId) {
		return registrationRepository.getRegistrationByRegID(regId);
	}

	@Override
	public Registration findByUserName(String userName) {
		Registration regObj = null;
		Optional<Registration> optional = registrationRepository.findById(userName);
		if (optional.isPresent()) {
			regObj = optional.get();
		}
		return regObj;
	}

	@Override
	public Registration updateByUserName(String userName, Registration registration) {
		Registration reg = new Registration(userName, registration.getRegistrationId(), registration.getMobileNo(), registration.getPassword());
		return registrationRepository.insert(reg);
	}

	@Override
	public Registration updateByRegId(int registrationId, Registration registration) {
		Registration reg = new Registration(registration.getUserName(), registrationId, registration.getMobileNo(), registration.getPassword());
		return registrationRepository.insert(reg);
	}

}
