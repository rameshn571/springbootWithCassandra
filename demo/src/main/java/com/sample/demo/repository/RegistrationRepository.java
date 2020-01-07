package com.sample.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.demo.beans.Registration;

@Repository
public interface RegistrationRepository extends CassandraRepository<Registration, String> {

	@Query("select * from registration where id = ?0")
	Registration getRegistrationByRegID(int registrationId);
}
