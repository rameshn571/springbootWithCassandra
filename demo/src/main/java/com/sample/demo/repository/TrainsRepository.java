package com.sample.demo.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.sample.demo.beans.Trains;

@Repository
public interface TrainsRepository extends CassandraRepository<Trains, UUID> {

}
