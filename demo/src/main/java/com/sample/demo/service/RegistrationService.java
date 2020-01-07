package com.sample.demo.service;

import java.util.List;

import com.sample.demo.beans.Registration;

public interface RegistrationService {

	List<Registration> findAll();

	Registration create(Registration registration);

	Registration findById(int regId);

	Registration findByUserName(String userName);

	Registration updateByUserName(String userName, Registration registration);

	Registration updateByRegId(int regId, Registration registration);

}
